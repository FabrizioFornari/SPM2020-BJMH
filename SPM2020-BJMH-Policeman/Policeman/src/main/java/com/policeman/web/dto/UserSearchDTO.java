package com.policeman.web.dto;


import lombok.Data;

/**
 * @Title: UserSearchDTO
 * @Description:
 * @version: 1.0
 */
@Data
public class UserSearchDTO {
    private String sysUserName;

    private String userPhone;

    private String startTime;

    private String endTime;

}
