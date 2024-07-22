package view.view_product;

import entity.comment.*;
import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.profile.view_profile.ViewUserProfileController;
import interface_adapter.profile.view_profile.ViewUserProfileState;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.*;
import view.TopBarSampleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * The BuyerViewProductView class represents the view for the product detail page from a buyer's perspective.
 * This class handles the display of product information, Q&A, and allows actions such as adding a product to the cart
 * and publishing questions.
 * <p>
 * Controllers:
 * - AddToCartController: Transfers the user from the product view page to the shopping cart page.
 * - PublishQuestionController: Allows the user to publish their questions.
 * - MainPageController: Transfers the seller to the main page when the cancel button is clicked.
 * - GetSearchPageController, ViewSignupPageController, ViewLoginPageController, ShoppingCartController,
 *   LogOutController, ViewProfileController, ViewUserProfileController: Controllers for various user actions.
 * </p>
 */

public class BuyerViewProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "buyer_view_product view";

    private final BuyerViewProductViewModel buyerViewProductViewModel;

    final JTextField questionInputField = new JTextField(15);

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;
    private final ViewUserProfileController viewUserProfileController;


    private final JButton cancel;
    private final JButton addToCart;
    private final JButton publishQuestion;

    JPanel productInfo;
    JPanel qAInfo = new JPanel();
    private JPanel topBar;
    private JPanel qA_TextPanel = new JPanel();
    private final JPanel titlePanel = new JPanel();
    private BuyerQAInfoLabelTextPanel singleQa;
    private final JButton viewUserProfile;


    /**
     * Constructs a BuyerViewProductView with specific controllers and view model.
     *
     * @param buyerViewProductViewModel the view model containing state and operations for product viewing.
     * @param addToCartController the controller for adding a product to the shopping cart.
     * @param publishQuestionController the controller for publishing questions about the product.
     * @param mainPageController the controller for navigating back to the main page.
     * @param getSearchPageController the controller for accessing the search page.
     * @param viewSignupPageController the controller for the signup page view.
     * @param viewLoginPageController the controller for the login page view.
     * @param shoppingCartController the controller for managing the shopping cart.
     * @param logOutController the controller for handling the logout process.
     * @param viewProfileController the controller for viewing the user's profile.
     * @param viewUserProfileController the controller for viewing other user profiles.
     */
    public BuyerViewProductView(BuyerViewProductViewModel buyerViewProductViewModel,
                                AddToCartController addToCartController, PublishQuestionController publishQuestionController,

                                MainPageController mainPageController,
                                GetSearchPageController getSearchPageController,
                                ViewSignupPageController viewSignupPageController,
                                ViewLoginPageController viewLoginPageController,
                                ShoppingCartController shoppingCartController,
                                LogOutController logOutController,
                                ViewProfileController viewProfileController,
                                ViewUserProfileController viewUserProfileController){
        this.buyerViewProductViewModel = buyerViewProductViewModel;

        //top bar initialize
        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;
        this.viewUserProfileController = viewUserProfileController;

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);
        this.add(topBar);

        this.buyerViewProductViewModel.addPropertyChangeListener(this);


        productInfo = new JPanel();
        JLabel title = new JLabel(buyerViewProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);



        //(1)product_info
        Product wtv_product = buyerViewProductViewModel.getState().getProduct();
        productInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));

        final JLabel message = new JLabel("There is no product!");

        //(2)show q_and_a

        qAInfo.setLayout(new BoxLayout(qAInfo, BoxLayout.Y_AXIS));
        qAInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        final JLabel qA_title = new JLabel("Q&A:");

        ArrayList<Question> lst_question = buyerViewProductViewModel.getState().getQuestion();

        qA_TextPanel = new JPanel();
        for (Question question : lst_question) {

            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);

//            BuyerQAInfoLabelTextPanel panel = new BuyerQAInfoLabelTextPanel(q, a);
            singleQa = new BuyerQAInfoLabelTextPanel(q, a);
            qA_TextPanel.add(singleQa);
        }


        qA_TextPanel.setLayout(new BoxLayout(qA_TextPanel, BoxLayout.Y_AXIS));
        qAInfo.add(qA_title);
        qAInfo.add(new JScrollPane(qA_TextPanel));


        //(3)add_question
        JPanel addQuestionInfo = new JPanel();

        JLabel input_question_title = new JLabel(buyerViewProductViewModel.INPUT_QUESTION_TITLE);
        addQuestionInfo.add(input_question_title);

        addQuestionInfo.add(questionInputField);

        publishQuestion = new JButton(buyerViewProductViewModel.ADD_QUESTION);
        addQuestionInfo.add(publishQuestion);


        //(4)some_discrete_buttons
        JPanel buttons = new JPanel();
        cancel = new JButton(buyerViewProductViewModel.CANCEL_BUTTON_LABEL);
        addToCart = new JButton(buyerViewProductViewModel.ADD_TO_CART);

        buttons.add(cancel);
        buttons.add(addToCart);


        class AddTtoCartButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(addToCart)){
                    try {
                        addToCartController.execute(buyerViewProductViewModel.getState().getUser(),
                                buyerViewProductViewModel.getState().getProduct());
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
                                buyerViewProductViewModel.getState().getProduct().getSellerStudentNumber(),
                                buyerViewProductViewModel.getState().getUser());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        viewUserProfile = new JButton(buyerViewProductViewModel.VIEW_USER_PROFILE_BUTTON);
        viewUserProfile.addActionListener(new ViewUserProfileButtonListener());
        buttons.add(viewUserProfile);



//        class QuestionInputKeyListener implements KeyListener{
//            @Override
//            public void keyTyped(KeyEvent event){
//                BuyerViewProductState buyerViewProductState = buyerViewProductViewModel.getState();
//                String question_content = questionInputField.getText() + event.getKeyChar();
//
//
//            }
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//            @Override
//            public void keyReleased(KeyEvent e) {
//            }
//        }


        class QuestionPublishButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(publishQuestion)){
                    try{
                        Product que_product = buyerViewProductViewModel.getState().getProduct();

                        String question_content = questionInputField.getText();

                        CommonQuestionFactory questionFactory = new CommonQuestionFactory();
                        CommonAnswerFactory answerFactory = new CommonAnswerFactory();

                        UUID uuid = UUID.randomUUID();

                        Answer empty_ans = answerFactory.createAnswer("", "");
                        Question new_question = questionFactory.createQuestion(question_content,
                                buyerViewProductViewModel.getState().getProduct().getSellerStudentNumber(), empty_ans, uuid.toString());

                        System.out.println("this is the initial uuid:::::::::::tosting version:" + uuid.toString());
                        System.out.println("this is the initial uuid:::::::::::tosting version:" + uuid);
                        publishQuestionController.execute(new_question, que_product, buyerViewProductViewModel.getState().getUser());

                        buyerViewProductViewModel.getState().setPrompt_words("");
                        questionInputField.setText("");
                    }catch (SQLException e){
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
                        BuyerViewProductState state = buyerViewProductViewModel.getState();
                        User user = state.getUser();
                        mainPageController.execute(user);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }


        addToCart.addActionListener(new AddTtoCartButtonListener());
        publishQuestion.addActionListener(new QuestionPublishButtonListener());
        cancel.addActionListener(new CancelButtonListener());

        // needs adjustments x,y axis?????
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(Objects.requireNonNullElse(productInfo, message));
        this.add(qAInfo);
        this.add(addQuestionInfo);
        this.add(buttons);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Pop out the prompt window when detect state changes in ReplyQuestionPresenter to tell the user that their action
     * is successfully performed.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.

     * Pop up the prompt window when a state change is detected in ReplyQuestionPresenter to notify the user that their action
     * is successfully performed.
     *
     */

    @Override
    public void propertyChange(PropertyChangeEvent evt){

        BuyerViewProductState newState = (BuyerViewProductState) evt.getNewValue();
        System.out.println("buyer view product PropertyChangeEvent" + newState.getUser().getName());
        if (!Objects.equals(newState.getPrompt_words(), "")){
            JOptionPane.showMessageDialog(this, newState.getPrompt_words());
        }

        productInfo.removeAll();
        qAInfo.removeAll();
        qA_TextPanel.removeAll();

        productInfo.add(titlePanel);

        Product wtv_product = newState.getProduct();

        final JLabel image = new JLabel();//image???
        image.setIcon(new ImageIcon(wtv_product.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        final JLabel description = new JLabel(wtv_product.getDescription());
        final JLabel price = new JLabel(String.valueOf(wtv_product.getPrice()));
        final JLabel _title = new JLabel(wtv_product.getTitle());
        final JLabel rating = new JLabel(String.valueOf(wtv_product.getRating()));
        final JLabel state = new JLabel(String.valueOf(wtv_product.getState()));
        final JLabel address = new JLabel(wtv_product.getAddress());
        final JLabel lstTags = new JLabel(String.valueOf(wtv_product.getListTags()));//what will valueOf list look like???
        final JLabel productID = new JLabel(wtv_product.getProductID());

//            productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));
////            productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
////                    lstTags, productID);
        productInfo.add(_title);
        productInfo.add(productID);
        productInfo.add(description);
        productInfo.add(price);
        productInfo.add(rating);
        productInfo.add(state);
        productInfo.add(address);
        productInfo.add(lstTags);
        productInfo.add(image);

        ArrayList<Question> lst_question = newState.getQuestion();


        for (Question question : lst_question) {
            System.out.println(question.getDescription());
            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);

            singleQa = new BuyerQAInfoLabelTextPanel(q, a);

            qA_TextPanel.add(singleQa);
//            singleQa.removeAll();
        }

        qA_TextPanel.repaint();
        qA_TextPanel.revalidate();

        JLabel qA_title = new JLabel("Q&A: ");

        qAInfo.add(qA_title);
        qAInfo.add(new JScrollPane(qA_TextPanel));


        qAInfo.repaint();
        qAInfo.revalidate();

        productInfo.repaint();
        productInfo.revalidate();

        topBar.removeAll();
        topBar.add(new TopBarSampleView(buyerViewProductViewModel.getState().getUser(),
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController,
                mainPageController));
        topBar.repaint();
        topBar.revalidate();
        newState.setIsChanged(false);
    }
}
