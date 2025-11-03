/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaException.BDException;
import CapaPersistencia.PersistenciaDocente;
import java.util.ArrayList;

public class FachadaDocente {
    private final PersistenciaDocente pd = new PersistenciaDocente();

    public void registrarDocente(Docente d) throws BDException {
        if (d.getCedula() == null || d.getCedula().isBlank()) throw new BDException("Cédula docente obligatoria");
        if (d.getNombre() == null || d.getNombre().isBlank()) throw new BDException("Nombre docente obligatorio");
        if (d.getApellido() == null || d.getApellido().isBlank()) throw new BDException("Apellido docente obligatorio");
        if (pd.buscarPorCedula(d.getCedula()) != null) throw new BDException("El docente ya existe");
        pd.guardar(d);
    }

    public Docente buscar(String cedula) throws BDException {
        return pd.buscarPorCedula(cedula);
    }

    public ArrayList<Docente> listar() throws BDException {
        return pd.listar();
    }
}
