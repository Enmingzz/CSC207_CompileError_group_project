package interface_adapter.schedule;

import data_access.factories.interfaces.product.DataBaseProductReadByIdDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface;
import data_access.factories.interfaces.product.DatabaseProductUpdateStateDataAccessObjectFactoryInterface;
import data_access.factories.objects.product.DataBaseProductReadByIdDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductUpdateBuyerScheduleDataAccessObjectFactory;
import data_access.factories.objects.product.DatabaseProductUpdateStateDataAccessObjectFactory;
import data_access.in_memory.product.InMemoryProductReadByIdDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateBuyerScheduleDataAccessObject;
import data_access.in_memory.product.InMemoryProductUpdateStateDataAccessObject;
import data_access.interfaces.product.ProductReadByIdDataAccessInterface;
import data_access.interfaces.product.ProductUpdateBuyerScheduleDataAccessInterface;
import data_access.interfaces.product.ProductUpdateStateDataAccessInterface;
import entity.product.CommonProduct;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.user.CommonUser;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.schedule.buyer_select_schedule.BuyerSelectScheduleController;
import interface_adapter.schedule.buyer_select_schedule.BuyerSelectSchedulePresenter;
import interface_adapter.schedule.buyer_select_schedule.BuyerSelectScheduleViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.schedule.BuyerSelectScheduleInteractor;
import use_case.schedule.BuyerSelectScheduleOutputBoundary;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class BuyerSelectScheduleControllerTest {
    private BuyerSelectScheduleViewModel buyerSelectScheduleViewModel;
    private ViewManagerModel viewManagerModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private BuyerSelectScheduleController buyerSelectScheduleController;

    private User buyer;
    private Product product;
    private LocalDateTime selectedTime;
    private ArrayList<Product> products;


    @BeforeEach
    void setUp() throws SQLException, IOException {
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "This is a title";
        int state = 2;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1111111111";
        String address = "BA 3175";
        LocalDateTime buyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        sellerTime.add(LocalDateTime.parse("2024-07-13T12:00:00"));
        sellerTime.add(LocalDateTime.parse("2024-07-13T13:00:00"));
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        String productID = "id_1";

        product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);


        buyer = new CommonUser("tabby cat", "password", "tabby@mail.utoronto.ca", 5, "1234567890");

        selectedTime = LocalDateTime.parse("2024-07-13T12:00:00");

        products = new ArrayList<>();
        products.add(product);


        buyerSelectScheduleViewModel = new BuyerSelectScheduleViewModel();
        viewManagerModel = new ViewManagerModel();
        shoppingCartViewModel = new ShoppingCartViewModel();
        ProductReadByIdDataAccessInterface inMemoryProductReadByIdDataAccessObject =
                new InMemoryProductReadByIdDataAccessObject(products);
        ProductUpdateBuyerScheduleDataAccessInterface inMemoryProductUpdateBuyerScheduleDataAccessObject =
                new InMemoryProductUpdateBuyerScheduleDataAccessObject(products);
        ProductUpdateStateDataAccessInterface inMemoryProductUpdateStateDataAccessObject =
                new InMemoryProductUpdateStateDataAccessObject(products);


        BuyerSelectScheduleOutputBoundary buyerSelectSchedulePresenter =
                new BuyerSelectSchedulePresenter(buyerSelectScheduleViewModel, viewManagerModel, shoppingCartViewModel);
        DataBaseProductReadByIdDataAccessObjectFactoryInterface dataBaseProductReadByIdDataAccessObjectFactoryInterface =
                new DataBaseProductReadByIdDataAccessObjectFactory();
        ProductFactory productFactory = new CommonProductFactory();
        ProductReadByIdDataAccessInterface productReadByIdDataAccessObject =
                dataBaseProductReadByIdDataAccessObjectFactoryInterface.create(productFactory, scheduleFactory);
        DataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface dataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface =
                new DatabaseProductUpdateBuyerScheduleDataAccessObjectFactory();
        ProductUpdateBuyerScheduleDataAccessInterface productUpdateBuyerScheduleDataAccessObject =
                dataBaseProductUpdateBuyerScheduleDataAccessObjectFactoryInterface.create();
        DatabaseProductUpdateStateDataAccessObjectFactoryInterface databaseProductUpdateStateDataAccessObjectFactoryInterface =
                new DatabaseProductUpdateStateDataAccessObjectFactory();
        ProductUpdateStateDataAccessInterface productUpdateStateDataAccessObject =
                databaseProductUpdateStateDataAccessObjectFactoryInterface.create();
        BuyerSelectScheduleInteractor buyerSelectScheduleInteractor =
                new BuyerSelectScheduleInteractor(buyerSelectSchedulePresenter, inMemoryProductReadByIdDataAccessObject,
                        inMemoryProductUpdateBuyerScheduleDataAccessObject, inMemoryProductUpdateStateDataAccessObject);
        buyerSelectScheduleController = new BuyerSelectScheduleController(buyerSelectScheduleInteractor);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() throws SQLException, IOException {
        buyerSelectScheduleController.execute(buyer, product, selectedTime);
        assertInstanceOf(BuyerSelectScheduleController.class, buyerSelectScheduleController);
    }
}