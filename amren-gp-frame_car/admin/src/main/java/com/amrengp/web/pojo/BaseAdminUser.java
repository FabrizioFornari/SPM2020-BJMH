package com.amrengp.web.pojo;


public class BaseAdminUser {
    /**
     * ID
     */
    private Integer id;

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

    /**
     * Get ID
     *
     * @return id - ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get system user name
     *
     * @return sys_user_name - System user name
     */
    public String getSysUserName() {
        return sysUserName;
    }

    /**
     * Set system user name
     *
     * @param sysUserName System user name
     */
    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    /**
     * Get system user password
     *
     * @return sys_user_pwd - System user password
     */
    public String getSysUserPwd() {
        return sysUserPwd;
    }

    /**
     * Set system user password
     *
     * @param sysUserPwd System user password
     */
    public void setSysUserPwd(String sysUserPwd) {
        this.sysUserPwd = sysUserPwd;
    }

    /**
     * Get role
     *
     * @return role_id - Roles
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * Set role
     *
     * @param roleId Roles
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * Get mobile number
     *
     * @return user_phone - phone number
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * Set mobile phone number
     *
     * @param userPhone phone number
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * Get registration time
     *
     * @return reg_time - registration time
     */
    public String getRegTime() {
        return regTime;
    }

    /**
     * Set registration time
     *
     * @param regTime check-in time
     */
    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    /**
     * Get status (0: invalid; 1: valid)
     *
     * @return user_status - Get status (0: invalid; 1: valid)
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * set status (0: invalid; 1: valid)
     *
     * @param userStatus set status (0: invalid; 1: valid)
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

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