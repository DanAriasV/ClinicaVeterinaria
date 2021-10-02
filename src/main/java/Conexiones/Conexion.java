/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;
import Forms.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
//import java.sql.Statement;
/**
 *
 * @author Kenia Martinez
 */
public class Conexion {

    private static Connection contacto = null;
    private static String usuario = "veterinarios";
    private static String pass = "1234";

    public static Connection getConnection() {
        String conexionUrl = "jdbc:sqlserver://localhost:1433;databaseName=ClinicaVeterinaria";

        try {
            contacto = DriverManager.getConnection(conexionUrl, usuario, pass);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
        return contacto;
    }

    public static ResultSet Consultas(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }

}
