package com.policeman.web.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "admin")
@Data
public class BaseAdminMongoUser {
    /**
     * ID
     */
    @Id
    private String id;

    /**
     * System user name
     */
    private String sysUserName;

    /**
     * System user password
     */
    private String sysUserPwd;

    /**
     * Roles
     */
    private Integer roleId;

    /**
     * phone number
     */
    private String userPhone;

    /**
     * check-in time
     */
    private String regTime;

    /**
     * Status (0: invalid; 1: valid)
     */
    private Integer userStatus;


    @Override
    public String toString() {
        return "BaseAdminUser{" +
                "id=" + id +
                ", sysUserName='" + sysUserName + '\'' +
                ", sysUserPwd='" + sysUserPwd + '\'' +
                ", roleId=" + roleId +
                ", userPhone='" + userPhone + '\'' +
                ", regTime='" + regTime + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}