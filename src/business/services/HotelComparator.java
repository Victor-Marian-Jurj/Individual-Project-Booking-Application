package business.services;

import business.entities.Hotel;
import java.util.Comparator;

public class HotelComparator implements Comparator<Hotel> {

    @Override
    public int compare(Hotel firstHotel, Hotel secondHotel) {
        if(firstHotel.getRating() < secondHotel.getRating()) {
            return -1;
        }
        if ( firstHotel.getRating() == secondHotel.getRating()) {
            String ssn1 = String.valueOf(firstHotel.getLocation());
            String ssn2 = String.valueOf(secondHotel.getLocation());
            return ssn1.compareTo(ssn2);
        }
        return 1;
    }
}
