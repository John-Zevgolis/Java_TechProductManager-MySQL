/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.techproductmanager.Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author John
 */
public class DBConnection {
    private static final String HOST = "gateway01.eu-central-1.prod.aws.tidbcloud.com"; 
    private static final String PORT = "4000";                    
    private static final String DATABASE = "tech_product_manager";          
    private static final String USER = "3AanjvP5Xvf4WV8.root";
    private static final String PASSWORD = "fyYhwZB13Gs85LOU";
    
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?sslMode=VERIFY_IDENTITY";

    /**
     * Δημιουργεί και επιστρέφει μια νέα σύνδεση με το TiDB Cloud.
     * * @return Το αντικείμενο {@link Connection}
     * @throws SQLException Αν αποτύχει η σύνδεση
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Ο MySQL Driver δεν βρέθηκε στο classpath!", e);
        }
    }
}
