/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.techproductmanager.Frontend;

import com.mycompany.techproductmanager.Backend.Manufacturer;
import com.mycompany.techproductmanager.Backend.Product;
import com.mycompany.techproductmanager.Backend.Computer;
import com.mycompany.techproductmanager.Backend.Shop;
import com.mycompany.techproductmanager.Backend.Sale;
import com.mycompany.techproductmanager.Backend.MobilePhone;
import java.io.IOException;
import java.util.Scanner;


/**
 * Η κλάση διεπαφής χρήστη (ConsoleUI) της εφαρμογής.
 * Υλοποιεί ένα διαδραστικό περιβάλλον γραμμής εντολών (CLI) με μενού πλοήγησης,
 * επιτρέποντας στον χρήστη να διαχειρίζεται προϊόντα, κατασκευαστές και πωλήσεις
 * μέσω του πληκτρολογίου.
 * * @author John
 */
public class ConsoleUI {
    /** Αντικείμενο Scanner για την ανάγνωση των εισαγωγών του χρήστη. */
    Scanner scanner;
    /** Το backend αντικείμενο του καταστήματος για την εκτέλεση των λειτουργιών. */
    Shop shop;

    /**
     * Η κύρια μέθοδος (main) εκκίνησης ολόκληρης της εφαρμογής.
     *
     * @param args Τα ορίσματα της γραμμής εντολών (δεν χρησιμοποιούνται).
     */
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();
        consoleUI.menu();
    }
    
    /**
     * Κατασκευάζει το αντικείμενο της διεπαφής αρχικοποιώντας τον Scanner
     * και δημιουργώντας ένα νέο αντικείμενο {@link Shop} για τη διαχείριση των δεδομένων.
     */
    public ConsoleUI() {
        scanner = new Scanner(System.in);
        shop = new Shop();
    }
    
    /**
     * Εμφανίζει το κεντρικό μενού διαχείρισης της εφαρμογής.
     * Διαβάζει την επιλογή του χρήστη, ελέγχει για σφάλματα πληκτρολόγησης 
     * και καλεί τα αντίστοιχα υπομενού. Κατά την έξοδο, αποθηκεύει τα δεδομένα.
     */
    void menu() {
        int choice = 0;
        
        do {
            clsWin();
            
            System.out.println("     Μ Ε Ν Ο Υ   Δ Ι Α Χ Ε Ι Ρ Ι Σ Η Σ");
            System.out.println("     ====================================\n");
            System.out.println("[1]...Διαχείριση Υπολογιστών (Εισαγωγή/Διόρθωση/Διαγραφή)");
            System.out.println("[2]...Διαχείριση Κινητών (Εισαγωγή/Διόρθωση/Διαγραφή)");
            System.out.println("[3]...Διαχείριση Κατασκευαστών (Εισαγωγή/Προβολή)");
            System.out.println("[4]...Νέα Πώληση Προϊόντος");
            System.out.println("[5]...Στατιστικά Πωλήσεων & Αναφορές");
            System.out.println("[6]...Έξοδος");
            System.out.print("\nΕπιλογή : ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Λάθος εισαγωγή! Παρακαλώ δώστε έναν αριθμό από το 1 έως το 6.");
                pause();
                continue;
            }
            
            switch(choice) {
                case 1: computerMenu();
                    break;
                case 2: mobileMenu();
                    break;
                case 3: manufacturerMenu();
                    break;
                case 4: newSale();
                    break;
                case 5: statsMenu();
                    break;
                case 6: 
                    break;
                default: 
                    System.out.println("Λάθος επιλογή!");
                    pause();
            }
        } while (choice != 6);        
    }
    
    /**
     * Εμφανίζει το υπομενού που είναι αποκλειστικά υπεύθυνο για τη διαχείριση των Υπολογιστών.
     * Προσφέρει επιλογές για προβολή, προσθήκη, διόρθωση και διαγραφή.
     */
    public void computerMenu() {
        int choice = 0;
        
        do {
            clsWin();
            
            System.out.println("     Δ Ι Α Χ Ε Ι Ρ Ι Σ Η   Υ Π Ο Λ Ο Γ Ι Σ Τ Ω Ν");
            System.out.println("     ==============================================\n");
            System.out.println("[1]...Προβολή Υπολογιστών");
            System.out.println("[2]...Προσθήκη Νέου Υπολογιστη");
            System.out.println("[3]...Διόρθωση Στοιχείων Υπολογιστή");
            System.out.println("[4]...Διαγραφή Υπολογιστή");
            System.out.println("[5]...Επιστροφή στο Κεντρικό Μενού");
            System.out.print("\nΕπιλογή : ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Λάθος εισαγωγή! Παρακαλώ δώστε έναν αριθμό από το 1 έως το 5.");
                pause();
                continue;
            }
            
            switch(choice) {
                case 1: showComputers();
                    break;
                case 2: addComputer();
                    break;
                case 3: updateComputer();
                    break;
                case 4: deleteComputer();
                    break;
                case 5: 
                    break;
                default: 
                    System.out.println("Λάθος επιλογή!");
                    pause();
            }
        } while (choice != 5); 
    }
    
    /**
     * Φιλτράρει και εκτυπώνει αναλυτικά στην κονσόλα όλα τα προϊόντα
     * που αποτελούν στιγμιότυπα της κλάσης {@link Computer}.
     */
    public void showComputers() {
        clsWin();
        
        System.out.println("    ΠΡΟΒΟΛΗ ΥΠΟΛΟΓΙΣΤΩΝ");
        System.out.println("    ----------------------\n");
        
        boolean hasComputers = false;
        
        for (Product product : shop.getProducts()) {
            if (product instanceof Computer) {
                hasComputers = true;
                break;
            }
        }

        if (!hasComputers) {
            System.out.println("Δεν υπάρχουν καταχωρημένοι υπολογιστές στο σύστημα.");
            pause();
            return;
        }
        
        for(Product product : shop.getProducts()) {
            if(product instanceof Computer) {
                System.out.println("====================================");
                System.out.println(product);
            }
        }
        System.out.println("====================================");
        
        pause();
    }
    
    /**
     * Καθοδηγεί τον χρήστη βήμα-βήμα στην εισαγωγή ενός νέου υπολογιστή.
     * Ελέγχει την εγκυρότητα του κωδικού και των αριθμητικών δεδομένων,
     * συνδέοντας τη συσκευή με έναν έγκυρο κατασκευαστή.
     */
    public void addComputer() {
        String productCode;
        String name;
        Manufacturer manufacturer;
        double price;
        int quantity;
        int ramSize;
        int storageCapacity;
        
        Product product;
        
        clsWin();
        
        if(shop.getManufacturers().isEmpty()) {
            System.out.println("Δεν υπάρχουν διαθέσιμοι κατασκευεστές στο σύστημα.");
            System.out.println("Παρακαλώ πηγαίνετε πρώτα στο μενού [3] για να κάνετε Προσθήκη Κατασκευαστή.");
            pause();
            return;
        }
        
        System.out.println("    ΕΙΣΑΓΩΓΗ ΝΕΟΥ ΥΠΟΛΟΓΙΣΤΗ");
        System.out.println("    ---------------------------\n");
        System.out.print("Κωδικός: ");
        productCode = scanner.nextLine();
        
        product = shop.getProductByCode(productCode);
        if(product != null) {
            System.out.println("Υπάρχει ήδη προϊόν με αυτόν τον κωδικό.");
            pause();
            return;
        }
        
        System.out.print("Όνομα: ");
        name = scanner.nextLine();
        
        try {
            System.out.print("Τιμή: ");
            price = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Ποσότητα/Απόθεμα: ");
            quantity = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Μέγεθος RAM: ");
            ramSize = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Μέγεθος αποθηκευτικού χώρου: ");
            storageCapacity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Σφάλμα: Δώσατε άκυρη τιμή! Η εισαγωγή ακυρώθηκε.");
            pause();
            return;
        }
        
        System.out.println("Διαθέσιμοι Κατασκευαστές στο Σύστημα:");
        System.out.println("-------------------------------------");
        
        for(Manufacturer tempManufacturer : shop.getManufacturers()) {
            System.out.println("[ID: " + tempManufacturer.getId() + "] -> " + tempManufacturer.getName());
        }
        
        int manufacturerId = -1;
        
        do {
            try {
                System.out.print("Δώσε το ID του Κατασκευαστή για αυτόν τον Υπολογιστή: ");
                manufacturerId = Integer.parseInt(scanner.nextLine());
                
                if(shop.getManufacturer(manufacturerId) == null) {
                    System.out.println("Δεν υπάρχει αυτός ο κατασκευαστής. Ξαναδοκίμασε.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while(shop.getManufacturer(manufacturerId) == null);
        
        manufacturer = shop.getManufacturer(manufacturerId);
        product = new Computer(productCode, name, manufacturer, price, quantity, ramSize, storageCapacity);
        shop.insertProduct(product);
        
        System.out.println("Ο υπολογιστής προστέθηκε επιτυχώς!");
        
        pause();
    }
    
    /**
     * Επιτρέπει την εύρεση και την πλήρη επεξεργασία των στοιχείων ενός υπολογιστή
     * (Όνομα, Τιμή, Απόθεμα, RAM, Δίσκο και Κατασκευαστή) με βάση το ID του.
     */
    public void updateComputer() {
        String name;
        Manufacturer manufacturer;
        double price;
        int quantity;
        int ramSize;
        int storageCapacity;
        
        clsWin();
        
        System.out.println("    ΔΙΟΡΘΩΣΗ ΣΤΟΙΧΕΙΩΝ ΥΠΟΛΟΓΙΣΤΗ");
        System.out.println("    --------------------------------\n");
        
        boolean hasComputers = false;
        
        for (Product product : shop.getProducts()) {
            if (product instanceof Computer) {
                hasComputers = true;
                break;
            }
        }

        if (!hasComputers) {
            System.out.println("Δεν υπάρχουν καταχωρημένοι υπολογιστές στο σύστημα.");
            pause();
            return;
        }
        
        System.out.println("Λίστα Υπολογιστών:");
        for (Product product : shop.getProducts()) {
            if (product instanceof Computer) {
                System.out.println("[ID: " + product.getId() + "] - " + product.getName());
            }
        }
        
        int productId = -1;
        boolean isFound = false;

        do {
            try {
                System.out.print("\nΔώσε το ID του υπολογιστή προς διόρθωση (ή 0 για ακύρωση): ");
                productId = Integer.parseInt(scanner.nextLine());

                if (productId == 0) {
                    System.out.println("Η διόρθωση ακυρώθηκε.");
                    pause();
                    return;
                }
                
                Product product = shop.getProduct(productId);
                if(product == null || !(product instanceof Computer)) {
                    System.out.println("Λάθος ID! Δεν βρέθηκε υπολογιστής με αυτό το ID. Ξαναδοκίμασε.");
                } else {
                    isFound = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while (!isFound);
        
        Computer computer = (Computer) shop.getProduct(productId);
        
        System.out.print("Όνομα: ");
        name = scanner.nextLine();
        computer.setName(name);
        
        try {
            System.out.print("Τιμή: ");
            price = Double.parseDouble(scanner.nextLine());
            computer.setPrice(price);
            
            System.out.print("Ποσότητα/Απόθεμα: ");
            quantity = Integer.parseInt(scanner.nextLine());
            computer.setQuantity(quantity);
            
            System.out.print("Μέγεθος RAM: ");
            ramSize = Integer.parseInt(scanner.nextLine());
            computer.setRamSize(ramSize);
            
            System.out.print("Μέγεθος αποθηκευτικού χώρου: ");
            storageCapacity = Integer.parseInt(scanner.nextLine());
            computer.setStorageCapacity(storageCapacity);
        } catch (NumberFormatException e) {
            System.out.println("Σφάλμα: Δώσατε άκυρη τιμή! Η διόρθωση ακυρώθηκε.");
            pause();
            return;
        }
        
        System.out.println("Διαθέσιμοι Κατασκευαστές στο Σύστημα:");
        System.out.println("-------------------------------------");
        
        for(Manufacturer tempManufacturer : shop.getManufacturers()) {
            System.out.println("[ID: " + tempManufacturer.getId() + "] -> " + tempManufacturer.getName());
        }
        
        int manufacturerId = -1;
        
        do {
            try {
                System.out.print("Δώσε το ID του Κατασκευαστή για αυτόν τον Υπολογιστή: ");
                manufacturerId = Integer.parseInt(scanner.nextLine());
                
                if(shop.getManufacturer(manufacturerId) == null) {
                    System.out.println("Δεν υπάρχει αυτός ο κατασκευαστής.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while(shop.getManufacturer(manufacturerId) == null);
        
        manufacturer = shop.getManufacturer(manufacturerId);
        computer.setManufacturer(manufacturer);
        shop.updateProduct(computer);
        
        System.out.println("Ο υπολογιστής διορθώθηκε επιτυχώς!");
        
        pause();
    }
    
    /**
     * Αναλαμβάνει τη διαδικασία οριστικής διαγραφής ενός υπολογιστή από το σύστημα 
     * με βάση το ID που εισάγει ο χρήστης.
     */
    public void deleteComputer() {
        clsWin();
        
        System.out.println("    ΔΙΑΓΡΑΦΗ ΥΠΟΛΟΓΙΣΤΗ");
        System.out.println("    -------------------\n");
        
        boolean hasComputers = false;

        for (Product product : shop.getProducts()) {
            if (product instanceof Computer) {
                hasComputers = true;
                break;
            }
        }

        if (!hasComputers) {
            System.out.println("Δεν υπάρχουν καταχωρημένοι υπολογιστές στο σύστημα.");
            pause();
            return;
        }

        System.out.println("Λίστα Υπολογιστών:");
        for (Product product : shop.getProducts()) {
            if (product instanceof Computer) {
                System.out.println("[ID: " + product.getId() + "] - " + product.getName());
            }
        }
        
        int productId;
        boolean isDeleted = false;

        do {
            try {
                System.out.print("\nΔώσε το ID του υπολογιστή προς διαγραφή (ή 0 για ακύρωση): ");
                productId = Integer.parseInt(scanner.nextLine());

                if (productId == 0) {
                    System.out.println("Η διαγραφή ακυρώθηκε.");
                    pause();
                    return;
                }
                
                Product product = shop.getProduct(productId);
                if(product == null || !(product instanceof Computer)) {
                    System.out.println("Λάθος ID! Δεν βρέθηκε υπολογιστής με αυτό το ID. Ξαναδοκίμασε.");
                } else {
                    shop.deleteProduct(product);
                    isDeleted = true;
                    System.out.println("O υπολογιστής διαγράφηκε επιτυχώς!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while (!isDeleted);
        
        pause();
    }
    
    /**
     * Εμφανίζει το υπομενού που είναι αποκλειστικά υπεύθυνο για τη διαχείριση των Κινητών Τηλεφώνων.
     * Προσφέρει επιλογές για προβολή, προσθήκη, διόρθωση και διαγραφή.
     */
    public void mobileMenu() {
        int choice = 0;
        
        do {
            clsWin();
            System.out.println("     Δ Ι Α Χ Ε Ι Ρ Ι Σ Η   Κ Ι Ν Η Τ Ω Ν");
            System.out.println("     ======================================\n");
            System.out.println("[1]...Προβολή Κινητών");
            System.out.println("[2]...Προσθήκη Νέου Κινητού");
            System.out.println("[3]...Διόρθωση Στοιχείων Κινητού");
            System.out.println("[4]...Διαγραφή Κινητού");
            System.out.println("[5]...Επιστροφή στο Κεντρικό Μενού");
            System.out.print("\nΕπιλογή : ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Λάθος εισαγωγή! Παρακαλώ δώστε έναν αριθμό από το 1 έως το 5.");
                pause();
                continue;
            }
            
            switch(choice) {
                case 1: showMobilePhones();
                    break;
                case 2: addMobilePhone();
                    break;
                case 3: updateMobilePhone();
                    break;
                case 4: deleteMobilePhone();
                    break;
                case 5:
                    break;
                default: 
                    System.out.println("Λάθος επιλογή!");
                    pause();
            }
        } while (choice != 5); 
    }
    
    /**
     * Φιλτράρει και εκτυπώνει αναλυτικά στην κονσόλα όλα τα προϊόντα
     * που αποτελούν στιγμιότυπα της κλάσης {@link MobilePhone}.
     */
    public void showMobilePhones() {
        clsWin();
        
        System.out.println("    ΠΡΟΒΟΛΗ ΚΙΝΗΤΩΝ ΤΗΛΕΦΩΝΩΝ");
        System.out.println("    ----------------------------\n");
        
        boolean hasMobiles = false;
        
        for (Product product : shop.getProducts()) {
            if (product instanceof MobilePhone) {
                hasMobiles = true;
                break;
            }
        }

        if (!hasMobiles) {
            System.out.println("Δεν υπάρχουν καταχωρημένοι κινητά στο σύστημα.");
            pause();
            return;
        }
        
        for(Product product : shop.getProducts()) {
            if(product instanceof MobilePhone) {
                System.out.println("====================================");
                System.out.println(product);
            }
        }
        System.out.println("====================================");
        
        pause();
    }
    
    /**
     * Καθοδηγεί τον χρήστη στην εισαγωγή ενός νέου κινητού τηλεφώνου.
     * Ελέγχει την εγκυρότητα του κωδικού και των τεχνικών χαρακτηριστικών (Κάμερα, Χρώμα),
     * συνδέοντας τη συσκευή με έναν έγκυρο κατασκευαστή.
     */
    public void addMobilePhone() {
        String productCode;
        String name;
        Manufacturer manufacturer;
        double price;
        int quantity;
        int cameraResolution;
        String color;
        
        Product product;
        
        clsWin();
        
        if(shop.getManufacturers().isEmpty()) {
            System.out.println("Δεν υπάρχουν διαθέσιμοι κατασκευεστές στο σύστημα.");
            System.out.println("Παρακαλώ πηγαίνετε πρώτα στο μενού [3] για να κάνετε Προσθήκη Κατασκευαστή.");
            pause();
            return;
        }
        
        System.out.println("    ΕΙΣΑΓΩΓΗ ΝΕΟΥ ΚΙΝΗΤΟΥ");
        System.out.println("    ------------------------\n");
        System.out.print("Κωδικός: ");
        productCode = scanner.nextLine();
        
        product = shop.getProductByCode(productCode);
        if(product != null) {
            System.out.println("Υπάρχει ήδη προϊόν με αυτόν τον κωδικό.");
            pause();
            return;
        }
        
        System.out.print("Όνομα: ");
        name = scanner.nextLine();
        
        try {
            System.out.print("Τιμή: ");
            price = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Ποσότητα/Απόθεμα: ");
            quantity = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Ανάλυση Κάμερας (MP): ");
            cameraResolution = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Σφάλμα: Δώσατε άκυρη τιμή! Η εισαγωγή ακυρώθηκε.");
            pause();
            return;
        }
        
        System.out.print("Χρώμα: ");
        color = scanner.nextLine();
        
        System.out.println("Διαθέσιμοι Κατασκευαστές στο Σύστημα:");
        System.out.println("-------------------------------------");
        
        for(Manufacturer tempManufacturer : shop.getManufacturers()) {
            System.out.println("[ID: " + tempManufacturer.getId() + "] -> " + tempManufacturer.getName());
        }
        
        int manufacturerId = -1;
        
        do {
            try {
                System.out.print("Δώσε το ID του Κατασκευαστή για αυτό το Κινητό: ");
                manufacturerId = Integer.parseInt(scanner.nextLine());
                
                if(shop.getManufacturer(manufacturerId) == null) {
                    System.out.println("Δεν υπάρχει αυτός ο κατασκευαστής.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while(shop.getManufacturer(manufacturerId) == null);
        
        manufacturer = shop.getManufacturer(manufacturerId);
        product = new MobilePhone(productCode, name, manufacturer, price, quantity, cameraResolution, color);
        shop.insertProduct(product);
        
        System.out.println("Το κινητό προστέθηκε επιτυχώς!");
        
        pause();
    }
    
    /**
     * Επιτρέπει την εύρεση και την πλήρη επεξεργασία των στοιχείων ενός κινητού τηλεφώνου
     * (Όνομα, Τιμή, Απόθεμα, Ανάλυση Κάμερας, Χρώμα και Κατασκευαστή) με βάση το ID του.
     */
    public void updateMobilePhone() {
        String name;
        Manufacturer manufacturer;
        double price;
        int quantity;
        int cameraResolution;
        String color;
        
        clsWin();
        
        System.out.println("    ΔΙΟΡΘΩΣΗ ΣΤΟΙΧΕΙΩΝ ΚΙΝΗΤΟΥ");
        System.out.println("    -----------------------------\n");
        
        boolean hasMobiles = false;
        
        for (Product product : shop.getProducts()) {
            if (product instanceof MobilePhone) {
                hasMobiles = true;
                break;
            }
        }

        if (!hasMobiles) {
            System.out.println("Δεν υπάρχουν καταχωρημένα κινητά στο σύστημα.");
            pause();
            return;
        }
        
        System.out.println("Λίστα Κινητών:");
        for (Product product : shop.getProducts()) {
            if (product instanceof MobilePhone) {
                System.out.println("[ID: " + product.getId() + "] - " + product.getName());
            }
        }
        
        int productId = -1;
        boolean isFound = false;

        do {
            try {
                System.out.print("\nΔώσε το ID του κινητού προς διόρθωση (ή 0 για ακύρωση): ");
                productId = Integer.parseInt(scanner.nextLine());

                if (productId == 0) {
                    System.out.println("Η διόρθωση ακυρώθηκε.");
                    pause();
                    return;
                }
                
                Product product = shop.getProduct(productId);
                if(product == null || !(product instanceof MobilePhone)) {
                    System.out.println("Λάθος ID! Δεν βρέθηκε κινητό με αυτό το ID. Ξαναδοκίμασε.");
                } else {
                    isFound = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while (!isFound);
        
        MobilePhone mobile = (MobilePhone) shop.getProduct(productId);
        
        System.out.print("Όνομα: ");
        name = scanner.nextLine();
        mobile.setName(name);
        
        try {
            System.out.print("Τιμή: ");
            price = Double.parseDouble(scanner.nextLine());
            mobile.setPrice(price);
            
            System.out.print("Ποσότητα/Απόθεμα: ");
            quantity = Integer.parseInt(scanner.nextLine());
            mobile.setQuantity(quantity);
            
            System.out.print("Ανάλυση Κάμερας: ");
            cameraResolution = Integer.parseInt(scanner.nextLine());
            mobile.setCameraResolution(cameraResolution);
        } catch (NumberFormatException e) {
            System.out.println("Σφάλμα: Δώσατε άκυρη τιμή! Η διόρθωση ακυρώθηκε.");
            pause();
            return;
        }
        
        System.out.print("Χρώμα: ");
        color = scanner.nextLine();
        mobile.setColor(color);
        
        System.out.println("Διαθέσιμοι Κατασκευαστές στο Σύστημα:");
        System.out.println("-------------------------------------");
        
        for(Manufacturer tempManufacturer : shop.getManufacturers()) {
            System.out.println("[ID: " + tempManufacturer.getId() + "] -> " + tempManufacturer.getName());
        }
        
        int manufacturerId = -1;
        
        do {
            try {
                System.out.print("Δώσε το ID του Κατασκευαστή για αυτό το Κινητό: ");
                manufacturerId = Integer.parseInt(scanner.nextLine());
                
                if(shop.getManufacturer(manufacturerId) == null) {
                    System.out.println("Δεν υπάρχει αυτός ο κατασκευαστής.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while(shop.getManufacturer(manufacturerId) == null);
        
        manufacturer = shop.getManufacturer(manufacturerId);
        mobile.setManufacturer(manufacturer);
        shop.updateProduct(mobile);
        
        System.out.println("Το κινητό διορθώθηκε επιτυχώς!");
        
        pause();
    }
    
    /**
     * Αναλαμβάνει τη διαδικασία οριστικής διαγραφής ενός κινητού τηλεφώνου από το σύστημα 
     * με βάση το ID που εισάγει ο χρήστης.
     */
    public void deleteMobilePhone() {
        clsWin();
        
        System.out.println("    ΔΙΑΓΡΑΦΗ ΚΙΝΗΤΟΥ");
        System.out.println("    -------------------\n");
        
        boolean hasMobiles = false;

        for (Product product : shop.getProducts()) {
            if (product instanceof MobilePhone) {
                hasMobiles = true;
                break;
            }
        }

        if (!hasMobiles) {
            System.out.println("Δεν υπάρχουν καταχωρημένα κινητά στο σύστημα.");
            pause();
            return;
        }

        System.out.println("Λίστα Κινητών:");
        for (Product product : shop.getProducts()) {
            if (product instanceof MobilePhone) {
                System.out.println("[ID: " + product.getId() + "] - " + product.getName());
            }
        }
        
        int productId;
        boolean isDeleted = false;

        do {
            try {
                System.out.print("\nΔώσε το ID του κινητού προς διαγραφή (ή 0 για ακύρωση): ");
                productId = Integer.parseInt(scanner.nextLine());

                if (productId == 0) {
                    System.out.println("Η διαγραφή ακυρώθηκε.");
                    pause();
                    return;
                }
                
                Product product = shop.getProduct(productId);
                if(product == null || !(product instanceof MobilePhone)) {
                    System.out.println("Λάθος ID! Δεν βρέθηκε κινητό με αυτό το ID. Ξαναδοκίμασε.");
                } else {
                    shop.deleteProduct(product);
                    isDeleted = true;
                    System.out.println("Το κινητό διαγράφηκε επιτυχώς!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while (!isDeleted);
        
        pause();
    }
    
    /**
     * Εμφανίζει το υπομενού διαχείρισης των κατασκευαστών.
     * Παρέχει επιλογές για την προβολή των υπαρχόντων ή την καταχώρηση νέου κατασκευαστή.
     */
    public void manufacturerMenu() {
        int choice = 0;
        
        do {
            clsWin();
            System.out.println("     Δ Ι Α Χ Ε Ι Ρ Ι Σ Η   Κ Α Τ Α Σ Κ Ε Υ Α Σ Τ Ω Ν");
            System.out.println("     ==================================================\n");
            System.out.println("[1]...Προβολή Κατασκευαστών");
            System.out.println("[2]...Προσθήκη Νέου Κατασκευαστή");
            System.out.println("[3]...Επιστροφή στο Κεντρικό Μενού");
            System.out.print("\nΕπιλογή : ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Λάθος εισαγωγή! Δώστε αριθμό.");
                pause();
                continue;
            }
            
            switch(choice) {
                case 1: showManufacturers();
                    break;
                case 2: addManufacturer();
                    break;
                case 3: 
                    break;
                default: 
                    System.out.println("Λάθος επιλογή!");
                    pause();
            }
        } while (choice != 3); 
    }
    
    /**
     * Εκτυπώνει αναλυτικά στην οθόνη τη λίστα όλων των καταχωρημένων κατασκευαστών.
     */
    public void showManufacturers() {
        clsWin();
        
        System.out.println("    ΠΡΟΒΟΛΗ ΚΑΤΑΣΚΕΥΑΣΤΩΝ");
        System.out.println("    ------------------------\n");
        
        if(shop.getManufacturers().isEmpty()) {
            System.out.println("Δεν υπάρχουν διαθέσιμοι κατασκευεστές στο σύστημα.");
            pause();
            return;
        }
        
        for(Manufacturer manufacturer : shop.getManufacturers()) {
            System.out.println(manufacturer);
        }
        
        pause();
    }
    
     /**
     * Καθοδηγεί τον χρήστη στην εισαγωγή ενός νέου κατασκευαστή,
     * ελέγχοντας αν ο κωδικός του υπάρχει ήδη καταχωρημένος στο σύστημα.
     */
    public void addManufacturer() {
        String manufacturerCode;
        String name;
        String email;
        
        Manufacturer manufacturer;
        
        clsWin();
        
        System.out.println("    ΕΙΣΑΓΩΓΗ ΝΕΟΥ ΚΑΤΑΣΚΕΥΑΣΤΗ");
        System.out.println("    -----------------------------\n");
        
        System.out.print("Κωδικός: ");
        manufacturerCode = scanner.nextLine();
        
        manufacturer = shop.getManufacturerByCode(manufacturerCode);
        if(manufacturer != null) {
            System.out.println("Yπάρχει ήδη αυτός ο κατασκευαστής.");
            pause();
            return;
        }
        
        System.out.print("Όνομα: ");
        name = scanner.nextLine();
        
        System.out.print("Email: ");
        email = scanner.nextLine();
        
        manufacturer = new Manufacturer(manufacturerCode, name, email);

        shop.insertManufacturer(manufacturer);
        
        System.out.println("Ο κατασκευαστής προστέθηκε επιτυχώς!");
        pause();
    }
    
    /**
     * Εκκινεί τη ροή μιας νέας πώλησης. Εμφανίζει τα διαθέσιμα προϊόντα, ζητάει το ID
     * και την επιθυμητή ποσότητα, ελέγχει αν το απόθεμα επαρκεί, ενημερώνει την αποθήκη
     * και δημιουργεί ένα νέο αντικείμενο {@link Sale}.
     */
    public void newSale() {
        clsWin();
        
        System.out.println("    Ν Ε Α   Π Ω Λ Η Σ Η   Π Ρ Ο Ϊ Ο Ν Τ Ο Σ");
        System.out.println("    ==========================================\n");

        if (shop.getProducts().isEmpty()) {
            System.out.println("Δεν υπάρχουν διαθέσιμα προϊόντα στο κατάστημα για πώληση.");
            pause();
            return;
        }

        System.out.println("Διαθέσιμα Προϊόντα στην Αποθήκη:");
        System.out.println("====================================");
        for (Product product : shop.getProducts()) {
            System.out.println("[ID: " + product.getId() + "] " + product.getName() + 
                               " | Απόθεμα: " + product.getQuantity() + " τεμ. | Τιμή: " + product.getPrice() + "€");
        }
        System.out.println("====================================");
        
        int productId = -1;
        boolean isFound = false;

        do {
            try {
                System.out.print("\nΔώσε το ID του προϊόντος προς πώληση (ή 0 για ακύρωση): ");
                productId = Integer.parseInt(scanner.nextLine());

                if (productId == 0) {
                    System.out.println("Η πώληση ακυρώθηκε.");
                    pause();
                    return;
                }
                
                Product product = shop.getProduct(productId);
                if(product == null) {
                    System.out.println("Λάθος ID! Δεν βρέθηκε προϊόν με αυτό το ID. Ξαναδοκίμασε.");
                } else {
                    isFound = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Μη αριθμητικό ID! Παρακαλώ δώστε μόνο ψηφία.");
            }
        } while (!isFound);
        
        Product product = shop.getProduct(productId);
        
        int quantitySold = 0;
        
        try {
            System.out.print("Δώσε ποσότητα τεμαχίων προς πώληση: ");
            quantitySold = Integer.parseInt(scanner.nextLine());
        } catch(NumberFormatException e) {
            System.out.println("Άκυρη μορφή ποσότητας! Η πώληση ακυρώθηκε.");
            pause();
            return;
        }
        
        if(quantitySold <= 0) {
            System.out.println("Ακύρωση: Η ποσότητα πρέπει να είναι μεγαλύτερη από το μηδέν.");
            pause();
            return;
        }
        
        if(quantitySold > product.getQuantity()) {
            System.out.println("Ανεπαρκές απόθεμα! (Διαθέσιμα τεμάχια στην αποθήκη: " + product.getQuantity() + ")");
            pause();
            return;
        }
        
        product.setQuantity(product.getQuantity() - quantitySold);
        Sale sale = new Sale(product, quantitySold);
        shop.insertSale(sale);
        
        System.out.println("====================================");
        System.out.println("Η ΠΩΛΗΣΗ ΟΛΟΚΛΗΡΩΘΗΚΕ ΕΠΙΤΥΧΩΣ!");
        System.out.println("====================================");
        System.out.println(sale);
        System.out.println("====================================");
        
        pause(); 
    }
    
    /**
     * Εμφανίζει το μενού των στατιστικών αναφορών, επιτρέποντας την επιλογή 
     * μεταξύ γενικών συνόλων, ανάλυσης ανά κατηγορία ή ανά κατασκευαστή.
     */
    public void statsMenu() {
        int choice = 0;
        
        do {
            clsWin();
            
            System.out.println("     Σ Τ Α Τ Ι Σ Τ Ι Κ Α   Π Ω Λ Η Σ Ε Ω Ν   &   Π Ρ Ο Ϊ O Ν Τ Α");
            System.out.println("     ==============================================================\n");
            System.out.println("[1]...Προβολή Όλων των Πωλήσεων (Ιστορικό & Γενικά Σύνολα)");
            System.out.println("[2]...Στατιστικά ανά Κατηγορία Συσκευής (Υπολογιστές vs Κινητά Τηλέφωνα)");
            System.out.println("[3]...Στατιστικά ανά Κατασκευαστή (Apple, Samsung, Dell κλπ.)");
            System.out.println("[4]...Επιστροφή στο Κεντρικό Μενού");
            System.out.print("\nΕπιλογή : ");
            
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Λάθος εισαγωγή! Παρακαλώ δώστε έναν αριθμό από το 1 έως το 4.");
                pause();
                continue;
            }
            
            switch(choice) {
                case 1: showAllSalesStats();
                    break;
                case 2: showCategoryStats();
                    break;
                case 3: showManufacturerStats();
                    break;
                case 4: 
                    break;
                default: 
                    System.out.println("Λάθος επιλογή!");
                    pause();
            }
        } while (choice != 4); 
    }
    
    /**
     * Υπολογίζει και εμφανίζει τα συνολικά έσοδα του καταστήματος, τα συνολικά τεμάχια
     * που έχουν πουληθεί και εκτυπώνει το πλήρες ιστορικό όλων των καταγεγραμμένων πωλήσεων.
     */
    public void showAllSalesStats() {
        clsWin();
        
        System.out.println("     Γ Ε Ν Ι Κ Α   Σ Τ Α Τ Ι Σ Τ Ι Κ Α   Π Ω Λ Η Σ Ε Ω Ν");
        System.out.println("     ======================================================\n");

        if (shop.getSales().isEmpty()) {
            System.out.println("Δεν έχουν πραγματοποιηθεί πωλήσεις ακόμα στο κατάστημα.");
            pause();
            return;
        }
        
        double totalIncome = 0;
        int totalQuantity = 0;
        
        for(Sale sale : shop.getSales()) {
            totalIncome += (sale.getQuantity() * sale.getProduct().getPrice());
            totalQuantity += sale.getQuantity();
        }
        
        System.out.println("ΣΥΝΟΛΙΚΑ ΣΤΑΤΙΣΤΙΚΑ ΚΑΤΑΣΤΗΜΑΤΟΣ");
        System.out.println("--------------------------------");
        System.out.println("Συνολικά Έσοδα: " + totalIncome + " €");
        System.out.println("Συνολικά Τεμάχια: " + totalQuantity + " κομμάτια");
        System.out.println("--------------------------------");
        
        System.out.println("ΑΝΑΛΥΤΙΚΟ ΙΣΤΟΡΙΚΟ ΠΩΛΗΣΕΩΝ");
        
        for(Sale sale : shop.getSales()) {
            System.out.println("======================================");
            System.out.println(sale);
        }
        System.out.println("======================================");
        
        pause();
    }
    
    /**
     * Διαχωρίζει τις πωλήσεις με βάση τον τύπο του προϊόντος (Υπολογιστές vs Κινητά)
     * και εκτυπώνει ξεχωριστά έσοδα και τεμάχια για κάθε μία από τις δύο κατηγορίες.
     */
    public void showCategoryStats() {
        clsWin();
        
        System.out.println("     Σ Τ Α Τ Ι Σ Τ Ι Κ Α   Π Ω Λ Η Σ Ε Ω Ν   Α Ν Α   Κ Α Τ Η Γ Ο Ρ Ι Α");
        System.out.println("     ====================================================================\n");

        if (shop.getSales().isEmpty()) {
            System.out.println("Δεν έχουν πραγματοποιηθεί πωλήσεις ακόμα στο κατάστημα.");
            pause();
            return;
        }
        
        double computerIncome = 0;
        int computerQty = 0;
        
        double mobileIncome = 0;
        int mobileQty = 0;
        
        for(Sale sale : shop.getSales()) {
            if(sale.getProduct() instanceof Computer) {
                computerIncome += (sale.getQuantity() * sale.getProduct().getPrice());
                computerQty += sale.getQuantity();
            }
            
            if(sale.getProduct() instanceof MobilePhone) {
                mobileIncome += (sale.getQuantity() * sale.getProduct().getPrice());
                mobileQty += sale.getQuantity();
            }
        }
        
        System.out.println("ΥΠΟΛΟΓΙΣΤΕΣ");
        System.out.println("--------------------------------");
        System.out.println("Συνολικά Έσοδα: " + computerIncome + " €");
        System.out.println("Συνολικά Τεμάχια: " + computerQty + " κομμάτια");
        System.out.println("--------------------------------");
        
        System.out.println("ΚΙΝΗΤΑ ΤΗΛΕΦΩΝΑ");
        System.out.println("--------------------------------");
        System.out.println("Συνολικά Έσοδα: " + mobileIncome + " €");
        System.out.println("Συνολικά Τεμάχια: " + mobileQty + " κομμάτια");
        System.out.println("--------------------------------");
        
        pause();
    }
    
    /**
     * Ομαδοποιεί το ιστορικό των πωλήσεων ανά κατασκευαστή και εκτυπώνει 
     * τα συγκεντρωτικά έσοδα και κομμάτια για κάθε brand ξεχωριστά, 
     * εκτελώντας ελέγχους για την αποφυγή κρασαρισμάτων.
     */
    public void showManufacturerStats() {
        clsWin();
        
        System.out.println("     Σ Τ Α Τ Ι Σ Τ Ι Κ Α   Π Ω Λ Η Σ Ε Ω Ν   Α Ν Α   Κ Α Τ Α Σ Κ Ε Υ Α Σ Τ Η");
        System.out.println("     ==========================================================================\n");

        if (shop.getSales().isEmpty()) {
            System.out.println("Δεν έχουν πραγματοποιηθεί πωλήσεις ακόμα στο κατάστημα.");
            pause();
            return;
        }
        
        System.out.println("ΚΑΤΑΣΚΕΥΑΣΤΕΣ");
        System.out.println("--------------------------------");
        
        for(Manufacturer manufacturer : shop.getManufacturers()) {
            double manufacturerIncome = 0;
            int manufacturerQty = 0;
            
            for(Sale sale : shop.getSales()) {
                if(sale.getProduct() != null && sale.getProduct().getManufacturer() != null) {
                    if(sale.getProduct().getManufacturer().getId() == manufacturer.getId()) {
                        manufacturerIncome += (sale.getQuantity() * sale.getProduct().getPrice());
                        manufacturerQty += sale.getQuantity();
                    }
                }
            }
            
            if (manufacturerQty > 0) {
                System.out.println("Κατασκευαστής: " + manufacturer.getName());
                System.out.println("Συνολικά Έσοδα: " + manufacturerIncome + " €");
                System.out.println("Συνολικά Τεμάχια: " + manufacturerQty + " κομμάτια");
                System.out.println("--------------------------------");
            }
        }
        
        pause();
    }
    
    /**
     * Παγώνει προσωρινά την εκτέλεση της ροής, περιμένοντας από τον χρήστη
     * να πιέσει το πλήκτρο {@code <Enter>} για να επιστρέψει στο μενού.
     */
    public void pause () {
        System.out.print("\n\nΠιέστε <Enter> για συνέχεια  ");
        scanner.nextLine();
    }

    /**
     * Καθαρίζει την οθόνη του τερματικού (Console Clear).
     * Εκτελεί την εντολή {@code cls} των Windows μέσω ενός ProcessBuilder.
     */
    public void clsWin () {
        try {
            new ProcessBuilder ("cmd", "/c", "cls").inheritIO ().
                start(). waitFor ();
        } catch (IOException e) {
            e.getMessage();
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }
}