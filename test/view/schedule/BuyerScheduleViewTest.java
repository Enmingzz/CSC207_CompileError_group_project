package view.schedule;

import app.schedule_usecase_factory.BuyerScheduleUseCaseFactory;
import entity.product.CommonProduct;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.user.CommonUser;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.schedule.buyer_select_schedule.BuyerSelectScheduleState;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.product.Product;
import entity.user.User;
import interface_adapter.schedule.buyer_select_schedule.BuyerSelectScheduleViewModel;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


class BuyerScheduleViewTest {

    private BuyerSelectScheduleViewModel viewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private SearchProductViewModel searchProductViewModel;
    private MainPageViewModel mainPageViewModel;
    private ViewProfileViewModel viewProfileViewModel;
    private User buyer;
    private Product product;
    private BuyerScheduleView buyerScheduleView;

    @BeforeEach
    void setUp() throws IOException, SQLException {
        viewModel = new BuyerSelectScheduleViewModel();
        shoppingCartViewModel = new ShoppingCartViewModel();
        viewManagerModel = new ViewManagerModel();
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        searchProductViewModel = new SearchProductViewModel();
        mainPageViewModel = new MainPageViewModel();
        viewProfileViewModel = new ViewProfileViewModel();

//        buyerScheduleView = BuyerScheduleUseCaseFactory.create(viewModel, shoppingCartViewModel, viewManagerModel,
//                signupViewModel, loginViewModel, searchProductViewModel, mainPageViewModel, viewProfileViewModel);

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
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        String productID = "id_1";

        buyerScheduleView = BuyerScheduleUseCaseFactory.create(viewModel, shoppingCartViewModel, viewManagerModel,
                signupViewModel, loginViewModel, searchProductViewModel, mainPageViewModel, viewProfileViewModel);

        product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);


        buyer = new CommonUser("tabby cat", "password", "tabby@mail.utoronto.ca", 5, "1234567890");



    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        BuyerSelectScheduleState state = viewModel.getState();
        state.setBuyer(buyer);
        state.setProduct(product);
        viewModel.setState(state);
        viewModel.firePropertyChanged();
        assertEquals(viewModel.getState(), state);
        assertInstanceOf(BuyerScheduleView.class, buyerScheduleView);
    }
}