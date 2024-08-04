package view.schedule;

import app.schedule_usecase_factory.SellerScheduleUseCaseFactory;
import entity.product.CommonProduct;
import entity.product.Product;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.user.CommonUser;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.schedule.SellerSelectScheduleState;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.SearchProductViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SellerScheduleViewTest {
    private SellerSelectScheduleViewModel sellerSelectScheduleViewModel;
    private ViewManagerModel viewManagerModel;
    private ManageProductViewModel manageProductViewModel;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private MainPageViewModel mainPageViewModel;
    private SearchProductViewModel searchProductViewModel;
    private ViewProfileViewModel viewProfileViewModel;

    private Product product;
    private User seller;
    private SellerScheduleView sellerScheduleView;;

    @BeforeEach
    void setUp() throws IOException, SQLException {
        sellerSelectScheduleViewModel = new SellerSelectScheduleViewModel();
        viewManagerModel = new ViewManagerModel();
        manageProductViewModel = new ManageProductViewModel();
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        shoppingCartViewModel = new ShoppingCartViewModel();
        mainPageViewModel = new MainPageViewModel();
        searchProductViewModel = new SearchProductViewModel();
        viewProfileViewModel = new ViewProfileViewModel();

        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "This is a title";
        int state = 1;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1234567890";
        String address = "BA 3175";
        LocalDateTime buyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        String productID = "id_1";

        product = new CommonProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);


        seller = new CommonUser("tabby cat", "password", "tabby@mail.utoronto.ca", 5, "1234567890");

        sellerScheduleView = SellerScheduleUseCaseFactory.create(sellerSelectScheduleViewModel, viewManagerModel,
                manageProductViewModel, signupViewModel, loginViewModel, shoppingCartViewModel, mainPageViewModel, searchProductViewModel, viewProfileViewModel);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        SellerSelectScheduleState sellerSelectScheduleState = sellerSelectScheduleViewModel.getState();
        sellerSelectScheduleState.setSeller(seller);
        sellerSelectScheduleState.setProduct(product);
        sellerSelectScheduleViewModel.setState(sellerSelectScheduleState);
        sellerSelectScheduleViewModel.firePropertyChanged();
        assertEquals(sellerSelectScheduleViewModel.getState(), sellerSelectScheduleState);
        assertInstanceOf(SellerScheduleView.class, sellerScheduleView);
    }
}