package Controlador;

import Modelo.Clientes;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControlClientes {
    public JComboBox Clientes;
    JTable tabla1;
    JTextField nombre, identidad, telefono, residencia;
    public ControlClientes() {
    }
    public ControlClientes(JComboBox Clientes) {
        this.Clientes = Clientes;
    }
    public ControlClientes(JTable tab){
        tabla1 = tab;
    }
    public ControlClientes(JTextField nom, JTextField identi, JTextField tel, JTextField resi){
        nombre = nom; identidad = identi; telefono = tel; residencia = resi;
    }
    public void SelClientes(){
        Clientes clientes = new Clientes();
        clientes.setCantidadClientes();
        JComboBox combo1 = new JComboBox();
        int cont = 1;
        while(cont<=clientes.getCantidadClientes()){
            clientes.setNombreCombo(cont);
            combo1.addItem(clientes.getNombre());
            cont++;
        }
        Clientes.setModel(combo1.getModel());
    }
    public void SelectAllFromClientes(){
        Clientes clientes = new Clientes();
        clientes.setCantidadClientes();
        int cont = 1;
        while(cont<=clientes.getCantidadClientes()){
            DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
            clientes.selectClientes(cont);
            String Data[] = {String.valueOf(clientes.getID_Cliente()), clientes.getNombre(), clientes.getIdentidad(), clientes.getTelefono(), clientes.getResidencia()};
            model.addRow(Data);
            tabla1.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabla1.setModel(model); 
            cont++;
        }
    }
    public void AgregarCliente(){
        Clientes clientes = new Clientes();
        clientes.setCantidadClientes();
        clientes.setNombre(nombre.getText());
        clientes.setIdentidad(identidad.getText());
        clientes.setTelefono(telefono.getText());
        clientes.setResidencia(residencia.getText());
        if(nombre.getText().isEmpty() || identidad.getText().isEmpty() || telefono.getText().isEmpty() || residencia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
        }else{
            clientes.AgregarClientes();
        }
    }
    public void SelClientesProductos(){
        Clientes clientes = new Clientes();
        clientes.setCantidadClientes();
        JComboBox combo1 = new JComboBox();
        combo1.addItem("Público General");
        int cont = 1;
        while(cont<=clientes.getCantidadClientes()){
            clientes.setNombreCombo(cont);
            combo1.addItem(clientes.getNombre());
            cont++;
        }
        Clientes.setModel(combo1.getModel());
    }
    
    
}

            