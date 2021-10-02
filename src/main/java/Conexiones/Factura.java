package Conexiones;

/**
 *
 * @author Kenia Martinez
 */

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Factura {

    private int numFact;
    private String fecha;
    private String cliente;
    private String idConcepto;
    protected static int qty;
    private double importe;
    private double subTotal;
    private double desc;
    private double total;
    private String ref;
    private int tipoPago;
    private int idProducto;
    private int idCliente;

    public int getNumFact() {
        return numFact;
    }

    public void setNumFact(int numFact) {
        this.numFact = numFact;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getIdConcepto() {
        return idConcepto;
    }

    public void setIdConcepto(String idConcepto) {
        this.idConcepto = idConcepto;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        Factura.qty = qty;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDesc() {
        return desc;
    }

    public void setDesc(double desc) {
        this.desc = desc;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double CalculoSubTotal() {
        subTotal = importe * qty;
        return subTotal;
    }

    public double CalculoTotal() {
        total = subTotal - desc;
        return total;
    }

    //LLENAR COMBO BOX
    public void LlenarConcepto(JComboBox comboBox) {
        String consulta = "select nombre_producto from Producto";

        try {
            //Prepara la consulta sql
            PreparedStatement pst = Conexion.getConnection().prepareStatement(consulta);
            //Ejecuta la consulta
            ResultSet result = pst.executeQuery();
            comboBox.addItem("Seleccione una opción");

            while (result.next()) { //recorre los resultados
                comboBox.addItem(result.getString("nombre_producto"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
    }

    //BUSCAR CLIENTE
    public void BuscarCliente() {
        String consulta = "select id_cliente from Clientes where identidad = '" + cliente + "'";

        try {
            //Prepara la consulta sql
            PreparedStatement pst = Conexion.getConnection().prepareStatement(consulta);
            //Ejecuta la consulta
            ResultSet result = pst.executeQuery();

            while (result.next()) { //recorre los resultados
                idCliente = Integer.parseInt(result.getString("id_cliente"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void BuscarProducto() {
        String consulta = "SELECT id_producto FROM Producto where nombre_producto = '" + idConcepto + "'";

        try {
            //Prepara la consulta sql
            PreparedStatement pst = Conexion.getConnection().prepareStatement(consulta);
            //Ejecuta la consulta
            ResultSet result = pst.executeQuery();

            while (result.next()) { //recorre los resultados
                idProducto = Integer.parseInt(result.getString("id_producto"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void BuscarImporte(){
        String consulta = "SELECT precio_unitario FROM Producto where nombre_producto = '" + idConcepto + "'";

        try {
            //Prepara la consulta sql
            PreparedStatement pst = Conexion.getConnection().prepareStatement(consulta);
            //Ejecuta la consulta
            ResultSet result = pst.executeQuery();

            while (result.next()) { //recorre los resultados
                importe = Double.parseDouble(result.getString("precio_unitario"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void InsertarFact() throws SQLException {
        CallableStatement entrada = Conexion.getConnection().prepareCall("{call InsertarFactura(?,?,?,?,?)}");

        entrada.setString(1, fecha);
        entrada.setInt(2, idCliente);
        entrada.setDouble(3, desc);
        entrada.setInt(4, tipoPago);
        entrada.setString(5, ref);
        entrada.execute();
    }

    public void InsertarDetalle() throws SQLException {
        String consulta = "SELECT top 1 id_factura FROM Factura order by id_factura desc";

        try {
            //Prepara la consulta sql
            PreparedStatement pst = Conexion.getConnection().prepareStatement(consulta);
            //Ejecuta la consulta
            ResultSet result = pst.executeQuery();

            while (result.next()) { //recorre los resultados
                numFact = Integer.parseInt(result.getString("id_factura"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error" + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
        }

        CallableStatement entrada = Conexion.getConnection().prepareCall("{call InsertarDetalle(?,?,?,?)}");

        entrada.setInt(1, numFact);
        entrada.setInt(2, idProducto);
        entrada.setDouble(3, importe);
        entrada.setInt(4, qty);
        entrada.execute();
    }
    
    public void RestarProductos() throws SQLException {
       
        CallableStatement entrada = Conexion.getConnection().prepareCall("{call RestaProductos(?,?)}");

        entrada.setInt(1, idProducto);
        entrada.setInt(2, qty);
        entrada.execute();
    }
}
