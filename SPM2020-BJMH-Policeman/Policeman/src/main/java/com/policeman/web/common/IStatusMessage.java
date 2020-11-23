package com.policeman.web.common;

/**
 * @Title: IStatusMessage
 * @Description: response status information
 * @version: 1.0
 *
 */
public interface IStatusMessage {

    String getCode();

    String getMessage();

    public enum SystemStatus implements IStatusMessage{

        SUCCESS("200","SUCCESS"), //Request succeeded
        ERROR("404","ERROR"),	   //Request fail
        PARAM_ERROR("1002","PARAM_ERROR"), //request parameter fail
        SUCCESS_MATCH("1003","SUCCESS_MATCH"), //Indicates a successful match
        NO_LOGIN("1100","NO_LOGIN"), //Not logged in
        MANY_LOGINS("1101","MANY_LOGINS"), //Multi-user online (kick out user)
        UPDATE("1102","UPDATE"), //User information or permissions have been updated (log out and log in again)
        LOCK("1111","LOCK"); //User locked
        private String code;
        private String message;

        private SystemStatus(String code,String message){
            this.code = code;
            this.message = message;
        }

        public String getCode(){
            return this.code;
        }

        public String getMessage(){
            return this.message;
        }
    }

}
