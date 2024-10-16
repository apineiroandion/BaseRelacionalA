import model.Product;
import model.dao.ProductDAO;

import java.sql.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("p1", "parafusos", 3, LocalDate.parse("2020-12-27"));
        Product p2 = new Product("p2", "cravos", 4, LocalDate.parse("2020-04-06"));
        Product p3 = new Product("p3", "tachas", 6, LocalDate.parse("2020-07-03"));

        //ProductDAO.insireProduto(p1);
        //ProductDAO.insireProduto(p2);
        //ProductDAO.insireProduto(p3);

        listarProdutos();
        // ProductDAO.actualizaPre("p2", (p2.getPrezo()*2));
        //ProductDAO.eliminaProduto("p3");



    }

    /**
     * Metodo que imprime la lista de productos obtenida de la base de datos
     */
    public static void listarProdutos() {
        for (Product p : ProductDAO.listaProdutos()) {
            System.out.println(p.getCodigo() + " " + p.getDescricion() + " " + p.getPrezo() + " " + p.getDatac());
        }
    }
}