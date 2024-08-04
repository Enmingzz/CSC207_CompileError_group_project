package view.profile;

import app.user_usecase_factory.UserProfileUseCaseFactory;
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
import interface_adapter.modify_product.ViewCreateProductViewModel;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.profile.view_profile.ViewUserProfileState;
import interface_adapter.profile.view_profile.ViewUserProfileViewModel;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.schedule.BuyerSelectScheduleViewModel;
import interface_adapter.schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.SearchProductViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import interface_adapter.view_product.BuyerViewProductViewModel;
import interface_adapter.view_product.ReplyQuestionViewModel;
import interface_adapter.view_product.SellerViewProductViewModel;
import interface_adapter.view_product.UnloggedInViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.ViewManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserProfileViewTest {

    private ViewUserProfileViewModel viewUserProfileViewModel;
    private UserProfileView userProfileView;

    @BeforeEach
    void setUp() throws SQLException, IOException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        SellerViewProductViewModel sellerViewProductViewModel = new SellerViewProductViewModel();
        BuyerViewProductViewModel buyerViewProductViewModel = new BuyerViewProductViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
        UnloggedInViewModel unloggedInViewModel = new UnloggedInViewModel();
        viewUserProfileViewModel = new ViewUserProfileViewModel();

        userProfileView = UserProfileUseCaseFactory.create(
                viewManagerModel,
                signupViewModel,
                loginViewModel,
                mainPageViewModel,
                shoppingCartViewModel,
                buyerViewProductViewModel,
                sellerViewProductViewModel,
                unloggedInViewModel,
                viewProfileViewModel,
                searchProductViewModel,
                viewUserProfileViewModel);

        ViewUserProfileState viewUserProfileState = viewUserProfileViewModel.getState();
        UserFactory userFactory = new CommonUserFactory();
        User buyerUser = userFactory.createUser("a", "asdfgh", "a@a.com", 0, "12345");
        User sellerUser = userFactory.createUser("b", "asdfgh", "a@a.com", 0, "54321");

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

        viewUserProfileState.setBuyerUser(buyerUser);
        viewUserProfileState.setSellerUser(sellerUser);
        viewUserProfileState.setListProduct(databaseProducts);

        viewUserProfileViewModel.setState(viewUserProfileState);
        viewUserProfileViewModel.firePropertyChanged();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void propertyChange() {
        assertInstanceOf(UserProfileView.class, userProfileView);
        assertEquals(viewUserProfileViewModel.getState().getSellerUser().getStudentNumber(), "54321");
    }
}