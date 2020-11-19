package com.amrengp.web.dto;

import lombok.Data;

;

/**
 * @Title: AdminUserDTO
 * @Description:
 * @version: 1.0
 */
@Data
public class AdminUserDTO {

    private Integer id;

    private String sysUserName;

    private String sysUserPwd;

    private Integer roleId;

    private String roleName;

    private String userPhone;


    private String regTime;


    private Integer userStatus;

}
