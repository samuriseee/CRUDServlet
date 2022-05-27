/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author htk11
 */
public class ProductDao {

    public List<Product> getAllP() throws SQLException {
        List<Product> products = new ArrayList<Product>();

        Connection connection_16 = JDBCConnect.getJDBCConnection();

        String sql = "SELECT * FROM Product";

        try {
            PreparedStatement preparedStatement = connection_16.prepareStatement(sql);

            ResultSet rs_16 = preparedStatement.executeQuery();

            while (rs_16.next()) {
                Product Product = new Product();

                Product.setId(rs_16.getInt("id"));
                Product.setPdName(rs_16.getString("PdName"));
                Product.setPrice((float) rs_16.getDouble("price"));
                Product.setPtype(rs_16.getString("Ptype"));

                products.add(Product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Product getPById(int id) throws SQLException {

        Connection connection_16 = JDBCConnect.getJDBCConnection();

        String sql = "SELECT * FROM  Product WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection_16.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs_16 = preparedStatement.executeQuery();

            while (rs_16.next()) {
                Product p = new Product();

                p.setId(rs_16.getInt("id"));
                p.setPdName(rs_16.getString("PdName"));
                p.setPrice((float) rs_16.getDouble("price"));
                p.setPtype(rs_16.getString("Ptype"));

                return p;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int addP(Product p) throws SQLException {

        Connection connection_16 = JDBCConnect.getJDBCConnection();

        String sql = "INSERT INTO Product VALUES(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection_16.prepareStatement(sql);

            preparedStatement.setString(1, p.getPdName());
            preparedStatement.setDouble(2, p.getPrice());
            preparedStatement.setString(3, p.getPtype());
            int t = preparedStatement.executeUpdate();
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return 0;
    }

    public int updateP(Product p) throws SQLException {

        Connection connection_16 = JDBCConnect.getJDBCConnection();

        String sql = "UPDATE Product  Set PdName = ?, price =?,  Ptype=? Where id=?";

        try {
            PreparedStatement preparedStatement = connection_16.prepareStatement(sql);
            preparedStatement.setInt(4, p.getId());
            preparedStatement.setString(1, p.getPdName());
            preparedStatement.setDouble(2, p.getPrice());
            preparedStatement.setString(3, p.getPtype());

            int rs_16 = preparedStatement.executeUpdate();

            return rs_16;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteP(int id) throws SQLException {

        Connection connection_16 = JDBCConnect.getJDBCConnection();

        String sql = "DELETE FROM Product WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection_16.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int rs_16 = preparedStatement.executeUpdate();

            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
