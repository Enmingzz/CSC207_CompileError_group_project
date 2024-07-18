package view.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.User;
import interface_adapter.login.ViewLoginPageController;
import interface_adapter.logout.LogOutController;
import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.view_profile.ViewProfileController;
import interface_adapter.search_product.GetSearchPageController;
import interface_adapter.shopping_cart.ShoppingCartController;
import interface_adapter.signup.ViewSignupPageController;
import interface_adapter.view_product.*;
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
 * The SellerViewProductView class for the product view pages.
 * Two controller:
 *      ReplyQuestionController which is used to transfer the seller to the reply page when they click reply button.
 *      MainPageController is used to transfer the seller to the main page when they click cancel button.
 *
 */

public class SellerViewProductView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "seller_view_product view";

    //Top Bar stuff
    private final GetSearchPageController getSearchPageController;
    private final ViewSignupPageController viewSignupPageController;
    private final ViewLoginPageController viewLoginPageController;
    private final ShoppingCartController shoppingCartController;
    private final LogOutController logOutController;
    private final ViewProfileController viewProfileController;
    private final MainPageController mainPageController;

    private final JButton cancel;

    ProductInfoLabelTextPanel productInfo;
    JPanel qAInfo;

    /**
     * Constructor for the SellerViewProductView class.
     *
     * @param sellerViewProductViewModel the view model for the seller view product
     * @param replyQuestionController the controller for replying to questions
     * @param mainPageController the controller for navigating to the main page
     * @param getSearchPageController the controller for searching products
     * @param viewSignupPageController the controller for navigating to the signup page
     * @param viewLoginPageController the controller for navigating to the login page
     * @param shoppingCartController the controller for managing the shopping cart
     * @param logOutController the controller for logging out
     * @param viewProfileController the controller for viewing the profile page
     */
    public SellerViewProductView(SellerViewProductViewModel sellerViewProductViewModel,
                                ViewReplyQuestionController replyQuestionController,
                                MainPageController mainPageController,
                                 GetSearchPageController getSearchPageController,
                                 ViewSignupPageController viewSignupPageController,
                                 ViewLoginPageController viewLoginPageController,
                                 ShoppingCartController shoppingCartController,
                                 LogOutController logOutController,
                                 ViewProfileController viewProfileController){

        this.getSearchPageController = getSearchPageController;
        this.viewSignupPageController  = viewSignupPageController;
        this.viewLoginPageController = viewLoginPageController;
        this.shoppingCartController = shoppingCartController;
        this.logOutController = logOutController;
        this.viewProfileController = viewProfileController;
        this.mainPageController = mainPageController;

        sellerViewProductViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabel(sellerViewProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //(1)product_info
        Product wtv_product = sellerViewProductViewModel.getState().getProduct();
        final JLabel image = new JLabel(String.valueOf(wtv_product.getImage()));//image???
        final JLabel description = new JLabel(wtv_product.getDescription());
        final JLabel price = new JLabel(String.valueOf(wtv_product.getPrice()));
        final JLabel _title = new JLabel(wtv_product.getTitle());
        final JLabel rating = new JLabel(String.valueOf(wtv_product.getRating()));
        final JLabel state = new JLabel(String.valueOf(wtv_product.getState()));
        final JLabel address = new JLabel(wtv_product.getAddress());
        final JLabel lstTags = new JLabel(String.valueOf(wtv_product.getListTags()));//what will valueOf list look like???
        final JLabel productID = new JLabel(wtv_product.getProductID());

        ProductInfoLabelTextPanel productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
                lstTags, productID);


        //(2)show q_and_a
        final JPanel qAInfo = new JPanel();

        final JLabel qA_title = new JLabel("Q&A:");

        ArrayList<Question> lst_question = sellerViewProductViewModel.getState().getQuestion();
        final JPanel qA_TextPanel = new JPanel();
        for (Question question : lst_question) {

            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);
            JButton replyButton = new JButton("Reply");

            SellerQAInfoLabelTextPanel panel = new SellerQAInfoLabelTextPanel(q, a, replyButton);
            qA_TextPanel.add(panel);

            class ReplyButtonListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == replyButton) {
                        try{
                            SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();
                            Product product = sellerViewProductState.getProduct();
                            replyQuestionController.execute(product, sellerViewProductState.getUser(), question);
                        }catch (Exception ex){
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }

            replyButton.addActionListener(new ReplyButtonListener());
        }

        qAInfo.add(qA_title);
        qAInfo.add(qA_TextPanel);


        //(3)some_discrete_buttons
        cancel = new JButton(sellerViewProductViewModel.CANCEL_BUTTON_LABEL);


        class CancelButtonListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt) {
                if(evt.getSource().equals(cancel)){
                    try{
                        SellerViewProductState state = sellerViewProductViewModel.getState();
                        User user = state.getUser();
                        mainPageController.execute(user);
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                }
            }
        }


        cancel.addActionListener(new CancelButtonListener());

        // needs adjustments x,y axis?????
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(productInfo);
        this.add(qAInfo);
        this.add(cancel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Pop out the prompt window when detect state changes in ReplyQuestionPresenter to tell the user that their action
     * is successfully performed.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        SellerViewProductState newState = (SellerViewProductState) evt.getNewValue();
        if (!Objects.equals(newState.getPromptStr(), "")){
            JOptionPane.showMessageDialog(this, newState.getPromptStr());
        }else if(newState.getIsChanged()){

            Product wtv_product = newState.getProduct();

            final JLabel image = new JLabel(String.valueOf(wtv_product.getImage()));//image???
            final JLabel description = new JLabel(wtv_product.getDescription());
            final JLabel price = new JLabel(String.valueOf(wtv_product.getPrice()));
            final JLabel _title = new JLabel(wtv_product.getTitle());
            final JLabel rating = new JLabel(String.valueOf(wtv_product.getRating()));
            final JLabel state = new JLabel(String.valueOf(wtv_product.getState()));
            final JLabel address = new JLabel(wtv_product.getAddress());
            final JLabel lstTags = new JLabel(String.valueOf(wtv_product.getListTags()));//what will valueOf list look like???
            final JLabel productID = new JLabel(wtv_product.getProductID());

            productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
                    lstTags, productID);

            qAInfo = new JPanel();

            final JLabel qA_title = new JLabel("Q&A:");

            ArrayList<Question> lst_question = newState.getQuestion();

            final JPanel qA_TextPanel = new JPanel();

            for (Question question : lst_question) {

                String answer_content = question.getAnswer().getDescription();
                String question_content = question.getDescription();

                JLabel q = new JLabel(question_content);
                JLabel a = new JLabel(answer_content);
                JButton replyButton = new JButton("Reply");

                SellerQAInfoLabelTextPanel panel = new SellerQAInfoLabelTextPanel(q, a, replyButton);
                qA_TextPanel.add(panel);

                qAInfo.add(qA_title);
                qAInfo.add(qA_TextPanel);
            }

            JPanel topBar = new TopBarSampleView(newState.getUser(),
                    getSearchPageController, viewSignupPageController, viewLoginPageController, shoppingCartController, logOutController, viewProfileController, mainPageController);
            this.add(topBar);

            newState.setIsChanged(false);
        }
    }
}
