package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Ventas {
    private int ID_Venta;
    private String Nombre;
    private String Servicio;
    private String Paquete;
    private String Nombre_Tec;
    private int CantidadVentas;
    public Ventas() {
    }
    public Ventas(int ID_Cliente, String Nombre, String Servicio, String Paquete, String Nombre_Tec) {
        this.ID_Venta = ID_Cliente;
        this.Nombre = Nombre;
        this.Servicio = Servicio;
        this.Paquete = Paquete;
        this.Nombre_Tec = Nombre_Tec;
    }

    public int getCantidadVentas() {
        return CantidadVentas;
    }
    
    public int getID_Cliente() {
        return ID_Venta;
    }
    public void setID_Cliente(int ID_Cliente) {
        this.ID_Venta = ID_Cliente;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getServicio() {
        return Servicio;
    }
    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }
    public String getPaquete() {
        return Paquete;
    }
    public void setPaquete(String Paquete) {
        this.Paquete = Paquete;
    }
    public String getNombre_Tec() {
        return Nombre_Tec;
    }
    public void setNombre_Tec(String Nombre_Tec) {
        this.Nombre_Tec = Nombre_Tec;
    }
    
    public Ventas AgregarVenta(int Clienteid){
        try {
            String sql = "Insert into ventas values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = new Conexion().getConnection().prepareStatement(sql);
            ps.setInt(1, ID_Venta);
            ps.setString(2, Nombre);
            ps.setString(3, Servicio);
            ps.setString(4, Paquete);
            ps.setString(5, Nombre_Tec);
            ps.setInt(6, 1);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Ventas setvalueTecnico(int value){
        try {
            value = value +1;
            String sql = "select * from tecnicos where ID_Tecnico = "+value;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                Nombre_Tec = rs.getString("Nombre_Tec");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Ventas setvaluePaquete(int value){
        try {
            value = value +1;
            String sql = "select * from paquetes where ID_Paquete = "+value;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                Paquete = rs.getString("Paquete");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Ventas setvalueServicios(int value){
        try {
            value = value +1;
            String sql = "select * from servicios where ID_Servicio = "+value;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                Servicio = rs.getString("Servicio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Ventas setCantidadVentas(){
        try {
            String sql = "select count(*) from ventas";
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Venta = rs.getInt("count(*)");
                CantidadVentas = rs.getInt("count(*)");
            }
            ID_Venta = ID_Venta + 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Ventas selectVentas(int Ventasid){
        try {
            String sql = "select * from ventas where ID_Venta = "+Ventasid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Venta = rs.getInt("ID_Venta");
                Nombre = rs.getString("Nombre");
                Servicio = rs.getString("Servicio");
                Paquete = rs.getString("Paquete");
                Nombre_Tec = rs.getString("Nombre_Tec");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    
    
}