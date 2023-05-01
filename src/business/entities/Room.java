package business.entities;

import java.util.Objects;

public class Room {

     private String roomId;
     private int roomNumber;

     private String roomType;

     private int roomFloor;

     private int roomPrice;

     public Room(String roomId, int roomNumber, String roomType, int roomFloor, int roomPrice) {
          this.roomId = roomId;
          this.roomNumber = roomNumber;
          this.roomType = roomType;
          this.roomFloor = roomFloor;
          this.roomPrice = roomPrice;
     }


     public String getRoomId(){
          return roomId;
     }

     public void setRoomId(String roomId) {
          this.roomId = roomId;
     }
     public int getRoomNumber() {
          return roomNumber;
     }

     public void setRoomNumber(int roomNumber) {
          this.roomNumber = roomNumber;
     }

     public String getRoomType() {
          return roomType;
     }

     public void setRoomType(String roomType) {
          this.roomType = roomType;
     }

     public int getRoomFloor() {
          return roomFloor;
     }

     public void setRoomFloor(int roomFloor) {
          this.roomFloor = roomFloor;
     }

     public int getRoomPrice() {
          return roomPrice;
     }

     public void setRoomPrice(int roomPrice) {
          this.roomPrice = roomPrice;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Room room = (Room) o;
          return roomNumber == room.roomNumber && roomFloor == room.roomFloor && roomPrice == room.roomPrice && Objects.equals(roomId, room.roomId) && Objects.equals(roomType, room.roomType);
     }

     @Override
     public int hashCode() {
          return Objects.hash(roomId, roomNumber, roomType, roomFloor, roomPrice);
     }

     @Override
     public String toString() {
          return "Room {" +
                  "roomId='" + roomId + '\'' +
                  ", roomNumber=" + roomNumber +
                  ", roomType='" + roomType + '\'' +
                  ", roomFloor=" + roomFloor +
                  ", roomPrice=" + roomPrice +
                  '}';
     }
}
