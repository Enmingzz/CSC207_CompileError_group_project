package interface_adapter.schedule;

import interface_adapter.schedule.buyer_select_schedule.BuyerSelectScheduleState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuyerSelectScheduleStateTest {

    private BuyerSelectScheduleState buyerSelectScheduleState;

    @BeforeEach
    void setUp() {
        buyerSelectScheduleState = new BuyerSelectScheduleState();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getBuyer() {
        assertEquals(null, buyerSelectScheduleState.getBuyer());
    }

    @Test
    void setBuyer() {
        buyerSelectScheduleState.setBuyer(null);
    }

    @Test
    void getProduct() {
        assertEquals(null, buyerSelectScheduleState.getProduct());
    }

    @Test
    void setProduct() {
        buyerSelectScheduleState.setProduct(null);
    }


    @Test
    void getError() {
        assertEquals(null, buyerSelectScheduleState.getError());
    }

    @Test
    void setError() {
        buyerSelectScheduleState.setError(null);
    }
}