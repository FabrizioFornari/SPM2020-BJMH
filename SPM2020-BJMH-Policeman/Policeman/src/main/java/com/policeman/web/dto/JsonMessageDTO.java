package com.policeman.web.dto;

/**
 * @Author amrengp
 * @Date 2018/10/22 10:57
 */
public class JsonMessageDTO {

    private static final String DEFAULT_SUCCESS_MSG = "Successful operation";

    private static final String DEFAULT_FAILED_MSG = "operation failed";

    private boolean flag;

    private String msg;

    public JsonMessageDTO() {
        super();
    }

    public JsonMessageDTO(boolean flag) {
        this.flag = flag;
        if (flag) {
            this.msg = DEFAULT_SUCCESS_MSG;
        } else {
            this.msg = DEFAULT_FAILED_MSG;
        }
    }

    public JsonMessageDTO(boolean flag, String msg) {
        super();
        this.flag = flag;
        this.msg = msg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonMessage [flag=" + flag + ", msg=" + msg + "]";
    }

}
