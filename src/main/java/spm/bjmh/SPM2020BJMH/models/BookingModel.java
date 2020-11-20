package spm.bjmh.SPM2020BJMH.models;



import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document ("BookingModel")
public class BookingModel implements Serializable{

    /**
     *
     */

    
    @Id
    private static final long serialVersionUID = 1L;
	public String Name;
    public String phonenumber;
    public String email;
    public String car;
    public String slot;
    

     public BookingModel() {}

    public BookingModel(String Name, String phonenumber, String email, String car, String slot) {
        this.Name = Name;
        this.phonenumber = phonenumber;
        this.email = email;
        this.slot= slot;
        this.car = car;
    
    }
     
    
      @Override
      public String toString(){
        return String.format(
            "Booking[name=%s, phonenumber='%s', email='%s' , slot ='%s',car='%s]",
                Name, email, phonenumber,slot,car);
            }
        
        
            public String getEmail() {
            return email;
        }
    
        public String getName() {
            return Name;
        }
        public String  getPhoneNumber(String phoneNumber) {
            return phoneNumber;
        }

        public String getslot() {
            return slot;
        }   
            
            public String getcar() {
                return car;
        }
        public void setEmail(String email) {
            this.email = email;
        }
    
        public void setName(String name) {
            this.Name = name;
        }
    

    public void setPhoneNumber(String phoneNumber) {
        this.phonenumber = phoneNumber;
    }

    public void setslot(String slot) {
        this.slot = slot;
    }

    public void setcar(String car) {
        this.car = car;
    }

}
