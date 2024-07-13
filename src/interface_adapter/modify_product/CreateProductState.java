package interface_adapter.modify_product;

import java.awt.*;
import java.util.ArrayList;

public class CreateProductState {
    private Image image = null;
    private String imageError = null;
    private String description = "";
    private String descriptionError = null;
    private String price = "";
    private String priceError = null;
    private String title = "";
    private String titleError = null;
    private String eTransferEmail = "";
    private String eTransferEmailError = null;
    private String address = "";
    private String addressError = null;
    private ArrayList<String> listTags = new ArrayList<String>();
    private String listTagsError = null;

    public CreateProductState(CreateProductState copy) {
        image = copy.image;
        imageError = copy.imageError;
        description = copy.description;
        descriptionError = copy.descriptionError;
        price = copy.price;
        priceError = copy.priceError;
        title = copy.title;
        titleError = copy.titleError;
        eTransferEmail = copy.eTransferEmail;
        eTransferEmailError = copy.eTransferEmailError;
        address = copy.address;
        addressError = copy.addressError;

        listTags = copy.listTags;
        listTagsError = copy.listTagsError;
    }

    //A default constructor where the fields can be set later
    public CreateProductState(){}

    public Image getImage() {
        return image;
    }
    public String getImageError() {
        return imageError;
    }
    public String getDescription() {
        return description;
    }
    public String getDescriptionError() {
        return descriptionError;
    }
    public String getPrice() {
        return price;
    }
    public String getPriceError() {
        return priceError;
    }
    public String getTitle() {
        return title;
    }
    public String getTitleError() {
        return titleError;
    }
    public String geteTransferEmail() {
        return eTransferEmail;
    }
    public String geteTransferEmailError() {
        return eTransferEmailError;
    }
    public String getAddress() {
        return address;
    }
    public String getAddressError() {
        return addressError;
    }
    public ArrayList<String> getListTags() {
        return listTags;
    }
    public String getListTagsError() {
        return listTagsError;
    }

    public void setImageError(String error) {
        imageError = error;
    }
    public void setDescriptionError(String error) {
        descriptionError = error;
    }
    public void setPirceError(String error) {
        priceError = error;
    }
    public void setTitleError(String error) {
        titleError = error;
    }
    public void seteTransferEmailError(String error) {
        eTransferEmailError = error;
    }
    public void setAddressError(String error) {
        addressError = error;
    }
    public void setListTagsError(String error) {
        listTagsError = error;
    }

}
