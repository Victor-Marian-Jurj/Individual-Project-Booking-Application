package business.entities;


import java.time.LocalDate;
import java.util.Objects;

public class Reservation {

    private String reservationId;

    private String clientId;

    private String hotelId;

    private String roomId;
    private String reservationStatus;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    public Reservation(String reservationId, String clientId, String hotelId, String roomId, String reservationStatus, LocalDate checkInDate, LocalDate checkOutDate) {
        this.reservationId = reservationId;
        this.clientId = clientId;
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.reservationStatus = reservationStatus;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public <LocalData> Reservation(int reservationId, int clientId, int hotelId, int roomId, String reservationStatus, LocalData checkInDate, LocalData checkOutDate) {
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationId, that.reservationId) && Objects.equals(clientId, that.clientId) && Objects.equals(hotelId, that.hotelId) && Objects.equals(roomId, that.roomId) && Objects.equals(reservationStatus, that.reservationStatus) && Objects.equals(checkInDate, that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, clientId, hotelId, roomId, reservationStatus, checkInDate, checkOutDate);
    }

    @Override
    public String toString() {
        return "Reservation {" +
                "reservationId='" + reservationId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", hotelId='" + hotelId + '\'' +
                ", roomId='" + roomId + '\'' +
                ", reservationStatus='" + reservationStatus + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
