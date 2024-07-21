package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
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
 * In-memory implementation of {@link ProductReadByIdDataAccessInterface} to retrieve products by their ID.
 */
public class InMemoryProductReadByIdDataAccessObject implements ProductReadByIdDataAccessInterface {

    private ArrayList<Product> products;

    /**
     * Constructs an empty in-memory product data access object.
     */
    public InMemoryProductReadByIdDataAccessObject() {
        this.products = new ArrayList<>();
    }

    /**
     * Constructs an in-memory product data access object with a predefined list of products.
     *
     * @param products the list of products to initialize with
     */
    public InMemoryProductReadByIdDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param productID the ID of the product to retrieve
     * @return a copy of the product with the specified ID, or null if not found
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    @Override
    public Product getProductById(String productID) throws SQLException, IOException {
        for (Product product : products) {
            if (product.getProductID().equals(productID)) {
                ProductFactory productFactory = new CommonProductFactory();
                ArrayList<String> copyListTags = new ArrayList<>();
                for (String tag: product.getListTags()) {
                    copyListTags.add(tag);
                }

                Schedule schedule = product.getSchedule();
                ArrayList<LocalDateTime> sellerTimes = new ArrayList<>();
                for (LocalDateTime sellerTime: schedule.getSellerTime()){
                    sellerTimes.add(sellerTime);
                }
                ScheduleFactory scheduleFactory = new CommonScheduleFactory();
                Schedule copySchedule  = scheduleFactory.createSchedule(schedule.getBuyerTime(),
                        sellerTimes);
                Product copyProduct = productFactory.createProduct(product.getImage(),
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
                        copySchedule);
                return copyProduct;
            }

        }

        // MAY NOT BE NULL
        return null;
    }
}
