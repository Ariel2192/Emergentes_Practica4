package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/db_blog";
    static String usuario = "root";
    static String password = "";
    
    protected Connection conn = null;

    public ConexionBD() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,usuario,password);
            if (conn != null){
                System.out.println("Conexión OK " + conn);
            }
            
        }catch(SQLException ex){
            System.out.println("Error de SQL "+ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Falta driver "+ex.getMessage());
        }
    }
    
    public Connection conectar()
    {
        return conn;
    }
    public void desconectar()
    {
        try {
            System.out.println("Cerrando la BD"+conn);
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error de SQL "+ ex.getMessage());
        }
    }
    
    
    
}
