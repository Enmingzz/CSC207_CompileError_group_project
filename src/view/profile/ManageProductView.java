package view.profile;

import entity.product.Product;
import interface_adapter.main_page.MainPageController;
import interface_adapter.modify_product.CreateProductController;
import interface_adapter.modify_product.DeleteProductController;
import interface_adapter.modify_product.ModifyProductController;
import interface_adapter.profile.manage_product.ManageProductViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ManageProductView extends JFrame implements ActionListener, PropertyChangeListener {
    public final String viewName = "Mange Your Product";
    private final MainPageController mainPageController;
    private final CreateProductController createProductController;
    private final DeleteProductController deleteProductController;
    private final ModifyProductController modifyProductController;
    private final ManageProductViewModel manageProductViewModel;
    private final JPanel mainPanel = new JPanel();

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
            MangeSingleProductView panel = new MangeSingleProductView(product, manageProductViewModel,
                    modifyProductController, deleteProductController);
            mainPanel.add(panel);
            mainPanel.add(Box.createVerticalStrut(10));
        }

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //        try {
//            modifyProductController.execute(product);
//        } catch (SQLException | IOException ex) {
//            throw new RuntimeException(ex);
//        }
        System.out.println("createProductController.execute()");
        updateMainPanel();

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
