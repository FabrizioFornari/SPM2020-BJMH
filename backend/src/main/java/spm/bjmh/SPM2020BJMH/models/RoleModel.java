package spm.bjmh.SPM2020BJMH.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("roles")
public class RoleModel {
    @Id
    private String id;
    private ERole name;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private String role;


    public RoleModel() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }
    public void setName(ERole name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
