package Controlador;

import Modelo.Paquetes;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlPaquetes {
    
    public JTable tabla1;
    
    public ControlPaquetes() {
    }
    public ControlPaquetes(JTable tab){
        tabla1 = tab;
    }
    public void SelPaquetes(){
        int cont = 1;
        while(cont <4){
            DefaultTableModel modelopaquetes = (DefaultTableModel) tabla1.getModel();
            Paquetes paquetes = new Paquetes().selectPaquetes(cont);
            String tbData[] = {String.valueOf(String.valueOf(paquetes.getID_Paquete())), paquetes.getPaquete(), String.valueOf(paquetes.getPrecio())};
            modelopaquetes.addRow(tbData);
            tabla1.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabla1.getColumnModel().getColumn(2).setPreferredWidth(1);
            tabla1.setModel(modelopaquetes); 
            cont++;
        }
    }
}
