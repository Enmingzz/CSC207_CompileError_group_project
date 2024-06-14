package entity;

import java.awt.*;
import java.util.ArrayList;

public interface Product{
    Image getImage();

    String getDescription();

    float getPrice();

    String getTitle();

    Integer getRating();

    boolean isPending();

    String geteTransferEmail();

    CommonUser getBuyer();

    CommonUser getSeller();

    String getAddress();

    CommonSchedule getSchedule();

    ArrayList<Question> getQuestions();

    ArrayList<String> getListTags();
}
