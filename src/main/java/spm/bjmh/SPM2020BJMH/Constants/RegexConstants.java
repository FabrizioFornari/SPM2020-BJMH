package spm.bjmh.SPM2020BJMH.Constants;

public class RegexConstants {
    public static final String EMAIL_REGEX ="[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";
    public static final String PASSWORD_REGEX="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,10})";
    public static final String USERNAME_REGEX="^[a-z0-9_-]{3,5}$";
    public static final String PHONE_REGEX ="/^([+]39)?((38[{8,9}|0])|(34[{7-9}|0])|(36[6|8|0])|(33[{3-9}|0])|(32[{8,9}]))([\\d]{7})$/";
    public static final String PLATE_REGEX ="[A-Z]{1,3}-[A-Z]{1,2}-[0-9]{1,4}";
}
