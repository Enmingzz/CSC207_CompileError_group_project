package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadByNameDataAccessInterface;
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

public class InMemoryProductReadByNameDataAccessObject implements ProductReadByNameDataAccessInterface {

    private ArrayList<Product> products;

    public InMemoryProductReadByNameDataAccessObject() {
        products = new ArrayList<>();
    }

    public InMemoryProductReadByNameDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public ArrayList<Product> getProductByName(String name) throws SQLException, IOException {
        ArrayList<Product> outputProducts = new ArrayList<>();
        for (Product product : products) {
            if (Objects.equals(product.getTitle(), name)) {
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
