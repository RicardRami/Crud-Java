package paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletInsertar extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
    String nombre = request.getParameter("nombre");
    String paterno = request.getParameter("paterno");   
    try
    {
    Class.forName("com.mysql.jdbc.Driver");
    Connection db = DriverManager.getConnection("jdbc:mysql://localhost/Usuarios","root", "1234");
    Statement s = db.createStatement();        
    s.executeUpdate("INSERT INTO Usuario(nombre,paterno) VALUES('"+nombre+"','"+paterno+"');");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Uusuario creado</h1>");
            out.println("</body>");
            out.println("</html>");  
    }
    catch(Exception e)
    {
    e.printStackTrace();
    } 
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
