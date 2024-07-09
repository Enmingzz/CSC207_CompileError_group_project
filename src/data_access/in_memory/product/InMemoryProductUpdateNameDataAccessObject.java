package data_access.in_memory.product;

import data_access.interfaces.product.ProductUpdateNameDataAccessInterface;
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

public class InMemoryProductUpdateNameDataAccessObject implements ProductUpdateNameDataAccessInterface {

    private ArrayList<Product> products;

    public InMemoryProductUpdateNameDataAccessObject() {
        this.products = new ArrayList<>();
    }

    public InMemoryProductUpdateNameDataAccessObject(ArrayList<Product> products) {
        this.products = new ArrayList<>();
        for (Product product : products) {
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
            this.products.add(copyProduct);
        }
    }
    @Override
    public void updateProductName(Product updatedProduct, String name) throws SQLException {
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
                        name,
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
