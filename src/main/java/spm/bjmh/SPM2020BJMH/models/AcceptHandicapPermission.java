package spm.bjmh.SPM2020BJMH.models;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document("AcceptHandicapPermission")
public class AcceptHandicapPermission {
    @NotNull(message = "Username must not be null ")
    private String username;
    @NotNull(message = "")
    private boolean isAccepted;


    AcceptHandicapPermission() {

    }
    public AcceptHandicapPermission(String username, boolean isAccepted ) {
        this.username=username;
        this.isAccepted=isAccepted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }



}


