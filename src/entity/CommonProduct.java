package entity;

import java.awt.*;
import java.util.ArrayList;

public class CommonProduct implements Product{
    Image image;
    String description;
    float price;
    String title;
    boolean isPending;
    Integer rating;
    String eTransferEmail;
    CommonUser Buyer;
    CommonUser Seller;
    String address;
    CommonSchedule schedule;
    ArrayList<Question> questions;
    ArrayList<String> listTags;

    public CommonProduct(Image image, String description, String title, float price, Integer rating, boolean isPending, String eTransferEmail, CommonUser buyer, CommonUser seller, String address, CommonSchedule schedule, ArrayList<Question> questions, ArrayList<String> listTags) {
        this.image = image;
        this.description = description;
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.isPending = isPending;
        this.eTransferEmail = eTransferEmail;
        this.Buyer = buyer;
        this.Seller = seller;
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
        return Buyer;
    }

    @Override
    public CommonUser getSeller() {
        return Seller;
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
