package Controlador;

import Modelo.Ventas;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;

public class ControlVentas {
    private JTable VerVentas;
    
    JComboBox nombre;
    int LineaTecnico, LineaPaquete, LineaServicio;
    public ControlVentas(int Tecrow, int Paqrow, int Serrow, JComboBox Name){
        LineaTecnico = Tecrow;
        LineaPaquete = Paqrow;
        LineaServicio = Serrow;
        nombre = Name;
    }
    public ControlVentas(JTable tabla) {
        VerVentas = tabla;
    }
    public void addSale(){
        Ventas clientes = new Ventas();
        clientes.setCantidadVentas();
        clientes.setvalueTecnico(LineaTecnico);
        clientes.setNombre(String.valueOf(nombre.getSelectedItem()));
        clientes.setvaluePaquete(LineaPaquete);
        clientes.setvalueServicios(LineaServicio);
        clientes.AgregarVenta(clientes.getID_Cliente());
        JOptionPane.showMessageDialog(null, "Venta agregada con exito!");
    }
    public void SelectAllFromVentas(){
        Ventas ventas = new Ventas();
        ventas.setCantidadVentas();
        int cont = 1;
        while(cont<=ventas.getCantidadVentas()){
            DefaultTableModel model = (DefaultTableModel) VerVentas.getModel();
            ventas.selectVentas(cont);
            String Data[] = {String.valueOf(ventas.getID_Cliente()), ventas.getNombre(), ventas.getServicio(),ventas.getPaquete(),ventas.getNombre_Tec()};
            model.addRow(Data);
            VerVentas.setModel(model);
            cont++;
        }
        
    }
}
