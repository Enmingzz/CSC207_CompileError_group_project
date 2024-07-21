package interface_adapter.profile.view_profile;

import entity.product.Product;
import entity.user.User;
import entity.user.UserFactory;
import java.util.ArrayList;


public class ViewUserProfileState {

    private User sellerUser;
    private User buyerUser;
    private ArrayList<Product> listProduct = new ArrayList<>();

    public ViewUserProfileState(UserFactory commonUserFactory) {
        this.sellerUser = commonUserFactory.createUser("", "", "", 0, "");
        this.buyerUser = commonUserFactory.createUser("", "", "", 0, "");
    }

    public ViewUserProfileState(User user) {
        this.buyerUser = user;
    }

    public User getSellerUser() {
        return sellerUser;
    }

    public void setSellerUser(User sellerUser) {
        this.sellerUser = sellerUser;
    }

    public User getBuyerUser() {
        return buyerUser;
    }

    public void setBuyerUser(User buyerUser) {
        this.buyerUser = buyerUser;
    }

    public ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }
}
