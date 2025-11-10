/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/programacion"; 
        String user = "root";
        String pass = "";

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexión exitosa!");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

    

