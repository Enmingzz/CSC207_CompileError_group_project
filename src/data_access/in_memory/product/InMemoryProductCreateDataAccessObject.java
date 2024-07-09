package data_access.in_memory.product;

import data_access.interfaces.product.ProductCreateDataAccessInterface;
import entity.product.CommonProduct;
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

/**
 * DatabaseProductCreateDataAccessObject receives modify_product from CreateProductUseCaseInteractor
 * no return value
 */
public class InMemoryProductCreateDataAccessObject implements ProductCreateDataAccessInterface {

    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void saveProduct(Product product) throws SQLException, IOException {
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
    }

    /**
     *
     * @return returns an arraylist of Product to check if product has been saved into the mock database
     * @throws SQLException
     * @throws IOException
     */

    public ArrayList<Product> getProducts() throws SQLException, IOException {
        ArrayList<Product> outputProducts = new ArrayList<>();
        for(Product product: products){
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

            outputProducts.add(copyProduct);
        }

        return outputProducts;
    }
}
