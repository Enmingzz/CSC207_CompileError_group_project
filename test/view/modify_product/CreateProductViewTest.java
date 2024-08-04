package view.modify_product;

import app.product_usecase_factory.CreateProductUseCaseFactory;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.CreateProductState;
import interface_adapter.modify_product.ViewCreateProductViewModel;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
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

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CreateProductViewTest {

    private ViewCreateProductViewModel viewCreateProductViewModel;
    private CreateProductView createProductView;

    @BeforeEach
    void setUp() throws SQLException, IOException {
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        ManageProductViewModel manageProductViewModel = new ManageProductViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
        viewCreateProductViewModel = new ViewCreateProductViewModel();
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        createProductView = CreateProductUseCaseFactory.create(viewCreateProductViewModel, manageProductViewModel,
                shoppingCartViewModel, viewManagerModel, signupViewModel, loginViewModel, searchProductViewModel, viewProfileViewModel,
                mainPageViewModel);

        CreateProductState createProductState = viewCreateProductViewModel.getState();

        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("a", "a", "asd@a.com", 0, "12345");

        createProductState.setUser(user);
        viewCreateProductViewModel.setState(createProductState);
        viewCreateProductViewModel.firePropertyChanged();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        assertInstanceOf(CreateProductView.class, createProductView);
        assertEquals(viewCreateProductViewModel.getState().getUser().getStudentNumber(), "12345");
    }
}