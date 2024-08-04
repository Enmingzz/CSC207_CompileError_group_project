package interface_adapter.schedule;

import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.user.CommonUser;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.schedule.BuyerSelectScheduleOutputData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyerSelectSchedulePresenterTest {
    private BuyerSelectScheduleViewModel viewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;

    private User buyer;
    private Product product;
    private Product previousProduct;
    private ArrayList<Product> previousProducts;
    private BuyerSelectScheduleOutputData buyerSelectScheduleOutputData;

    private BuyerSelectSchedulePresenter buyerSelectSchedulePresenter;

    @BeforeEach
    void setUp() throws IOException {
        viewModel = new BuyerSelectScheduleViewModel();
        shoppingCartViewModel = new ShoppingCartViewModel();
        viewManagerModel = new ViewManagerModel();

        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "This is a title";
        int state = 3;
        int previousState = 2;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1111111111";
        String address = "BA 3175";
        LocalDateTime buyerTime = LocalDateTime.parse("2024-07-13T12:00:00");
        LocalDateTime previousBuyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        sellerTime.add(LocalDateTime.parse("2024-07-13T12:00:00"));
        sellerTime.add(LocalDateTime.parse("2024-07-13T13:00:00"));
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        Schedule previousSchedule = scheduleFactory.createSchedule(previousBuyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        String productID = "id_1";

        product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        previousProduct = new CommonProduct(image, des, title, price, previousState, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, previousSchedule);


        buyer = new CommonUser("tabby cat", "password", "tabby@mail.utoronto.ca", 5, "1234567890");

        previousProducts = new ArrayList<>();
        previousProducts.add(previousProduct);

        buyerSelectScheduleOutputData = new BuyerSelectScheduleOutputData(buyer, product);

        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setListProducts(previousProducts);
        shoppingCartState.setUser(buyer);
        shoppingCartViewModel.setState(shoppingCartState);

        buyerSelectSchedulePresenter = new BuyerSelectSchedulePresenter(viewModel, viewManagerModel, shoppingCartViewModel);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void prepareSuccessfulView() {
        buyerSelectSchedulePresenter.prepareSuccessfulView(buyerSelectScheduleOutputData);
        ArrayList<Product> updatedProducts = new ArrayList<>();
        updatedProducts.add(product);
        assertEquals(shoppingCartViewModel.getState().getListProducts(), updatedProducts);
        assertNull(viewModel.getState().getError());
    }

    @Test
    void prepareFailedView() {
//        buyerSelectSchedulePresenter.prepareFailedView("a");

    }
}