package com.amrengp.web.dto;

import lombok.Data;


/**
 * @Title: AdminRoleDTO
 * @Description:
 * @version: 1.0
 */
@Data
public class AdminRoleDTO {
    private Integer id;

    /**
     * Role Name
     */
    private String roleName;

    /**
     * Role description
     */
    private String roleDesc;

    private String permissionIds;
    /**
     * Authority
     */
    private String permissions;

    /**
     * Creation time
     */
    private String createTime;

    /**
     * Update time
     */
    private String updateTime;

    /**
     * 1：valid
     0：invalid
     */
    private Integer roleStatus;
}
