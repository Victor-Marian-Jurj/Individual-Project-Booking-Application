package business.entities;

import java.util.Objects;

public class Hotel {

    private String hotelId;

    private int numberOfRooms;
    private int rating;

    private String name;

    private String location;

    public Hotel(String hotelId, int numberOfRooms, int rating, String name, String location) {
        this.hotelId = hotelId;
        this.numberOfRooms = numberOfRooms;
        this.rating = rating;
        this.name = name;
        this.location = location;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return numberOfRooms == hotel.numberOfRooms && rating == hotel.rating && Objects.equals(hotelId, hotel.hotelId) && Objects.equals(name, hotel.name) && Objects.equals(location, hotel.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, numberOfRooms, rating, name, location);
    }

    @Override
    public String toString() {
        return "Hotel {" +
                "hotelId='" + hotelId + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", rating=" + rating +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}


