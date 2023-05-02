
import business.entities.Hotel;
import business.services.*;
import data_access.*;
import user_interface.UserInterface;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        HotelDataAccess dataAccessHotelDataAccess = new HotelDataAccess();
        HotelService hotelService = new HotelService(dataAccessHotelDataAccess);

        ClientDataAccess dataAccessClientDataAccess = new ClientDataAccess();
        ClientService clientService = new ClientService(dataAccessClientDataAccess);

        ReservationDataAccess dataAccessReservationDataAccess = new ReservationDataAccess();
        ReservationService reservationService = new ReservationService(dataAccessReservationDataAccess);

        PaymentDataAccess dataAccessPaymentDataAccess = new PaymentDataAccess();
        PaymentService paymentService = new PaymentService(dataAccessPaymentDataAccess);

        RoomDataAccess dataAccessRoomDataAccess = new RoomDataAccess();
        RoomService roomService = new RoomService(dataAccessRoomDataAccess);

        UserInterface userInterface = new UserInterface(hotelService, clientService, reservationService, paymentService, roomService);

        userInterface.printGreetingMessage();
        userInterface.showMainMenu();

    }

}
