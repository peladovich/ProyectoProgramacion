/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

import java.time.LocalDate;

public class Inasistencia {
    private int id;
    private String cedulaDocente;
    private LocalDate desde;
    private LocalDate hasta;

    public Inasistencia(int id, String cedulaDocente, LocalDate desde, LocalDate hasta) {
        this.id = id;
        this.cedulaDocente = cedulaDocente;
        this.desde = desde;
        this.hasta = hasta;
    }

    public Inasistencia(String cedulaDocente, LocalDate desde, LocalDate hasta) {
        this(0, cedulaDocente, desde, hasta);
    }

    public int getId() { return id; }
    public String getCedulaDocente() { return cedulaDocente; }
    public LocalDate getDesde() { return desde; }
    public LocalDate getHasta() { return hasta; }
}
