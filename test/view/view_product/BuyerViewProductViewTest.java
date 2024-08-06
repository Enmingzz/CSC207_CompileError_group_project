package view.view_product;

import app.product_usecase_factory.BuyerViewProductUseCaseFactory;
import entity.comment.*;
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
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.profile.view_profile.ViewUserProfileViewModel;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.schedule.buyer_select_schedule.BuyerSelectScheduleViewModel;
import interface_adapter.schedule.seller_select_schedule.SellerSelectScheduleViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import interface_adapter.view_product.buyer_view.BuyerViewProductState;
import interface_adapter.view_product.buyer_view.BuyerViewProductViewModel;
import interface_adapter.view_product.non_logged_in_view.UnloggedInViewModel;
import interface_adapter.view_product.reply_question.ReplyQuestionViewModel;
import interface_adapter.view_product.seller_view.SellerViewProductViewModel;
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

class BuyerViewProductViewTest {

    private BuyerViewProductViewModel buyerViewProductViewModel;
    private BuyerViewProductView buyerViewProductView;

    @BeforeEach
    void setUp() throws SQLException, IOException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        UserFactory commonUserFactory = new CommonUserFactory();

        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        ManageProductViewModel manageProductViewModel = new ManageProductViewModel();
        ModifyProfileViewModel modifyProfileViewModel = new ModifyProfileViewModel();
        SellerViewProductViewModel sellerViewProductViewModel = new SellerViewProductViewModel();
        buyerViewProductViewModel = new BuyerViewProductViewModel();
        ViewModifyProductViewModel modifyProductViewModel = new ViewModifyProductViewModel();
        SellerSelectScheduleViewModel sellerSelectScheduleViewModel = new SellerSelectScheduleViewModel();
        BuyerSelectScheduleViewModel buyerSelectScheduleViewModel = new BuyerSelectScheduleViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
        UnloggedInViewModel unloggedInViewModel = new UnloggedInViewModel();
        SignupViewModel signUpViewModel = new SignupViewModel();
        ReplyQuestionViewModel replyQuestionViewModel = new ReplyQuestionViewModel();
        RateProductViewModel rateProductViewModel = new RateProductViewModel();
        ViewCreateProductViewModel viewCreateProductViewModel = new ViewCreateProductViewModel();
        ViewModifyProductViewModel viewModifyProductViewModel = new ViewModifyProductViewModel();
        ViewUserProfileViewModel viewUserProfileViewModel = new ViewUserProfileViewModel();

        buyerViewProductView =
                BuyerViewProductUseCaseFactory.create(viewManagerModel, mainPageViewModel, shoppingCartViewModel,
                        viewProfileViewModel, buyerViewProductViewModel, searchProductViewModel,
                        signupViewModel, loginViewModel, viewUserProfileViewModel);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() throws IOException {

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



        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("name", "password", "email@email.com", 0, "12345");

        AnswerFactory answerFactory = new CommonAnswerFactory();

        Answer empty_ans = answerFactory.createAnswer("", "");
        Question question  = new CommonQuestion("", "", empty_ans, "");
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(question);


        BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
        buyerViewProductState.setProduct(product1);
        buyerViewProductState.setUser(user);
        buyerViewProductState.setLst_question(questions);
        buyerViewProductViewModel.setState(buyerViewProductState);
        buyerViewProductViewModel.firePropertyChanged();
        assertEquals(buyerViewProductViewModel.getState().getUser().getStudentNumber(), user.getStudentNumber());
        assertInstanceOf(BuyerViewProductView.class, buyerViewProductView);


    }
}