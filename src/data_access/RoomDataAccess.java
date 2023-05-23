package data_access;

import business.entities.Reservation;
import business.entities.Room;

import java.util.ArrayList;
import java.util.List;

public interface RoomDataAccess {
    public List<Room> loadAllRooms();

    public void saveAllRooms(List<Room> rooms);

}
