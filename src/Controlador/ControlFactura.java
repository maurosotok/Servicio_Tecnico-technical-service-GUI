package Controlador;

import Modelo.Factura;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControlFactura {
    JComboBox cliente, idcliente;
    JTextField monto;
    JTable Tfactura;
    int tpaquetes, tservicios;
    public ControlFactura(){
    }
    public ControlFactura(JComboBox idcli, JTable table, JTextField total){
       idcliente = idcli;
       Tfactura = table;
       monto = total;
    }
    public ControlFactura(JComboBox clien, int tpaq, int tserv){
        cliente = clien;
        tpaquetes = tpaq; tservicios = tserv;
    }
    
    public void AgregarFactura(){
        Factura factura = new Factura();
        factura.setCantidadFacturas(); 
        factura.setID_Cliente(cliente.getSelectedIndex()); 
        factura.setNombre(String.valueOf(cliente.getSelectedItem()));
        factura.setvaluePaquete(tpaquetes);
        factura.setvalueServicios(tservicios);
        factura.setCosto(tpaquetes, tservicios);
        
        factura.AgregarFactura();
    }
    public void VerFactura(){
        Factura factura = new Factura();
        factura.setCantidadFacturas();
        factura.setID_Cliente(idcliente.getSelectedIndex());
        DefaultTableModel model = (DefaultTableModel) Tfactura.getModel();
        model.setRowCount(0);
        int cont = 1;
        while(cont<=factura.getCantidadFactura()){
            factura.selectFactura(cont);
            if(factura.accessed()){
                String Data[] = {String.valueOf(factura.getID_Factura()), factura.getNombre(), factura.getServicio(), factura.getPaquete(), String.valueOf(factura.getCosto())};
                model.addRow(Data);
                Tfactura.setModel(model);
            }
            cont++;
        }
        monto.setText(String.valueOf(factura.getTotal()));
    }
}
