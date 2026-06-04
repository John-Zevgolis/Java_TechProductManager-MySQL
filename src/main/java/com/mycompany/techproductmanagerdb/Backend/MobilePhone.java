/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.techproductmanagerdb.Backend;

/**
 * Αντιπροσωπεύει ένα προϊόν τύπου Κινητού Τηλεφώνου (MobilePhone) στο κατάστημα.
 * Κληρονομεί τα βασικά χαρακτηριστικά από την κλάση {@link Product} και
 * εισάγει επιπλέον προδιαγραφές όπως η ανάλυσης της κάμερας και το χρώμα της συσκευής.
 * * @author John
 */
public class MobilePhone extends Product {
    private int cameraResolution;
    private String color;

    /**
     * Κατασκευάζει ένα νέο κινητό τηλέφωνο με τα καθορισμένα στοιχεία χωρίς ID.
     * Χρησιμοποιείται κυρίως κατά τη δημιουργία ενός νέου προϊόντος στην εφαρμογή,
     * πριν αυτό εισαχθεί στη βάση δεδομένων, καθώς το ID θα παραχθεί αυτόματα (AUTO_INCREMENT).
     * Καλεί τον constructor της υπερκλάσης για τα κοινά πεδία.
     *
     * @param productCode      Ο μοναδικός κωδικός του προϊόντος.
     * @param name             Το όνομα/μοντέλο του κινητού.
     * @param manufacturer     Ο κατασκευαστής της συσκευής.
     * @param price            Η τιμή πώλησης σε ευρώ.
     * @param quantity         Το διαθέσιμο απόθεμα.
     * @param cameraResolution Η ανάλυση της κύριας κάμερας σε Megapixels (MP).
     * @param color            Το χρώμα της συσκευής.
     */
    public MobilePhone(String productCode, String name, Manufacturer manufacturer, double price, int quantity, int cameraResolution, String color) {
        super(productCode, name, manufacturer, price, quantity);
        this.cameraResolution = cameraResolution;
        this.color = color;
    }
    
    /**
     * Κατασκευάζει ένα κινητό τηλέφωνο αναθέτοντάς του ένα ήδη υπάρχον ID.
     * Χρησιμοποιείται κατά την ανάκτηση (SELECT) των δεδομένων από τη βάση δεδομένων,
     * όπου το ID είναι ήδη γνωστό και έχει παραχθεί από το σύστημα.
     * Καλεί τον αντίστοιχο constructor της υπερκλάσης.
     *
     * @param id               Το μοναδικό αναγνωριστικό του προϊόντος από τη βάση.
     * @param productCode      Ο μοναδικός κωδικός του προϊόντος.
     * @param name             Το όνομα/μοντέλο του κινητού.
     * @param manufacturer     Ο κατασκευαστής της συσκευής.
     * @param price            Η τιμή πώλησης σε ευρώ.
     * @param quantity         Το διαθέσιμο απόθεμα.
     * @param cameraResolution Η ανάλυση της κύριας κάμερας σε Megapixels (MP).
     * @param color            Το χρώμα της συσκευής.
     */
    public MobilePhone(int id, String productCode, String name, Manufacturer manufacturer, double price, int quantity, int cameraResolution, String color) {
        super(id, productCode, name, manufacturer, price, quantity);
        this.cameraResolution = cameraResolution;
        this.color = color;
    }

    public int getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(int cameraResolution) {
        this.cameraResolution = cameraResolution;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    /**
     * Συνθέτει τα γενικά στοιχεία του προϊόντος με τα ειδικά τεχνικά χαρακτηριστικά του κινητού.
     *
     * @return Μια συμβολοσειρά (String) με την πλήρη περιγραφή της συσκευής.
     */
    @Override
    public String toString() {
        return super.toString() +
               "\nΑνάλυση Κάμερας: " + cameraResolution + " MP" + 
               "\nΧρώμα: " + color;
    }
    
    /**
     * Επιστρέφει τον σταθερό τύπο του προϊόντος για τον διαχωρισμό του στη βάση δεδομένων.
     * Υλοποιεί την αφηρημένη μέθοδο της υπερκλάσης {@link Product} και χρησιμοποιείται
     * για την αποθήκευση της σωστής τιμής στη στήλη product_type.
     *
     * @return Η συμβολοσειρά "MOBILE_PHONE" που προσδιορίζει την κατηγορία του προϊόντος.
     */
    @Override
    public String productType() {
        return "MOBILE_PHONE";
    }
}