package use_case.schedule;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SellerSelectScheduleInputData {
    private String sellerName;
    private String productId;
    private ArrayList<LocalDateTime> availableTimes;

    public SellerSelectScheduleInputData(String sellerName, String productId, ArrayList<LocalDateTime> availableTimes) {
        this.sellerName = sellerName;
        this.productId = productId;
        this.availableTimes = truncateToHours(availableTimes);
    }

    private ArrayList<LocalDateTime> truncateToHours(ArrayList<LocalDateTime> times) {
        times.replaceAll(localDateTime -> localDateTime.withHour(0).withSecond(0).withNano(0));
        return times;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getProductId() {
        return productId;
    }

    public ArrayList<LocalDateTime> getAvailableTimes() {
        return availableTimes;
    }
}
