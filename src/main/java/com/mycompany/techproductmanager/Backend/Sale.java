/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.techproductmanager.Backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Αντιπροσωπεύει μια συναλλαγή/πώληση (Sale) προϊόντος στο κατάστημα.
 * Καταγράφει το προϊόν που πουλήθηκε, την ποσότητα των τεμαχίων,
 * καθώς και την ακριβή ημερομηνία και ώρα της συναλλαγής.
 * * @author John
 */
public class Sale {
    private int id;
    private Product product;
    private int quantity;
    private LocalDateTime timestamp;

    /**
     * Κατασκευάζει μια νέα πώληση για την τρέχουσα συναλλαγή.
     * Χρησιμοποιείται όταν καταγράφουμε μια νέα πώληση στην εφαρμογή. 
     * Το ID και η ημερομηνία/ώρα θα αποδοθούν αυτόματα από τη βάση δεδομένων κατά την εισαγωγή.
     *
     * @param product  Το αντικείμενο {@link Product} που πωλείται.
     * @param quantity Η ποσότητα των τεμαχίων που αγοράστηκαν.
     */
    public Sale(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.timestamp = LocalDateTime.now(); 
    }
    
    /**
     * Κατασκευάζει μια πώληση με πλήρη στοιχεία (ID και Timestamp).
     * Χρησιμοποιείται κατά την ανάκτηση (SELECT) του ιστορικού πωλήσεων από τη βάση δεδομένων.
     *
     * @param id        Το μοναδικό αναγνωριστικό της πώλησης από τη βάση.
     * @param product   Το αντικείμενο {@link Product} που είχε πουληθεί.
     * @param quantity  Η ποσότητα των τεμαχίων που είχαν αγοραστεί.
     * @param timestamp Η ημερομηνία και ώρα της συναλλαγής όπως καταγράφηκε στη βάση.
     */
    public Sale(int id, Product product, int quantity, LocalDateTime timestamp) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Μορφοποιεί τα στοιχεία της πώλησης σε κείμενο.
     *
     * @return Μια συμβολοσειρά (String) με την απόδειξη/ιστορικό της συναλλαγής.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        return "Όνομα προϊόντος: " + product.getName() + 
               "\nΠοσότητα: " + quantity + 
               "\nΚόστος συναλλαγής: " + (quantity * product.getPrice()) +
               "\nΗμ/νία Συναλλαγής: " + timestamp.format(formatter); 
    }  
}