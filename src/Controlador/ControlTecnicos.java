package Controlador;


import Modelo.Tecnicos;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControlTecnicos {
    JTable tabla1;
    JOptionPane nombre;
    public ControlTecnicos() {
    }
    public ControlTecnicos(JTable tab){
        tabla1 = tab;
    }
    public ControlTecnicos(JOptionPane name){
        nombre = name;
    }
    public void SelTecnicos(){
        int cont = 1;
        Tecnicos Tecnicos = new Tecnicos();
        Tecnicos.setCantidadTecnicos();
        DefaultTableModel model = (DefaultTableModel) tabla1.getModel();
        model.setRowCount(0);
        while(cont <=Tecnicos.getCantidadTecnicos()){
            Tecnicos.selectTecnicos(cont);
            String Data[] = {String.valueOf(Tecnicos.getID_Tecnico()), Tecnicos.getNombre_Tec()};
            model.addRow(Data);
            tabla1.setModel(model);  
            cont++;
        }
    }
    public void inseTecnico(){
        Tecnicos tecnico = new Tecnicos();
        tecnico.setCantidadTecnicos();
        String value = JOptionPane.showInputDialog(null, "Ingrese el nombre del tecnico");
        if(value.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor llene el campo.");
        }else{
            tecnico.insertTecnicos(value);
            JOptionPane.showMessageDialog(null, "Ténico agregado!");
        }
        
    }
}
