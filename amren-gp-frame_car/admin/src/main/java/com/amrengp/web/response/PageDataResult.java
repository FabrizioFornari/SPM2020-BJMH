package com.amrengp.web.response;

import java.util.List;

/**
 * @Title: PageDataResult
 * @Description: Package DTO paging data (number of records and all records)
 * @version: 1.0
 */
public class PageDataResult {

    private Integer code=200;

    //Total number of records
    private Integer totals;

    private List<?> list;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTotals() {
        return totals;
    }

    public void setTotals(Integer totals) {
        this.totals = totals;
    }

    public List <?> getList() {
        return list;
    }

    public void setList(List <?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageDataResult{" +
                "code=" + code +
                ", totals=" + totals +
                ", list=" + list +
                '}';
    }
}
