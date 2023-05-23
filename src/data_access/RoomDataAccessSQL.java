package data_access;

import business.entities.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomDataAccessSQL implements RoomDataAccess {
    public List<Room> loadAllRooms(){
        System.out.println("loadAllRooms - dummy SQL implementation");
        //JDBC implementation
        return new ArrayList<>();
    }

    public void saveAllRooms(List<Room> rooms){
        System.out.println("saveAllRooms - dummy SQL implementation");
        //JDBC implementation
    }
}
