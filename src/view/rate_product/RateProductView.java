package view.rate_product;

import entity.product.CommonProductFactory;
import entity.product.Product;
import entity.product.ProductFactory;
import entity.schedule.CommonScheduleFactory;
import entity.schedule.Schedule;
import entity.schedule.ScheduleFactory;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.ViewModel;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.rating.GetRatePageController;
import interface_adapter.rating.RateProductController;
import interface_adapter.rating.RateProductState;
import interface_adapter.rating.RateProductViewModel;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import view.TopBarSampleView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RateProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "view rate product";

    private final RateProductViewModel rateProductViewModel;
    private final JTextField ratingInputField = new JTextField(3);

    RateProductController rateProductController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;

    private final JButton createRating;
    private final JButton cancel;

    RateProductLabelTextPanel showProduct;
    JPanel getRating;
    private JPanel topBar;


    //TODO figure out how cancel works and if anything extra is needed to be done in order to get cancel working
    //maybe we don't need cancel button? since we already have main page button in the top bar --from Freya

    public RateProductView(RateProductViewModel rateProductViewModel,
                           RateProductController rateProductController,
                           GetSearchPageController getSearchPageController,
                           MainPageController mainPageController,
                           ViewSignupPageController viewSignupPageController,
                           ViewLoginPageController viewLoginPageController,
                           ShoppingCartController shoppingCartController,
                           LogOutController logOutController,
                           ViewProfileController viewProfileController
                           ) throws IOException {
        this.rateProductViewModel = rateProductViewModel;
        this.getSearchPageController = getSearchPageController;
        this.mainPageController = mainPageController;
        this.viewSignupPageController = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;

        //TODO: FIX CA IN THIS AREA
        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        ProductFactory productFactory = new CommonProductFactory();
        ScheduleFactory scheduleFactory = new CommonScheduleFactory();

        Image productImage = ImageIO.read(new File("src/pic/testpic1.png"));

        String description = "";

        String productTitle = "";

        float productPrice = 0;

        Integer rating = 0;

        int state = 0;

        String eTransferEmail = "";

        String sellerStudentNumber = "";

        String address = "";

        ArrayList<String> listTags = new ArrayList<>();

        String productID = "";

        LocalDateTime buyerTime = null;

        ArrayList<LocalDateTime> sellerTime = new ArrayList<>();

        Schedule schedule = scheduleFactory.createSchedule(buyerTime, sellerTime);

        Product product = productFactory.createProduct(
                productImage, description, productTitle, productPrice, rating, state, eTransferEmail, sellerStudentNumber, address,
                listTags, productID, schedule
        );


        rateProductViewModel.addPropertyChangeListener(this);
        this.rateProductController = rateProductController;

        JLabel title = new JLabel(rateProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        cancel = new JButton(rateProductViewModel.CANCEL_BUTTON_LABEL);
        createRating = new JButton(rateProductViewModel.CREATE_RATING_BUTTON_LABEL);

        buttons.add(cancel);
        buttons.add(createRating);

        //(1) show the product information

        final JLabel image = new JLabel(String.valueOf(product.getImage()));
        final JLabel _title = new JLabel(product.getTitle());
        final JLabel price = new JLabel(String.valueOf(product.getPrice()));

        showProduct = new RateProductLabelTextPanel(image, _title, price);

        //(2) show the rating
        getRating = new JPanel();

        final JLabel rating_title = new JLabel("Create Rating:");

        getRating.add(ratingInputField); //the input field
        getRating.add(createRating); //the button

        class RatingInputFieldListener implements KeyListener{
            //Update the rating entered by the user.
            @Override
            public void keyTyped(KeyEvent e) {
                RateProductState state = rateProductViewModel.getState();
                state.setRating(ratingInputField.getText() + e.getKeyChar());
                rateProductViewModel.setState(state);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        }

        class CreateRatingListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(createRating)) {
                    try {
                        rateProductController.execute(rateProductViewModel.getState().getUser(), rateProductViewModel.getState().getProduct(),
                                rateProductViewModel.getState().getRating());
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }

        class CancelButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(cancel)) {
                    try{
                        RateProductState state = rateProductViewModel.getState();
                        User user = state.getUser();
                        shoppingCartController.execute(user);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar, BorderLayout.NORTH);

        createRating.addActionListener(new CreateRatingListener());
        ratingInputField.addKeyListener(new RatingInputFieldListener());
        cancel.addActionListener(new CancelButtonListener());

        //TODO write how the layout will be
        this.setLayout(new BorderLayout());
        this.add(title, BorderLayout.CENTER);
        this.add(showProduct, BorderLayout.WEST);
        this.add(getRating, BorderLayout.EAST);
        this.add(buttons, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("rate page state updated");
        RateProductState state = (RateProductState) evt.getNewValue();
        if(state.getRatingError() != null) {
            JOptionPane.showMessageDialog(this, state.getRatingError());
        }

        topBar.removeAll();
        topBar.add(new TopBarSampleView(rateProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();
    }
}


