/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.techproductmanagerdb.Backend;

/**
 * Αντιπροσωπεύει έναν κατασκευαστή (Manufacturer) τεχνολογικών προϊόντων.
 * Αποθηκεύει τα βασικά στοιχεία επικοινωνίας και αναγνώρισης της εταιρείας,
 * όπως τον κωδικό, το όνομα και το email της.
 * * @author Lenovo
 */
public class Manufacturer {
    private int id;
    private String manufacturerCode;
    private String name;
    private  String email;

    /**
     * Κατασκευάζει έναν νέο κατασκευαστή με τα απαραίτητα στοιχεία χωρίς ID.
     * Χρησιμοποιείται κυρίως κατά τη δημιουργία ενός νέου κατασκευαστή στην εφαρμογή,
     * πριν αυτός εισαχθεί στη βάση δεδομένων, καθώς το ID θα παραχθεί αυτόματα (AUTO_INCREMENT).
     *
     * @param manufacturerCode Ο μοναδικός κωδικός του κατασκευαστή (π.χ. APP, SAM).
     * @param name             Το όνομα της εταιρείας του κατασκευαστή.
     * @param email            Το email επικοινωνίας του κατασκευαστή.
     */
    public Manufacturer(String manufacturerCode, String name, String email) {
        this.manufacturerCode = manufacturerCode;
        this.name = name;
        this.email = email;
    }

    /**
     * Κατασκευάζει έναν κατασκευαστή αναθέτοντάς του ένα ήδη υπάρχον ID.
     * Χρησιμοποιείται κατά την ανάκτηση (SELECT) των δεδομένων από τη βάση δεδομένων,
     * όπου το ID είναι ήδη γνωστό και έχει παραχθεί από το σύστημα.
     *
     * @param id               Το μοναδικό αναγνωριστικό του κατασκευαστή όπως ορίστηκε από τη βάση.
     * @param manufacturerCode Ο μοναδικός κωδικός του κατασκευαστή.
     * @param name             Το όνομα της εταιρείας του κατασκευαστή.
     * @param email            Το email επικοινωνίας του κατασκευαστή.
     */
    public Manufacturer(int id, String manufacturerCode, String name, String email) {
        this.id = id;
        this.manufacturerCode = manufacturerCode;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Μορφοποιεί τα στοιχεία του κατασκευαστή σε κείμενο.
     *
     * @return Μια συμβολοσειρά (String) με τα δεδομένα του κατασκευαστή.
     */
    @Override
    public String toString() {
        return "ID: " + id + " | Κωδικός: " + manufacturerCode + " | Όνομα: " + name + " | Email: " + email;
    }
}