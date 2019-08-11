/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityModels;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Chris
 */
@Named(value = "makeOrder")
@Dependent
public class MakeOrder {

    /**
     * Creates a new instance of MakeOrder
     */
    public MakeOrder() {
    }


}
