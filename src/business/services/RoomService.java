package business.services;


import business.entities.Room;
import data_access.RoomDataAccess;
import java.util.List;
import java.util.Objects;

public class RoomService {
    private final RoomDataAccess roomDataAccess;

    public RoomService(RoomDataAccess roomDataAccess) {
        this.roomDataAccess = roomDataAccess;
    }

    public List<Room> getRooms() {
        List<Room> rooms = roomDataAccess.loadAllRooms();
        roomDataAccess.saveAllRooms(rooms);
        return rooms;
    }

    public void addNewRoom(Room newRoom) {
        List<Room> rooms = roomDataAccess.loadAllRooms();
        rooms.add(newRoom);
        roomDataAccess.saveAllRooms(rooms);
    }

    public void removeExistingRoom(String roomId) {
        List<Room> rooms = roomDataAccess.loadAllRooms();
        int index = getRoomIndex(rooms, roomId);
        if (index != -1) { // if found
            rooms.remove(index);
            roomDataAccess.saveAllRooms(rooms);
        }
    }

    private int getRoomIndex(List<Room> rooms, String roomId) {
        for (int currentIndex = 0; currentIndex < rooms.size(); currentIndex++) {
            Room currentRoom = rooms.get(currentIndex);
            if (currentRoom.getRoomId().equals(roomId)) {
                return currentIndex;
            }
            return currentIndex;
        }
        return -1;
    }
}
