/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;

import CapaException.BDException;
import CapaLogica.Inasistencia;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PersistenciaInasistencia {

    public void registrar(Inasistencia i) throws BDException {
        final String sql = "INSERT INTO inasistencias (cedula_docente, desde, hasta) VALUES (?, ?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, i.getCedulaDocente());
            ps.setDate(2, Date.valueOf(i.getDesde()));
            ps.setDate(3, Date.valueOf(i.getHasta()));
            ps.executeUpdate();
        } catch (SQLException e) {
    e.printStackTrace();
    throw new BDException("Error SQL: " + e.getMessage());


        }
    }

    public ArrayList<Inasistencia> listarTodas() throws BDException {
        final String sql = "SELECT id_inasistencia, cedula_docente, desde, hasta FROM inasistencias ORDER BY desde DESC";
        ArrayList<Inasistencia> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Inasistencia(
                    rs.getInt("id_inasistencia"),
                    rs.getString("cedula_docente"),
                    rs.getDate("desde").toLocalDate(),
                    rs.getDate("hasta").toLocalDate()
                ));
            }
        } catch (SQLException e) {
            throw new BDException("Error listando inasistencias", e);
        }
        return lista;
    }

    public ArrayList<Inasistencia> listarActivas(LocalDate hoy) throws BDException {
        final String sql = "SELECT id_inasistencia, cedula_docente, desde, hasta FROM inasistencias WHERE hasta >= ? ORDER BY hasta ASC";
        ArrayList<Inasistencia> lista = new ArrayList<>();
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(hoy));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new Inasistencia(
                        rs.getInt("id_inasistencia"),
                        rs.getString("cedula_docente"),
                        rs.getDate("desde").toLocalDate(),
                        rs.getDate("hasta").toLocalDate()
                    ));
                }
            }
        } catch (SQLException e) {
            throw new BDException("Error listando inasistencias activas", e);
        }
        return lista;
    }
}
