/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.techproductmanager.Backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Η κεντρική κλάση διαχείρισης του καταστήματος (Shop).
 * Λειτουργεί ως ο συνδετικός κρίκος του συστήματος, διατηρώντας τις λίστες
 * των προϊόντων, των κατασκευαστών και των πωλήσεων, και αναλαμβάνοντας
 * τη μόνιμη αποθήκευση και φόρτωση των δεδομένων από/σε βάση δεδομένων TiDB Cloud.
 * * @author John
 */
public class Shop {
    private ArrayList<Product> products;
    private ArrayList<Manufacturer> manufacturers;
    private ArrayList<Sale> sales;
    
    /**
     * Αρχικοποιεί τις λίστες των δεδομένων και καλεί αυτόματα τη μέθοδο
     * {@link #loadData()} για να φορτώσει τις υπάρχουσες εγγραφές από τη βάση.
     */
    public Shop() {
        products =  new ArrayList<>();
        manufacturers = new ArrayList<>();
        sales = new ArrayList<>();
        
        loadData();
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    public ArrayList<Sale> getSales() {
        return sales;
    }
    
    /**
     * Αναζητά ένα προϊόν στη λίστα με βάση το ID του.
     *
     * @param id Το ID του προϊόντος.
     * @return Το αντικείμενο {@link Product} αν βρεθεί, αλλιώς {@code null}.
     */
    public Product getProduct(int id) {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Αναζητά έναν κατασκευαστή στη λίστα με βάση το ID του.
     *
     * @param id Το ID του κατασκευαστή.
     * @return Το αντικείμενο {@link Manufacturer} αν βρεθεί, αλλιώς {@code null}.
     */
    public Manufacturer getManufacturer(int id) {
        for(Manufacturer manufacturer : manufacturers) {
            if(manufacturer.getId() == id) {
                return manufacturer;
            }
        }
        return null;
    }
    
    /**
     * Αναζητά μια πώληση στη λίστα με βάση το ID της.
     *
     * @param id Το ID της πώλησης.
     * @return Το αντικείμενο {@link Sale} αν βρεθεί, αλλιώς {@code null}.
     */
    public Sale getSale(int id) {
        for(Sale sale : sales) {
            if(sale.getId() == id) {
                return sale;
            }
        }
        return null;
    }
    
    /**
     * Αναζητά ένα προϊόν χρησιμοποιώντας τον αλφαριθμητικό κωδικό του.
     *
     * @param code Ο μοναδικός κωδικός του προϊόντος (case-insensitive).
     * @return Το αντικείμενο {@link Product} αν βρεθεί, αλλιώς {@code null}.
     */
    public Product getProductByCode(String code) {
        for(Product product : products) {
            if(product.getProductCode().equalsIgnoreCase(code)) {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Αναζητά έναν κατασκευαστή χρησιμοποιώντας τον αλφαριθμητικό κωδικό του.
     *
     * @param code Ο μοναδικός κωδικός του κατασκευαστή (case-insensitive).
     * @return Το αντικείμενο {@link Manufacturer} αν βρεθεί, αλλιώς {@code null}.
     */
    public Manufacturer getManufacturerByCode(String code) {
        for(Manufacturer manufacturer : manufacturers) {
            if(manufacturer.getManufacturerCode().equalsIgnoreCase(code)) {
                return manufacturer;
            }
        }
        return null;
    }
    
    /**
     * Φορτώνει όλα τα δεδομένα (κατασκευαστές, προϊόντα, πωλήσεις) live από τη 
     * βάση δεδομένων και συγχρονίζει τις τοπικές λίστες (ArrayList).
     */
    public final void loadData() {
        this.manufacturers.clear();
        this.products.clear();
        this.sales.clear();

        String selectManufacturers = "SELECT id, manufacturer_code, name, email FROM manufacturers";
        String selectProducts = "SELECT id, product_type, product_code, name, manufacturer_id, price, quantity, ram_size, storage_capacity, camera_resolution, color FROM products";
        String selectSales = "SELECT id, product_id, quantity, sale_timestamp FROM sales";

        try (Connection conn = DBConnection.getConnection()) {

            try (PreparedStatement stmt = conn.prepareStatement(selectManufacturers);
                ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String code = rs.getString("manufacturer_code");
                    String name = rs.getString("name");
                    String email = rs.getString("email");

                    this.manufacturers.add(new Manufacturer(id, code, name, email));
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement(selectProducts);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String type = rs.getString("product_type");
                    String code = rs.getString("product_code");
                    String name = rs.getString("name");
                    int mId = rs.getInt("manufacturer_id");
                    double price = rs.getDouble("price");
                    int qty = rs.getInt("quantity");

                    Manufacturer manufacturer = null;
                    for (Manufacturer m : this.manufacturers) {
                        if (m.getId() == mId) {
                            manufacturer = m;
                            break;
                        }
                    }

                    if ("COMPUTER".equals(type)) {
                        int ram = rs.getInt("ram_size");
                        int storage = rs.getInt("storage_capacity");
                        this.products.add(new Computer(id, code, name, manufacturer, price, qty, ram, storage));
                    } else if ("MOBILE_PHONE".equals(type)) {
                        int camera = rs.getInt("camera_resolution");
                        String color = rs.getString("color");
                        this.products.add(new MobilePhone(id, code, name, manufacturer, price, qty, camera, color));
                    }
                }
            }

            try (PreparedStatement stmt = conn.prepareStatement(selectSales);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    int pId = rs.getInt("product_id");
                    int quantity = rs.getInt("quantity");

                    LocalDateTime timestamp = rs.getTimestamp("sale_timestamp").toLocalDateTime();

                    Product product = null;
                    for (Product p : this.products) {
                        if (p.getId() == pId) {
                            product = p;
                            break;
                        }
                    }

                    if (product != null) {
                        this.sales.add(new Sale(id, product, quantity, timestamp));
                    }
                }
            }

            System.out.println("Τα δεδομένα φορτώθηκαν επιτυχώς από το TiDB Cloud!");

        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά τη φόρτωση των δεδομένων από τη βάση: " + e.getMessage());
        }
    }
    
    /**
     * Εισάγει έναν νέο κατασκευαστή στη βάση δεδομένων και στην τοπική λίστα.
     * Ανακτά αυτόματα το ID που παρήχθη από το AUTO_INCREMENT της βάσης.
     *
     * @param manufacturer Το αντικείμενο {@link Manufacturer} προς εισαγωγή.
     */
    public void insertManufacturer(Manufacturer manufacturer) {
        String sql = "INSERT INTO manufacturers (manufacturer_code, name, email) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, manufacturer.getManufacturerCode());
            pstmt.setString(2, manufacturer.getName());
            pstmt.setString(3, manufacturer.getEmail());
            pstmt.executeUpdate();

            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    manufacturer.setId(keys.getInt(1));
                }
            }

            this.manufacturers.add(manufacturer);
            
        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά την εισαγωγή κατασκευαστή: " + e.getMessage());
        }
    }
    
    /**
     * Ενημερώνει τα στοιχεία ενός υπάρχοντος κατασκευαστή στη βάση δεδομένων.
     * Ο κατασκευαστής εντοπίζεται στη βάση με βάση το μοναδικό του ID.
     *
     * @param manufacturer Το αντικείμενο {@link Manufacturer} με τα ανανεωμένα στοιχεία.
     */
    public void updateManufacturer(Manufacturer manufacturer) {
        String sql = "UPDATE manufacturers SET name = ?, email =? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, manufacturer.getName());
            pstmt.setString(2, manufacturer.getEmail());
            
            pstmt.setInt(3, manufacturer.getId());
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά τη διόρθωση κατασκευαστή: " + e.getMessage());
        }
    }
    
    /**
     * Διαγράφει έναν κατασκευαστή από τη βάση δεδομένων.
     * Λόγω του ON DELETE CASCADE στην SQL, αφαιρεί αυτόματα μέσω removeIf 
     * και όλα τα εξαρτώμενα προϊόντα και τις πωλήσεις τους από τη μνήμη της Java.
     *
     * @param manufacturer Το αντικείμενο {@link Manufacturer} προς διαγραφή.
     */
    public void deleteManufacturer(Manufacturer manufacturer) {
        String sql = "DELETE FROM manufacturers WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, manufacturer.getId());
            pstmt.executeUpdate();

            this.manufacturers.remove(manufacturer);
            
            this.sales.removeIf(sale -> sale.getProduct().getManufacturer().getId() == manufacturer.getId());
            
            this.products.removeIf(product -> product.getManufacturer().getId() == manufacturer.getId());

        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά τη διαγραφή κατασκευαστή: " + e.getMessage());
        }
    }
    
    /**
     * Εισάγει ένα νέο προϊόν (Computer ή MobilePhone) στη βάση δεδομένων.
     * Διαχειρίζεται κατάλληλα τις NULL τιμές για τα πεδία που δεν ανήκουν 
     * στον συγκεκριμένο τύπο προϊόντος.
     *
     * @param product Το αντικείμενο {@link Product} προς εισαγωγή.
     */
    public void insertProduct(Product product) {
        String sql = "INSERT INTO products (product_type, product_code, name, manufacturer_id, price, quantity, ram_size, storage_capacity, camera_resolution, color) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, product.productType());
            pstmt.setString(2, product.getProductCode());
            pstmt.setString(3, product.getName());
            pstmt.setInt(4, product.getManufacturer().getId());
            pstmt.setDouble(5, product.getPrice());
            pstmt.setInt(6, product.getQuantity());
            if(product instanceof Computer) {
                Computer x = (Computer) product;
                pstmt.setInt(7, x.getRamSize());
                pstmt.setInt(8, x.getStorageCapacity());
                pstmt.setNull(9, java.sql.Types.INTEGER);
                pstmt.setNull(10, java.sql.Types.VARCHAR);
            }
            if(product instanceof MobilePhone) {
                MobilePhone x = (MobilePhone) product;
                pstmt.setNull(7, java.sql.Types.INTEGER);
                pstmt.setNull(8, java.sql.Types.INTEGER);
                pstmt.setInt(9, x.getCameraResolution());
                pstmt.setString(10, x.getColor());
            }
            
            pstmt.executeUpdate();

            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    product.setId(keys.getInt(1));
                }
            }

            this.products.add(product);
            
        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά την εισαγωγή προϊόντος: " + e.getMessage());
        }
    }
    
    /**
     * Ενημερώνει τα στοιχεία ενός υπάρχοντος προϊόντος στη βάση δεδομένων.
     * Το προϊόν εντοπίζεται στη βάση με βάση το μοναδικό του ID.
     *
     * @param product Το αντικείμενο {@link Product} με τα ανανεωμένα στοιχεία.
     */
    public void updateProduct(Product product) {
        String sql = "UPDATE products SET name = ?, manufacturer_id = ?, price = ?, quantity = ?, ram_size = ?, storage_capacity = ?, camera_resolution = ?, color = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getName());
            pstmt.setInt(2, product.getManufacturer().getId());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getQuantity());
            if(product instanceof Computer) {
                Computer x = (Computer) product;
                pstmt.setInt(5, x.getRamSize());
                pstmt.setInt(6, x.getStorageCapacity());
                pstmt.setNull(7, java.sql.Types.INTEGER);
                pstmt.setNull(8, java.sql.Types.VARCHAR);
            }
            if(product instanceof MobilePhone) {
                MobilePhone x = (MobilePhone) product;
                pstmt.setNull(5, java.sql.Types.INTEGER);
                pstmt.setNull(6, java.sql.Types.INTEGER);
                pstmt.setInt(7, x.getCameraResolution());
                pstmt.setString(8, x.getColor());
            }
            
            pstmt.setInt(9, product.getId());
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά τη διόρθωση προϊόντος: " + e.getMessage());
        }
    }
    
    /**
     * Διαγράφει ένα προϊόν από τη βάση δεδομένων και την τοπική λίστα.
     * Επίσης, καθαρίζει live από τη μνήμη τις πωλήσεις που συνδέονταν 
     * με αυτό το προϊόν.
     *
     * @param product Το αντικείμενο {@link Product} προς διαγραφή.
     */
    public void deleteProduct(Product product) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, product.getId());
            pstmt.executeUpdate();

            this.products.remove(product);
            
            this.sales.removeIf(sale -> sale.getProduct().getId() == product.getId());

        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά τη διαγραφή προϊόντος: " + e.getMessage());
        }
    }
    
    /**
     * Καταγράφει μια νέα πώληση στη βάση δεδομένων και την προσθέτει στο ιστορικό.
     * Μετατρέπει το LocalDateTime της Java σε Timestamp για συμβατότητα με την SQL.
     *
     * @param sale Το αντικείμενο {@link Sale} προς καταχώρηση.
     */
    public void insertSale(Sale sale) {
        String sql = "INSERT INTO sales (product_id, quantity, sale_timestamp) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setInt(1, sale.getProduct().getId());
            pstmt.setInt(2, sale.getQuantity());
            pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(sale.getTimestamp()));
            pstmt.executeUpdate();

            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) {
                    sale.setId(keys.getInt(1));
                }
            }

            this.sales.add(sale);
            
        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά την εισαγωγή πώλησης: " + e.getMessage());
        }
    }
    
    /**
     * Διαγράφει μια καταχωρημένη πώληση από τη βάση δεδομένων και το ιστορικό της Java.
     *
     * @param sale Το αντικείμενο {@link Sale} προς διαγραφή.
     */
    public void deleteSale(Sale sale) {
        String sql = "DELETE FROM sales WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, sale.getId());
            pstmt.executeUpdate();

            this.sales.remove(sale);

        } catch (SQLException e) {
            System.out.println("Σφάλμα κατά τη διαγραφή πώλησης: " + e.getMessage());
        }
    }
}