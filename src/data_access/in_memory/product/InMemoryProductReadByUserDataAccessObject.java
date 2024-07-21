package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadByUserDataAccessInterface;
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
import java.util.Objects;

/**
 * In-memory implementation of {@link ProductReadByUserDataAccessInterface} to retrieve products by their user ID.
 */
public class InMemoryProductReadByUserDataAccessObject implements ProductReadByUserDataAccessInterface {

    private ArrayList<Product> products;

    /**
     * Constructs an empty in-memory product data access object.
     */
    public InMemoryProductReadByUserDataAccessObject() {
        this.products = new ArrayList<>();
    }

    /**
     * Constructs an in-memory product data access object with a predefined list of products.
     *
     * @param products the list of products to initialize with
     */
    public InMemoryProductReadByUserDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Retrieves products by the user ID of their seller.
     *
     * @param userID the user ID of the seller
     * @return a list of products sold by the specified user
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    @Override
    public ArrayList<Product> getProductByUser(String userID) throws SQLException, IOException {
        ArrayList<Product> outputProducts = new ArrayList<>();
        for (Product product : products) {
            if (Objects.equals(product.getSellerStudentNumber(), userID)) {
                ProductFactory productFactory = new CommonProductFactory();
                ArrayList<String> copyListTags = new ArrayList<>();
                for (String tag : product.getListTags()) {
                    copyListTags.add(tag);
                }

                Schedule schedule = product.getSchedule();
                ArrayList<LocalDateTime> sellerTimes = new ArrayList<>();
                for (LocalDateTime sellerTime : schedule.getSellerTime()) {
                    sellerTimes.add(sellerTime);
                }
                ScheduleFactory scheduleFactory = new CommonScheduleFactory();
                Schedule copySchedule = scheduleFactory.createSchedule(schedule.getBuyerTime(),
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

                outputProducts.add(copyProduct);
            }
        }
        return outputProducts;
    }
}
