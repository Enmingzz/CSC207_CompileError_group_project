package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdatePictureDataAccessInterface;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * In-memory implementation of {@link ProductUpdatePictureDataAccessInterface} to update the picture of a product.
 */
public class InMemoryProductUpdatePictureDataAccessObject implements ProductUpdatePictureDataAccessInterface {

    private ArrayList<Product> products;

    /**
     * Constructs an empty in-memory product data access object.
     */
    public InMemoryProductUpdatePictureDataAccessObject() {
        this.products = new ArrayList<>();
    }

    /**
     * Constructs an in-memory product data access object with a predefined list of products.
     *
     * @param products the list of products to initialize with
     */
    public InMemoryProductUpdatePictureDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }
    /**
     * Updates the picture of a product.
     *
     * @param updatedProduct the product with the new picture
     * @param image          the new picture of the product
     * @throws SQLException if a database access error occurs
     * @throws IOException  if an I/O error occurs
     */
    @Override
    public void updateProductPicture(Product updatedProduct, Image image) throws SQLException, IOException {
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
                Product copyProduct = productFactory.createProduct(image,
                        products.get(i).getDescription(),
                        products.get(i).getTitle(),
                        products.get(i).getPrice(),
                        products.get(i).getRating(),
                        products.get(i).getState(),
                        products.get(i).geteTransferEmail(),
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
