/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityModels;

import EntityModels.util.JsfUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chris
 */
@Named(value = "shoppingCart")
@Dependent
public class ShoppingCart {

    private List<Product> list;

    /**
     * Creates a new instance of ShoppingCart
     */
    public ShoppingCart() {
    }
    @EJB
    private ProductFacade productEjbFacade;

    private ProductFacade getProductFacade() {
        return productEjbFacade;
    }

    public Long getCartTotal() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Map<Long, Long> hashlist = (HashMap<Long, Long>) session.getAttribute("shoppingcart");

        Long total = 0l;
        for (Map.Entry<Long, Long> entry : hashlist.entrySet()) {
            Long key = entry.getKey();
            Long totalItem = this.getTotalForItem(key);
            total = total + totalItem;
        }
        return total;
    }

    public List<Product> getList() {

        if (this.list == null) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Map<Long, Long> hashlist = (HashMap<Long, Long>) session.getAttribute("shoppingcart");

            if (hashlist == null) {
                this.list = new ArrayList<Product>();
            } else {
                ArrayList newList = new ArrayList<Product>();

                for (Map.Entry<Long, Long> entry : hashlist.entrySet()) {
                    Long key = entry.getKey();
                    Product prod = getProductFacade().find(key);
                    newList.add(prod);
                }

                list = newList;
            }
        }

        return list;
    }

    public int getProductCount() {

        if (list == null) {
            list = getList();
        }
        return list.size();
    }

    public Long getItemCount(Long id) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Map<Long, Long> list = (HashMap<Long, Long>) session.getAttribute("shoppingcart");
        return list.get(id);
    }

    public Long getTotalForItem(Long id) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Map<Long, Long> list = (HashMap<Long, Long>) session.getAttribute("shoppingcart");

        Long totalPounds = 0l;
        for (Map.Entry<Long, Long> entry : list.entrySet()) {
            Long key = entry.getKey();
            if (key == id) {
                Long count = entry.getValue();
                Product prod = getProductFacade().find(key);
                totalPounds = totalPounds + (prod.getPrice() * count);
            }

        }

        return totalPounds;
    }

    public void addProductToCart(Product procuct) {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

        Map<Long, Long> list = (HashMap<Long, Long>) session.getAttribute("shoppingcart");

        if (list == null) {
            list = new HashMap<Long, Long>();
            list.put(procuct.getId(), 1l);
        } else {
            if (!list.containsKey(procuct.getId())) {
                list.put(procuct.getId(), 1l);
            } else {
                Long count = list.get(procuct.getId()) + 1;
                list.replace(procuct.getId(), count);
            }
        }

        session.setAttribute("shoppingcart", list);

    }

    public void removeFromCart(Product procuct) {

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        Map<Long, Long> list = (HashMap<Long, Long>) session.getAttribute("shoppingcart");
        if (list == null) {

        } else if (list.containsKey(procuct.getId())) {
            list.remove(procuct.getId());
        }

        session.setAttribute("shoppingcart", list);
    }
}
