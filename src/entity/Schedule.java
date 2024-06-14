package entity;

import java.sql.Time;
import java.util.ArrayList;

public interface Schedule {
    public Time getBuyerTime();

    public ArrayList<Time> getSellerTime();
}
