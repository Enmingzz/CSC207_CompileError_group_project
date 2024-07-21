package data_access.in_memory.product;

import data_access.interfaces.product.ProductReadByTagDataAccessInterface;
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
 * In-memory implementation of {@link ProductReadByTagDataAccessInterface} to retrieve products by their tag.
 */
public class InMemoryProductReadByTagDataAccessObject implements ProductReadByTagDataAccessInterface {

    private ArrayList<Product> products;

    /**
     * Constructs an empty in-memory product data access object.
     */
    public InMemoryProductReadByTagDataAccessObject() {
        this.products = new ArrayList<>();
    }

    public InMemoryProductReadByTagDataAccessObject(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public ArrayList<Product> getProductByTag(String targetTag) throws SQLException, IOException {
        ArrayList<Product> outputProducts = new ArrayList<>();
        for (Product product : products) {
            for (String indexTag : product.getListTags()) {
                if (Objects.equals(indexTag, targetTag)) {
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
                    break;
                }
            }
        }
        return outputProducts;
    }
}
