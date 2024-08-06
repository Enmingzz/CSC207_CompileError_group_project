package view.view_product;

import app.product_usecase_factory.SellerViewProductUseCaseFactory;
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
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import interface_adapter.view_product.reply_question.ReplyQuestionViewModel;
import interface_adapter.view_product.seller_view.SellerViewProductState;
import interface_adapter.view_product.seller_view.SellerViewProductViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SellerViewProductViewTest {

    private SellerViewProductView sellerViewProductView;
    private SellerViewProductViewModel sellerViewProductViewModel;

    @BeforeEach
    void setUp() throws IOException {
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        sellerViewProductViewModel = new SellerViewProductViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
        ReplyQuestionViewModel replyQuestionViewModel = new ReplyQuestionViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        sellerViewProductView = SellerViewProductUseCaseFactory.create(mainPageViewModel, viewManagerModel,
                sellerViewProductViewModel, viewProfileViewModel, replyQuestionViewModel,
                shoppingCartViewModel, searchProductViewModel,
                signupViewModel, loginViewModel);

        SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();

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

        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("name", "password", "email@email.com", 0, "12345");

        sellerViewProductState.setUser(user);
        sellerViewProductState.setProduct(product1);

        sellerViewProductViewModel.setState(sellerViewProductState);
        sellerViewProductViewModel.firePropertyChanged();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        assertInstanceOf(SellerViewProductView.class, sellerViewProductView);
        assertEquals(sellerViewProductViewModel.getState().getUser().getStudentNumber(), "12345");
    }
}