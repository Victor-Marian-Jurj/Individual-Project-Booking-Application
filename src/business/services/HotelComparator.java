package business.services;

import business.entities.Hotel;
import java.util.Comparator;

public class HotelComparator implements Comparator<Hotel> {

    @Override
    public int compare(Hotel firstHotel, Hotel secondHotel) {
        if(firstHotel.getNumberOfRooms() < secondHotel.getNumberOfRooms()) {
            return -1;
        }
        if ( firstHotel.getNumberOfRooms() == secondHotel.getNumberOfRooms()) {
            String ssn1 = String.valueOf(firstHotel.getHotelId());
            String ssn2 = String.valueOf(secondHotel.getHotelId());
            return - ssn1.compareTo(ssn2);
        }
        return 1;
    }
}
