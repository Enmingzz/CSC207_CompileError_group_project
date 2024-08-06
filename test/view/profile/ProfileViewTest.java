package view.profile;

import app.user_usecase_factory.ProfileUseCaseFactory;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.profile.view_profile.ViewProfileState;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import interface_adapter.search_product.search.SearchProductViewModel;
import interface_adapter.shopping_cart.view_shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.signup.SignupViewModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ProfileViewTest {

    private ViewProfileViewModel viewProfileViewModel;
    private ProfileView profileView;

    @BeforeEach
    void setUp() throws SQLException, IOException {
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        ManageProductViewModel manageProductViewModel = new ManageProductViewModel();
        ModifyProfileViewModel modifyProfileViewModel = new ModifyProfileViewModel();
        SearchProductViewModel searchProductViewModel = new SearchProductViewModel();

        profileView = ProfileUseCaseFactory.create(viewManagerModel, signupViewModel
                , loginViewModel, mainPageViewModel, shoppingCartViewModel, manageProductViewModel,
                searchProductViewModel, viewProfileViewModel, modifyProfileViewModel);

        UserFactory userFactory = new CommonUserFactory();
        User user = userFactory.createUser("asdfg", "sdfghj", "a@a.com", 0, "12345");

        ViewProfileState viewProfileState = viewProfileViewModel.getState();
        viewProfileState.setUser(user);
        viewProfileViewModel.setState(viewProfileState);
        viewProfileViewModel.firePropertyChanged();


    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void propertyChange() {
        assertInstanceOf(ProfileView.class, profileView);
        assertEquals(viewProfileViewModel.getState().getUser().getStudentNumber(), "12345");
    }
}