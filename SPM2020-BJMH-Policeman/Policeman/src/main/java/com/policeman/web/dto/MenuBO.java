package com.policeman.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class MenuBO {
    private Integer id;
    //Menu name
    private String title;
    //Menu path
    private String href;
    //Menu icon
    private String icon="&#xe609;";
    //Parent menu id
    private Long parentId;
    //Submenu
    private List<MenuBO> children = new ArrayList();
    //Parent menu
    @JsonIgnore
    private MenuBO parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public List<MenuBO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuBO> children) {
        this.children = children;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public MenuBO getParent() {
        return parent;
    }

    public void setParent(MenuBO parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "MenuBO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", icon='" + icon + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                ", parent=" + parent +
                '}';
    }
}