package spm.bjmh.SPM2020BJMH.models.RequestBody;

import spm.bjmh.SPM2020BJMH.models.Coordinates;

public class StreetInformation {

    private String street;
    private Coordinates coordinates;

    public StreetInformation(String street, Coordinates coordinates){
        this.setStreet(street);
        this.setCoordinates(coordinates);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}

