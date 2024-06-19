package entity;

import java.sql.Time;
import java.util.ArrayList;

public interface Schedule {
    Time getBuyerTime();

    ArrayList<Time> getSellerTime();
}
