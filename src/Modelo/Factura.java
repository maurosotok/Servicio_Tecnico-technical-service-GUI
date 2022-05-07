package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Factura {
    private int ID_Factura;
    private int ID_Cliente;
    private String Nombre;
    private String Servicio;
    private String Paquete;
    private int Costo;
    private int CantidadUserFactura = 0;
    private int CantidadFactura;
    private boolean validar;
    private int Total;
    public int getID_Factura() {
        return ID_Factura;
    }

    public int getTotal() {
        return Total;
    }
    public void setID_Factura(int ID_Factura) {
        this.ID_Factura = ID_Factura;
    }
    public int getID_Cliente() {
        return ID_Cliente;
    }
    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
        this.ID_Cliente = this.ID_Cliente +1;
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
    public int getCosto() {
        return Costo;
    }
    public int getCantidadFactura(){
        return CantidadFactura;
    }
    public int getCantidadUserFactura(){
        return CantidadUserFactura;
    }
    public boolean accessed(){
        return validar;
    }
    public Factura AgregarFactura(){
        try { //IDFactura, ID Cliente, Nombre, Servicio, Paquete, Costo
            String sql;
            sql = "Insert into factura values (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = new Conexion().getConnection().prepareStatement(sql);
            ps.setInt(1, ID_Factura);
            ps.setInt(2, ID_Cliente);
            ps.setString(3, Nombre);
            ps.setString(4, Servicio);
            ps.setString(5, Paquete);
            ps.setInt(6, Costo);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Factura setvaluePaquete(int value){
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
    public Factura setvalueServicios(int value){
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
    public Factura setCantidadFacturas(){
        try {
            String sql = "select count(*) from factura";
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Factura = rs.getInt("count(*)");
                CantidadFactura = rs.getInt("count(*)");
            }
            ID_Factura = ID_Factura + 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Factura setCosto(int Paqueteid, int Servicioid){
        try {
            int valor = 0, valor1 = 0;
            Paqueteid = Paqueteid +1;
            Servicioid = Servicioid + 1;
            String sql = "select * from paquetes where ID_Paquete = "+Paqueteid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                valor = rs.getInt("Precio");
            }
            String sql2 = "select * from servicios where ID_Servicio = "+Servicioid;
            ResultSet rs2 = new Conexion().getStatement().executeQuery(sql2);
            while(rs2.next()){
                valor1 = rs2.getInt("Precio");
            }
            Costo = valor + valor1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Factura selectFactura(int id){
        try {
            //id = id +1;
            validar = false;
            String sql = "select * from factura where ID_Cliente = "+ID_Cliente+" and ID_Factura = "+id;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                validar = true;
                ID_Factura = rs.getInt("ID_Factura");
                Nombre = rs.getString("Nombre");
                Servicio = rs.getString("Servicio");
                Paquete = rs.getString("Paquete");
                Costo = rs.getInt("Costo");
                Total = Total + Costo;
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Factura setCantidadperUserFacturas(int id){
        try {
            id = id +1;
            String sql = "select * from factura where ID_Cliente = "+id;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                CantidadUserFactura++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return this;
    }
    public Factura verTotal(){
        String sql = "";
        
        
        return this;
    }
}
