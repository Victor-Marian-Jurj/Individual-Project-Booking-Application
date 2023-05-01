package business.entities;

import java.util.Objects;

public class Payment {

private String paymentId;

private String clientId;

private String reservationId;

private int roomPrice;

private int numberOfNights;

private int total;

private String paymentStatus;

    public Payment(String paymentId, String clientId, String reservationId, int roomPrice, int numberOfNights, int total, String paymentStatus) {
        this.paymentId = paymentId;
        this.clientId = clientId;
        this.reservationId = reservationId;
        this.roomPrice = roomPrice;
        this.numberOfNights = numberOfNights;
        this.total = total;
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return roomPrice == payment.roomPrice && numberOfNights == payment.numberOfNights && total == payment.total && Objects.equals(paymentId, payment.paymentId) && Objects.equals(clientId, payment.clientId) && Objects.equals(reservationId, payment.reservationId) && Objects.equals(paymentStatus, payment.paymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, clientId, reservationId, roomPrice, numberOfNights, total, paymentStatus);
    }

    @Override
    public String toString() {
        return "Payment {" +
                "paymentId='" + paymentId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", reservationId='" + reservationId + '\'' +
                ", roomPrice=" + roomPrice +
                ", numberOfNights=" + numberOfNights +
                ", total=" + total +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
