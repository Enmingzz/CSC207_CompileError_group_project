package entity.schedule;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Basic business logic is seller can select more than one proper schedule for trading.
 * However, buyer can only select one time from the list of Time which is determinate by sellers.
 * Provide all getter method for private attributes.
 * @author CompileError group
 */

public class CommonSchedule implements Schedule{
    private LocalDateTime buyerTime;
    private ArrayList<LocalDateTime> sellerTime;

    /**
     * Constructs a {@code CommonSchedule} object with the specified buyer time and seller times.
     *
     * @param buyerTime   the date and time for the buyer
     * @param sellerTime  the list of dates and times for the seller
     */

    public CommonSchedule(LocalDateTime buyerTime, ArrayList<LocalDateTime> sellerTime) {
        this.buyerTime = buyerTime;
        this.sellerTime = sellerTime;
    }
    public LocalDateTime getBuyerTime() {
        return buyerTime;
    }

    public ArrayList<LocalDateTime> getSellerTime() {
        return sellerTime;
    }
}
