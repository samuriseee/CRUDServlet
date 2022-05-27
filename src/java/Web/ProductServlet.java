package Web;

import java.io.IOException;
import Services.ProductServices;
import Model.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductServlet"})
public class ProductServlet extends HttpServlet {

    ProductServices productSer = new ProductServices();
 public void listProduct(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException, SQLException {
        List<Product> listProduct = new ArrayList<Product>();

        listProduct =   productSer.getAllP();
        request.setAttribute("listProduct", listProduct);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        
          List<Product> listProduct = new ArrayList<Product>();

        try {
            listProduct =   productSer.getAllP();
        } catch (SQLException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("listProduct",  listProduct);
          request.getRequestDispatcher("/productList.jsp").forward(request, response);
//        String action = request.getServletPath();
       
//        try {
//            listProduct(request, response);
//        } catch (SQLException ex) {
//            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        switch (action) {
//            case "/new":
//                showNewForm(request, response);
//                break;
//            case "/add": {
//                try {
//                    addNewProduct(request, response);
//                } catch (SQLException ex) {
//                    Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            break;
//            case "/delete":
//                break;
//        }
    }

//    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("productForm.jsp");
//        dispatcher.forward(request, response);
//        
//    }
//
//    public void addNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        Product p = new Product();
//
//        p.setPdName(request.getParameter("PdName"));
//        p.setPtype(request.getParameter("Ptype"));
//        p.setPrice(Float.valueOf(request.getParameter("price")));
//        productSer.addP(p);
//        response.sendRedirect("List");
//    }

    

//    @Override
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
}
