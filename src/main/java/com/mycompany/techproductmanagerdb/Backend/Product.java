/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.techproductmanagerdb.Backend;

/**
 * Αντιπροσωπεύει ένα αφηρημένο προϊόν στο κατάστημα.
 * Περιέχει τα βασικά χαρακτηριστικά που μοιράζονται όλα τα τεχνολογικά προϊόντα,
 * όπως μοναδικό κωδικό, όνομα, τιμή, απόθεμα και κατασκευαστή.
 * * @author John
 */
public abstract class Product {
    protected int id;
    protected String productCode;
    protected String name;
    protected Manufacturer manufacturer;
    protected double price;
    protected int quantity;

/**
     * Κατασκευάζει ένα νέο προϊόν με τα βασικά του στοιχεία χωρίς ID.
     * Χρησιμοποιείται κυρίως κατά τη δημιουργία ενός νέου προϊόντος στην εφαρμογή,
     * πριν αυτό εισαχθεί στη βάση δεδομένων, καθώς το ID θα παραχθεί αυτόματα (AUTO_INCREMENT).
     *
     * @param productCode  Ο μοναδικός αλφαριθμητικός κωδικός του προϊόντος.
     * @param name         Το όνομα/μοντέλο του προϊόντος.
     * @param manufacturer Ο κατασκευαστής του προϊόντος.
     * @param price        Η τιμή πώλησης του προϊόντος σε ευρώ.
     * @param quantity     Το αρχικό διαθέσιμο απόθεμα στην αποθήκη.
     */
    public Product(String productCode, String name, Manufacturer manufacturer, double price, int quantity) {
        this.productCode = productCode;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Κατασκευάζει ένα προϊόν αναθέτοντάς του ένα ήδη υπάρχον ID.
     * Χρησιμοποιείται κατά την ανάκτηση (SELECT) των δεδομένων από τη βάση δεδομένων,
     * όπου το ID είναι ήδη γνωστό και έχει παραχθεί από το σύστημα.
     *
     * @param id           Το μοναδικό αναγνωριστικό του προϊόντος όπως ορίστηκε από τη βάση.
     * @param productCode  Ο μοναδικός αλφαριθμητικός κωδικός του προϊόντος.
     * @param name         Το όνομα/μοντέλο του προϊόντος.
     * @param manufacturer Ο κατασκευαστής του προϊόντος.
     * @param price        Η τιμή πώλησης του προϊόντος σε ευρώ.
     * @param quantity     Το διαθέσιμο απόθεμα στην αποθήκη.
     */
    public Product(int id, String productCode, String name, Manufacturer manufacturer, double price, int quantity) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }
    
    public abstract String productType();

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Μορφοποιεί τα βασικά στοιχεία του προϊόντος σε κείμενο.
     *
     * @return Μια συμβολοσειρά (String) με τα δεδομένα του προϊόντος.
     */
    @Override
    public String toString() {
        return "ID: " + id + 
               "\nΚωδικός: " + productCode + 
               "\nΌνομα: " + name + 
               "\nΚατασκευαστής: " + manufacturer.getName() + 
               "\nΤιμή: " + price + " €" + 
               "\nΑπόθεμα: " + quantity + " τεμ.";
    }
}