package business.services;

import business.entities.Reservation;
import data_access.ReservationDataAccess;
import java.util.List;
import java.util.Objects;

public class ReservationService {
    private final ReservationDataAccess reservationDataAccess;

    public ReservationService(ReservationDataAccess reservationDataAccess) {
        this.reservationDataAccess = reservationDataAccess;
    }

    public List<Reservation> getReservations() {
        List<Reservation> reservations = reservationDataAccess.loadAllReservations();
        reservationDataAccess.saveAllReservations(reservations);
        return reservations;
    }

    public void addNewReservation(Reservation newReservation) {
        List<Reservation> reservations = reservationDataAccess.loadAllReservations();
        reservations.add(newReservation);
        reservationDataAccess.saveAllReservations(reservations);
    }

    public void removeExistingReservation(String reservationId) {
        List<Reservation> reservations = reservationDataAccess.loadAllReservations();
        int index = getReservationIndex(reservations, reservationId);
        if (index != -1) { // if found
            reservations.remove(index);
            reservationDataAccess.saveAllReservations(reservations);
        }
    }

    private int getReservationIndex(List<Reservation> reservations, String reservationId) {
        for (int currentIndex = 0; currentIndex < reservations.size(); currentIndex++) {
            Reservation currentReservation = reservations.get(currentIndex);
            if (!Objects.equals(currentReservation.getReservationId(), reservationId)) {
                continue;
            }
            return currentIndex;
        }
        return -1;
    }
}

