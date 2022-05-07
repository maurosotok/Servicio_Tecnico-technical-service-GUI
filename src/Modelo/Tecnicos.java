package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Tecnicos {
    private int ID_Tecnico;
    private String Nombre_Tec;
    
    private int CantidadTecnicos;

    public int getCantidadTecnicos() {
        return CantidadTecnicos;
    }
    
    public int getID_Tecnico() {
        return ID_Tecnico;
    }
    public void setID_Tecnico(int ID_Tecnico) {
        this.ID_Tecnico = ID_Tecnico;
    }
    public String getNombre_Tec() {
        return Nombre_Tec;
    }
    public void setNombre_Tec(String Nombre_Tec) {
        this.Nombre_Tec = Nombre_Tec;
    }
    
    
    public Tecnicos selectTecnicos(int Tecnicoid){
        try {
            String sql = "select * from tecnicos where ID_Tecnico = "+Tecnicoid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Tecnico = rs.getInt("ID_Tecnico");
                Nombre_Tec = rs.getString("Nombre_Tec");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Tecnicos setCantidadTecnicos(){
        try {
            String sql = "select count(*) from tecnicos";
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Tecnico = rs.getInt("count(*)");
                CantidadTecnicos= rs.getInt("count(*)");
            }
            ID_Tecnico = ID_Tecnico + 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return this;
    }
    public Tecnicos insertTecnicos(String Nombre_Te){
        try {
            String sql = "insert into tecnicos values (?, ?)";
            PreparedStatement ps = new Conexion().getConnection().prepareStatement(sql);
            ps.setInt(1, ID_Tecnico);
            ps.setString(2, Nombre_Te);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
}
