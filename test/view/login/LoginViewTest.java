package view.login;

import app.user_usecase_factory.LoginUseCaseFactory;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import interface_adapter.view_product.buyer_view.BuyerViewProductViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginViewTest {

    private LoginViewModel loginViewModel;
    private LoginView loginView;

    @BeforeEach
    void setUp() {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        BuyerViewProductViewModel buyerViewProductViewModel = new BuyerViewProductViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();

        loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, mainPageViewModel,
                shoppingCartViewModel,
                viewProfileViewModel,
                buyerViewProductViewModel,
                searchProductViewModel,
                signupViewModel);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        LoginState loginState = loginViewModel.getState();
        UserFactory commonUserFactory = new CommonUserFactory();
        User user = commonUserFactory.createUser("asdf", "sdfgh", "email@email.com", 0, "123456");
        loginState.setUser(user);
        loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        loginState.setUser(user);
        assertEquals(loginState.getUser().getStudentNumber(), user.getStudentNumber());
        assertInstanceOf(LoginView.class, loginView);

    }
}