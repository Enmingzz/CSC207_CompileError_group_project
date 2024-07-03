package use_case.schedule;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class SellerSelectScheduleOutputData {
    private String sellerName;
    private String productId;
    private ArrayList<LocalDateTime> availableTimes;
    private boolean success;

    public SellerSelectScheduleOutputData(String sellerName, String productId, ArrayList<LocalDateTime> availableTimes, boolean success) {
        this.sellerName = sellerName;
        this.productId = productId;
        this.availableTimes = availableTimes;
        this.success = success;
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

    public boolean isSuccess() {
        return success;
    }
}
