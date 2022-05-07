package Controlador;

import Modelo.Contado;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlContado {
    
    JTable tabla1, Tablacredito;
    int line;
    JComboBox cliente, cantidad;
    public ControlContado(int linea, JComboBox cli, JComboBox cantid){
        line = linea;
        cliente = cli;
        cantidad = cantid;
    }
    public ControlContado(){
        
    }
    public ControlContado(JTable seleccredito){
        Tablacredito = seleccredito;
        
    }
    public void agregarContado(){
        if("Público General".equals(String.valueOf(cliente.getSelectedItem()))){
            Contado credito = new Contado();
            credito.setCantidadContado();
            credito.setNombre(String.valueOf(cliente.getSelectedItem()));
            credito.setProducto(line);
            credito.setTotal(cantidad.getSelectedIndex(), line);
            credito.insertContado();
        }
    }
    public void selecContado(){
        Contado credito = new Contado();
        credito.setCantidadContado();
        int cont = 1;
        while(cont<=credito.getCantidadContado()){
            DefaultTableModel model = (DefaultTableModel) Tablacredito.getModel();
            credito.selectContado(cont);
            String Data[] = {String.valueOf(credito.getID_Transaccion()), credito.getNombre(), credito.getProducto(), String.valueOf(credito.getTotal())};
            model.addRow(Data);
            Tablacredito.setModel(model);
            cont++;
        }
    }
    
}
