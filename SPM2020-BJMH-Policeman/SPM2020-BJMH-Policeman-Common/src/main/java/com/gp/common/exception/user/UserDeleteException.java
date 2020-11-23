package com.gp.common.exception.user;

/**
 * 用户账号已被Delete
 * 
 * @author amren
 */
public class UserDeleteException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserDeleteException()
    {
        super("user.password.delete", null);
    }
}
