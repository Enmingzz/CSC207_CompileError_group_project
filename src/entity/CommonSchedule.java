package entity;

import java.sql.Time;
import java.util.ArrayList;

public class CommonSchedule implements Schedule{
    private Time buyerTime;
    private ArrayList<Time> sellerTime;

    public CommonSchedule(Time buyerTime, ArrayList<Time> sellerTime) {
        this.buyerTime = buyerTime;
        this.sellerTime = sellerTime;
    }
    public Time getBuyerTime() {
        return buyerTime;
    }

    public ArrayList<Time> getSellerTime() {
        return sellerTime;
    }
}
