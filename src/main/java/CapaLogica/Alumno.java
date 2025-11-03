/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaLogica;

public class Alumno {
    private int idAlumno;

    public Alumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAlumno() { return idAlumno; }
    public void setIdAlumno(int idAlumno) { this.idAlumno = idAlumno; }

    @Override
    public String toString() { return "Alumno{id=" + idAlumno + "}"; }
}
