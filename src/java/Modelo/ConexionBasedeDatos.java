/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CarlosAndres
 */
public class ConexionBasedeDatos {
    private static String nombreDB = "taller";
    private static String user = "root";
    private static String pass = "";
    private static String host = "localhost:3306";
    private static String server = "jdbc:mysql://"+host+"/"+nombreDB+"?autoReconnect=true&useSSL=false";
    public Connection conectar(){
        Connection cn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(server, user, pass);
            //System.out.println("Conectado");
        }catch(Exception e){
            System.out.println("No conectado");
        }
        return cn;
    }
}
