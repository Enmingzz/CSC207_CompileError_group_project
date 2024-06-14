package entity;

import java.awt.*;
import java.util.ArrayList;

public interface Product{
    public Image getImage();

    public String getDescription();

    public float getPrice();

    public String getTitle();

    public Integer getRating();

    public boolean isPending();

    public String geteTransferEmail();

    public CommonUser getBuyer();

    public CommonUser getSeller();

    public String getAddress();

    public CommonSchedule getSchedule();

    public ArrayList<Question> getQuestions();

    public ArrayList<String> getListTags();
}
