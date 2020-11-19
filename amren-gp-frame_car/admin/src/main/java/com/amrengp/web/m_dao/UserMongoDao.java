package com.amrengp.web.m_dao;

import com.amrengp.web.pojo.UserMongo;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * User management Mapper interface
 *
 */
public interface UserMongoDao
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
     * @param userMongo User Management
     * @return User Management Collection
     */
    public List<UserMongo> selectUserList(UserMongo userMongo);

    /**
     * New user management
     * 
     * @param userMongo User Management
     * @return result
     */
    public int insertUser(UserMongo userMongo);

    /**
     * Modify user management
     * 
     * @param userMongo User Management
     * @return result
     */
    public int updateUser(UserMongo userMongo);

    /**
     * Delete user management
     * 
     * @param id User management ID
     * @return result
     */
    public int deleteUserById(String id);

    /**
     * Batch delete user management
     * 
     * @param ids ID of the data to be deleted
     * @return result
     */
    public int deleteUserByIds(String[] ids);
}
