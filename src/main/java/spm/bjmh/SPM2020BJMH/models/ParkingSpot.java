package spm.bjmh.SPM2020BJMH.models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ParkingSpot {

    @NotNull(message = "Street must not be null")
    @NotEmpty(message = "Street must not be empty")
    private String street;
    @NotNull(message = "Number of parking spot must not be null")
    private Integer numberOfParkingSpot;
    @NotNull(message = "isHandicapParkingSpot must not be null ")
    private Boolean isHandicapParkingSpot;
    @NotNull(message = "Coordinates must not be null")
    private Coordinates coordinates;
    @NotNull(message = "Price pe hours must not be null ")
    private Double pricePerHours;



    public ParkingSpot(String street, Integer numberOfParkingSpot, Boolean isHandicapParkingSpot, Coordinates coordinates) {
        this.setStreet(street);
        this.setNumberOfParkingSpot(numberOfParkingSpot);
        this.setHandicapParkingSpot(isHandicapParkingSpot);
        this.setPricePerHours(pricePerHours);
        this.setCoordinates(coordinates);
    }




    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if (street != null && street !=""){
            this.street = street;
    }
        else {
            throw new IllegalArgumentException("Street is invalid");
        }
    }

    public Integer getNumberOfParkingSpot() {
        return numberOfParkingSpot;
    }

    public void setNumberOfParkingSpot(Integer numberOfParkingSpot) {
        if(numberOfParkingSpot != null ){
        this.numberOfParkingSpot = numberOfParkingSpot;
    }
        else{
            throw new IllegalArgumentException("numberOfParkingSpot is null");
        }

        }

    public Boolean getHandicapParkingSpot() {
        return isHandicapParkingSpot;
    }

    public void setHandicapParkingSpot(Boolean handicapParkingSpot) {
        if (isHandicapParkingSpot !=null){
        isHandicapParkingSpot = handicapParkingSpot;
    }
    else{
        throw new IllegalArgumentException("isHandicapParkingSpot is null");
        }

    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public Double getPricePerHours() {
        return pricePerHours;
    }

    public void setPricePerHours(Double pricePerHours) {
        if(pricePerHours !=null){
        this.pricePerHours = pricePerHours;
    }
        else {
            throw new IllegalArgumentException("pricePerHours is invalid");
        }
    }




}
