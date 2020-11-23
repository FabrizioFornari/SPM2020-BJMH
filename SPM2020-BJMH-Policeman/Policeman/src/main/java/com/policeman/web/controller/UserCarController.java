package com.policeman.web.controller;

import java.util.List;

import com.policeman.web.pojo.User;
import com.policeman.web.service.IUserMongoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.gp.common.annotation.Log;
import com.gp.common.enums.BusinessType;
import com.policeman.web.pojo.UserMongo;
import com.gp.common.core.controller.BaseController;
import com.gp.common.core.domain.AjaxResult;
import com.gp.common.utils.poi.ExcelUtil;
import com.gp.common.core.page.TableDataInfo;

/**
 * User Management Controller
 * 
 * @author amren
 * @date 2020-11-17
 */
@Controller
@RequestMapping("/web/user")
public class UserCarController extends BaseController
{
    private String prefix = "web/user";

    @Autowired
    private IUserMongoService iUserMongoService;

    @GetMapping()
    public String UserMongo()
    {
        return prefix + "/user";
    }

    /**
     * Query user management list
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserMongo UserMongo)
    {
        startPage();
        List<UserMongo> list = iUserMongoService.selectUserList(UserMongo);
        return getDataTable(list);
    }

    /**
     * Export user management list
     */
    @Log(title = "User Management", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserMongo UserMongo)
    {
        List<UserMongo> list = iUserMongoService.selectUserList(UserMongo);
        ExcelUtil<UserMongo> util = new ExcelUtil<UserMongo>(UserMongo.class);
        return util.exportExcel(list, "UserMongo");
    }

    /**
     * New user management
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * Added save user management
     */
    @Log(title = "User Management", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserMongo UserMongo)
    {
        return toAjax(iUserMongoService.insertUser(UserMongo));
    }

    /**
     * Modify user management
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        UserMongo userMongo = iUserMongoService.selectUserById(id);
        User user = new User();
        BeanUtils.copyProperties(userMongo, user);
        mmap.put("user", userMongo);
        return prefix + "/edit";
    }

    /**
     * Modify and save user management
     */
    @Log(title = "User Management", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserMongo UserMongo)
    {
        return toAjax(iUserMongoService.updateUser(UserMongo));
    }

    /**
     * Delete user management
     */
    @Log(title = "User Management", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(iUserMongoService.deleteUserByIds(ids));
    }
}
