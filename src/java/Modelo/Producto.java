/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author CarlosAndres
 */
public class Producto {
    String nombre;
    int cantidad;
    int precio;
    
    ConexionBasedeDatos conexion; //INSTANCIAMOS LA VARIABLE PARA EL OBJETO CONEXION
    public ResultSet rs;
    private PreparedStatement ps;
    
    public Producto(){
        conexion = new ConexionBasedeDatos(); // GUARDAMOS EL OBJETO DE LA CLASE CONEXION EN ESTA VARIABLE
                                    //PARA LUEGO LLAMAR A LOS METODOS DE ESTA CLASE. EN ESTE CASO
                                    //LLAMAREMOS MAS ABAJO "CONECTAR"
        nombre = "";
        cantidad = 0;
        precio = 0;
    }
    
    public Producto(String nom, int cant, int pre){
        this.nombre=nom;
        this.cantidad=cant;
        this.precio=pre;
        conexion = new ConexionBasedeDatos();
    }
    
    public Producto(int cant){
        this.cantidad=cant;
        conexion = new ConexionBasedeDatos();
    }
    
    public Producto(String nom){
        this.nombre=nom;
        conexion = new ConexionBasedeDatos();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public ArrayList<Producto> verificarSiExisteProducto(String nombreProducto){
        ArrayList<Producto> producto = new ArrayList<Producto>();
        Connection accesoDB = conexion.conectar();
        try{
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM producto WHERE nombre='"+nombreProducto+"'");
            rs = ps.executeQuery();
            int a = 0;
            while(rs.next()) {
               producto.add(new Producto(rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
            accesoDB.close();
            return producto;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return producto;
    }
    
    public Integer verificarCantidadProducto(String nombreProducto){
        Connection accesoDB = conexion.conectar();
        int a = 0;
        try{
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM producto WHERE nombre='"+nombreProducto+"'");
            rs = ps.executeQuery();
            while(rs.next()) {
               a = rs.getInt(3);
            }
            accesoDB.close();
            return a;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return a;
    }
    
    public boolean actualizarProducto(String nombreProducto, int cantidad, int precio){
        Connection accesoDB = conexion.conectar();
        try{
            ps = accesoDB.prepareStatement("UPDATE producto SET nombre='"+nombreProducto+"', cantidad="+cantidad+", precio="+precio+" WHERE nombre='"+nombreProducto+"'");
            int a = ps.executeUpdate();
            accesoDB.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    public boolean agregarProducto(String nombreProducto, int cantidad, int precio){
        Connection accesoDB = conexion.conectar();
        int rsu = 0;
            try{
                ps = accesoDB.prepareStatement("INSERT INTO producto ( nombre, cantidad, precio)" +
                "VALUES ('"+nombreProducto+"', "+cantidad+", "+precio+")");
                rsu = ps.executeUpdate();
                accesoDB.close();
                return true;
            }catch(Exception e){
                return false;
        }
    }
    
    public ArrayList<Producto> buscarProducto(String nombreProducto){
        ArrayList<Producto> producto = new ArrayList<Producto>();
        Connection accesoDB = conexion.conectar();
        int rsu = 0;
            try{
                ps = accesoDB.prepareStatement("SELECT * FROM producto WHERE nombre='"+nombreProducto+"'");
                rsu = ps.executeUpdate();
                while(rs.next()) {
                   producto.add(new Producto(rs.getString(2), rs.getInt(3), rs.getInt(4)));
                }
                accesoDB.close();
                return producto;
            }catch(Exception e){
                return producto;
        }
    }
    
    public ArrayList<Producto> capturarNombreProductos(){
        ArrayList<Producto> producto = new ArrayList<Producto>();
        Connection accesoDB = conexion.conectar();
        try{
            PreparedStatement ps = accesoDB.prepareStatement("SELECT * FROM producto");
            rs = ps.executeQuery();
            while(rs.next()) {
               producto.add(new Producto(rs.getString(2)));
            }
            accesoDB.close();
            return producto;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return producto;
    }
    
    public boolean eliminarProducto(String nombreProducto){
        Connection accesoDB = conexion.conectar();
        try{
            ps = accesoDB.prepareStatement("DELETE FROM producto WHERE nombre='"+nombreProducto+"'");
            int a = ps.executeUpdate();
            accesoDB.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
