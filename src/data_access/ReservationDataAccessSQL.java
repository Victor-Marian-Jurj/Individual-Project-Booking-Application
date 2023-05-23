package data_access;

import business.entities.Payment;
import business.entities.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationDataAccessSQL implements ReservationDataAccess{
    public List<Reservation> loadAllReservations(){
        System.out.println("loadAllPayments - dummy SQL implementation");
        //JDBC implementation
        return new ArrayList<>();
    }

    public void saveAllReservations(List<Reservation> reservations){
        System.out.println("saveAllPayments - dummy SQL implementation");
        //JDBC implementation
    }
}
