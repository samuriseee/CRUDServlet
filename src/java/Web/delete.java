/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;

import Services.ProductServices;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author htk11
 */
@WebServlet(name = "delete", urlPatterns = {"/delete"})
public class delete extends HttpServlet {
 ProductServices productSer = new ProductServices();
private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
     try {
         int id = Integer.parseInt(request.getParameter("id"));
         productSer.deleteP(id);
                 request.setAttribute("listProduct", productSer.getAllP());
                 RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
                 dispatcher.forward(request, response); 
     } catch (ServletException ex) {
         Logger.getLogger(delete.class.getName()).log(Level.SEVERE, null, ex);
     }
       
       
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
         deleteProduct(request, response);
     } catch (SQLException ex) {
         Logger.getLogger(delete.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//     try {
//         deleteProduct(request, response);
//     } catch (SQLException ex) {
//         Logger.getLogger(delete.class.getName()).log(Level.SEVERE, null, ex);
//     }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
