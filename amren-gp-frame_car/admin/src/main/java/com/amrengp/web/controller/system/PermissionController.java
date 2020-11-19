package com.amrengp.web.controller.system;


import com.amrengp.web.dto.MenuBO;
import com.amrengp.web.dto.PermissionDTO;
import com.amrengp.web.pojo.BaseAdminUser;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Title: PermissionController
 * @Description: authority management
 * @version: 1.0
 */
@Controller
@RequestMapping("permission")
public class PermissionController {


    @RequestMapping(value = "/Menulist", name = "Menu access", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public List menulist(HttpServletRequest request) {
        try {
            Map<String, Object> data = new HashMap<>();
            BaseAdminUser user = (BaseAdminUser) SecurityUtils.getSubject().getPrincipal();
            //data = permissionService.getUserPerms(user);
            List<PermissionDTO> permissionDTOS = new ArrayList<>(1);
            PermissionDTO father = new PermissionDTO();

            List<PermissionDTO> permissionDTOSChild = new ArrayList<>(1);
            PermissionDTO child = new PermissionDTO();
            child.setId(10);
            child.setName("management");
            child.setPid(9);
            child.setDescpt("management");
            child.setUrl("web/user");
            child.setDelFlag(1);
            permissionDTOSChild.add(child);

            father.setChildrens(permissionDTOSChild);
            father.setId(9);
            father.setName("Parking management");
            father.setPid(0);
            father.setDescpt("Parking management");
            father.setUrl("/");
            father.setDelFlag(1);
            permissionDTOS.add(father);

            data.put("perm", permissionDTOS);

            List<PermissionDTO> permissionList = (List<PermissionDTO>)data.get("perm");
            Iterator<PermissionDTO> iterator = permissionList.iterator();
            while (iterator.hasNext()) {
                PermissionDTO next = iterator.next();
                List<PermissionDTO> children1 = next.getChildrens();
                Iterator<PermissionDTO> iterator1 = children1.iterator();
                while (iterator1.hasNext()) {
                    PermissionDTO next1 = iterator1.next();
                    next1.setChildrens(null);
                }
            }
            return creatMenuBOList(permissionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private List<MenuBO> creatMenuBOList(List<PermissionDTO> resourceBOList) {
        return resourceBOList.stream().map(e -> {
            MenuBO menuBO = new MenuBO();
            if (e != null) {
                menuBO.setId(e.getId());
                menuBO.setTitle(e.getName());
                menuBO.setHref(e.getUrl());
                if (e.getChildrens() != null) {
                    menuBO.setChildren(creatMenuBOList(e.getChildrens()));
                }
            }
            return menuBO;
        }).collect(Collectors.toList());
    }

}
