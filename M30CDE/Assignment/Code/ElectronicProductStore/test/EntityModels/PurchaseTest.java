/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityModels;

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
     * Test of getQuantity method, of class Purchase.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Purchase instance = new Purchase();
        Long expResult = null;
        Long result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setQuantity method, of class Purchase.
     */
    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        Long quantity = null;
        Purchase instance = new Purchase();
        instance.setQuantity(quantity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOrder method, of class Purchase.
     */
    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        Purchase instance = new Purchase();
        CustomerOrder expResult = null;
        CustomerOrder result = instance.getOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrder method, of class Purchase.
     */
    @Test
    public void testSetOrder() {
        System.out.println("setOrder");
        CustomerOrder order = null;
        Purchase instance = new Purchase();
        instance.setOrder(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductSet method, of class Purchase.
     */
    @Test
    public void testGetProductSet() {
        System.out.println("getProductSet");
        Purchase instance = new Purchase();
        Set expResult = null;
        Set result = instance.getProductSet();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProductSet method, of class Purchase.
     */
    @Test
    public void testSetProductSet() {
        System.out.println("setProductSet");
        Set productSet = null;
        Purchase instance = new Purchase();
        instance.setProductSet(productSet);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Purchase.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Purchase instance = new Purchase();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Purchase.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        Purchase instance = new Purchase();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Purchase.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Purchase instance = new Purchase();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Purchase.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Purchase instance = new Purchase();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Purchase.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Purchase instance = new Purchase();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
