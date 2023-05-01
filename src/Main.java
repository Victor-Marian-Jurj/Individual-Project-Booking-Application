
import business.entities.Hotel;
import business.services.*;
import data_access.*;
import user_interface.UserInterface;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        HotelDataAccess dataAccessHotelDataAccess = new HotelDataAccess();
        HotelService hotelService = new HotelService(dataAccessHotelDataAccess);

        ClientDataAccess dataAccessclientDataAccess = new ClientDataAccess();
        ClientService clientService = new ClientService(dataAccessclientDataAccess);

        ReservationDataAccess dataAccessreservationDataAccess = new ReservationDataAccess();
        ReservationService reservationService = new ReservationService(dataAccessreservationDataAccess);

        PaymentDataAccess dataAccesspaymentDataAccess = new PaymentDataAccess();
        PaymentService paymentService = new PaymentService(dataAccesspaymentDataAccess);

        RoomDataAccess dataAccessroomDataAccess = new RoomDataAccess();
        RoomService roomService = new RoomService(dataAccessroomDataAccess);

        UserInterface userInterface = new UserInterface(hotelService, clientService, reservationService, paymentService, roomService);

        userInterface.printGreetingMessage();
        userInterface.showMainMenu();

    }

}
