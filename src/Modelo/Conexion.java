package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection con;
    public Conexion(){
        try{
            String url = "jdbc:mysql://127.0.0.2:3306/servicio_tecnico?";
            con = DriverManager.getConnection(url, "root", "unahvs2021");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public Connection getConnection(){
        return con;
    }
    public Statement getStatement(){
        Statement stm = null;
        try {
            stm = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return stm;
    }
    /*public ResultSet getResultSet(){
        ResultSet rs = null;
        try{
            rs = con.
        }catch(Exception e){
            
        }
    }*/
}
