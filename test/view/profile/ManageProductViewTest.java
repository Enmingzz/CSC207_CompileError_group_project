package view.profile;

import app.user_usecase_factory.ManageProductUseCaseFactory;
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
import interface_adapter.modify_product.create.ViewCreateProductViewModel;
import interface_adapter.modify_product.modify.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductState;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.schedule.seller_select_schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
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

class ManageProductViewTest {

    private ManageProductView manageProductView;
    private ManageProductViewModel manageProductViewModel;
    @BeforeEach
    void setUp() throws IOException, SQLException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        manageProductViewModel = new ManageProductViewModel();
        SellerViewProductViewModel sellerViewProductViewModel = new SellerViewProductViewModel();
        BuyerViewProductViewModel buyerViewProductViewModel = new BuyerViewProductViewModel();
        SellerSelectScheduleViewModel sellerSelectScheduleViewModel = new SellerSelectScheduleViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
        UnloggedInViewModel unloggedInViewModel = new UnloggedInViewModel();
        ViewCreateProductViewModel viewCreateProductViewModel = new ViewCreateProductViewModel();
        ViewModifyProductViewModel viewModifyProductViewModel = new ViewModifyProductViewModel();

        manageProductView = ManageProductUseCaseFactory.create(searchProductViewModel, manageProductViewModel,
                viewManagerModel, buyerViewProductViewModel, sellerViewProductViewModel, unloggedInViewModel, signupViewModel, loginViewModel,
                shoppingCartViewModel, mainPageViewModel, viewProfileViewModel, viewCreateProductViewModel, viewModifyProductViewModel,
                sellerSelectScheduleViewModel);

        ManageProductState manageproductState = manageProductViewModel.getState();

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

        LocalDateTime buyerTime = null;

        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();

        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);

        Product product1 = productFactory.createProduct(
                image, description, title, price, rating, state, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product1);

        Product product2 = productFactory.createProduct(
                image, description, title, price, rating, state, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product2);

        Product product3 = productFactory.createProduct(
                image, description, title, price, rating, state, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product3);

        Product product4 = productFactory.createProduct(
                image, description, title, price, rating, state, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );

        databaseProducts.add(product4);

        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("name", "password", "email@email.com", 0, "12345");
        manageproductState.setUser(user);
        manageproductState.setProduct(databaseProducts);
        manageProductViewModel.setState(manageproductState);
        manageProductViewModel.firePropertyChanged();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateMainPanel() {
    }

    @Test
    void actionPerformed() {

    }

    @Test
    void propertyChange() {
        assertInstanceOf(ManageProductView.class, manageProductView);
        assertEquals(manageProductViewModel.getState().getUser().getStudentNumber(), "12345");

    }
}