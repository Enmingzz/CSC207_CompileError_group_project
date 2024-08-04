package view.rate_product;

import app.product_usecase_factory.RateProductUseCaseFactory;
import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.rating.RateProductState;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.search_product.SearchProductViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
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

class RateProductViewTest {
    private RateProductViewModel rateProductViewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private ViewManagerModel viewManagerModel;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private SearchProductViewModel searchProductViewModel;
    private MainPageViewModel mainPageViewModel;
    private ViewProfileViewModel viewProfileViewModel;
    private String selectedRating;
    private Product product;
    private User user;

    private RateProductView rateProductView;

    @BeforeEach
    void setUp() throws IOException, SQLException {
        rateProductViewModel = new RateProductViewModel();
        shoppingCartViewModel = new ShoppingCartViewModel();
        viewManagerModel = new ViewManagerModel();
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        searchProductViewModel = new SearchProductViewModel();
        mainPageViewModel = new MainPageViewModel();
        viewProfileViewModel = new ViewProfileViewModel();



        String name = "Calico";
        String password = "Cat123";
        String email = "calico.cat@mail.utoronto.ca";
        float userRating = 4;
        String studentNumber = "1010101010";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);

        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String description = "It was worn once";
        float price = 2;
        String title = "Red Dress";
        int state = 1;
        Integer rating = 3;
        String eTransferEmail = "calico.cat@mail.utoronto.ca";
        String sellerStudentNumber = "1010101010";
        String address = "123College";
        LocalDateTime time = null;
        ArrayList<LocalDateTime> arrayList = new ArrayList<>();
        CommonScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Schedule schedule = scheduleFactory.createSchedule(time, arrayList);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("clothes");
        String productID = "ASDASD";

        ProductFactory productFactory = new CommonProductFactory();

        product = productFactory.createProduct(image, description, title, price, state, rating, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule);

        selectedRating = "4";

        RateProductState rateProductState= rateProductViewModel.getState();
        rateProductState.setProduct(product);
        rateProductViewModel.setState(rateProductState);


        rateProductView = RateProductUseCaseFactory.create(rateProductViewModel, shoppingCartViewModel, viewManagerModel,
                signupViewModel, loginViewModel, searchProductViewModel, mainPageViewModel, viewProfileViewModel);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        RateProductState rateProductState= rateProductViewModel.getState();
        rateProductState.setRating(selectedRating);
        rateProductState.setUser(user);
        rateProductViewModel.setState(rateProductState);
        rateProductViewModel.firePropertyChanged();
        assertEquals(rateProductViewModel.getState(), rateProductState);
    }
}