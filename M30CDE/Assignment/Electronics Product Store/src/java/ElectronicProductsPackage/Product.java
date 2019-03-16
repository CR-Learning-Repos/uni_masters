/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ElectronicProductsPackage;

/**
 *
 * @author ChrisRollings
 */
public class Product {
    private int _id;
    private String _desc;
    private ProductCategories _category;
    
    
    public int Id(){
        return _id;
    }
    public String Description(){
        return _desc;
    }
    public ProductCategories Category(){
        return _category;
    }
}
