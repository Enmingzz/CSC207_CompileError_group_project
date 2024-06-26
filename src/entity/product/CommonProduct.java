package entity.product;

import entity.schedule.CommonSchedule;
import entity.schedule.Schedule;

import java.awt.*;
import java.util.ArrayList;

/**
 * One of core entities. Override all getter method in the interface Product.
 * Has some important attributes; ArrayList<Question> questions and CommonUser Buyer, Seller.
 * @author CompileError group
 */

public class CommonProduct implements Product{
    private Image image;
    private String description;
    private float price;
    private String title;
    private int state;
    private Integer rating;
    private String eTransferEmail;
    private String sellerStudentNumber;
    private String address;
    private CommonSchedule schedule = null;
    private ArrayList<String> listTags;
    private String productID;

    public CommonProduct(Image image, String description, String title, float price, Integer rating, int state, String eTransferEmail, String sellerStudentNumber, String address, ArrayList<String> listTags, String productID) {
        this.image = image;
        this.description = description;
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.state = state;
        this.eTransferEmail = eTransferEmail;
        this.sellerStudentNumber = sellerStudentNumber;
        this.address = address;
        this.listTags = listTags;
        this.productID = productID;

    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Integer getRating() {
        return rating;
    }

    @Override
    public int getState() {
        return state;
    }

    @Override
    public String geteTransferEmail() {
        return eTransferEmail;
    }

    @Override
    public String getSellerStudentNumber() {
        return sellerStudentNumber;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public ArrayList<String> getListTags() {
        return listTags;
    }

    public String getProductID() {
        return productID;
    }

    public Schedule getSchedule() {
        return schedule;
    }
}
