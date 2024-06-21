package entity.product;

import entity.schedule.CommonSchedule;

import java.awt.*;
import java.util.ArrayList;

public interface Product{
    Image getImage();

    String getDescription();

    float getPrice();

    String getTitle();

    Integer getRating();

    int getState();

    String geteTransferEmail();

    String getSellerStudentNumber();

    String getAddress();

    CommonSchedule getSchedule();

    ArrayList<String> getListTags();

    String getProductID();
}