/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Vista.VistaActualizarProducto;
import Vista.VistaAgregarProducto;
import Vista.VistaBuscarProducto;
import Vista.VistaEliminarProducto;
import Vista.VistaGeneral;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CarlosAndres
 */
public class ControladorVistaGeneral implements ActionListener{
    VistaGeneral vg = new VistaGeneral();
    Producto producto = new Producto();
    
    public ControladorVistaGeneral(VistaGeneral vgeneral, Producto prod){
        this.vg=vgeneral;
        this.producto=prod;
        
        JButton agregar = this.vg.btnAgregar;
        JButton buscar = this.vg.btnBuscar;
        JButton actualizar = this.vg.btnModificar;
        JButton eliminar = this.vg.btnEliminar;
        JButton salir = this.vg.btnSalir;
        
        agregar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        VistaAgregarProducto vap = new VistaAgregarProducto();
                        ControladorAgregarProducto cap = new ControladorAgregarProducto(vap, producto);
                        vap.setVisible(true);
                        vg.setVisible(false);
                    }
        });
        
        buscar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                        VistaBuscarProducto vbp = new VistaBuscarProducto();
                        ControladorVistaBuscarProducto cvbp = new ControladorVistaBuscarProducto(vbp, producto);
                        vbp.setVisible(true);
                        vg.setVisible(false);
                    }
                    
        });
        
        actualizar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        VistaActualizarProducto vap = new VistaActualizarProducto();
                        ControladorActualizarProducto cap = new ControladorActualizarProducto(vap, producto);
                        vap.setVisible(true);
                        vg.setVisible(false);
                    }
        });
        
        eliminar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                        VistaEliminarProducto vep = new VistaEliminarProducto();
                        ControladorEliminarProducto cvbp = new ControladorEliminarProducto(vep, producto);
                        vep.setVisible(true);
                        vg.setVisible(false);
                    }
                    
        });
        
        salir.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        vg.setVisible(false);
                        System.exit(0);
                    }
                }
        );
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
