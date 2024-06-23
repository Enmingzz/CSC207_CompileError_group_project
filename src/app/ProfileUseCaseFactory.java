package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.profile.ManageProductViewModel;
import interface_adapter.profile.ProfileController;
import interface_adapter.profile.ProfileViewModel;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.signup.SignupViewModel;
import view.ManageProductView;
import view.ProfileView;

import java.io.IOException;

public class ProfileUseCaseFactory {

    private ProfileUseCaseFactory() {}

    public static ProfileView create(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel, MainPageViewModel mainPageViewModel, ProfileViewModel profileViewModel, ShoppingCartViewModel shoppingCartViewModel, ManageProductViewModel manageProductViewModel) throws IOException {
        //TODO implements this
        return null;
    }

    private static ProfileController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignupViewModel signupViewModel, LoginViewModel loginViewModel) throws IOException {
        //TODO implements this
        return null;
    }
}
