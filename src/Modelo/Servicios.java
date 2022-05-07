package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Servicios {
    private int ID_Servicio;
    private String Servicio;
    private int Precio;
    private int CantidadServicios;
    public Servicios() {
    }
    public Servicios(int ID_Servicio, String Servicio, int Precio) {
        this.ID_Servicio = ID_Servicio;
        this.Servicio = Servicio;
        this.Precio = Precio;
    }
    public int getID_Servicio() {
        return ID_Servicio;
    }

    public void setID_Servicio(int ID_Servicio) {
        this.ID_Servicio = ID_Servicio;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }

    public int getprecio() {
        return Precio;
    }
    public int getCantidadServicios() {
        return CantidadServicios;
    }

    public void setprecio(int ID_precio) {
        this.Precio = ID_precio;
    }
    public Servicios selectServicios(int Servicioid){
        try {
            String sql = "select * from servicios where ID_Servicio = "+Servicioid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Servicio = rs.getInt("ID_Servicio");
                Servicio = rs.getString("Servicio");
                Precio = rs.getInt("Precio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Servicios setCantidadServicios(){
        try {
            String sql = "select count(*) from servicios";
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Servicio = rs.getInt("count(*)");
                CantidadServicios= rs.getInt("count(*)");
            }
            ID_Servicio = ID_Servicio + 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Servicios insertServicios(){
        try {
            String sql = "insert into servicios values (?, ?, ?)";
            PreparedStatement ps = new Conexion().getConnection().prepareStatement(sql);
            ps.setInt(1, ID_Servicio);
            ps.setString(2, Servicio);
            ps.setInt(3, Precio);
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
}
