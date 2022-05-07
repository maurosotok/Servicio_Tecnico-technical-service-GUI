package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Clientes {
    private int ID_Cliente;
    private String Nombre;
    private String Identidad;
    private String Telefono;
    private String Residencia;
    private int CantidadClientes;
    public int getID_Cliente() {
        return ID_Cliente;
    }

    public int getCantidadClientes() {
        return CantidadClientes;
    }
    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    public String getNombre() {
        return Nombre;
    }
    
    public String getIdentidad() {
        return Identidad;
    }
    public void setIdentidad(String Identidad) {
        this.Identidad = Identidad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getResidencia() {
        return Residencia;
    }

    public void setResidencia(String Residencia) {
        this.Residencia = Residencia;
    }
    
    public Clientes setNombreCombo(int Clienteid) {
        try {
            String sql = "select * from clientes where ID_Cliente = "+Clienteid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                Nombre = rs.getString("Nombre");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    
    public Clientes setCantidadClientes(){
        try {
            String sql = "select count(*) from clientes";
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Cliente = rs.getInt("count(*)");
                CantidadClientes = rs.getInt("count(*)");
            }
            ID_Cliente = ID_Cliente + 1;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Clientes selectClientes(int Servicioid){
        try {
            String sql = "select * from clientes where ID_Cliente = "+Servicioid;
            ResultSet rs = new Conexion().getStatement().executeQuery(sql);
            while(rs.next()){
                ID_Cliente = rs.getInt("ID_Cliente");
                Nombre = rs.getString("Nombre");
                Identidad = rs.getString("Identidad");
                Telefono = rs.getString("Telefono");
                Residencia = rs.getString("Residencia");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    public Clientes AgregarClientes(){
        try {
            String sql = "Insert into clientes values (?, ?, ?, ?, ?)";
            PreparedStatement ps = new Conexion().getConnection().prepareStatement(sql);
            ps.setInt(1, ID_Cliente);
            ps.setString(2, Nombre);
            ps.setString(3, Identidad);
            ps.setString(4, Telefono);
            ps.setString(5, Residencia);
            ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this;
    }
    
    
    
}
