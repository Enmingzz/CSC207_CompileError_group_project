package view.modify_product;

import app.product_usecase_factory.ModifyProductUseCaseFactory;
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
import interface_adapter.modify_product.modify.ViewModifyProductState;
import interface_adapter.modify_product.modify.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
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

class ModifyProductViewTest {

    private ViewModifyProductViewModel viewModifyProductViewModel;
    private ModifyProductView modifyProductView;

    @BeforeEach
    void setUp() throws SQLException, IOException {

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        ManageProductViewModel manageProductViewModel = new ManageProductViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
        viewModifyProductViewModel = new ViewModifyProductViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        modifyProductView =  ModifyProductUseCaseFactory.create(viewModifyProductViewModel, viewManagerModel,
                searchProductViewModel, signupViewModel, loginViewModel, shoppingCartViewModel, mainPageViewModel, viewProfileViewModel,
                manageProductViewModel);

        ViewModifyProductState viewModifyProductState = viewModifyProductViewModel.getState();

        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("a", "asdfgh", "a@a.com", 0, "12345");

        viewModifyProductState.setUser(user);

        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        ProductFactory productFactory = new CommonProductFactory();

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
                listTags, productID, schedule);

        viewModifyProductState.setProduct(product1);

        viewModifyProductViewModel.setState(viewModifyProductState);
        viewModifyProductViewModel.firePropertyChanged();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        assertInstanceOf(ModifyProductView.class, modifyProductView);
        assertEquals(viewModifyProductViewModel.getState().getUser().getStudentNumber(), "12345");
    }
}