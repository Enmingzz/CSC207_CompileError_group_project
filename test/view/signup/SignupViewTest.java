package view.signup;

import app.user_usecase_factory.SignupUseCaseFactory;
import entity.user.CommonUser;
import entity.user.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupState;
import interface_adapter.signup.signup.SignupViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SignupViewTest {
    private ViewManagerModel viewManagerModel;
    private LoginViewModel loginViewModel;
    private SignupViewModel signupViewModel;
    private MainPageViewModel mainPageViewModel;
    private ShoppingCartViewModel shoppingCartViewModel;
    private SearchProductViewModel searchProductViewModel;
    private ViewProfileViewModel viewProfileViewModel;

    private SignupView signupView;
    private User user;

    @BeforeEach
    void setUp() {
        viewManagerModel = new ViewManagerModel();
        loginViewModel = new LoginViewModel();
        signupViewModel = new SignupViewModel();
        mainPageViewModel = new MainPageViewModel();
        shoppingCartViewModel = new ShoppingCartViewModel();
        searchProductViewModel = new SearchProductViewModel();
        viewProfileViewModel = new ViewProfileViewModel();

        user = new CommonUser("hanrui", "123456", "hanrui@mail", 0, "11111");

        signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, mainPageViewModel,
                shoppingCartViewModel, searchProductViewModel, loginViewModel, viewProfileViewModel);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {

    }

    @Test
    void propertyChange() {
        SignupState signupState = signupViewModel.getState();
        signupState.setUser(user);
        signupViewModel.setState(signupState);
        signupViewModel.firePropertyChanged();
        assertEquals(signupViewModel.getState(), signupState);
    }
}