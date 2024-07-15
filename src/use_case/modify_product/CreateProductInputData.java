package use_case.modify_product;

import entity.product.CommonProduct;
import entity.product.Product;
import entity.user.User;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CreateProductInputData {
    private final User user;
    private final Image image;
    private final String description;
    private final String price;
    private final String title;
    private final String eTransferEmail;
    private final String address;
    private final ArrayList<String> listTags;

    public CreateProductInputData(User user, Image image, String description, String price, String title, String
            eTransferEmail, String address, ArrayList<String> listTags) {
        this.image = image;
        this.description = description;
        this.user = user;
        this.price = price;
        this.title = title;
        this.eTransferEmail = eTransferEmail;
        this.address = address;
        this.listTags = listTags;
    }

    public User getUser() {
        return user;
    }

    public Image getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String geteTransferEmail() {
        return eTransferEmail;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getListTags() {
        return listTags;
    }

    public String getDescription() {
        return description;
    }
}

//How do I implement this though?
//I can leave everything to the View Page, where only if all the correct information is filled, will the button be pressable?