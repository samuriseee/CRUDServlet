
package Services;

import Model.Product;
import DAO.ProductDao;


import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author htk11
 */
public class ProductServices {
     private  ProductDao pd = new ProductDao();


    public List<Product> getAllP() throws SQLException {
        return pd.getAllP();
    }

    public Product getPById(int id) throws SQLException {
        return pd.getPById(id);
    }
    
    public int addP(Product p) throws SQLException {
        return pd.addP(p);
    }

    public int updateP(Product p) throws SQLException {
        return pd.updateP(p);
    }

    public int deleteP(int id) throws SQLException {
        return pd.deleteP(id);
    }
}
