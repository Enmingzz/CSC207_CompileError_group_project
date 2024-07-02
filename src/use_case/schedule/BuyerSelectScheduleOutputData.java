package use_case.schedule;

import java.time.LocalDateTime;

public class BuyerSelectScheduleOutputData {
    private String buyerName;
    private String productId;
    private LocalDateTime selectedTime;
    private boolean success;

    public BuyerSelectScheduleOutputData(String buyerName, String productId, LocalDateTime selectedTime, boolean success) {
        this.buyerName = buyerName;
        this.productId = productId;
        this.selectedTime = selectedTime;
        this.success = success;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public String getProductId() {
        return productId;
    }

    public LocalDateTime getSelectedTime() {
        return selectedTime;
    }

    public boolean isSuccess() {
        return success;
    }
}
