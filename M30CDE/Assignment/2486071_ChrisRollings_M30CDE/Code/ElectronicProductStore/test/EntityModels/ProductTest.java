/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityModels;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Chris
 */
public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Product.
     */
    @Test
    public void testSetAndGetId() {
        System.out.println("getId");
        Product instance = new Product();
        Long expResult = 1l;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }
    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testSetAndGetPrice() {
        System.out.println("getPrice");
        Product instance = new Product();
        int expResult = 15;
        instance.setPrice(expResult);
        int result = instance.getPrice();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDescription method, of class Product.
     */
    @Test
    public void testSetGetDescription() {
        System.out.println("getDescription");
        Product instance = new Product();
        String expResult = "DESC";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testSetAndGetProductName() {
        System.out.println("getProductName");
        Product instance = new Product();
        String expResult = "name";
        instance.setProductName(expResult);
        String result = instance.getProductName();
        assertEquals(expResult, result);
;
    }

    /**
     * Test of getCategories method, of class Product.
     */
    @Test
    public void testSetAndGetCategories() {
        System.out.println("getCategories");
        Product instance = new Product();
        Set<Category> expResult = new HashSet<Category>();
        instance.setCategories(expResult);
        Set<Category> result = instance.getCategories();
        assertEquals(expResult, result);
    }

   
}
