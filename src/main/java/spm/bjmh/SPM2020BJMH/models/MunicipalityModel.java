package spm.bjmh.SPM2020BJMH.models;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

    
   @Document ("Municipalities")
  public class MunicipalityModel implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    
    private String id;
	private String city;
	private String province;
	private String region;
    private String email;
    

	
    public MunicipalityModel() { }

	public MunicipalityModel(String city, String province, String region, String id, String email) {
		this.id = id;
		this.email = email;
		this.city = city;
		this.province = province;
		this.region = region;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
  
	
	


