package interface_adapter.schedule;

import interface_adapter.schedule.seller_select_schedule.SellerSelectScheduleState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SellerSelectScheduleStateTest {

    private SellerSelectScheduleState sellerSelectScheduleState;

    @BeforeEach
    void setUp() {
        sellerSelectScheduleState = new SellerSelectScheduleState();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSeller() {
        assertNull(sellerSelectScheduleState.getSeller());
    }

    @Test
    void setSeller() {
        sellerSelectScheduleState.setSeller(null);
    }

    @Test
    void getProduct() {
        assertNull(sellerSelectScheduleState.getProduct());
    }

    @Test
    void setProduct() {
        sellerSelectScheduleState.setProduct(null);
    }

    @Test
    void getError() {
        assertNull(sellerSelectScheduleState.getError());
    }

    @Test
    void setError() {
        sellerSelectScheduleState.setError(null);
    }
}