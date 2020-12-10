package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document("BookingModels")
public class Booking {
    @NotNull(message="Street must not be null")
    @NotEmpty(message = "Street must not be empty")
    private String street;
    @NotNull(message="numberOfParkingSpot must not be null")
    private Integer numberOfParkingSpot;
    @NotNull(message="username must not be null")
    private String username;
    @NotNull(message="Timestamp must not be null")
    private long timestamp;
    @NotNull(message="Coordinates must not be null")
    private Coordinates coordinates;

    public Booking() {}

    public Booking(String street, Integer numberOfParkingLot, String username, long timestamp, Coordinates coordinates) {
        this.setStreet(street);
        this.setNumberOfParkingSpot(numberOfParkingSpot);
        this.setUsername(username);
        this.setTimestamp(timestamp);
        this.setCoordinates(coordinates);
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(street != null && street != "" ) {
            this.street = street;
        }
        else {
            throw new IllegalArgumentException("Street is invalid");
        }
    }
    public int getNumberOfParkingSpot() {
        return numberOfParkingSpot;
    }

    public void setNumberOfParkingSpot(Integer numberOfParkingSpot) {
        if(numberOfParkingSpot != null) {
            this.numberOfParkingSpot = numberOfParkingSpot;
        }
        else {
            throw new IllegalArgumentException("numberOfParkingSpot is invalid");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(numberOfParkingSpot != null) {
            this.username = username;
        }
        else {
            throw new IllegalArgumentException("username is invalid");
        }
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        if(numberOfParkingSpot != null) {
            this.timestamp = timestamp;
        }
        else {
            throw new IllegalArgumentException("timestamp is invalid");
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Booking booking = (Booking) o;
        return(booking.getStreet().equals(this.getStreet()) &&
                ((Integer)booking.getNumberOfParkingSpot()).equals((Integer)this.getNumberOfParkingSpot()) &&
                booking.getUsername().equals(this.getUsername()) &&
                ((Long)booking.getTimestamp()).equals((Long)this.getTimestamp()) &&
                booking.getCoordinates().equals(this.getCoordinates()));

    }
}

