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

public class InMemoryProductReadByIdDataAccessObject implements ProductReadByIdDataAccessInterface {

    private ArrayList<Product> products;

    public InMemoryProductReadByIdDataAccessObject() {
        this.products = new ArrayList<>();
    }

    public InMemoryProductReadByIdDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

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
