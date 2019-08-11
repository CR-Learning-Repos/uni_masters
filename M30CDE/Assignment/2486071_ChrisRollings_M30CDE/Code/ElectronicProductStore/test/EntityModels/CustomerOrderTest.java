/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityModels;

import java.util.Date;
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
public class CustomerOrderTest {

    public CustomerOrderTest() {
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
     * Test of setTotal method, of class CustomerOrder.
     */
    @Test
    public void testSetAndGetTotal() {
        System.out.println("setTotal");
        Long total = 10l;
        CustomerOrder instance = new CustomerOrder();
        instance.setTotal(total);
        Long expResult = instance.getTotal();
        assertEquals(expResult, total);
    }

    /**
     * Test of getDateOfOrder method, of class CustomerOrder.
     */
    @Test
    public void testGetSetDateOfOrder() {
        System.out.println("getDateOfOrder");
        CustomerOrder instance = new CustomerOrder();
        Date expResult = new Date();
        instance.setDateOfOrder(expResult);
        Date result = instance.getDateOfOrder();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetId() {
        System.out.println("getId");
        CustomerOrder instance = new CustomerOrder();
        Long expResult = 10l;
        instance.setId(expResult);
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class CustomerOrder.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        CustomerOrder instance = new CustomerOrder();
        boolean expResult = true;
        boolean result = instance.equals(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of getNameOnCard method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetNameOnCard() {
        System.out.println("getNameOnCard");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "JEFF";
        instance.setNameOnCard(expResult);
        String result = instance.getNameOnCard();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCreditCardNumber method, of class CustomerOrder.
     */
    @Test
    public void testGetANdSetCreditCardNumber() {
        System.out.println("getCreditCardNumber");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "1234";
        instance.setCreditCardNumber(expResult);
        String result = instance.getCreditCardNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetAddress() {
        System.out.println("getAddress");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "COV";
        instance.setAddress(expResult);
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCity method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetCity() {
        System.out.println("getCity");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "Cov";
        instance.setCity(expResult);
        String result = instance.getCity();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExpMonth method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetExpMonth() {
        System.out.println("getExpMonth");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "03";
        instance.setExpMonth(expResult);
        String result = instance.getExpMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getState method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetState() {
        System.out.println("getState");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "Midlands";
        instance.setState(expResult);
        String result = instance.getState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getZip method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetZip() {
        System.out.println("getZip");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "cv3";
        instance.setZip(expResult);
        String result = instance.getZip();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExpYear method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetExpYear() {
        System.out.println("getExpYear");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "1989";
        instance.setExpYear(expResult);
        String result = instance.getExpYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCvv method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetCvv() {
        System.out.println("getCvv");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "352";
        instance.setCvv(expResult);
        String result = instance.getCvv();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetFirstName() {
        System.out.println("getFirstName");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "JEFF";
        instance.setFirstName(expResult);
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class CustomerOrder.
     */
    @Test
    public void testGetAndSetEmail() {
        System.out.println("getEmail");
        CustomerOrder instance = new CustomerOrder();
        String expResult = "a@g.com";
        instance.setEmail(expResult);
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNameOnCard method, of class CustomerOrder.
     */
    @Test
    public void testSetAndGetNameOnCard() {
        System.out.println("setNameOnCard");
        String nameOnCard = "";
        CustomerOrder instance = new CustomerOrder();
        instance.setNameOnCard(nameOnCard);
    }

}
