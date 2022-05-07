package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Producto {
    private int ID_Producto;
    private String Producto;
    private int Costo;
    private int Existencias;
    private int CantidadProducto;

    public int getCantidadProducto() {
        return CantidadProducto;
    }
    
    public int getID_Producto() {
        return ID_Producto;
    }
    public void setID_Producto(int ID_Producto) {
        this.ID_Producto = ID_Producto;
    }

    public String getProducto() {
        return Producto;
    }
    public void setProducto(String Producto) {
        this.Producto = Producto;
    }
    public int getCosto() {
        return Costo;
    }
    public void setCosto(int Costo) {
        this.Costo = Costo;
    }
    public int getExistencias() {
        return Existencias;
    }
    public void setExistencias(int Existencias) {
        this.Existencias = Existencias;
    }
    public Producto VerProdcuto(int productoid){
        try {
            String sql = "select * from producto where ID_Producto = "+productoid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Producto = rs.getInt("ID_Producto");
                Producto = rs.getString("Producto");
                Costo = rs.getInt("Costo");
                Existencias = rs.getInt("Existencias");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Producto SetCantidadProductos(){
        try {
            String sql = "select count(*) from producto";
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                CantidadProducto = rs.getInt("count(*)");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return this;
    }
    public Producto reducestock(int cantidad, int productoid){//int cantidad, int productoid
        try { // update producto set Existencias = 500 where ID_Producto = 1
            int actual = 0;
            productoid = productoid + 1;
            String sql = "select * from producto where ID_Producto = "+productoid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                actual = rs.getInt("Existencias");
            }
            int reduccion = actual - cantidad;
            String sql2 = "update producto set Existencias = ? where ID_Producto =  ?";
            PreparedStatement ps = new Conexion().getConnection().prepareStatement(sql2);
            ps.setInt(1, reduccion);
            ps.setInt(2, productoid);
            ps.executeUpdate();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        
        
        return this;
    }
}
