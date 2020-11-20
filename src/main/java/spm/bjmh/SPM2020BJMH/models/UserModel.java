package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

/*
@NotNull: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null, but it can be empty
@NotEmpty: a constrained CharSequence, Collection, Map, or Array is valid as long as it's not null and its size/length is greater than zero
@NotBlank: a constrained String is valid as long as it's not null and the trimmed length is greater than zero
 */
@Document("user")
public class UserModel {
    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    @NotEmpty
    @Size(max = 50)
    private String email;
    @NotEmpty
    @Size(max = 120)
    private String password;
    private String username;
    private int phoneNumber;
    @DBRef
    private Set<RoleModel> roles;

    public UserModel() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<RoleModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleModel> roles) {
        this.roles = roles;
    }
}
