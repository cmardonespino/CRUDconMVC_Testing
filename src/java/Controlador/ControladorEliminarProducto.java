/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Vista.VistaEliminarProducto;
import Vista.VistaGeneral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author CarlosAndres
 */
public class ControladorEliminarProducto implements ActionListener{

    VistaGeneral vg = new VistaGeneral();
    VistaEliminarProducto vep = new VistaEliminarProducto();
    Producto producto = new Producto();
    
    public ControladorEliminarProducto(VistaEliminarProducto vep, Producto producto){
        this.producto=producto;
        this.vep=vep;
        this.vg=vg;
        
        ArrayList<Producto> p = new ArrayList<Producto>();
        p = producto.capturarNombreProductos();
        JComboBox jcbox = new JComboBox();
        for(int i=0;i<p.size();i++){
            vep.jComboBoxNombreProducto.addItem(String.valueOf(p.get(i).getNombre()));
        }
        
        JButton eliminar = this.vep.btnEliminar;
        JButton atras = this.vep.btnAtras;
     
        eliminar.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    String nombreProducto = vep.jComboBoxNombreProducto.getSelectedItem().toString();
                    if(producto.eliminarProducto(nombreProducto)==true){
                        JOptionPane.showMessageDialog(vep, "PRODUCTO ELIMINADO EXITOSAMENTE");
                    }else{
                        JOptionPane.showMessageDialog(vep, "PROBLEMAS AL ELIMINAR PRODUCTO");
                    }
                }
            
        });
        
        
        atras.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    ControladorVistaGeneral cvg = new ControladorVistaGeneral(vg, producto);
                    vg.setVisible(true);
                    vep.setVisible(false);
                }
            
        });
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
