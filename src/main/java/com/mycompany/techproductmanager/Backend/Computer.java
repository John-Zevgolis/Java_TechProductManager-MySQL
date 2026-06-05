/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.techproductmanager.Backend;

/**
 * Αντιπροσωπεύει ένα προϊόν τύπου Υπολογιστή (Computer) στο κατάστημα.
 * Κληρονομεί τα βασικά χαρακτηριστικά από την κλάση {@link Product} και
 * εισάγει επιπλέον προδιαγραφές όπως το μέγεθος RAM και τη χωρητικότητα δίσκου.
 * * @author John
 */
public class Computer extends Product {
    private int ramSize;
    private int storageCapacity;

    /**
     * Κατασκευάζει έναν νέο υπολογιστή με τα καθορισμένα στοιχεία χωρίς ID.
     * Χρησιμοποιείται κυρίως κατά τη δημιουργία ενός νέου προϊόντος στην εφαρμογή,
     * πριν αυτό εισαχθεί στη βάση δεδομένων, καθώς το ID θα παραχθεί αυτόματα (AUTO_INCREMENT).
     * Καλεί τον constructor της υπερκλάσης για τα κοινά πεδία.
     *
     * @param productCode     Ο μοναδικός κωδικός του προϊόντος.
     * @param name            Το όνομα/μοντέλο του υπολογιστή.
     * @param manufacturer    Ο κατασκευαστής της συσκευής.
     * @param price           Η τιμή πώλησης σε ευρώ.
     * @param quantity        Το διαθέσιμο απόθεμα.
     * @param ramSize         Το μέγεθος της μνήμης RAM σε GB.
     * @param storageCapacity Η χωρητικότητα του αποθηκευτικού χώρου σε GB.
     */
    public Computer(String productCode, String name, Manufacturer manufacturer, double price, int quantity, int ramSize, int storageCapacity) {
        super(productCode, name, manufacturer, price, quantity);
        this.ramSize = ramSize;
        this.storageCapacity = storageCapacity;
    }
    
    /**
     * Κατασκευάζει έναν υπολογιστή αναθέτοντάς του ένα ήδη υπάρχον ID.
     * Χρησιμοποιείται κατά την ανάκτηση (SELECT) των δεδομένων από τη βάση δεδομένων,
     * όπου το ID είναι ήδη γνωστό και έχει παραχθεί από το σύστημα.
     * Καλεί τον αντίστοιχο constructor της υπερκλάσης.
     *
     * @param id              Το μοναδικό αναγνωριστικό του προϊόντος από τη βάση.
     * @param productCode     Ο μοναδικός κωδικός του προϊόντος.
     * @param name            Το όνομα/μοντέλο του υπολογιστή.
     * @param manufacturer    Ο κατασκευαστής της συσκευής.
     * @param price           Η τιμή πώλησης σε ευρώ.
     * @param quantity        Το διαθέσιμο απόθεμα.
     * @param ramSize         Το μέγεθος της μνήμης RAM σε GB.
     * @param storageCapacity Η χωρητικότητα του αποθηκευτικού χώρου σε GB.
     */
    public Computer(int id, String productCode, String name, Manufacturer manufacturer, double price, int quantity, int ramSize, int storageCapacity) {
        super(id, productCode, name, manufacturer, price, quantity);
        this.ramSize = ramSize;
        this.storageCapacity = storageCapacity;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    } 
    
    /**
     * Συνθέτει τα γενικά στοιχεία του προϊόντος με τα ειδικά τεχνικά χαρακτηριστικά του υπολογιστή.
     *
     * @return Μια συμβολοσειρά (String) με την πλήρη περιγραφή της συσκευής.
     */
    @Override
    public String toString() {
        return super.toString() +
               "\nΜέγεθος RAM: " + ramSize + " GB" + 
               "\nΜέγεθος Αποθηκευτικού Χώρου: " + storageCapacity + " GB";
    }
    
    /**
     * Επιστρέφει τον σταθερό τύπο του προϊόντος για τον διαχωρισμό του στη βάση δεδομένων.
     * Υλοποιεί την αφηρημένη μέθοδο της υπερκλάσης {@link Product} και χρησιμοποιείται
     * για την αποθήκευση της σωστής τιμής στη στήλη product_type.
     *
     * @return Η συμβολοσειρά "COMPUTER" που προσδιορίζει την κατηγορία του προϊόντος.
     */
    @Override
    public String productType() {
        return "COMPUTER";
    }
}