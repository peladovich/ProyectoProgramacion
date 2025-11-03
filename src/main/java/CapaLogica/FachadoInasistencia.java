/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import CapaException.BDException;
import CapaPersistencia.PersistenciaDocente;
import CapaPersistencia.PersistenciaInasistencia;
import java.time.LocalDate;
import java.util.ArrayList;

public class FachadoInasistencia {
    private final PersistenciaInasistencia pi = new PersistenciaInasistencia();
    private final PersistenciaDocente pd = new PersistenciaDocente();

    public void registrarDocente(Docente d) throws BDException {
        if (d.getCedula() == null || d.getCedula().isBlank()) throw new BDException("Cédula docente obligatoria");
        pd.guardar(d);
    }

    public void registrarInasistencia(Inasistencia i) throws BDException {
        if (i.getDesde().isAfter(i.getHasta())) throw new BDException("Rango de fechas inválido");
        // Validar que exista el docente
        if (pd.buscarPorCedula(i.getCedulaDocente()) == null) throw new BDException("Docente no existe");
        pi.registrar(i);
    }

    public ArrayList<Inasistencia> verInasistenciasActivas() throws BDException {
        return pi.listarActivas(LocalDate.now());
    }

    public ArrayList<Inasistencia> verInasistenciasTodas() throws BDException {
        return pi.listarTodas();
    }
}
