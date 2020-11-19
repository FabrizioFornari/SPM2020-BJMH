package com.amrengp.web.shiro;

import com.amrengp.web.pojo.BaseAdminMongoUser;
import com.amrengp.web.pojo.BaseAdminUser;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * @Title: MyRealm
 * @Description:
 * @version: 1.0
 */
public class MyRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @Autowired
    MongoTemplate mongoTemplate;



    /**
     *
     * Function description: authorization
     *
     * @param:
     * @return:
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        //Authorization
        logger.info("Grant roles and permissions");
        // Add permissions and role information
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // Get the currently logged in user
        /*Subject subject = SecurityUtils.getSubject();
        BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();
        System.out.println(user);
        if (user.getSysUserName().equals("admin")) {
            // Super administrator, add all roles, add all permissions
            authorizationInfo.addRole("*");
            authorizationInfo.addStringPermission("*");
        } else {
            // Ordinary users, query the role of the user, query permissions based on the role
            Integer roleId = user.getRoleId();
            BaseAdminRole role = roleService.findRoleById(roleId);
            if (null != role ) {
                String permissions = role.getPermissions();
                String[] ids = permissions.split(",");
                for (String id : ids) {
                    authorizationInfo.addRole(role.getRoleName());
                    // Permission data corresponding to the role
                    BaseAdminPermission perm = permissionService.getById(id);
                    if (null != perm ) {
                        // All permissions under authorized roles
                        authorizationInfo.addStringPermission(perm.getUrl());
                    }
                }
            }
        }*/
        return authorizationInfo;
    }


    /**
     * Function description: Certification
     * This method is for user verification
     * The doGetAuthenticationInfo method will be called when the currUser.login(token) method is called,
     * The main content of rewriting this method is to match the submitted user name and password to the database. If it matches, it will return an AuthenticationInfo object, otherwise it will return null.
     * The same shiro will help us judge when returning null, an exception will be thrown, and the corresponding logic can be processed according to the exception
     *
     * @param:
     * @return:
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken is used to store the submitted login information
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("User login authentication: the token obtained when verifying the current subject is:" + ReflectionToStringBuilder
                .toString(token, ToStringStyle.MULTI_LINE_STYLE));
        String username = token.getUsername();
        // Call data layer
        Query query = new Query();
        query.addCriteria(new Criteria("sysUserName").is(username));
        BaseAdminMongoUser one = mongoTemplate.findOne(query, BaseAdminMongoUser.class);
        BaseAdminUser sysUser = new BaseAdminUser();
        sysUser.setId(1);
        BeanUtils.copyProperties(one,sysUser);
//        BaseAdminUser sysUser = userService.findByUserName(username);
        logger.info("User login authentication! User information user:" + sysUser);
        if (sysUser == null) {
            // User does not exist
            return null;
        }
        // Return password
        return new SimpleAuthenticationInfo(sysUser, sysUser.getSysUserPwd(), ByteSource.Util.bytes(username), getName());

    }

}
