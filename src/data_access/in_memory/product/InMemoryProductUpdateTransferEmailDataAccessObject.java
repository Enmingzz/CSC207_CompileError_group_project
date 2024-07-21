package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateTransferEmailDataAccessInterface;
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
 * In-memory implementation of {@link ProductUpdateTransferEmailDataAccessInterface} to update the transfer email of a product.
 */
public class InMemoryProductUpdateTransferEmailDataAccessObject implements ProductUpdateTransferEmailDataAccessInterface {

    private ArrayList<Product> products;

    /**
     * Constructs an empty in-memory product data access object.
     */
    public InMemoryProductUpdateTransferEmailDataAccessObject() {
        products = new ArrayList<>();
    }

    /**
     * Constructs an in-memory product data access object with a predefined list of products.
     *
     * @param products the list of products to initialize with
     */
    public InMemoryProductUpdateTransferEmailDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

    /**
     * Updates the transfer email of a product.
     *
     * @param updatedProduct the product with the new transfer email
     * @param eMail          the new transfer email of the product
     * @throws SQLException if a database access error occurs
     */
    @Override
    public void updateProductEmail(Product updatedProduct, String eMail) throws SQLException {
        for (int i = 0; i < products.size(); i++) {
            if (Objects.equals(products.get(i).getProductID(), updatedProduct.getProductID())) {
                ProductFactory productFactory = new CommonProductFactory();
                ArrayList<String> copyListTags = new ArrayList<>();
                for (String tag : products.get(i).getListTags()) {
                    copyListTags.add(tag);
                }

                Schedule schedule = products.get(i).getSchedule();
                ArrayList<LocalDateTime> sellerTimes = new ArrayList<>();
                for (LocalDateTime sellerTime : schedule.getSellerTime()) {
                    sellerTimes.add(sellerTime);
                }
                ScheduleFactory scheduleFactory = new CommonScheduleFactory();
                Schedule copySchedule = scheduleFactory.createSchedule(schedule.getBuyerTime(),
                        sellerTimes);
                Product copyProduct = productFactory.createProduct(products.get(i).getImage(),
                        products.get(i).getDescription(),
                        products.get(i).getTitle(),
                        products.get(i).getPrice(),
                        products.get(i).getRating(),
                        products.get(i).getState(),
                        eMail,
                        products.get(i).getSellerStudentNumber(),
                        products.get(i).getAddress(),
                        copyListTags,
                        products.get(i).getProductID(),
                        copySchedule);

                products.set(i, copyProduct);

                break;

            }
        }

    }

}
