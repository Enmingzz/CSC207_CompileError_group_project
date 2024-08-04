package view.profile;

import app.user_usecase_factory.ModifyProfileUseCaseFactory;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.main_page.MainPageViewModel;
import interface_adapter.modify_product.ViewCreateProductViewModel;
import interface_adapter.modify_product.ViewModifyProductViewModel;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileState;
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

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ModifyProfileViewTest {
    private ModifyProfileView modifyProfileView;
    private ModifyProfileViewModel modifyProfileViewModel;

    @BeforeEach
    void setUp() throws SQLException {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();
        MainPageViewModel mainPageViewModel = new MainPageViewModel();
        ViewProfileViewModel viewProfileViewModel = new ViewProfileViewModel();
        ShoppingCartViewModel shoppingCartViewModel = new ShoppingCartViewModel();
        ManageProductViewModel manageProductViewModel = new ManageProductViewModel();
        modifyProfileViewModel = new ModifyProfileViewModel();
        SellerViewProductViewModel sellerViewProductViewModel = new SellerViewProductViewModel();
        BuyerViewProductViewModel buyerViewProductViewModel = new BuyerViewProductViewModel();
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