/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Vista.VistaAgregarProducto;
import Vista.VistaGeneral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author CarlosAndres
 */
public class ControladorAgregarProducto implements ActionListener{

    VistaGeneral vg = new VistaGeneral();
    VistaAgregarProducto vap = new VistaAgregarProducto();
    Producto producto = new Producto();
    
    public ControladorAgregarProducto(VistaAgregarProducto vap, Producto producto){
        this.producto=producto;
        this.vap=vap;
        
        JButton agregar = this.vap.btnAgregar;
        JButton atras = this.vap.btnAtras;
        
        agregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<Producto> p = new ArrayList<Producto>();
                String nombreProducto = vap.txtFieldNombreProducto.getText().toString();
                String cantidad = vap.txtFieldCantidad.getText().toString();
                String precio = vap.txtFieldPrecio.getText().toString();
                //JOptionPane.showMessageDialog(vg, nombreProducto);
                if(producto.verificarSiExisteProducto(nombreProducto).isEmpty()){
                    if(producto.agregarProducto(nombreProducto, Integer.parseInt(cantidad), Integer.parseInt(precio))==true){
                        JOptionPane.showMessageDialog(vg, "PRODUCTO AGREGADO");
                        vap.txtFieldNombreProducto.setText("");
                        vap.txtFieldCantidad.setText("");
                        vap.txtFieldPrecio.setText("");
                        }else{
                            JOptionPane.showMessageDialog(vg, "PROBLEMAS AL AGREGAR PRODUCTO");
                        }
                    }else{
                        JOptionPane.showMessageDialog(vg, "PRODUCTO YA EXISTE EN EL SISTEMA");
                        vap.txtFieldNombreProducto.setText("");
                        vap.txtFieldCantidad.setText("");
                        vap.txtFieldPrecio.setText("");
                    }
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
