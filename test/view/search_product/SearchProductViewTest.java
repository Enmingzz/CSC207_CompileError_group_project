package view.search_product;

import app.search_product_usecase_factory.SearchProductUseCaseFactory;
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
import interface_adapter.search_product.search.SearchProductState;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class SearchByNameViewTest {
    private SearchProductViewModel searchProductViewModel;
    private ViewManagerModel viewManagerModel;
    private BuyerViewProductViewModel buyerViewProductViewModel;
    private SellerViewProductViewModel sellerViewProductViewModel;
    private UnloggedInViewModel unloggedInViewModel;
    private SignupViewModel signupViewModel;
    private LoginViewModel loginViewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private MainPageViewModel mainPageViewModel;
    private ViewProfileViewModel viewProfileViewModel;

    private User user;
    private ArrayList<Product> products;
    private Product product1;
    private Product product2;
    private SearchProductView searchProductView;

    @BeforeEach
    void setUp() throws IOException, SQLException {

        searchProductViewModel = new SearchProductViewModel();
        viewManagerModel = new ViewManagerModel();
        buyerViewProductViewModel = new BuyerViewProductViewModel();
        sellerViewProductViewModel = new SellerViewProductViewModel();
        unloggedInViewModel = new UnloggedInViewModel();
        signupViewModel = new SignupViewModel();
        loginViewModel = new LoginViewModel();
        shoppingCartViewModel = new ShoppingCartViewModel();
        mainPageViewModel = new MainPageViewModel();
        viewProfileViewModel = new ViewProfileViewModel();

        String name = "tabby cat";
        String password = "password";
        String email = "tabby@mail.utoronto.ca";
        float userRating = 5;
        String studentNumber = "1234567890";

        UserFactory userFactory = new CommonUserFactory();
        user = userFactory.createUser(name, password, email, userRating, studentNumber);
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();
        Image image = ImageIO.read(new File("src/pic/testpic1.png"));
        String des = "This is a description";
        float price = 1;
        String title = "This is a title";
        int state = 0;
        int rating = 0;
        String eTransferEmail = "example@email.com";
        String sellerStudentNumber = "1111111111";
        String address = "BA 3175";
        LocalDateTime buyerTime = null;
        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();
        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);
        ArrayList<String> listTags = new ArrayList<>();
        listTags.add("Tag 1");
        String productID = "id_1";

        product1 = productFactory.createProduct(image, des, title, price, state, rating, eTransferEmail,
                sellerStudentNumber, address, listTags, productID, schedule);

        products = new ArrayList<>();
        products.add(product1);

        Image image2 = ImageIO.read(new File("src/pic/testpic2.png"));
        String description2 = "This is a description";
        String title2 = "This is a title ";
        float price2 = 2;
        Integer rating2 = 0;
        int state2 = 0;
        String eTransferEmail2 = "example@email.com";
        String sellerStudentNumber2 = "1234567890";
        String address2 = "BA 3185";
        ArrayList<String> listTags2 = new ArrayList<>();
        listTags2.add("Tag 1");
        String productID2 = "id_2";
        LocalDateTime buyerTime2 = null;
        ArrayList<LocalDateTime> sellerTime2 = new ArrayList<>();
        Schedule schedule2 = scheduleFactory.createSchedule(buyerTime2, sellerTime2);
        product2 = productFactory.createProduct(
                image2, description2, title2, price2, rating2, state2, eTransferEmail2, sellerStudentNumber2, address2,
                listTags2, productID2, schedule2
        );

        products.add(product2);

        searchProductView = SearchProductUseCaseFactory.create(searchProductViewModel, viewManagerModel, buyerViewProductViewModel,
                sellerViewProductViewModel, unloggedInViewModel, signupViewModel, loginViewModel, shoppingCartViewModel, mainPageViewModel, viewProfileViewModel);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        SearchProductState searchProductState = searchProductViewModel.getState();
        searchProductState.setProducts(products);
        searchProductState.setUser(user);
        searchProductViewModel.setState(searchProductState);
        searchProductViewModel.firePropertyChanged();
        assertEquals(searchProductViewModel.getState(), searchProductState);
        assertInstanceOf(SearchProductView.class, searchProductView);
    }
}