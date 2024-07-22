package view.view_product;

import app.Main;
import entity.comment.Question;
import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewUserProfileController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.UnloggedInState;
import interface_adapter.view_product.UnloggedInViewModel;
import view.TopBarSampleView;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class provides a view for non-logged-in users to explore product details. It includes functionality
 * to display product information, questions and answers related to the product, and options to navigate
 * to other parts of the application like login or signup pages.
 * <p>
 * The class uses several controllers to manage user interaction with the application and to update the view
 * according to user actions and application state changes.
 * </p>
 */


public class NonloggedInProductView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "non login view product view";
    private final UnloggedInViewModel nonLoggedInViewModel;
    private final ViewUserProfileController viewUserProfileController;

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;


    private final JButton cancel;
    private final JButton addToCart;
    private final JButton viewUserProfile;

    private JPanel productInfo = new JPanel();
    private JPanel qAInfo = new JPanel();
    private JPanel topBar;
    private final JPanel titlePanel = new JPanel();
    private JPanel qA_TextPanel = new JPanel();
    private BuyerQAInfoLabelTextPanel singleQa;
    private final JLabel image = new JLabel();

    private ProductInfoLabelTextPanel imageInfo;
    private ProductInfoLabelTextPanel descriptionInfo;
    private ProductInfoLabelTextPanel priceInfo;
    private ProductInfoLabelTextPanel _titleInfo;
    private ProductInfoLabelTextPanel ratingInfo;
    private ProductInfoLabelTextPanel stateInfo;
    private ProductInfoLabelTextPanel addressInfo;
    private ProductInfoLabelTextPanel lstTagsInfo;
    private ProductInfoLabelTextPanel productIDInfo;



    /**
     * Constructs a NonloggedInProductView with specific controllers and view model to manage the view's state and interactions.
     *
     * @param nonLoggedInViewModel the view model containing state and operations specific to non-logged-in users.
     * @param viewLoginPageController controller to manage login operations.
     * @param mainPageController controller to navigate to the main page.
     * @param getSearchPageController controller to access the search page functionality.
     * @param viewSignupPageController controller to manage signup operations.
     * @param shoppingCartController controller to handle shopping cart operations.
     * @param logOutController controller to manage logout operations.
     * @param viewProfileController controller to view user profiles.
     * @param viewUserProfileController controller to view other user profiles.
     */

    public NonloggedInProductView(UnloggedInViewModel nonLoggedInViewModel,
                                  ViewLoginPageController viewLoginPageController,
                                  MainPageController mainPageController,
                                  GetSearchPageController getSearchPageController,
                                  ViewSignupPageController viewSignupPageController,
                                  ShoppingCartController shoppingCartController,
                                  LogOutController logOutController,
                                  ViewProfileController viewProfileController,
                                  ViewUserProfileController viewUserProfileController){
        this.nonLoggedInViewModel = nonLoggedInViewModel;
        this.viewUserProfileController = viewUserProfileController;

        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;

        this.nonLoggedInViewModel.addPropertyChangeListener(this);


        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);

        JLabel title = new JLabel(nonLoggedInViewModel.TITLE_LABEL+", but you are not logged in yet :(");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //(1)product_info
//        final JLabel message = new JLabel("There is no product");
        Product wtv_product = nonLoggedInViewModel.getState().getProduct();
//        if (wtv_product == null){
//            productInfo = null;
//        } else {
//        final JLabel image = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getImage()));//image???
        final JLabel description = (wtv_product == null)? new JLabel(): new JLabel(wtv_product.getDescription());
        final JLabel price = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getPrice()));
        final JLabel _title = (wtv_product == null)? new JLabel(): new JLabel(wtv_product.getTitle());
        final JLabel rating = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getRating()));
        final JLabel state = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getState()));
        final JLabel address = (wtv_product == null)? new JLabel(): new JLabel(wtv_product.getAddress());
        final JLabel lstTags = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getListTags()));//what will valueOf list look like???
        final JLabel productID = (wtv_product == null)? new JLabel(): new JLabel(wtv_product.getProductID());

//            productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
//                    lstTags, productID);
        imageInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.IMAGE_LABEL), image);
        descriptionInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.DESCRIPTION_LABEL), description);
        priceInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.PRICE_LABEL), price);
        _titleInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.PRODUCTTITLE_LABEL), _title);
        ratingInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.RATING_LABEL), rating);
        stateInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.STATE_LABEL), state);
        addressInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.ADDRESS_LABEL), address);
        lstTagsInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.LISTTAGS_LABEL), lstTags);
        productIDInfo = new ProductInfoLabelTextPanel(new JLabel(nonLoggedInViewModel.PRODUCTID_LABEL), productID);

        titlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        productInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));

        if(nonLoggedInViewModel.getState().getProduct() != null) {
            System.out.println("this is the initial :::price::::::" + nonLoggedInViewModel.getState().getProduct().getPrice());
        }

        titlePanel.add(title);
        productInfo.add(titlePanel);
        productInfo.add(_titleInfo);
        productInfo.add(productIDInfo);
        productInfo.add(descriptionInfo);
        productInfo.add(priceInfo);
        productInfo.add(ratingInfo);
        productInfo.add(stateInfo);
        productInfo.add(addressInfo);
        productInfo.add(lstTagsInfo);
        productInfo.add(imageInfo);
//        }


        //(2)show q_and_a
        qAInfo.setLayout(new BoxLayout(qAInfo, BoxLayout.Y_AXIS));
        qAInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        final JLabel qA_title = new JLabel("Q&A:");

        ArrayList<Question> lst_question = nonLoggedInViewModel.getState().getQuestion();

        for (Question question : lst_question) {

            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);

//            BuyerQAInfoLabelTextPanel panel = new BuyerQAInfoLabelTextPanel(q, a);
//            qA_TextPanel.add(panel);
            singleQa = new BuyerQAInfoLabelTextPanel(q, a);
            qA_TextPanel.add(singleQa);
        }

        qA_TextPanel.setLayout(new BoxLayout(qA_TextPanel, BoxLayout.Y_AXIS));
        qAInfo.add(qA_title);
        qAInfo.add(new JScrollPane(qA_TextPanel));


        //(3)buttons
        JPanel buttons = new JPanel();
        cancel = new JButton(nonLoggedInViewModel.CANCEL_BUTTON_LABEL);
        viewUserProfile = new JButton(nonLoggedInViewModel.VIEW_USER_PROFILE_BUTTON);
        addToCart = new JButton(nonLoggedInViewModel.ADD_TO_CART);


        buttons.add(cancel);
        buttons.add(viewUserProfile);
        buttons.add(addToCart);


        class AddTtoCartButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(addToCart)) {
                    try {
                        viewLoginPageController.execute();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        class ViewUserProfileButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (evt.getSource().equals(viewUserProfile)) {
                    try {
                        System.out.println("click view user profile button");
                        viewUserProfileController.execute(
                                nonLoggedInViewModel.getState().getProduct().getSellerStudentNumber(),
                                nonLoggedInViewModel.getState().getUser());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }


        class CancelButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(cancel)){
                    try{
                        UserFactory userFactory = new CommonUserFactory();
                        User emptyuser = userFactory.createUser("","","",0, "");
                        mainPageController.execute(emptyuser);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        addToCart.addActionListener(new AddTtoCartButtonListener());
        viewUserProfile.addActionListener(new ViewUserProfileButtonListener());
        cancel.addActionListener(new CancelButtonListener());
//
//        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
//        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//
//        this.add(title);
//        this.add(Objects.requireNonNullElse(productInfo, message));
//        this.add(qAInfo);
//        this.add(buttons);
        this.setLayout(new BorderLayout(1, 1));
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout());
        centerPanel.add(productInfo);
        centerPanel.add(qAInfo);
        this.add(topBar, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);

        this.add(buttons, BorderLayout.SOUTH);
        this.add(new JPanel(), BorderLayout.EAST);
        this.add(new JPanel(), BorderLayout.WEST);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * Responds to property changes and updates the UI accordingly. This method ensures that the view reflects
     * the current state of the model after changes occur.
     *
     * @param evt the property change event, indicating changes in the model state that may affect the view.

    /**
     * Responds to property changes and updates the UI accordingly. This method ensures that the view reflects
     * the current state of the model after changes occur.
     *
     */

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        qAInfo.setLayout(new BoxLayout(qAInfo, BoxLayout.Y_AXIS));
        qAInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        UnloggedInState newState = (UnloggedInState) evt.getNewValue();
        if(newState.getIsChanged()){
            JLabel title= new JLabel(String.valueOf(newState.getProduct().getTitle()));
//            JLabel image = new JLabel(String.valueOf(newState.getProduct().getImage()));
            image.setIcon(new ImageIcon(newState.getProduct().getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
            JLabel des = new JLabel(String.valueOf(newState.getProduct().getDescription()));
            JLabel price = new JLabel(String.valueOf(newState.getProduct().getPrice()));
            JLabel rating = new JLabel(String.valueOf(newState.getProduct().getRating()));
            JLabel pro_state = new JLabel(String.valueOf(newState.getProduct().getState()));
            JLabel address = new JLabel(String.valueOf(newState.getProduct().getAddress()));
            JLabel lstTags = new JLabel(String.valueOf(newState.getProduct().getListTags()));
            JLabel proId = new JLabel(String.valueOf(newState.getProduct().getProductID()));
//            this.productInfo = new ProductInfoLabelTextPanel(title, image, des, price, rating, pro_state, address,lstTags, proId);

            System.out.println("this is the price::::::" + newState.getProduct().getPrice());
            nonLoggedInViewModel.setState(newState);

            qA_TextPanel.removeAll();

            _titleInfo.removeAll();
            imageInfo.removeAll();
            descriptionInfo.removeAll();
            ratingInfo.removeAll();
            priceInfo.removeAll();
            stateInfo.removeAll();
            addressInfo.removeAll();
            lstTagsInfo.removeAll();
            productIDInfo.removeAll();

            _titleInfo.setText(title);
            imageInfo.setText(image);
            descriptionInfo.setText(des);
            ratingInfo.setText(rating);
            priceInfo.setText(price);
            stateInfo.setText(pro_state);
            addressInfo.setText(address);
            lstTagsInfo.setText(lstTags);
            productIDInfo.setText(proId);

            //(2)show q_and_a
//            qAInfo = new JPanel();

//            final JLabel qA_title = new JLabel("Q&A:");

            ArrayList<Question> lst_question = newState.getQuestion();

//            final JPanel qA_TextPanel = new JPanel();
            for (Question question : lst_question) {

                String answer_content = question.getAnswer().getDescription();
                String question_content = question.getDescription();

                JLabel q = new JLabel(question_content);
                JLabel a = new JLabel(answer_content);

//                BuyerQAInfoLabelTextPanel panel = new BuyerQAInfoLabelTextPanel(q, a);
                singleQa = new BuyerQAInfoLabelTextPanel(q, a);
                qA_TextPanel.add(singleQa);
            }

            qA_TextPanel.repaint();
            qA_TextPanel.revalidate();
            productInfo.repaint();
            productInfo.revalidate();

            topBar.removeAll();
            topBar.add(new TopBarSampleView(nonLoggedInViewModel.getState().getUser(),
                    getSearchPageController, viewSignupPageController, viewLoginPageController,
                    shoppingCartController, logOutController, viewProfileController,
                    mainPageController));
            topBar.repaint();
            topBar.revalidate();

            newState.setIsChanged(false);
        }
    }
}