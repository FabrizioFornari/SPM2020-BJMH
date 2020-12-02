package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("DriverInformationModels")
public class DriverInformation {
    private String username;
    private String plate;
    private boolean hasHandicap;


    public DriverInformation() {}

    public DriverInformation(Driver driver) {
        this.setUsername(driver.getUsername());
        this.setPlate(driver.getPlate());
        this.setHandicap(false);


    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;


    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        DriverInformation information = (DriverInformation) o;
        return(information.getPlate().equals(this.getPlate()) &&
                information.getUsername().equals(this.getUsername())) ;

    }

    public boolean getHandicap() {
        return hasHandicap;
    }

    public void setHandicap(boolean handicap) {
        this.hasHandicap = handicap;
    }
}
