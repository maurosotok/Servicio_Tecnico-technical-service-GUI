package Controlador;

import Modelo.Credito;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlCredito {
    
    int line;
    JTable tabla1, Tablacredito;
    JComboBox cliente, cantidad;
    public ControlCredito(int rowselect, JComboBox cli, JComboBox cantid){
        line = rowselect;
        cliente = cli;
        cantidad = cantid;
    }
    public ControlCredito(){
        
    }
    public ControlCredito(JTable seleccredito){
        Tablacredito = seleccredito;
        
    }
    public void agregarcredito(){
        if("Público General".equals(String.valueOf(cliente.getSelectedItem()))){
        }else{
            Credito credito = new Credito();
            credito.setCantidadCredito();
            credito.setNombre(String.valueOf(cliente.getSelectedItem()));
            credito.setTotal(cantidad.getSelectedIndex(), line);
            credito.setProducto(line);
            credito.insertcredito();
            
        }
    }
    public void selecredito(){
        Credito credito = new Credito();
        credito.setCantidadCredito();
        int cont = 1;
        while(cont<=credito.getCantidadCredito()){
            DefaultTableModel model = (DefaultTableModel) Tablacredito.getModel();
            credito.selectCredito(cont);
            String Data[] = {String.valueOf(credito.getID_Transaccion()), credito.getNombre(), credito.getProducto(), String.valueOf(credito.getTotal())};
            model.addRow(Data);
            Tablacredito.setModel(model);
            cont++;
        }
    }
}
