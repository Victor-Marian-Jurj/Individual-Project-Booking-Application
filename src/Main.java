//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import business.services.ClientService;
import business.services.HotelService;
import business.services.PaymentService;
import business.services.ReservationService;
import business.services.RoomService;
import data_access.ClientDataAccess;
import data_access.HotelDataAccess;
import data_access.PaymentDataAccess;
import data_access.ReservationDataAccess;
import data_access.RoomDataAccess;
import java.io.IOException;
import user_interface.UserInterface;

public class Main {
    public Main() {
    }

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

