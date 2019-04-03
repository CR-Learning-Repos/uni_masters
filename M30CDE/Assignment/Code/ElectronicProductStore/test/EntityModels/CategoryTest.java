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
public class CategoryTest {

    public CategoryTest() {
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
     * Test of getName method, of class Category.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Category instance = new Category();
        String expResult = "Dave";
        instance.setName(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Category.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Dave";
        Category instance = new Category();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getDescription method, of class Category.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Category instance = new Category();
        String expResult = "Desc";
        instance.setDescription(expResult);
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Category.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String desc = "desc";
        Category instance = new Category();
        instance.setDescription(desc);
        String result = instance.getDescription();
        assertEquals(desc, result);
    }

    /**
     * Test of getId method, of class Category.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Category instance = new Category();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Category.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1l;
        Category instance = new Category();
        instance.setId(id);
        Long result = instance.getId();
        assertEquals(id, result);
    }

    /**
     * Test of getProducts method, of class Category.
     */
    @Test
    public void testGetProducts() {
        System.out.println("getProducts");
        Category instance = new Category();
        Set expResult = null;
        Set result = instance.getProducts();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProducts method, of class Category.
     */
    @Test
    public void testSetProducts() {
        System.out.println("setProducts");
        Set products = null;
        Category instance = new Category();
        instance.setProducts(products);
    }

    /**
     * Test of hashCode method, of class Category.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Category instance = new Category();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Category.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Category instance = new Category();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
    }
}
