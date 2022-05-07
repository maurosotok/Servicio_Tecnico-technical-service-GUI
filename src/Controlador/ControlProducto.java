package Controlador;

import Modelo.Producto;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlProducto {
    JTable tabla1;
    JComboBox Clientes, cantidad;
    int selectedproduct;
    public ControlProducto(){
        
    }
    public ControlProducto(JTable tab, JComboBox clien){
        tabla1 = tab; Clientes = clien;
        
    }
    public ControlProducto(JTable Tab){
        tabla1 = Tab;
    }
    public ControlProducto (int index, JComboBox cliente, JComboBox cant, JTable Tab){
        cantidad = cant;
        selectedproduct = index;
        Clientes = cliente;
        tabla1 = Tab;
        
    }
    public void VerProductos(){
        Producto producto = new Producto();
        producto.SetCantidadProductos();
        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
        //model.setRowCount(0);
        int cont = 1;
        while(cont<=producto.getCantidadProducto()){
            producto.VerProdcuto(cont);
            String Data[] = {String.valueOf(producto.getID_Producto()), producto.getProducto(), String.valueOf(producto.getCosto()), String.valueOf(producto.getExistencias())};
            model.addRow(Data);
            tabla1.setModel(model);
            cont++;
        }
    }
    public void VenderProducto(){
        Producto producto = new Producto();
        if(selectedproduct == -1){
            JOptionPane.showMessageDialog(null, "Seleccione una fila");
        }else{
            producto.reducestock(Integer.parseInt(String.valueOf(cantidad.getSelectedItem())), selectedproduct);
            JOptionPane.showMessageDialog(null, "Venta de producto realizada!");
        }
        
        
    }
    public void ActualizarProductos(){
        Producto producto = new Producto();
        producto.SetCantidadProductos();
        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
        model.setRowCount(0);
        int cont = 1;
        while(cont<=producto.getCantidadProducto()){
            producto.VerProdcuto(cont);
            String Data[] = {String.valueOf(producto.getID_Producto()), producto.getProducto(), String.valueOf(producto.getCosto()), String.valueOf(producto.getExistencias())};
            model.addRow(Data);
            tabla1.setModel(model);
            cont++;
        }
    }
}
