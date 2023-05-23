package data_access;

import business.entities.Hotel;

import java.util.ArrayList;
import java.util.List;

public class HotelDataAccessSQL implements HotelDataAccess {

    public List<Hotel> loadAllHotels(){
        System.out.println("loadAllHotels - dummy SQL implementation");
        //JDBC implementation
        return new ArrayList<>();
    }

    public void saveAllHotels(List<Hotel> hotels){
        System.out.println("saveAllHotels - dummy SQL implementation");
        //JDBC implementation
    }
}
