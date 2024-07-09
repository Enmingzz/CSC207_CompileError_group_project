package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.Product;
import entity.schedule.Schedule;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class InMemoryProductReadAllDataAccessObject implements ProductReadAllDataAccessInterface {

    private ArrayList<Product> products = new ArrayList<>();

    public InMemoryProductReadAllDataAccessObject() {}

    public InMemoryProductReadAllDataAccessObject(ArrayList<Product> products){
        for (Product product : products) {

        }
    }

    @Override
    public ArrayList<Product> getAllProducts() throws SQLException, IOException {
        ArrayList<Product> outputProducts = new ArrayList<>();
        for (Product product : products) {
            outputProducts.add(product);
        }
        return outputProducts;
    }
}
