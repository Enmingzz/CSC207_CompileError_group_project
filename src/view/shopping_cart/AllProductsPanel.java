package view.shopping_cart;

import entity.product.Product;
import entity.user.User;
import interface_adapter.rating.GetRatePageController;
import interface_adapter.schedule.GetBuyerSchedulePageController;
import interface_adapter.shopping_cart.ConfirmController;
import interface_adapter.shopping_cart.DeleteShoppingCartProductController;
import interface_adapter.shopping_cart.PurchaseController;
import interface_adapter.shopping_cart.ShoppingCartViewModel;
import interface_adapter.view_product.ViewProductController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AllProductsPanel extends JPanel{
    AllProductsPanel(ArrayList<Product> listProducts,
                     ShoppingCartViewModel shoppingCartViewModel,
                     ViewProductController viewProductController,
                     PurchaseController purchaseController,
                     DeleteShoppingCartProductController deleteShoppingCartProductController,
                     GetBuyerSchedulePageController getBuyerSelectSchedulePageController,
                     ConfirmController confirmController,
                     GetRatePageController getRatePageController
                     ){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        for (Product product : listProducts) {

            JButton viewButton = new JButton(product.getTitle());
            // dimension set as this for now but will likely get changed later
            viewButton.setPreferredSize(new Dimension(250, 50));
            viewButton.addActionListener(
                    new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                            if (event.getSource().equals(viewButton)) {
                                User user = shoppingCartViewModel.getState().getUser();
                                try {
                                    viewProductController.execute(product, user) ;
                                } catch (SQLException e) {
                                    throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                }

                            }
                        }
                    }
            );

            String priceAsString = String.valueOf(product.getPrice());

            JLabel priceLabel = new JLabel("$" + priceAsString);

            if (product.getState() == 0) {
                JButton checkoutButton = new JButton(shoppingCartViewModel.CHECKOUT_BUTTON_LABEL);
                // dimension set as this for now but will likely get changed later
                checkoutButton.setPreferredSize(new Dimension(100, 50));
                checkoutButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                if (event.getSource().equals(checkoutButton)) {
                                    User user = shoppingCartViewModel.getState().getUser();
                                    try {
                                        purchaseController.execute(user, product) ;
                                    } catch (SQLException | IOException e) {
                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                    }

                                }
                            }
                        }
                );

                JButton deleteButton = new JButton(shoppingCartViewModel.DELETE_BUTTON_LABEL);
                // dimension set as this for now but will likely get changed later
                deleteButton.setPreferredSize(new Dimension(100, 50));
                deleteButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                if (event.getSource().equals(deleteButton)) {
                                    User user = shoppingCartViewModel.getState().getUser();
                                    try {
                                        deleteShoppingCartProductController.execute(user, product) ;
                                    } catch (SQLException | IOException e) {
                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                    }

                                }
                            }
                        }
                );

                ShoppingCartSellingPanel productSellingPanel = new ShoppingCartSellingPanel(
                        viewButton, priceLabel, checkoutButton, deleteButton
                );
                this.add(productSellingPanel);

            }
            else if (product.getState() == 1) {
                JLabel pendingScheduleLabel = new JLabel(shoppingCartViewModel.PENDING_SELLER_SCHEDULE_LABEL);
                ShoppingCartSellerSelectPanel sellerSelectPanel = new ShoppingCartSellerSelectPanel(
                        viewButton, priceLabel, pendingScheduleLabel
                );
                this.add(sellerSelectPanel);

            }

            else if (product.getState() == 2) {
                JButton scheduleButton = new JButton(shoppingCartViewModel.BUYER_SCHEDULES_BUTTON_LABEL);
                // dimension set as this for now but will likely get changed later
                scheduleButton.setPreferredSize(new Dimension(200, 50));
                scheduleButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                if (event.getSource().equals(scheduleButton)) {
                                    User user = shoppingCartViewModel.getState().getUser();
                                    try {
                                        getBuyerSelectSchedulePageController.execute(user, product);
                                    } catch (SQLException | IOException e) {
                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                    }

                                }
                            }
                        }
                );

                ShoppingCartBuyerSelectPanel buyerSelectPanel = new ShoppingCartBuyerSelectPanel(
                        viewButton, priceLabel, scheduleButton
                );
                this.add(buyerSelectPanel);

            }

            else if (product.getState() == 3) {
                JButton confirmButton = new JButton(shoppingCartViewModel.RECEIVED_PRODUCT_BUTTON_LABEL);
                // dimension set as this for now but will likely get changed later
                confirmButton.setPreferredSize(new Dimension(200, 50));
                confirmButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                if (event.getSource().equals(confirmButton)) {
                                    User user = shoppingCartViewModel.getState().getUser();

                                    try {
                                        confirmController.execute(user, product);
                                    } catch (Exception e) {
                                        throw new RuntimeException(e); //Revisit this in case of bug in viewing a product
                                    }

                                }
                            }
                        }
                );

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy, HH:mm");
                String formattedDateTime = product.getSchedule().getBuyerTime().format(formatter);
                JLabel scheduleLabel = new JLabel("scheduled meeting time: " + formattedDateTime);


                ShoppingCartConfirmationPanel confirmationPanel = new ShoppingCartConfirmationPanel(
                        viewButton, priceLabel, scheduleLabel, confirmButton
                );
                this.add(confirmationPanel);
            }

            else if (product.getState() == 4) {

                JButton ratingButton = new JButton(shoppingCartViewModel.RATE_PRODUCT_BUTTON_LABEL);
                // dimension set as this for now but will likely get changed later
                ratingButton.setPreferredSize(new Dimension(200, 50));
                ratingButton.addActionListener(
                        new ActionListener() {
                            public void actionPerformed(ActionEvent event) {
                                if (event.getSource().equals(ratingButton)) {
                                    User user = shoppingCartViewModel.getState().getUser();
                                    getRatePageController.execute(user, product);

                                }
                            }
                        }
                );

                ShoppingCartRatingPanel ratingPanel = new ShoppingCartRatingPanel(
                        viewButton, priceLabel, ratingButton
                );
                this.add(ratingPanel);
            }

        }

        String totalPriceAsString = String.valueOf(shoppingCartViewModel.getState().getTotalPrice());

        JLabel totalPriceLabel = new JLabel("$" + totalPriceAsString);

        TotalPricePanel totalPricePanel = new TotalPricePanel(
                totalPriceLabel
        );

        this.add(totalPricePanel);
    }
}
