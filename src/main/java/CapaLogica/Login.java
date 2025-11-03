/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaException.BDException;

public class Login {
    private final FachadaAdministrativo fa = new FachadaAdministrativo();

    public boolean validar(String cedula, String pass) {
        try { return fa.validarLogin(cedula, pass); }
        catch (BDException e) { return false; }
    }
}
