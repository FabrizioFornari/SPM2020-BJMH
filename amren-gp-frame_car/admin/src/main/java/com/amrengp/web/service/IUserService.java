package com.amrengp.web.service;

import java.util.List;
import com.amrengp.web.pojo.User;

/**
 * User Management Service Interface
 *
 * @date 2020-11-17
 */
public interface IUserService 
{
    /**
     * Query user management
     * 
     * @param id User management ID
     * @return User Management
     */
    public User selectUserById(Long id);

    /**
     * Query user management list
     * 
     * @param user User Management
     * @return User Management Collection
     */
    public List<User> selectUserList(User user);

    /**
     * New user management
     * 
     * @param user User Management
     * @return result
     */
    public int insertUser(User user);

    /**
     * Modify user management
     * 
     * @param user User Management
     * @return result
     */
    public int updateUser(User user);

    /**
     * Batch delete user management
     * 
     * @param ids ID of the data to be deleted
     * @return result
     */
    public int deleteUserByIds(String ids);

    /**
     * Delete user management information
     * 
     * @param id User management ID
     * @return result
     */
    public int deleteUserById(Long id);
}
