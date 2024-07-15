package view.profile;

import entity.product.Product;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.*;
import interface_adapter.profile.manage_product.ManageProductViewModel;
import interface_adapter.view_product.ViewProductController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.sql.SQLException;

public class ManageProductView extends JFrame implements ActionListener, PropertyChangeListener {
    public final String viewName = "Product View";
    private final MainPageController mainPageController;
    private final ViewCreateProductController viewCreateProductController;
    private final ViewModifyProductController viewModifyProductController;
    private final ViewProductController viewProductController;
    private final DeleteProductController deleteProductController;
    private final ManageProductViewModel manageProductViewModel;
    private final JPanel mainPanel = new JPanel();

    private final JButton addProduct;

    public ManageProductView(MainPageController mainPageController, ViewCreateProductController viewCreateProductController,
                             DeleteProductController deleteProductController, ViewModifyProductController viewModifyProductController,
                             ManageProductViewModel manageProductViewModel, ViewProductController viewProductController){
        this.mainPageController = mainPageController;
        this.viewCreateProductController = viewCreateProductController;
        this.viewProductController = viewProductController;
        this.deleteProductController = deleteProductController;
        this.viewModifyProductController = viewModifyProductController;
        this.manageProductViewModel = manageProductViewModel;

        manageProductViewModel.addPropertyChangeListener(this);
        JLabel title = new JLabel(manageProductViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        updateMainPanel();

        this.add(new JScrollPane(mainPanel), BorderLayout.CENTER);

        JPanel buttons = new JPanel((new FlowLayout(FlowLayout.RIGHT)));
        addProduct = new JButton(manageProductViewModel.ADD_BUTTON_LABEL);
        buttons.add(addProduct);

        addProduct.addActionListener(this);

        this.add(buttons, BorderLayout.NORTH);

    }

    public void updateMainPanel(){
        mainPanel.removeAll();

        for (Product product: manageProductViewModel.getState().getProduct()) {
            MangeSingleProductView panel = new MangeSingleProductView(manageProductViewModel.getState().getUser(),
                    product, manageProductViewModel, viewProductController,
                    viewModifyProductController, deleteProductController);
            mainPanel.add(panel);
            mainPanel.add(Box.createVerticalStrut(10));
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            viewCreateProductController.execute(manageProductViewModel.getState().getUser());
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
        updateMainPanel();

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
