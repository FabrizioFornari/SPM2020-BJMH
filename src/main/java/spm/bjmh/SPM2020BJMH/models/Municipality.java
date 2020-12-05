package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import spm.bjmh.SPM2020BJMH.Enum.Roles;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document("MunicipalityModels")

public class Municipality extends User{
@NotNull(message = "Id must not be null")
@NotEmpty(message = "Id must not be empty")
    private String id;
@NotNull(message = "City must not be null ")
@NotEmpty(message = "City must not be empty")
    private String city;
@NotNull(message = "Province must not be null")
@NotEmpty(message = "Province must not be empty")
    private String province;
@NotNull(message = "Region must not be null ")
@NotEmpty(message = "Region must not be empty")
    private String region;




    public Municipality(String firstname, String lastname, String email, String phone, String username, String password,String id,
                        String city,String province, String region) {
        super(firstname, lastname, email, phone, username, password,Roles.ROLE_PARKING_MANAGER);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}