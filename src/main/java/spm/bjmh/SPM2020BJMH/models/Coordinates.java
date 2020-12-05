package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document("Coordinates")
public class Coordinates {
    @NotNull(message="Latitude must not be null")
    @NotEmpty(message = "Latitude must not be empty")
    private String latitude;
    @NotNull(message="Longitude must not be null")
    @NotEmpty(message = "Longitude must not be empty")
    private String longitude;




    public Coordinates() {

    }
    public Coordinates(String latitude, String longitude) {
        this.setLatitude(latitude);
        this.setLongitude(longitude);
    }



    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        if(latitude != null && latitude !="" ) {
            this.latitude = latitude;
        }
        else {
            throw new IllegalArgumentException("Latitude is invalid");
        }
    }

    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        if(longitude != null && longitude !="" ) {
            this.longitude = longitude;
        }
        else {
            throw new IllegalArgumentException("Longitude is invalid");
        }
    }
}


