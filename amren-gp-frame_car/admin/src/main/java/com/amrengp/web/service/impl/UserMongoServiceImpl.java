package com.amrengp.web.service.impl;

import com.amrengp.web.m_dao.UserMongoDao;
import com.amrengp.web.pojo.User;
import com.amrengp.web.pojo.UserMongo;
import com.amrengp.web.service.IUserMongoService;
import com.gp.common.core.text.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User management Service business layer processing
 *
 * @date 2020-11-17
 */
@Service
public class UserMongoServiceImpl implements IUserMongoService
{
    @Autowired
    private UserMongoDao userMongoDao;

    /**
     * Query user management
     * 
     * @param id User management ID
     * @return User Management
     */
    @Override
    public UserMongo selectUserById(String id)
    {
        return userMongoDao.selectUserById(id);
    }

    /**
     * Query user management list
     * 
     * @param user User Management
     * @return User Management
     */
    @Override
    public List<UserMongo> selectUserList(UserMongo user)
    {
        return userMongoDao.selectUserList(user);
    }

    /**
     * New user management
     * 
     * @param user User Management
     * @return User Management
     */
    @Override
    public int insertUser(UserMongo user)
    {
        return userMongoDao.insertUser(user);
    }

    /**
     * Modify user management
     * 
     * @param user User Management
     * @return result
     */
    @Override
    public int updateUser(UserMongo user)
    {
        return userMongoDao.updateUser(user);
    }

    /**
     * Delete user management object
     * 
     * @param ids Delete user management object
     * @return result
     */
    @Override
    public int deleteUserByIds(String ids)
    {
        return userMongoDao.deleteUserByIds(Convert.toStrArray(ids));
    }

    /**
     * Delete user management information
     * 
     * @param id User management ID
     * @return result
     */
    @Override
    public int deleteUserById(String id)
    {
        return userMongoDao.deleteUserById(id);
    }
}
