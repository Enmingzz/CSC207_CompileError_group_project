package use_case.schedule;

import java.time.LocalDateTime;

public class BuyerSelectScheduleInputData {
    private String buyerName;
    private String productId;
    private LocalDateTime selectedTime;

    public BuyerSelectScheduleInputData(String buyerName, String productId, LocalDateTime selectedTime) {
        this.buyerName = buyerName;
        this.productId = productId;
        this.selectedTime = truncateToHour(selectedTime);
    }

    private LocalDateTime truncateToHour(LocalDateTime time) {
        return time.withMinute(0).withSecond(0).withNano(0);
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
}

