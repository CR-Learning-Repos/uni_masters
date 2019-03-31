/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicProductsSQL;

/**
 *
 * @author ChrisRollings
 */
public class BaseSQLManager {

    protected String URL;
    protected String USERNAME;
    protected String PASSWORD;

    BaseSQLManager() {
        this.URL = "jdbc:derby://localhost:1527/ElectronicProduct";
        this.USERNAME = "chris";
        this.PASSWORD = "1234";
    }
}
