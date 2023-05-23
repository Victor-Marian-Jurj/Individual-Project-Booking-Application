package data_access;

import business.entities.Room;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDataAccessTXT implements RoomDataAccess {
    public List<Room> loadAllRooms() {
        List<Room> rooms = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/rooms.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                Room currentRoom = readRoom(bufferedReader);
                rooms.add(currentRoom);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return rooms;
    }

    public void saveAllRooms(List<Room> rooms) {
        try (FileWriter fileWriter = new FileWriter("resources/rooms.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Room currentRoom : rooms) {
                writeRoom(printWriter, currentRoom);
            }
            printWriter.println("---");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Room readRoom(BufferedReader bufferedReader) throws IOException {
        String roomId = bufferedReader.readLine();
        int roomNumber = Integer.parseInt(bufferedReader.readLine());
        String roomType = bufferedReader.readLine();
        int roomFloor = Integer.parseInt(bufferedReader.readLine());
        int roomPrice = Integer.parseInt(bufferedReader.readLine());
        return new Room(roomId, roomNumber, roomType, roomFloor, roomPrice);
    }

    private void writeRoom(PrintWriter printWriter, Room room) {
        printWriter.println("+++");
        printWriter.println(room.getRoomId());
        printWriter.println(room.getRoomNumber());
        printWriter.println(room.getRoomType());
        printWriter.println(room.getRoomFloor());
        printWriter.println(room.getRoomPrice());
    }
}
