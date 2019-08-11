/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityModels;

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
public class PurchaseTest {

    public PurchaseTest() {
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
     * Test of setQuantity method, of class Purchase.
     */
    @Test
    public void testSetAndGetQuantity() {
        System.out.println("setQuantity");
        Long quantity = 10l;
        Purchase instance = new Purchase();
        instance.setQuantity(quantity);
        Long expResult = instance.getQuantity();
        assertEquals(expResult, quantity);
    }

    /**
     * Test of setOrder method, of class Purchase.
     */
    @Test
    public void testSetAndSetOrder() {
        System.out.println("setOrder");
        CustomerOrder order = new CustomerOrder();
        Purchase instance = new Purchase();
        instance.setOrder(order);
        CustomerOrder expResult = instance.getOrder();
        assertEquals(expResult, order);
    }

    /**
     * Test of setProductSet method, of class Purchase.
     */
    @Test
    public void testSetAndGetProductSet() {
        System.out.println("setProductSet");
        Set productSet = new HashSet<Product>();
        Purchase instance = new Purchase();
        instance.setProductSet(productSet);
        Set expResult = instance.getProductSet();
        assertEquals(expResult, productSet);
    }

    /**
     * Test of setId method, of class Purchase.
     */
    @Test
    public void testSetAndGetId() {
        System.out.println("setId");
        Long id = 10l;
        Purchase instance = new Purchase();
        instance.setId(id);
        Long expResult = instance.getId();
        assertEquals(expResult, id);
    }
}
