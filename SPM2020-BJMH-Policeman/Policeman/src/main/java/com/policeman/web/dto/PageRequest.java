package com.policeman.web.dto;


/**
 * @Title:
 * @Description:
 * @version:
 */
public class PageRequest {
    /** Default page size */
    public static Integer		DEFAULT_PAGE_SIZE = 10;

    /** Default page number */
    public static Integer		DEFAULT_PAGE_NUM  = 1;

    private Integer pageNum;
    private Integer pageSize;


    public Integer getPageNum() {
        return pageNum <= 0 ? DEFAULT_PAGE_NUM : pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize <= 0 ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
