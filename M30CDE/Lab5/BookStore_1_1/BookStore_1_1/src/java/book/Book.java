/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.util.HashMap;

/**
 *
 * @author nazaraf
 */
public class Book {

    private String name;
    private String author;
    private float price;
    private int quantity;

    public static HashMap<String, Book> AVAILABLEBOOKS = new HashMap<String, Book>() {
        {
            put("0", new Book("Java", "David Bell", 5.50f));
            put("1", new Book("Visual Basic", "Tony Butcher", 10.15f));
            put("2", new Book("C Programming", "Simon Locus", 6.95f));
        }
    };

    Book(String name, String author, float price) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }

}
