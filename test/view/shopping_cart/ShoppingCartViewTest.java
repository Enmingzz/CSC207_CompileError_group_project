package view.shopping_cart;

import app.shopping_cart_usecase_factory.ShoppingCartUseCaseFactory;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.schedule.buyer_select_schedule.BuyerSelectScheduleViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartState;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import interface_adapter.view_product.buyer_view.BuyerViewProductViewModel;
import interface_adapter.view_product.seller_view.SellerViewProductViewModel;
import interface_adapter.view_product.non_logged_in_view.UnloggedInViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartViewTest {

    private ShoppingCartViewModel shoppingCartViewModel;
    private ShoppingCartView shoppingCartView;

    @BeforeEach
    void setUp() throws SQLException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        UserFactory commonUserFactory = new CommonUserFactory();

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        shoppingCartViewModel = new ShoppingCartViewModel();
        SellerViewProductViewModel sellerViewProductViewModel = new SellerViewProductViewModel();
        BuyerViewProductViewModel buyerViewProductViewModel = new BuyerViewProductViewModel();
        BuyerSelectScheduleViewModel buyerSelectScheduleViewModel = new BuyerSelectScheduleViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
        UnloggedInViewModel unloggedInViewModel = new UnloggedInViewModel();
        RateProductViewModel rateProductViewModel = new RateProductViewModel();

        shoppingCartView =
                ShoppingCartUseCaseFactory.create(shoppingCartViewModel, buyerViewProductViewModel, sellerViewProductViewModel,
                        unloggedInViewModel, buyerSelectScheduleViewModel, rateProductViewModel, viewProfileViewModel, mainPageViewModel,
                        searchProductViewModel, viewManagerModel, signupViewModel, loginViewModel);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {

    }

    @Test
    void propertyChange() throws IOException {
        ArrayList<Product> databaseProducts = new ArrayList<>();

        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        // product1 initialized is a normal product on sale with 2 tags

        Image image = ImageIO.read(new File("src/pic/testpic1.png"));

        String description = "This is a description";

        String title = "This is a normal product";

        float price = 1;

        Integer rating = 0;

        int state = 0;

        String eTransferEmail = "example@email.com";

        String sellerStudentNumber = "1234567890";

        String address = "BA 3175";

        ArrayList<String> listTags = new ArrayList<>();

        listTags.add("Tag 1");

        listTags.add("Tag 2");

        String productID = "id_1";

        LocalDateTime buyerTime = LocalDateTime.parse("2024-07-13T12:00:00");

        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();

        sellerTime.add(buyerTime);

        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);

        Product product1 = productFactory.createProduct(
                image, description, title, price, rating, state, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product1);

        Product product2 = productFactory.createProduct(
                image, description, title, price, rating, 1, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product2);

        Product product3 = productFactory.createProduct(
                image, description, title, price, rating, 2, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product3);

        Product product4 = productFactory.createProduct(
                image, description, title, price, rating, 3, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product4);

        Product product5 = productFactory.createProduct(
                image, description, title, price, rating, 4, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product5);

        Product product6 = productFactory.createProduct(
                image, description, title, price, rating, -1, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product6);

        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("name", "password", "email@email.com", 0, "12345");

        ShoppingCartState shoppingCartState = shoppingCartViewModel.getState();
        shoppingCartState.setUser(user);
        shoppingCartState.setListProducts(databaseProducts);
        shoppingCartViewModel.setState(shoppingCartState);
        shoppingCartViewModel.firePropertyChanged();
        assertEquals(shoppingCartViewModel.getState().getUser().getStudentNumber(), "12345");
        assertNotNull(shoppingCartViewModel.getState().getListProducts());
        assertInstanceOf(ShoppingCartView.class, shoppingCartView);
    }
}