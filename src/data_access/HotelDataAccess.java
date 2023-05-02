package data_access;

import business.entities.Hotel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class HotelDataAccess {
    public List<Hotel> loadAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try (FileReader fileReader = new FileReader("resources/hotels-comparator.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String currentLine = bufferedReader.readLine();
            while (!"---".equals(currentLine)) {
                Hotel currentHotel = readHotel(bufferedReader);
                hotels.add(currentHotel);
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        return hotels;
    }

    public void saveAllHotels(List<Hotel> hotels) {
        try (FileWriter fileWriter = new FileWriter("resources/hotels-comparator.txt")) {
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Hotel currentHotel : hotels) {
                writeHotel(printWriter, currentHotel);
            }
            printWriter.println("---");
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Hotel readHotel(BufferedReader bufferedReader) throws IOException {
        String hotelId = bufferedReader.readLine();
        int numberOfRooms = Integer.parseInt(bufferedReader.readLine());
        int rating = Integer.parseInt(bufferedReader.readLine());
        String name = bufferedReader.readLine();
        String location = bufferedReader.readLine();

        return new Hotel(hotelId, numberOfRooms, rating, name, location);
    }

    private void writeHotel(PrintWriter printWriter, Hotel hotel) {
        printWriter.println("+++");
        printWriter.println(hotel.getHotelId());
        printWriter.println(hotel.getNumberOfRooms());
        printWriter.println(hotel.getRating());
        printWriter.println(hotel.getName());
        printWriter.println(hotel.getLocation());
    }
}


