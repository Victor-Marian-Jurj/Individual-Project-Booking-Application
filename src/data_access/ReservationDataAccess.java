package data_access;

import business.entities.Reservation;

import java.util.List;

public interface ReservationDataAccess {

    List<Reservation> loadAllReservations();

    void saveAllReservations(List<Reservation> reservations);
}
