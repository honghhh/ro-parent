package com.project.entity;

import java.io.Serializable;

/**
 * @description 分页对象
 * @author: huangh
 * @since 2019-09-02 15:39
 */
public class Page implements Serializable {

    /** 当前页 */
    private Integer page = 1;

    /** 每页显示条数 */
    private Integer rows = 10;

    /** 是否分页 0不分页 1分页 */
    private boolean ispage = true;

    /** 页数 */
    private Integer pageNum;

    /** 条数 */
    private Integer total;

    /** 开始时间 */
    private String startTime;

    /** 结束时间 */
    private String endTime;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public boolean isIspage() {
        return ispage;
    }

    public void setIspage(boolean ispage) {
        this.ispage = ispage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
