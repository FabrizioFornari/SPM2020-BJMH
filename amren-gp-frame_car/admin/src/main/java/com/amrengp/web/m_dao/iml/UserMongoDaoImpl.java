package com.amrengp.web.m_dao.iml;

import com.amrengp.web.m_dao.UserMongoDao;
import com.amrengp.web.pojo.UserMongo;
import com.gp.common.utils.StringUtils;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

/**
 * User management Mapper interface
 * @date 2020-11-17
 */
@Component
public class UserMongoDaoImpl implements UserMongoDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public UserMongo selectUserById(String id) {
        return mongoTemplate.findById(id, UserMongo.class);
    }

    @Override
    public List<UserMongo> selectUserList(UserMongo userMongo) {
        // Get all the attributes of the entity class and return the Field array
        Query query = new Query();

        // Use reflection to get the attribute value of the empty part
        Field[] field = userMongo.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            Field f = field[i];
            // Set some properties are accessible
            f.setAccessible(true);
            try {
                Object object = f.get(userMongo);
                if (object != null && StringUtils.isNotBlank(object.toString())) {
                    query.addCriteria(new Criteria(f.getName()).is(object));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        List<UserMongo> list = ( List<UserMongo> )mongoTemplate.find(query,userMongo.getClass());
        return list;
    }

    @Override
    public int insertUser(UserMongo userMongo) {
        UserMongo insert = mongoTemplate.insert(userMongo);
        return 1;
    }

    @Override
    public int updateUser(UserMongo userMongo) {
        Update update = new Update();
        // Get all the attributes of the entity class and return the Field array
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(userMongo.getId()));
        // Use reflection to get the attribute value of the empty part
        Field[] field = userMongo.getClass().getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            Field f = field[i];
            // Set some properties are accessible
            f.setAccessible(true);
            try {
                Object object = f.get(userMongo);
                if (object != null) {
                    update.set(f.getName(), object);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        UpdateResult updateResult = this.mongoTemplate.updateFirst(query, update, userMongo.getClass());
        return (Integer.parseInt(updateResult.getModifiedCount() + ""));
    }

    @Override
    public int deleteUserById(String id) {
        Query query = new Query();
        query.addCriteria(new Criteria("_id").is(id));
        DeleteResult remove = mongoTemplate.remove(query, UserMongo.class);
        return (Integer.parseInt(remove.getDeletedCount() + ""));
    }

    @Override
    public int deleteUserByIds(String[] ids) {
        for (String id : ids) {
            deleteUserById(id);
        }
        return 1;
    }
}
