package business.services;

import business.entities.Hotel;
import data_access.HotelDataAccess;
import data_access.HotelDataAccessTXT;
import java.util.List;
import java.util.Objects;

public class HotelService {

    private final HotelDataAccess hotelDataAccess;

    public HotelService(HotelDataAccess hotelDataAccess) {
        this.hotelDataAccess = hotelDataAccess;
    }

    public List<Hotel> getHotels() {
        List<Hotel> hotels = hotelDataAccess.loadAllHotels();
        hotels.sort(new HotelComparator());

        return hotels;
    }

    public void addNewHotel(Hotel newHotel) {
        List<Hotel> hotels = hotelDataAccess.loadAllHotels();
        hotels.add(newHotel);
        hotelDataAccess.saveAllHotels(hotels);
    }

    public void removeExistingHotel(String hotelId) {
        List<Hotel> hotels = hotelDataAccess.loadAllHotels();
        int index = getHotelIndex(hotels, hotelId);
        if (index != -1) { // if found
            hotels.remove(index);
            hotelDataAccess.saveAllHotels(hotels);
        }
    }

    private int getHotelIndex(List<Hotel> hotels, String hotelId) {
        for (int currentIndex = 0; currentIndex < hotels.size(); currentIndex++) {
            Hotel currentHotel = hotels.get(currentIndex);
            if (!Objects.equals(currentHotel.getHotelId(), hotelId)) {
                continue;
            }
            return currentIndex;
        }
        return -1;
    }
}

