package com.emergentes.controlador;

import com.emergentes.modelo.Entrada;
import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EntradaController", urlPatterns = {"/EntradaController"})
public class EntradaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";

        ArrayList<Entrada> lista = new ArrayList<Entrada>();

        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();

        PreparedStatement ps;
        ResultSet rs;

        if (op.equals("list")) {
            try {
                String sql = "select * from entradas";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Entrada e = new Entrada();
                    e.setId(rs.getInt("id"));
                    e.setFecha(rs.getString("fecha"));
                    e.setTitulo(rs.getString("titulo"));
                    e.setContenido(rs.getString("contenido"));
                    e.setAutor(rs.getString("autor"));    
                    lista.add(e);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("entradas.jsp").forward(request, response);
            } catch (SQLException ex) {
                System.out.println("Error en SQl " + ex.getMessage());
            } finally {
                canal.desconectar();
            }
        }
        if (op.equals("nuevo")) {
            Entrada e = new Entrada();
            request.setAttribute("entrada", e);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        
        if (op.equals("editar")){
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                String sql = "select * from entradas where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                
                rs = ps.executeQuery();
                Entrada en = new Entrada();
                
                while (rs.next()){
                    en.setId(rs.getInt("id"));
                    en.setFecha(rs.getString("fecha"));
                    en.setTitulo(rs.getString("titulo"));
                    en.setContenido(rs.getString("contenido"));
                    en.setAutor(rs.getString("autor"));
                }
                request.setAttribute("entrada", en);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                
            } catch (SQLException ex) {
                System.out.println("Error en SQL "+ ex.getMessage());
            }
        }
        
        if (op.equals("eliminar")) {
            try {
                int id = Integer.parseInt(request.getParameter(("id")));

                String sql = "delete from entradas where id = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);

                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error de SQL " + ex.getMessage());
            } finally {
                canal.desconectar();
            }
            response.sendRedirect("EntradaController");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        String autor = request.getParameter("autor");

        Entrada e = new Entrada();
        e.setId(id);
        e.setFecha(fecha);
        e.setTitulo(titulo);
        e.setContenido(contenido);
        e.setAutor(autor);
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;

        if (id == 0) {
            String sql = "insert into entradas (fecha,titulo,contenido,autor) values (?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, e.getFecha());
                ps.setString(2, e.getTitulo());
                ps.setString(3, e.getContenido());
                ps.setString(4, e.getAutor());
                
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                System.out.println("Error de SQL "+ ex.getMessage());            
            } finally {
                canal.desconectar();
            }
            response.sendRedirect("EntradaController");
        }
        
        else{
            try {
                String sql = "update entradas set fecha=?, titulo=?, contenido=?, autor=? where id =?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, e.getFecha());
                ps.setString(2, e.getTitulo());
                ps.setString(3, e.getContenido());
                ps.setString(4, e.getAutor());
                ps.setInt(5, e.getId());
                
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Error al actualizar "+ex.getMessage());
            }
            response.sendRedirect("EntradaController");
            
        }
    }
}
