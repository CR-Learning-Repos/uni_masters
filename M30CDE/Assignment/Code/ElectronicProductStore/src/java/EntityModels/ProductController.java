package EntityModels;

import EntityModels.util.JsfUtil;
import EntityModels.util.PaginationHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

@Named("productController")
@SessionScoped
public class ProductController implements Serializable {

    private Product current;
    private DataModel items = null;
    @EJB
    private EntityModels.ProductFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private List<String> categories;

    public ProductController() {
    }

    public Product getSelected() {
        if (current == null) {
            current = new Product();
            selectedItemIndex = -1;
        }
        return current;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> cats) {
        categories = cats;
    }

    private ProductFacade getFacade() {
        return ejbFacade;
    }



    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Product) getItems().getRowData();
        this.categories = new ArrayList<String>();

        current.getCategories().stream().forEach(x -> {
            this.categories.add(x.getId().toString());
        });

        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Product();
        selectedItemIndex = -1;
        return "/product/Create";
    }
    @EJB
    private EntityModels.CategoryFacade catEjbFacade;

    public List<Category> getCategoriesTodisplay() {
        List<Category> cats = new ArrayList<Category>();
        for (int i = 0; i < categories.size(); i++) {
            Long id = Long.parseLong(categories.get(i));
            Category cat = (Category) catEjbFacade.find(id);
            cats.add(cat);
        }

        return cats;
    }

    public String create() {
        try {

            List<Category> cats = new ArrayList<Category>();
            for (int i = 0; i < categories.size(); i++) {
                Long id = Long.parseLong(categories.get(i));
                Category cat = (Category) catEjbFacade.find(id);
                cats.add(cat);
            }

            Set<Category> set = new HashSet<Category>(cats);

            current.setCategories(set);

            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Product) getItems().getRowData();
        this.categories = new ArrayList<String>();

        current.getCategories().stream().forEach(x -> {
            this.categories.add(x.getId().toString());
        });
        current = (Product) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            List<Category> cats = new ArrayList<Category>();
            for (int i = 0; i < categories.size(); i++) {
                Long id = Long.parseLong(categories.get(i));
                Category cat = (Category) catEjbFacade.find(id);
                cats.add(cat);
            }
            Set<Category> set = new HashSet<Category>(cats);

            current.setCategories(set);
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Product) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProductDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Product getProduct(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Product.class)
    public static class ProductControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProductController controller = (ProductController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "productController");
            return controller.getProduct(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Product) {
                Product o = (Product) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Product.class.getName());
            }
        }

    }

}
