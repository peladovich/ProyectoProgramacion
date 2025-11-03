/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;

import CapaException.BDException;
import CapaLogica.Administrativo;
import java.sql.*;

public class PersistenciaAdministrativo {

    public void registrar(Administrativo a) throws BDException {
        final String sql = "INSERT INTO administrativo (cedula_admin, contraseña) VALUES (?, ?)";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, a.getCedulaAdmin());
            ps.setString(2, a.getContrasenia());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new BDException("Error registrando administrativo", e);
        }
    }

    public Administrativo buscarPorCedula(String cedula) throws BDException {
        final String sql = "SELECT cedula_admin, contraseña FROM administrativo WHERE cedula_admin = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cedula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Administrativo(rs.getString("cedula_admin"), rs.getString("contraseña"));
                }
                return null;
            }
        } catch (SQLException e) {
            throw new BDException("Error buscando administrativo", e);
        }
    }
}
