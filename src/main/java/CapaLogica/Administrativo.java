/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

public class Administrativo {
    private String cedulaAdmin;
    private String contrasenia;

    public Administrativo(String cedulaAdmin, String contrasenia) {
        this.cedulaAdmin = cedulaAdmin;
        this.contrasenia = contrasenia;
    }

    public String getCedulaAdmin() { 
        return cedulaAdmin;
    }
    public String getContrasenia() { 
        return contrasenia;
    }
}
