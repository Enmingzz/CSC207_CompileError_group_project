package view.profile;

import entity.product.Product;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.CreateProductController;
import interface_adapter.modify_product.DeleteProductController;
import interface_adapter.modify_product.ModifyProductController;
import interface_adapter.profile.manage_product.ManageProductController;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.profile.modify_profile.ModifyProfileController;
import interface_adapter.profile.view_profile.ViewProfileViewModel;
import view.profile.ProfileListener.ModifyProfileListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ManageProductView extends JFrame implements ActionListener, PropertyChangeListener {
    public final String viewName = "manage modify_product";
    private final MainPageController mainPageController;
    private final CreateProductController createProductController;
    private final DeleteProductController deleteProductController;
    private final ModifyProductController modifyProductController;
    private final ManageProductViewModel manageProductViewModel;
    private final JPanel mainPanel = new JPanel();

    private final JButton deleteProduct;
    private final JButton addProduct;

    public ManageProductView(MainPageController mainPageController, CreateProductController createProductController, DeleteProductController deleteProductController, ModifyProductController modifyProductController, ManageProductViewModel manageProductViewModel){
        this.mainPageController = mainPageController;
        this.createProductController = createProductController;
        this.deleteProductController = deleteProductController;
        this.modifyProductController = modifyProductController;
        this.manageProductViewModel = manageProductViewModel;
        manageProductViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(manageProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        this.add(new JScrollPane(mainPanel), BorderLayout.CENTER);
        this.setVisible(true);

        JPanel buttons = new JPanel((new FlowLayout(FlowLayout.RIGHT)));
        deleteProduct = new JButton(manageProductViewModel.DELETE_BUTTON_LABEL);
        buttons.add(deleteProduct);
        addProduct = new JButton(manageProductViewModel.ADD_BUTTON_LABEL);
        buttons.add(addProduct);

        deleteProduct.addActionListener(this);
        addProduct.addActionListener(this);

        this.add(buttons, BorderLayout.NORTH);
    }

    public void updateMainPanel(){
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
