/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Vista.VistaActualizarProducto;
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
public class ControladorActualizarProducto implements ActionListener{
    
    VistaActualizarProducto vap = new VistaActualizarProducto();
    VistaGeneral vg = new VistaGeneral();
    Producto producto = new Producto();
    
    public ControladorActualizarProducto(VistaActualizarProducto vap, Producto producto){
        this.producto=producto;
        this.vap=vap;
        
        ArrayList<Producto> p = new ArrayList<Producto>();
        p = producto.capturarNombreProductos();
        JComboBox jcbox = new JComboBox();
        for(int i=0;i<p.size();i++){
            vap.jComboBoxNombreProducto.addItem(String.valueOf(p.get(i).getNombre()));
        }
        
        JButton actualizar = this.vap.btnActualizar;
        JButton atras = this.vap.btnAtras;
        
        actualizar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String nombreProducto = vap.jComboBoxNombreProducto.getSelectedItem().toString();
                        String cantidad = vap.txtFieldCantidad.getText().toString();
                        String precio = vap.txtFieldPrecio.getText().toString();
                        
                        if(producto.actualizarProducto(nombreProducto, Integer.parseInt(cantidad), Integer.parseInt(precio))==true){
                            JOptionPane.showMessageDialog(vap, "PRODUCTO ACTUALIZADO");
                        }else{
                            JOptionPane.showMessageDialog(vap, "PROBLEMAS AL ACTUALIZAR PRODUCTO");
                        }
                        vap.txtFieldPrecio.setText("");
                        vap.txtFieldCantidad.setText("");
                        vap.jComboBoxNombreProducto.setSelectedIndex(0);
                    }
        });
        
        atras.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    ControladorVistaGeneral cvg = new ControladorVistaGeneral(vg, producto);
                    vg.setVisible(true);
                    vap.setVisible(false);
                }
            }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
