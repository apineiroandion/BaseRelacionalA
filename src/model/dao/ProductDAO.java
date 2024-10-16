package model.dao;

import model.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static boolean insireProduto(Product product) {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produtos VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, product.getCodigo());
            preparedStatement.setString(2, product.getDescricion());
            preparedStatement.setInt(3, product.getPrezo());
            preparedStatement.setDate(4, Date.valueOf(product.getDatac()));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Product> listaProdutos() {
        Connection connection = DataBaseConnection.getConnection();
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT FROM produtos");
            preparedStatement.executeQuery();
            while (preparedStatement.getResultSet().next()) {
                Product product = new Product();
                product.setCodigo(preparedStatement.getResultSet().getString("codigo"));
                product.setDescricion(preparedStatement.getResultSet().getString("descricion"));
                product.setPrezo(preparedStatement.getResultSet().getInt("prezo"));
                product.setDatac(preparedStatement.getResultSet().getDate("datac").toLocalDate());
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
    }
        return null;
    }

    public static List<Product> listaProdutoPorCodigo(String codigo){
        Connection connection = DataBaseConnection.getConnection();
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT FROM produtos WHERE codigo = ?");
            preparedStatement.setString(1, codigo);
            preparedStatement.executeQuery();
            while (preparedStatement.getResultSet().next()) {
                Product product = new Product();
                product.setCodigo(preparedStatement.getResultSet().getString("codigo"));
                product.setDescricion(preparedStatement.getResultSet().getString("descricion"));
                product.setPrezo(preparedStatement.getResultSet().getInt("prezo"));
                product.setDatac(preparedStatement.getResultSet().getDate("datac").toLocalDate());
                products.add(product);
            }
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean actualizaPre(String codigo, Integer prezo) {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE produtos SET prezo = ? WHERE codigo = ?");
            preparedStatement.setInt(1, prezo);
            preparedStatement.setString(2, codigo);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean eliminaProduto (String codigo) {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE * FROM produtos WHERE codigo = ?");
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

