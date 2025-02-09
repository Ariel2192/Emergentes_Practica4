
package com.emergentes.controlador;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hp
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = (request.getParameter("action") == null) ? "view": request.getParameter("action");
        if (action.equals("view")){
            response.sendRedirect("index.jsp");
        }
        if(action.equals("logout")){
            HttpSession ses = request.getSession();
            ses.invalidate();
            response.sendRedirect("index.jsp");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                
        try {
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
           
            
            
            ResultSet rs;
            
            ConexionBD canal = new ConexionBD();
            Connection cn = canal.conectar();
            String sql = "select * from usuarios where usuario = ? and password = ? limit 1";
            PreparedStatement ps = cn.prepareStatement(sql);
            
            ps.setString(1, usuario);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                HttpSession ses = request.getSession();
                ses.setAttribute("logueado", "OK");
                ses.setAttribute("usuario", usuario);
                response.sendRedirect("EntradaController");
            }
            else{
                response.sendRedirect("index.jsp");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

}