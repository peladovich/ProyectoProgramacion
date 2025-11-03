/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaException.BDException;
import CapaPersistencia.PersistenciaAdministrativo;

public class FachadaAdministrativo {
    private final PersistenciaAdministrativo pa = new PersistenciaAdministrativo();

    public void registrarAdmin(Administrativo a) throws BDException {
        if (a.getCedulaAdmin() == null || a.getCedulaAdmin().isBlank()) throw new BDException("Cédula obligatoria");
        if (a.getContrasenia() == null || a.getContrasenia().isBlank()) throw new BDException("Contraseña obligatoria");
        pa.registrar(a);
    }

    public boolean validarLogin(String cedula, String pass) throws BDException {
        Administrativo a = pa.buscarPorCedula(cedula);
        return a != null && a.getContrasenia().equals(pass);
    }
}
