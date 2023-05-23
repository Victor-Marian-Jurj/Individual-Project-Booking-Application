package data_access;

import business.entities.Reservation;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationDataAccessTXT implements ReservationDataAccess{

    @Override
    public List<Reservation> loadAllReservations() {
        List<Reservation> reservations = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/reservations.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                Reservation currentReservation = readReservation(bufferedReader);
                reservations.add(currentReservation);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return reservations;
    }

    @Override
    public void saveAllReservations(List<Reservation> reservations) {
        try (FileWriter fileWriter = new FileWriter("resources/reservations.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Reservation currentReservation : reservations) {
                writeReservation(printWriter, currentReservation);
            }
            printWriter.println("---");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Reservation readReservation(BufferedReader bufferedReader) throws IOException {
        String reservationId = bufferedReader.readLine();
        String hotelId = bufferedReader.readLine();
        String clientId = bufferedReader.readLine();
        String roomId = bufferedReader.readLine();
        String reservationStatus = bufferedReader.readLine();
        LocalDate checkInDate = LocalDate.parse(bufferedReader.readLine());
        LocalDate checkOutDate = LocalDate.parse(bufferedReader.readLine());

        return new Reservation(reservationId, clientId, hotelId, roomId, reservationStatus, checkInDate, checkOutDate);

//        LocalDate checkInDate = readLocalDate(bufferedReader);
//        LocalDate checkOutDate = readLocalDate(bufferedReader);

    }

//    private LocalDate readLocalDate(BufferedReader bufferedReader) throws IOException {
//        int year = Integer.parseInt(bufferedReader.readLine());
//        int month = Integer.parseInt(bufferedReader.readLine());
//        int dayOfMonth = Integer.parseInt(bufferedReader.readLine());
//        return LocalDate.of(year, month, dayOfMonth);
//    }

    private void writeReservation(PrintWriter printWriter, Reservation reservation) {
        printWriter.println("+++");
        printWriter.println(reservation.getReservationId());
        printWriter.println(reservation.getClientId());
        printWriter.println(reservation.getHotelId());
        printWriter.println(reservation.getRoomId());
        printWriter.println(reservation.getReservationStatus());
        printWriter.println(reservation.getCheckInDate());
        printWriter.println(reservation.getCheckOutDate());

//        printWriter.println(reservation.getCheckInDate().getYear());
//        printWriter.println(reservation.getCheckInDate().getMonthValue());
//        printWriter.println(reservation.getCheckInDate().getDayOfMonth());
//
//        printWriter.println(reservation.getCheckOutDate().getYear());
//        printWriter.println(reservation.getCheckOutDate().getMonthValue());
//        printWriter.println(reservation.getCheckOutDate().getDayOfMonth());
    }
}