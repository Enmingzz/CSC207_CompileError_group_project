package view.view_product;

import entity.comment.Question;
import entity.product.Product;
import entity.user.CommonUserFactory;
import entity.user.User;
import entity.user.UserFactory;
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
    private final ViewReplyQuestionController viewReplyQuestionController;

    private final SellerViewProductViewModel sellerViewProductViewModel;

    private final JButton cancel;
//    JButton replyButton = new JButton("Reply");

    private JPanel topBar;

//    private ProductInfoLabelTextPanel productInfo;
    private JPanel productInfo = new JPanel();
    private JPanel qAInfo = new JPanel();
    private JPanel qA_TextPanel = new JPanel();
    SellerQAInfoLabelTextPanel singleQa;
    private final JPanel titlePanel = new JPanel();

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
     * Constructor for the SellerViewProductView class.
     *
     * @param sellerViewProductViewModel the view model for the seller view product
     * @param viewReplyQuestionController the controller for replying to questions
     * @param mainPageController the controller for navigating to the main page
     * @param getSearchPageController the controller for searching products
     * @param viewSignupPageController the controller for navigating to the signup page
     * @param viewLoginPageController the controller for navigating to the login page
     * @param shoppingCartController the controller for managing the shopping cart
     * @param logOutController the controller for logging out
     * @param viewProfileController the controller for viewing the profile page
     */
    public SellerViewProductView(SellerViewProductViewModel sellerViewProductViewModel,
                                 ViewReplyQuestionController viewReplyQuestionController,
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
        this.sellerViewProductViewModel = sellerViewProductViewModel;
        this.viewReplyQuestionController = viewReplyQuestionController;

        UserFactory commonUserFactory = new CommonUserFactory();
        User commonUser = commonUserFactory.createUser("", "", "", 0, "");
        topBar = new TopBarSampleView(commonUser,
                getSearchPageController, viewSignupPageController, viewLoginPageController,
                shoppingCartController, logOutController, viewProfileController, mainPageController);


        sellerViewProductViewModel.addPropertyChangeListener(this);


        JLabel title = new JLabel(sellerViewProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //(1)product_info
        Product wtv_product = sellerViewProductViewModel.getState().getProduct();

        final JLabel image = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getImage()));//image???
        final JLabel description = (wtv_product == null)? new JLabel(): new JLabel(wtv_product.getDescription());
        final JLabel price = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getPrice()));
        final JLabel _title = (wtv_product == null)? new JLabel(): new JLabel(wtv_product.getTitle());
        final JLabel rating = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getRating()));
        final JLabel state = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getState()));
        final JLabel address = (wtv_product == null)? new JLabel(): new JLabel(wtv_product.getAddress());
        final JLabel lstTags = (wtv_product == null)? new JLabel(): new JLabel(String.valueOf(wtv_product.getListTags()));//what will valueOf list look like???
        final JLabel productID = (wtv_product == null)? new JLabel(): new JLabel(wtv_product.getProductID());

//        productInfo = new ProductInfoLabelTextPanel(_title, image, description, price, rating, state, address,
//                lstTags, productID);

        imageInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.IMAGE_LABEL), image);
        descriptionInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.DESCRIPTION_LABEL), description);
        priceInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.PRICE_LABEL), price);
        _titleInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.PRODUCTTITLE_LABEL), _title);
        ratingInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.RATING_LABEL), rating);
        stateInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.STATE_LABEL), state);
        addressInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.ADDRESS_LABEL), address);
        lstTagsInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.LISTTAGS_LABEL), lstTags);
        productIDInfo = new ProductInfoLabelTextPanel(new JLabel(sellerViewProductViewModel.PRODUCTID_LABEL), productID);

        productInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        titlePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        titlePanel.add(title);

        productInfo.setLayout(new BoxLayout(productInfo, BoxLayout.Y_AXIS));
        productInfo.add(titlePanel);
        productInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        productInfo.add(_titleInfo);
        productInfo.add(productIDInfo);
        productInfo.add(descriptionInfo);
        productInfo.add(priceInfo);
        productInfo.add(ratingInfo);
        productInfo.add(stateInfo);
        productInfo.add(addressInfo);
        productInfo.add(lstTagsInfo);
        productInfo.add(imageInfo);

        //(2)show q_and_a
        qAInfo.setLayout(new BoxLayout(qAInfo, BoxLayout.Y_AXIS));
        qAInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        final JLabel qA_title = new JLabel("Q&A:");

        ArrayList<Question> lst_question = sellerViewProductViewModel.getState().getQuestion();

        for (Question question : lst_question) {

            JButton replyButton = new JButton("Reply");
            String answer_content = question.getAnswer().getDescription();
            String question_content = question.getDescription();

            JLabel q = new JLabel(question_content);
            JLabel a = new JLabel(answer_content);

            singleQa = new SellerQAInfoLabelTextPanel(q, a, replyButton);
            qA_TextPanel.add(singleQa);

            class ReplyButtonListener implements ActionListener {
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == replyButton) {
                        try{
                            SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();
                            Product product = sellerViewProductState.getProduct();
                            viewReplyQuestionController.execute(product, sellerViewProductState.getUser(), question);
                        }catch (Exception ex){
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }

            replyButton.addActionListener(new ReplyButtonListener());
        }

        qAInfo.add(qA_title);
        qAInfo.add((new JScrollPane(qA_TextPanel)));


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
//        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setLayout(new BorderLayout(1, 1));
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout());
        centerPanel.add(productInfo);
        centerPanel.add(qAInfo);
        this.add(topBar, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(cancel, BorderLayout.SOUTH);
        this.add(new JPanel(), BorderLayout.EAST);
        this.add(new JPanel(), BorderLayout.WEST);

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
            sellerViewProductViewModel.getState().setPromptStr("");
        }else if(newState.getIsChanged()){
            sellerViewProductViewModel.setState(newState);

            qA_TextPanel.removeAll();

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

            _titleInfo.removeAll();
            imageInfo.removeAll();
            descriptionInfo.removeAll();
            ratingInfo.removeAll();
            priceInfo.removeAll();
            stateInfo.removeAll();
            addressInfo.removeAll();
            lstTagsInfo.removeAll();
            productIDInfo.removeAll();

            imageInfo.setText(image);
            descriptionInfo.setText(description);
            priceInfo.setText(price);
            _titleInfo.setText(_title);
            ratingInfo.setText(rating);
            stateInfo.setText(state);
            addressInfo.setText(address);
            lstTagsInfo.setText(lstTags);
            productIDInfo.setText(productID);

            ArrayList<Question> lst_question = newState.getQuestion();

            for (Question question : lst_question) {
                JButton replyButton = new JButton("Reply");
                String answer_content = question.getAnswer().getDescription();
                String question_content = question.getDescription();

                JLabel q = new JLabel(question_content);
                JLabel a = new JLabel(answer_content);

                singleQa = new SellerQAInfoLabelTextPanel(q, a, replyButton);

                class ReplyButtonListener implements ActionListener {
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() == replyButton) {
                            try{
                                SellerViewProductState sellerViewProductState = sellerViewProductViewModel.getState();
                                Product product = sellerViewProductState.getProduct();
                                System.out.println("question_des in button listener, delivered by replyquestioncontroller" + question.getDescription());
                                viewReplyQuestionController.execute(product, sellerViewProductState.getUser(), question);
                            }catch (Exception ex){
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
                replyButton.addActionListener(new ReplyButtonListener());

                qA_TextPanel.add(singleQa);
            }

            qA_TextPanel.repaint();
            qA_TextPanel.revalidate();
            productInfo.repaint();
            productInfo.revalidate();

            topBar.removeAll();
            topBar.add(new TopBarSampleView(sellerViewProductViewModel.getState().getUser(),
                    getSearchPageController, viewSignupPageController, viewLoginPageController,
                    shoppingCartController, logOutController, viewProfileController,
                    mainPageController));
            topBar.repaint();
            topBar.revalidate();

            newState.setIsChanged(false);
        }
    }
}
