package data_access.in_memory.product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
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
 * In-memory implementation of the ProductCreateDataAccessInterface.
 * This class simulates a database by storing products in memory.
 * It receives products from the CreateProductUseCaseInteractor and saves them.
 */

public class InMemoryProductCreateDataAccessObject implements ProductCreateDataAccessInterface {

    private ArrayList<Product> products;

    /**
     * Constructs an InMemoryProductCreateDataAccessObject with an empty list of products.
     */
    public InMemoryProductCreateDataAccessObject() {
        this.products = new ArrayList<>();
    }

    /**
     * Constructs an InMemoryProductCreateDataAccessObject with the given list of products.
     *
     * @param products the initial list of products
     */
    public InMemoryProductCreateDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Saves a product to the in-memory list.
     * Creates a copy of the product and its schedule to ensure the original product is not modified.
     *
     * @param product the product to save
     * @throws SQLException if a database access error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void saveProduct(Product product) throws SQLException, IOException {
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

        products.add(copyProduct);
    }
}
