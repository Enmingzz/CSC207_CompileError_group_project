package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateDescriptionDataAccessInterface;
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
 * Update specific modify_product description
 * Input is modify_product and String description
 * No return Value
 * @author CompileError group
 */

public class InMemoryProductUpdateDescriptionDataAccessObject implements ProductUpdateDescriptionDataAccessInterface {

    private ArrayList<Product> products;

    public InMemoryProductUpdateDescriptionDataAccessObject() {
        products = new ArrayList<>();
    }

    public InMemoryProductUpdateDescriptionDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public void updateProductDescription(Product updatedProduct, String description) throws SQLException {
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
                        description,
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
