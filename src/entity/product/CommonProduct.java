package entity.product;

import entity.schedule.CommonSchedule;
import entity.schedule.Schedule;

import java.awt.*;
import java.util.ArrayList;

/**
 * One of core entities. Override all getter method in the interface product.
 * Has some important attributes; ArrayList<question> questions and CommonUser Buyer, Seller.
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
    private Schedule schedule;
    private ArrayList<String> listTags;
    private String productID;

    /**
     *
     * @param image: Image of product in view page and main page
     * @param description: description of product
     * @param title: short title of product viewable in shopping cart and main page
     * @param price: price of product sold
     * @param rating: rating of product if it is sold
     * @param state: the current state of the product, determining whether it is being sold, pending schedule, pending
     *             rating, sold etc. Integer representation of each state is as follows:
     *             - 0: product is being sold, searchable using searchByTag or searchByName; a newly created product has
     *                  state 0
     *             - 1: product has been checked out by a buyer and the seller is prompted to choose a list of times
     *                  for scheduling meeting time
     *             - 2: Seller has chosen a list of times for scheduling meeting time, and the buyer is prompted to
     *                  choose a meeting time from the seller's chosen list
     *             - 3: Buyer has chosen a meeting time, and the buyer is prompted to confirm that they have received
     *                  the product from the seller
     *             - 4: Buyer has confirmed that they have received the product, and the buyer is prompted to give a
     *                  rating for the product they have received
     *             - -1: Buyer has rated the product, and the product disappears from the buyer's shopping cart.
     * @param eTransferEmail: email for payment provided by seller
     * @param sellerStudentNumber: student number of the seller of product
     * @param address: address on UofT for meetup
     * @param listTags: tags that the product is searchable by searchByTag function
     * @param productID: unique ID of product; primarily for database use
     * @param schedule: associated schedule of product; defaulted as null
     */

    public CommonProduct(Image image, String description, String title, float price, Integer rating, int state, String eTransferEmail, String sellerStudentNumber, String address, ArrayList<String> listTags, String productID, Schedule schedule) {
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
        this.schedule = schedule;

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
