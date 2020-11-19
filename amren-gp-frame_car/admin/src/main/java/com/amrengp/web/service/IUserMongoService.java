package com.amrengp.web.service;

import com.amrengp.web.pojo.UserMongo;

import java.util.List;

/**
 * User Management Service Interface
 *
 * @date 2020-11-17
 */
public interface IUserMongoService 
{
    /**
     * Query user management
     * 
     * @param id User management ID
     * @return User Management
     */
    public UserMongo selectUserById(String id);

    /**
     * Query user management list
     * 
     * @param UserMongo User Management
     * @return User Management Collection
     */
    public List<UserMongo> selectUserList(UserMongo UserMongo);

    /**
     * New user management
     * 
     * @param UserMongo User Management
     * @return result
     */
    public int insertUser(UserMongo UserMongo);

    /**
     * Modify user management
     * 
     * @param UserMongo User Management
     * @return result
     */
    public int updateUser(UserMongo UserMongo);

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
    public int deleteUserById(String id);
}
