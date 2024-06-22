package entity.schedule;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Basic business logic is seller can select more than one proper schedule for trading.
 * However, buyer can only select one time from the list of Time which is determinate by sellers.
 * Provide all getter method for private attributes.
 * @author CompileError group
 */

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
