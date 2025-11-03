/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;

import CapaException.BDException;
import CapaLogica.Docente;
import java.sql.*;
import java.util.ArrayList;

public class PersistenciaDocente {

    public void guardar(Docente d) throws BDException {
        final String sql = "INSERT INTO docente (cedula_docente, nombre_docente, apellido_docente) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, d.getCedula());
            ps.setString(2, d.getNombre());
            ps.setString(3, d.getApellido());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new BDException("Error guardando docente", e);
        }
    }

    public Docente buscarPorCedula(String cedula) throws BDException {
        final String sql = "SELECT cedula_docente, nombre_docente, apellido_docente FROM docente WHERE cedula_docente = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Docente(
                        rs.getString("cedula_docente"),
                        rs.getString("nombre_docente"),
                        rs.getString("apellido_docente")
                    );
                }
                return null;
            }
        } catch (SQLException e) {
            throw new BDException("Error buscando docente", e);
        }
    }

    public ArrayList<Docente> listar() throws BDException {
        final String sql = "SELECT cedula_docente, nombre_docente, apellido_docente FROM docente ORDER BY apellido_docente, nombre_docente";
        ArrayList<Docente> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Docente(
                    rs.getString("cedula_docente"),
                    rs.getString("nombre_docente"),
                    rs.getString("apellido_docente")
                ));
            }
        } catch (SQLException e) {
            throw new BDException("Error listando docentes", e);
        }
        return lista;
    }
}
