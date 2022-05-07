package Controlador;

import Modelo.Servicios;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlServicios {
    
    public JTable tabla1;

    public ControlServicios() {
    }
    public ControlServicios(JTable tab){
        tabla1 = tab;
    }
    public void SelServicios(){
        int cont = 1;
        Servicios servicios = new Servicios();
        servicios.setCantidadServicios();
        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
        model.setRowCount(0);
        while(cont <= servicios.getCantidadServicios()){
            servicios.selectServicios(cont);
            String Data[] = {String.valueOf(servicios.getID_Servicio()), servicios.getServicio(), String.valueOf(servicios.getprecio())};
            model.addRow(Data);
            tabla1.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabla1.getColumnModel().getColumn(2).setPreferredWidth(1);
            tabla1.setModel(model);  
            cont++;
        }
    }
    public void insServicios(){
        Servicios servicios = new Servicios();
        servicios.setCantidadServicios();
        String value = JOptionPane.showInputDialog(null, "Ingrese el nombre del servicio");
        String value1 = JOptionPane.showInputDialog(null, "Ingrese el costo del servicio");
        if(value.isEmpty() || value1.isEmpty()){
            JOptionPane.showMessageDialog(null, "Llene todos los campos");
        }else{
            servicios.setServicio(value);
            servicios.setprecio(Integer.parseInt(value1));
            servicios.insertServicios();
            JOptionPane.showMessageDialog(null, "Servicio agregado!");  
        }
    }
}
