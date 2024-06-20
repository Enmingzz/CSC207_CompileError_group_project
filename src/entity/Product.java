package entity;

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

    ArrayList<String> getBuyerStudentNumber();

    String getSellerStudentNumber();

    String getAddress();

    CommonSchedule getSchedule();

    ArrayList<String> getListTags();
}
