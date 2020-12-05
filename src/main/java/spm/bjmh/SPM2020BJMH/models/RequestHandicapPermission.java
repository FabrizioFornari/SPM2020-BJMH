package spm.bjmh.SPM2020BJMH.models;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document("RequestHandicapPermission")

public class RequestHandicapPermission {
    @NotNull(message = "Username must not be null")
    private String username;
    @NotNull(message = "Timestamp must not be null")
    private long timestamp;
    private boolean isAccepted;
    private boolean isProcessed;

    public RequestHandicapPermission(){}


    public RequestHandicapPermission(String username, long timestamp, boolean isAccepted, boolean isProcessed){
        this.setUsername(username);
        this.setTimestamp(timestamp);
        this.setAccepted(isAccepted);
        this.setProcessed(isProcessed);

    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        if(username != null) {
            this.username = username;
        }
        else {
            throw new IllegalArgumentException("Username is invalid");
        }
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        if(timestamp != null) {
            this.timestamp = timestamp;
        }
        else {
            throw new IllegalArgumentException("Timestamp is invalid");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        RequestHandicapPermission req = (RequestHandicapPermission) o;
        return(req.getUsername().equals(this.getUsername()) &&
                req.getTimestamp() == this.getTimestamp() &&
                req.isAccepted() == this.isAccepted() &&
                req.isProcessed() == this.isProcessed());
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }
}
