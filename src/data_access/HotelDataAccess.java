package data_access;

import business.entities.Hotel;

import java.util.List;

public interface HotelDataAccess {
    List<Hotel> loadAllHotels();

    public void saveAllHotels(List<Hotel> hotels);
}
