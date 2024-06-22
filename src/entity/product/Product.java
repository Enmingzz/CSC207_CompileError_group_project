package entity.product;

import entity.schedule.CommonSchedule;

import java.awt.*;
import java.util.ArrayList;

/**
 * Provide the interface of CommonProduct
 * @author CompileError group
 */

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

    ArrayList<String> getListTags();

    String getProductID();
}
