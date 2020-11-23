package com.policeman.web.pojo;

import com.gp.common.annotation.Excel;
import com.gp.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * User Management Object user
 * 
 * @author amren
 * @date 2020-11-17
 */
@Document(collection = "user")
public class UserMongo extends BaseEntity
{

    @Id
    /** id */
    private String id;

    /** password */
    @Excel(name = "password")
    private String password;

    /** email */
    @Excel(name = "email")
    private String email;

    /** name */
    @Excel(name = "name")
    private String name;

    /** lastname */
    @Excel(name = "lastname")
    private String lastname;

    /** phonenumber */
    @Excel(name = "phonenumber")
    private String phonenumber;

    /** carplate */
    @Excel(name = "carplate")
    private String carplate;

    /** carcolor */
    @Excel(name = "carcolor")
    private String carcolor;

    /** entrytime */
    @Excel(name = "entrytime", width = 30, dateFormat = "yyyy-MM-dd")
    private Date entrytime;

    /** departuretime */
    @Excel(name = "departuretime", width = 30, dateFormat = "yyyy-MM-dd")
    private Date departuretime;

    /** inparking */
    @Excel(name = "inparking1Y0N")
    private String inparking;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setLastname(String lastname) 
    {
        this.lastname = lastname;
    }

    public String getLastname() 
    {
        return lastname;
    }
    public void setPhonenumber(String phonenumber) 
    {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() 
    {
        return phonenumber;
    }
    public void setCarplate(String carplate) 
    {
        this.carplate = carplate;
    }

    public String getCarplate() 
    {
        return carplate;
    }
    public void setCarcolor(String carcolor) 
    {
        this.carcolor = carcolor;
    }

    public String getCarcolor() 
    {
        return carcolor;
    }
    public void setEntrytime(Date entrytime) 
    {
        this.entrytime = entrytime;
    }

    public Date getEntrytime() 
    {
        return entrytime;
    }
    public void setDeparturetime(Date departuretime) 
    {
        this.departuretime = departuretime;
    }

    public Date getDeparturetime() 
    {
        return departuretime;
    }
    public void setInparking(String inparking) 
    {
        this.inparking = inparking;
    }

    public String getInparking() 
    {
        return inparking;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("password", getPassword())
            .append("email", getEmail())
            .append("name", getName())
            .append("lastname", getLastname())
            .append("phonenumber", getPhonenumber())
            .append("carplate", getCarplate())
            .append("carcolor", getCarcolor())
            .append("entrytime", getEntrytime())
            .append("departuretime", getDeparturetime())
            .append("inparking", getInparking())
            .toString();
    }
}
