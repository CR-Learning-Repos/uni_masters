package EntityModels;

import EntityModels.util.JsfUtil;
import EntityModels.util.PaginationHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
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

@Named("customerOrderController")
@SessionScoped
public class CustomerOrderController implements Serializable {

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setCurrent(CustomerOrder current) {
        this.current = current;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getExpYear() {
        return expYear;
    }

    public String getCvv() {
        return cvv;
    }

    public CustomerOrder getCurrent() {
        return current;
    }

    private String firstName;
    private String email;

    public void setItems(DataModel items) {
        this.items = items;
    }

    public String getEmail() {
        return email;
    }
    @EJB
    private EntityModels.PurchaseFacade purchaseejbFacade;
    @EJB
    private EntityModels.ProductFacade productejbFacade;

    public Long getTotal() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Map<Long, Long> list = (HashMap<Long, Long>) session.getAttribute("shoppingcart");
        Long totalPounds = 0l;
        for (Map.Entry<Long, Long> entry : list.entrySet()) {
            Long key = entry.getKey();
            Product prod = productejbFacade.find(key);
            totalPounds = totalPounds + prod.getPrice();
        }
        return totalPounds;
    }

    public String Submit() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Map<Long, Long> list = (HashMap<Long, Long>) session.getAttribute("shoppingcart");

        List<Product> products = new ArrayList<Product>();
        Long totalPounds = 0l;
        for (Map.Entry<Long, Long> entry : list.entrySet()) {
            Long key = entry.getKey();
            Product prod = productejbFacade.find(key);
            products.add(prod);
            totalPounds = totalPounds + prod.getPrice();
        }

        CustomerOrder order = new CustomerOrder();
        order.setFirstName(firstName);
        order.setEmail(email);
        order.setNameOnCard(nameOnCard);
        order.setCreditCardNumber(creditCardNumber);
        order.setAddress(address);
        order.setCity(city);
        order.setExpMonth(expMonth);
        order.setState(state);
        order.setZip(zip);
        order.setExpYear(expYear);
        order.setCvv(cvv);
        order.setTotal(totalPounds);
        Date todaysDate = new Date();
        order.setDateOfOrder(todaysDate);
        try {
            ejbFacade.create(order);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CustomerOrderCreated"));
            Purchase purchase = new Purchase();
            purchase.setOrder(order);
            purchase.setProductSet(new HashSet<Product>(products));
            purchaseejbFacade.create(purchase);
            return "/customerOrder/OrderConfirmation";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return "/customerOrder/OrderDenied";
        }
    }

    private String nameOnCard;
    private String creditCardNumber;
    private String address;
    private String city;
    private String expMonth;
    private String state;
    private String zip;
    private String expYear;
    private String cvv;

    private CustomerOrder current;
    private DataModel items = null;
    @EJB
    private EntityModels.CustomerOrderFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public CustomerOrderController() {
    }

    public CustomerOrder getSelected() {
        if (current == null) {
            current = new CustomerOrder();
            selectedItemIndex = -1;
        }
        return current;
    }

    private CustomerOrderFacade getFacade() {
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
        current = (CustomerOrder) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new CustomerOrder();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CustomerOrderCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (CustomerOrder) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CustomerOrderUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (CustomerOrder) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("CustomerOrderDeleted"));
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

    public CustomerOrder getCustomerOrder(java.lang.Long id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = CustomerOrder.class)
    public static class CustomerOrderControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CustomerOrderController controller = (CustomerOrderController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "customerOrderController");
            return controller.getCustomerOrder(getKey(value));
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
            if (object instanceof CustomerOrder) {
                CustomerOrder o = (CustomerOrder) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + CustomerOrder.class.getName());
            }
        }

    }

}
