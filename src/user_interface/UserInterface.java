package user_interface;


import business.entities.*;
import business.services.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.List;

public class UserInterface {

    private final HotelService hotelService;
    private final ClientService clientService;
    private final ReservationService reservationService;
    private final PaymentService paymentService;
    private final RoomService roomService;
    private final BufferedReader bufferedReader;

    public UserInterface(HotelService hotelService, ClientService clientService, ReservationService reservationService, PaymentService paymentService, RoomService roomService) {
        this.hotelService = hotelService;
        this.clientService = clientService;
        this.reservationService = reservationService;
        this.paymentService = paymentService;
        this.roomService = roomService;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    public void printGreetingMessage() {
        System.out.println("----------Hello!----------");
        System.out.println("Book your trip the smart and easy way with us!");
        System.out.println();
    }

////Hotel

    private String readLine() {
        try {
            return bufferedReader.readLine();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void showMainMenu() throws IOException {
        String option;
        do {
            printOptions();
            System.out.print("Please choose your option: ");
            option = readLine();
            System.out.println("Your option is: " + option);
            handleOption(option);
        } while (shouldContinue(option));
    }

    private void printOptions() {
        System.out.println("----------------------------");
        System.out.println("1 - Print hotel data");
        System.out.println("2 - Add new hotel");
        System.out.println("3 - Remove existing hotel");
        System.out.println();
        System.out.println("4 - Print client data");
        System.out.println("5 - Add new client");
        System.out.println("6 - Remove existing client");
        System.out.println();
        System.out.println("7 - Print payment data");
        System.out.println("8 - Add new payment");
        System.out.println("9 - Remove existing payment");
        System.out.println();
        System.out.println("10 - Print reservation data");
        System.out.println("11 - Add new reservation");
        System.out.println("12 - Remove existing reservation");
        System.out.println();
        System.out.println("13 - Print room data");
        System.out.println("14 - Add new room");
        System.out.println("15 - Remove existing room");
        System.out.println();
        System.out.println("0 - Exit application");
        System.out.println("----------------------------");
    }

    private void handleOption(String option) throws IOException {
        switch (option) {
            case "1":
                handlePrintHotelData();
                break;
            case "2":
                handleAddNewHotel();
                break;
            case "3":
                handleRemoveExistingHotel();
                break;
            case "4":
                handlePrintClientData();
                break;
            case "5":
                handleAddNewClient();
                break;
            case "6":
                handleRemoveExistingClient();
                break;
            case "7":
                handlePrintPaymentData();
                break;
            case "8":
                handleAddNewPayment();
                break;
            case "9":
                handleRemoveExistingPayment();
                break;
            case "10":
                handlePrintReservationData();
                break;
            case "11":
                handleAddNewReservation();
                break;
            case "12":
                handleRemoveExistingReservation();
                break;
            case "13":
                handlePrintRoomData();
                break;
            case "14":
                handleAddNewRoom();
                break;
            case "15":
                handleRemoveExistingRoom();
                break;
            case "0":
                handleExitApplication();
                break;
            default:
                handleInvalidOption(option);
        }
    }

    private void handlePrintHotelData() {
        System.out.println("Print hotel data...");
        List<Hotel> hotels = hotelService.getHotels();
        printHotelData(hotels);
    }

    private void printHotelData(List<Hotel> hotels) {
        for (Hotel currentHotel : hotels) {
            System.out.println(currentHotel.toString());
        }
    }

    private void handleAddNewHotel() {
        System.out.println("Add new hotel...");
        Hotel newhotel = readHotel();
        hotelService.addNewHotel(newhotel);
    }

    private Hotel readHotel(){
        System.out.print("Please enter hotel id: ");
        String hotelId = readLine();
        System.out.print("Please enter number of rooms: ");
        int numberOfRooms = Integer.parseInt(readLine());
        System.out.print("Please enter rating: ");
        int rating = Integer.parseInt(readLine());
        System.out.print("Please enter name: ");
        String name = readLine();
        System.out.print("Please enter location: ");
        String location = readLine();

        Hotel hotel = new Hotel(hotelId, numberOfRooms, rating, name, location);
        return hotel;
    }

    private void handleRemoveExistingHotel() {
        System.out.println("Remove existing hotel...");
        System.out.print("Please enter hotel id: ");
        String hotelId = readLine();;
        hotelService.removeExistingHotel(hotelId);
    }

    private void handleExitApplication() {
        System.out.println("Exit application...");
        System.out.println("Bye bye!");
    }

    private void handleInvalidOption(String option) {
        System.out.println(option + " is invalid.");
    }

    private boolean shouldContinue(String option) {
        if ("0".equals(option)) {
            return false;
        } else {
            return true;
        }
    }


//    Client

    private void handlePrintClientData() {
        System.out.println("Print client data...");
        List<Client> clients = clientService.getClients();
        printClientData(clients);
    }

    private void printClientData(List<Client> clients) {
        for (Client currentClient : clients) {
            System.out.println(currentClient.toString());
        }
    }

    private void handleAddNewClient() throws IOException {
        System.out.println("Add new client...");
        try {
            Client newclient = readClient();
            clientService.addNewClient(newclient);
        } catch (InvalidClientIdException exception) {
            System.out.println(exception.getClientId() + " is not a valid ID.");
        }
    }

    private Client readClient() throws IOException, InvalidClientIdException {
        System.out.print("Please enter client id: ");
        String clientId = readLine();
        System.out.print("Please enter first name: ");
        String firstName = readLine();
        System.out.print("Please enter last name: ");
        String lastName = readLine();
        System.out.print("Please enter phone number: ");
        String phoneNumber = readLine();
        System.out.print("Please enter email adress: ");
        String emailAdress = readLine();
        System.out.print("Please enter birth day: ");
        LocalDate birthDay = LocalDate.parse(bufferedReader.readLine());

        Client client = new Client(clientId, firstName, lastName, phoneNumber, emailAdress, birthDay);
        return client;
    }
//    private LocalDate readLocalDate(BufferedReader bufferedReader) throws IOException {
//        int year = Integer.parseInt(bufferedReader.readLine());
//        int month = Integer.parseInt(bufferedReader.readLine());
//        int dayOfMonth = Integer.parseInt(bufferedReader.readLine());
//        return LocalDate.of(year, month, dayOfMonth);
//    }
    private void handleRemoveExistingClient() {
        System.out.println("Remove existing client...");
        System.out.print("Please enter client id: ");
        String clientId = readLine();
        clientService.removeExistingClient(clientId);
    }

//      Payment

    private void handlePrintPaymentData() {
        System.out.println("Print payment data...");
        List<Payment> payments = paymentService.getPayments();
        printPaymentData(payments);
    }

    private void printPaymentData(List<Payment> payments) {
        for (Payment currentPayment : payments) {
            System.out.println(currentPayment.toString());
        }
    }

    private void handleAddNewPayment() throws IOException {
        System.out.println("Add new payment...");
        Payment newpayment = readPayment();
        paymentService.addNewPayment(newpayment);
    }

    private Payment readPayment() throws IOException {
        System.out.print("Please enter payment id: ");
        String paymentId = readLine();
        System.out.print("Please enter client id: ");
        String clientId = readLine();
        System.out.print("Please enter reservation id: ");
        String reservationId = readLine();
        System.out.print("Please enter room price: ");
        int roomPrice = Integer.parseInt(readLine());
        System.out.print("Please enter number of nights: ");
        int numberOfNights = Integer.parseInt(readLine());
        System.out.print("Please enter total: ");
        int total = Integer.parseInt(readLine());
        System.out.print("Please enter payment status: ");
        String paymentStatus = readLine();


        Payment payment = new Payment(paymentId, clientId, reservationId, roomPrice, numberOfNights, total, paymentStatus);
        return payment;
    }

    private void handleRemoveExistingPayment() {
        System.out.println("Remove existing payment...");
        System.out.print("Please enter payment id: ");
        String paymentId = readLine();
        paymentService.removeExistingPayment(paymentId);
    }

//    Reservation

    private void handlePrintReservationData() {
        System.out.println("Print reservation data...");
        List<Reservation> reservations = reservationService.getReservations();
        printReservationData(reservations);
    }

    private void printReservationData(List<Reservation> reservations) {
        for (Reservation currentReservation : reservations) {
            System.out.println(currentReservation.toString());
        }
    }

    private void handleAddNewReservation() throws IOException {
        System.out.println("Add new reservation...");
        Reservation newreservation = readReservation();
        reservationService.addNewReservation(newreservation);
    }

    private Reservation readReservation() throws IOException {
        System.out.print("Please enter reservation id: ");
        String reservationId = readLine();
        System.out.print("Please enter client id: ");
        String clientId = readLine();
        System.out.print("Please enter hotel id: ");
        String hotelId = readLine();
        System.out.print("Please enter room id: ");
        String roomId = readLine();
        System.out.print("Please enter reservation status: ");
        String reservationStatus = readLine();
        System.out.print("Please enter check in date: ");
        LocalDate checkInDate = LocalDate.parse(bufferedReader.readLine());
        System.out.print("Please enter check out date: ");
        LocalDate checkOutDate = LocalDate.parse(bufferedReader.readLine());


        Reservation reservation = new Reservation(reservationId, clientId, hotelId, roomId, reservationStatus, checkInDate, checkOutDate);
        return reservation;
    }

    private void handleRemoveExistingReservation() {
        System.out.println("Remove existing reservation...");
        System.out.print("Please enter reservation id: ");
        String reservationId = readLine();
        reservationService.removeExistingReservation(reservationId);
    }

//     Room

    private void handlePrintRoomData() {
        System.out.println("Print room data...");
        List<Room> rooms = roomService.getRooms();
        printRoomData(rooms);
    }

    private void printRoomData(List<Room> rooms) {
        for (Room currentRoom : rooms) {
            System.out.println(currentRoom.toString());
        }
    }

    private void handleAddNewRoom() throws IOException {
        System.out.println("Add new room...");
        Room newroom = readRoom();
        roomService.addNewRoom(newroom);
    }

    private Room readRoom() throws IOException {
        System.out.print("Please enter room id: ");
        String roomId = readLine();
        System.out.print("Please enter room number: ");
        int roomNumber = Integer.parseInt(readLine());
        System.out.print("Please enter room type: ");
        String roomType = readLine();
        System.out.print("Please enter room floor: ");
        int roomFloor = Integer.parseInt(readLine());
        System.out.print("Please enter room price: ");
        int roomPrice = Integer.parseInt(readLine());



        Room room = new Room(roomId, roomNumber, roomType, roomFloor, roomPrice);
        return room;
    }

    private void handleRemoveExistingRoom() {
        System.out.println("Remove existing room...");
        System.out.print("Please enter room id: ");
        String roomId = readLine();
        roomService.removeExistingRoom(String.valueOf(roomId));
    }
}









