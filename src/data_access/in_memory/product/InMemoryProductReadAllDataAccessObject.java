package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadAllDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * In-memory implementation of the ProductReadAllDataAccessInterface.
 * This class simulates a database by storing products in memory and provides methods to retrieve all products.
 */
public class InMemoryProductReadAllDataAccessObject implements ProductReadAllDataAccessInterface {

    private ArrayList<Product> products;

    /**
     * Constructs an InMemoryProductReadAllDataAccessObject with an empty list of products.
     */
    public InMemoryProductReadAllDataAccessObject() {
        this.products = new ArrayList<>();
    }

    /**
     * Constructs an InMemoryProductReadAllDataAccessObject with the given list of products.
     *
     * @param products the initial list of products
     */
    public InMemoryProductReadAllDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Retrieves all products from the in-memory list.
     * Creates copies of the products and their schedules to ensure the original products are not modified.
     *
     * @return a list of all products
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public ArrayList<Product> getAllProducts() throws SQLException, IOException {
        ArrayList<Product> outputProducts = new ArrayList<>();
        for (Product product : products) {
            ProductFactory productFactory = new CommonProductFactory();
            ArrayList<String> copyListTags = new ArrayList<>(product.getListTags());

            Schedule schedule = product.getSchedule();
            ArrayList<LocalDateTime> sellerTimes = new ArrayList<>(schedule.getSellerTime());
            ScheduleFactory scheduleFactory = new CommonScheduleFactory();
            Schedule copySchedule = scheduleFactory.createSchedule(schedule.getBuyerTime(), sellerTimes);

            Product copyProduct = productFactory.createProduct(
                    product.getImage(),
                    product.getDescription(),
                    product.getTitle(),
                    product.getPrice(),
                    product.getRating(),
                    product.getState(),
                    product.geteTransferEmail(),
                    product.getSellerStudentNumber(),
                    product.getAddress(),
                    copyListTags,
                    product.getProductID(),
                    copySchedule
            );

            outputProducts.add(copyProduct);
        }
        return outputProducts;
    }
}
