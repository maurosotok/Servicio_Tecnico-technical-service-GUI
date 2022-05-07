package Modelo;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Paquetes {
    private int ID_Paquete; 
    private String Paquete;
    private int Precio;
    
    public Paquetes() {
        
    }
    public Paquetes(int ID_Paquete, String Paquete, int Precio){
        this.ID_Paquete = ID_Paquete;
        this.Paquete = Paquete;
        this.Precio = Precio;
    }
    public int getID_Paquete() {
        return ID_Paquete;
    }
    public void setID_Paquete(int ID_Paquete) {
        this.ID_Paquete = ID_Paquete;
    }
    public String getPaquete() {
        return Paquete;
    }
    public void setPaquete(String Paquete) {
        this.Paquete = Paquete;
    }
    public int getPrecio() {
        return Precio;
    }
    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
    
    public Paquetes selectPaquetes(int Paqueteid){
        try {
            String sql = "select * from Paquetes where ID_Paquete = "+Paqueteid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Paquete = rs.getInt("ID_Paquete");
                Paquete = rs.getString("Paquete");
                Precio = rs.getInt("Precio");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
}
