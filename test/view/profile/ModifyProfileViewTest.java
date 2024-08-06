package view.profile;

import app.user_usecase_factory.ModifyProfileUseCaseFactory;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileState;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ModifyProfileViewTest {
    private ModifyProfileView modifyProfileView;
    private ModifyProfileViewModel modifyProfileViewModel;

    @BeforeEach
    void setUp() throws SQLException {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        modifyProfileViewModel = new ModifyProfileViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();
        SignupViewModel signUpViewModel = new SignupViewModel();
        modifyProfileView = ModifyProfileUseCaseFactory.create(viewManagerModel
                , mainPageViewModel,shoppingCartViewModel, searchProductViewModel, viewProfileViewModel, signUpViewModel,
                loginViewModel,modifyProfileViewModel);

        ModifyProfileState modifyProfileState = modifyProfileViewModel.getState();
        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("asdf", "asdf", "a@a.com", 0, "12345");
        modifyProfileState.setUser(user);
        modifyProfileState.setModified(true);
        modifyProfileViewModel.setState(modifyProfileState);
        modifyProfileViewModel.firePropertyChanged();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void actionPerformed() {
    }

    @Test
    void propertyChange() {
        assertInstanceOf(ModifyProfileView.class, modifyProfileView);
        assertEquals(modifyProfileViewModel.getState().getUser().getStudentNumber(), "12345");
    }
}