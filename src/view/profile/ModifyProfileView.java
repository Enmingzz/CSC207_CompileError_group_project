package view.profile;

import interface_adapter.main_page.MainPageController;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.modify_profile.ModifyProfileViewModel;
import interface_adapter.search_product.SearchProductByNameController;
import interface_adapter.shopping_cart.ShoppingCartController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ModifyProfileView extends JPanel implements ActionListener, PropertyChangeListener {

    private final ModifyProfileViewModel modifyProfileViewModel = new ModifyProfileViewModel();
    private final ModifyProfileController modifyProfileController;
    private final MainPageController mainPageController;
    private final ShoppingCartController shoppingCartController;
    private final SearchProductByNameController searchProductByNameController;


    public final String viewName = "Modify Profile";

    public ModifyProfileView(ModifyProfileController modifyProfileController, MainPageController mainPageController, ShoppingCartController shoppingCartController, SearchProductByNameController searchProductByNameController) {
        this.modifyProfileController = modifyProfileController;
        this.mainPageController = mainPageController;
        this.shoppingCartController = shoppingCartController;
        this.searchProductByNameController = searchProductByNameController;



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
