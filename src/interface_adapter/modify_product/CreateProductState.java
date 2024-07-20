package interface_adapter.modify_product;

import entity.user.User;

import java.awt.*;
import java.util.ArrayList;

public class CreateProductState {
    private Image image = null;
    private String description = "";
    private String price = "";
    private String title = "";
    private String eTransferEmail = "";
    private String address = "";
    private ArrayList<String> listTags = new ArrayList<String>();

    private String createProductError = null;

    private String path;

    private User user;

    public CreateProductState(CreateProductState copy) {
        image = copy.image;
        description = copy.description;
        price = copy.price;
        title = copy.title;
        eTransferEmail = copy.eTransferEmail;
        address = copy.address;
        listTags = copy.listTags;
        createProductError = copy.createProductError;

        user = copy.user;
    }

    //A default constructor where the fields can be set later
//    public CreateProductState(User user){
//        this.user = user;
//    }
    public CreateProductState(){}

    public Image getImage() {
        return image;
    }
    public String getDescription() {
        return description;
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
    public User getUser() {return user;}
    public String getPath() {
        return path;
    }
    public String getCreateProductError() {return createProductError;}


    public void setImage(Image image) {
        this.image = image;
    }
    public void setDescription(String des) {
        description = des;
    }
    public void setPrice(String pri) {
        price = pri;
    }
    public void setTitle(String titl) {
        title = titl;
    }
    public void seteTransferEmail(String email) {
        eTransferEmail = email;
    }
    public void setAddress(String add) {
        address = add;
    }
    public void setListTags(ArrayList<String> tags) {
        listTags = tags;
    }
    public void setUser(User user){this.user = user;}
    public void setPath(String path){this.path = path;}
    public void setCreateProductError(String err) {this.createProductError = err;}

}
