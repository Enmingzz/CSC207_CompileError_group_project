package entity;

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
    private boolean isPending;
    private Integer rating;
    private String eTransferEmail;
    private CommonUser buyer;
    private CommonUser seller;
    private String address;
    private CommonSchedule schedule;
    private ArrayList<Question> questions;
    private ArrayList<String> listTags;

    public CommonProduct(Image image, String description, String title, float price, Integer rating, boolean isPending, String eTransferEmail, CommonUser buyer, CommonUser seller, String address, CommonSchedule schedule, ArrayList<Question> questions, ArrayList<String> listTags) {
        this.image = image;
        this.description = description;
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.isPending = isPending;
        this.eTransferEmail = eTransferEmail;
        this.buyer = buyer;
        this.seller = seller;
        this.address = address;
        this.schedule = schedule;
        this.questions = questions;
        this.listTags = listTags;
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
    public boolean isPending() {
        return isPending;
    }

    @Override
    public String geteTransferEmail() {
        return eTransferEmail;
    }

    @Override
    public CommonUser getBuyer() {
        return buyer;
    }

    @Override
    public CommonUser getSeller() {
        return seller;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public CommonSchedule getSchedule() {
        return schedule;
    }

    @Override
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    @Override
    public ArrayList<String> getListTags() {
        return listTags;
    }
}
