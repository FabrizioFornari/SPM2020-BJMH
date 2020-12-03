package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document("ProcessHandicapPermission")
public class ProcessHandicapPermission {
    @NotNull(message = "Username must not be null ")
    private String username;
    @NotNull(message = "")
    private boolean isProcessed;


    ProcessHandicapPermission() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }
}