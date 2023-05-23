
import business.services.*;
import data_access.*;
import user_interface.UserInterface;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        HotelDataAccessSQL dataAccessHotelDataAccess = new HotelDataAccessSQL();
        HotelService hotelService = new HotelService(dataAccessHotelDataAccess);

        ClientDataAccessSQL dataAccessClientDataAccess = new ClientDataAccessSQL();
        ClientService clientService = new ClientService(dataAccessClientDataAccess);

        ReservationDataAccessSQL dataAccessReservationDataAccess = new ReservationDataAccessSQL();
        ReservationService reservationService = new ReservationService(dataAccessReservationDataAccess);

        PaymentDataAccessSQL dataAccessPaymentDataAccess = new PaymentDataAccessSQL();
        PaymentService paymentService = new PaymentService(dataAccessPaymentDataAccess);

        RoomDataAccess dataAccessRoomDataAccess = new RoomDataAccess();
        RoomService roomService = new RoomService(dataAccessRoomDataAccess);

        UserInterface userInterface = new UserInterface(hotelService, clientService, reservationService, paymentService, roomService);

        userInterface.printGreetingMessage();
        userInterface.showMainMenu();

    }

}
