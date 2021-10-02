/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

//import Forms.*;
//import static Forms.Frm_Inventario.res;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author josea
 */
public class ConexionInventario {

    static ResultSet res;
    private String id;
    private String nombre;
    private String descripcion;
    private String precio;
    private String categoria;
    private String continuidad;
    private String cantidad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getContinuidad() {
        return continuidad;
    }

    public void setContinuidad(String continuidad) {
        this.continuidad = continuidad;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void GetProducto(JTable tablas) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tablas.getModel();
        modelo.setRowCount(0);

        String consulta = "SELECT \n"
                + "id_producto,\n"
                + "nombre_producto,\n"
                + "descripcion_producto,\n"
                + "precio_unitario,\n"
                + "C.nombre_categoria,\n"
                + "\n"
                + "CASE \n"
                + "WHEN continuidad = 0\n"
                + "THEN 'Activo'\n"
                + "ELSE\n"
                + "'Inactivo'\n"
                + "END Continuidad,\n"
                + "cantidad_existencia\n"
                + "\n"
                + "FROM [dbo].[Producto] P\n"
                + "INNER JOIN Categoria C ON C.id_categoria = P.id_categoria";

        try {
            //Prepara la consulta sql
            PreparedStatement pst = Conexion.getConnection().prepareStatement(consulta);
            //Ejecuta la consulta
            res = pst.executeQuery();

            while (res.next()) { //recorre los resultados
                Vector v = new Vector();
                v.add(res.getString(1));
                v.add(res.getString(2));
                v.add(res.getString(3));
                v.add(res.getString(4));
                v.add(res.getString(5));
                v.add(res.getString(6));
                int qty=Integer.parseInt( res.getString(7));
                if(qty<=0){
                    v.add("0");
                }else{
                  v.add(res.getString(7));
                }
                
                modelo.addRow(v);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void InsertProducto() throws SQLException {

        CallableStatement entrada = Conexion.getConnection().prepareCall("{call InsertProductos(?,?,?,?,?,?)}");

        entrada.setString(1, nombre);
        entrada.setString(2, descripcion);
        entrada.setString(3, precio);
        entrada.setString(4, categoria);
        entrada.setString(5, continuidad);
        entrada.setString(6, cantidad);
        entrada.execute();

    }

    public void UpdateProducto() throws SQLException {

        CallableStatement entrada = Conexion.getConnection().prepareCall("{call UpdateProductos(?,?,?,?,?,?,?)}");
        entrada.setString(1, id);
        entrada.setString(2, nombre);
        entrada.setString(3, descripcion);
        entrada.setString(4, precio);
        entrada.setString(5, categoria);
        entrada.setString(6, continuidad);
        entrada.setString(7, cantidad);
        entrada.execute();

    }

}
