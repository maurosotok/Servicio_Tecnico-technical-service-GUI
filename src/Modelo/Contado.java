
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Contado {
    private int ID_Transaccion;
    private String Nombre;
    private String Producto;
    private int Total;
    private int CantidadContado;

    public int getID_Transaccion() {
        return ID_Transaccion;
    }
    public void setID_Transaccion(int ID_Transaccion) {
        this.ID_Transaccion = ID_Transaccion;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getProducto() {
        return Producto;
    }

    public int getCantidadContado() {
        return CantidadContado;
    }
    
    
    public int getTotal() {
        return Total;
    }
    public void setTotal(int canti, int rowselected) {
        try {
            int temp = 0;
            canti = canti + 1;
            rowselected = rowselected + 1;
            String sql = "select * from producto where ID_Producto = "+rowselected;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                temp = rs.getInt("Costo");
                Producto = rs.getString("Producto");
            }
            Total = temp * canti;

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public Contado setProducto(int rowselect) {
        try {
            rowselect = rowselect + 1;
            String sql = "select * from producto where ID_Producto = "+rowselect;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            
            while(rs.next()){
                Producto = rs.getString("Producto");
            }

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Contado insertContado(){
        try {
            String sql = "insert into Contado values (?, ?, ?, ?)";
            PreparedStatement ps = new Conexion().getConnection().prepareStatement(sql);
            ps.setInt(1, ID_Transaccion);
            ps.setString(2, Nombre);
            ps.setString(3, Producto);
            ps.setInt(4, Total);
            ps.executeUpdate();
            
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        return this;
    }
    public Contado setCantidadContado(){
        try {
            String sql = "select count(*) from Contado";
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Transaccion = rs.getInt("count(*)");
                CantidadContado= rs.getInt("count(*)");
            }
            ID_Transaccion = ID_Transaccion + 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Contado selectContado(int Contadoid){
        try {
            String sql = "select * from Contado where ID_Transaccion = "+Contadoid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Transaccion = rs.getInt("ID_Transaccion");
                Nombre = rs.getString("Nombre");
                Producto = rs.getString("Producto");
                Total = rs.getInt("Total");
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    
}
