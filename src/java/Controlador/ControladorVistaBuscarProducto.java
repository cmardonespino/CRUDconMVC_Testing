/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Producto;
import Vista.VistaBuscarProducto;
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
public class ControladorVistaBuscarProducto implements ActionListener{
    
    VistaBuscarProducto vbp = new VistaBuscarProducto();
    VistaGeneral vg = new VistaGeneral();
    
    Producto producto = new Producto();
    
    public ControladorVistaBuscarProducto(VistaBuscarProducto vbp, Producto prod){
        this.producto=prod;
        this.vbp=vbp;
        this.vg=vg;
        
        JButton buscar = this.vbp.btnBuscarProducto;
        JButton atras = this.vbp.btnAtras;
        
        buscar.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                        ArrayList<Producto> p = new ArrayList<Producto>();
                        ArrayList<Producto> p2 = new ArrayList<Producto>();
                        
                        String nombreProducto = vbp.txtFieldNombreProducto.getText().toString();
                        
                        p = producto.verificarSiExisteProducto(nombreProducto);
                        if(p.isEmpty()){
                            JOptionPane.showConfirmDialog(vg, "NOMBRE DEL PRODUCTO INGRESADO NO EXISTE");
                        }else{
                            String filas[] = new String[100];
                            DefaultTableModel m;
                            String nombresRows[] = {"Nombre Producto", "Cantidad", "Precio"};
                            m = new DefaultTableModel(null, nombresRows);
                            vbp.tableBuscarProductos.setModel(m);
                            
                            int j=0;
                            for(int i=0;i<p.size();i++){
                                filas[j]=String.valueOf(p.get(i).getNombre());
                                j++;
                                filas[j]= String.valueOf(p.get(i).getCantidad());
                                j++;
                                filas[j]= String.valueOf(p.get(i).getPrecio());
                                j++;
                                if(j==3)
                                    j=0;
                                m.addRow(filas);
                                vbp.tableBuscarProductos.setModel(m);
                            }
                            
                            vbp.txtFieldNombreProducto.setText("");
                        }
                    }
                }
        );
        
        atras.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    ControladorVistaGeneral cvg = new ControladorVistaGeneral(vg, producto);
                    vg.setVisible(true);
                    vbp.setVisible(false);
                }
            }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
