/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Web;

import Model.Product;
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
@WebServlet(name = "insert", urlPatterns = {"/insert"})
public class insert extends HttpServlet {

ProductServices productSer = new ProductServices();

     private void insertProduct(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        Product p = new Product();

        p.setPdName(request.getParameter("pdName"));
        p.setPrice(Double.parseDouble(request.getParameter("price")));
        p.setPtype(request.getParameter("ptype"));

        productSer.addP(p);
        
        request.setAttribute("listProduct", productSer.getAllP());
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        dispatcher.forward(request, response);
//         response.sendRedirect("productList.jsp");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
        insertProduct(request, response);
    } catch (SQLException ex) {
        Logger.getLogger(insert.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
