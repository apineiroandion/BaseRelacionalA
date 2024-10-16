package Model.DAO;

import Model.Product;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO {
    public static void insireProduto(Product product) {
        Connection connection = DataBaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO produtos VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, product.getCodigo());
            preparedStatement.setString(2, product.getDescricion());
            preparedStatement.setInt(3, product.getPrezo());
            preparedStatement.setDate(4, Date.valueOf(product.getDatac()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> listaProdutos() {
        Connection connection = DataBaseConnection.getConnection();
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produtos");
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

    public static ArrayList<Product> listaProdutoPorCodigo(String codigo){
        Connection connection = DataBaseConnection.getConnection();
        ArrayList<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM produtos WHERE codigo = "+ codigo +";");
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


}

