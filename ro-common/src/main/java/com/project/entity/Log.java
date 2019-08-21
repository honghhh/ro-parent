package com.project.entity;

import java.util.Date;

/**
 * 操作日志记录表
 * @author huangh
 */
public class Log extends Page {

    /** ID */
    private Integer id;

    /** 当前操作人 */
    private String loginaccount;

    /** 当前操作人ip */
    private String loginip;

    /** 操作请求的链接 */
    private String actionurl;

    /** 执行的模块 */
    private String module;

    /** 执行的方法 */
    private String method;

    /** 执行操作时长 */
    private Long actiontime;

    /** 描述 */
    private String description;

    /** 执行开始时间 */
    private Date gmtcreate;

    /** 该操作状态，1表示成功，-1表示失败！ */
    private Integer state;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.id
     *
     * @return the value of log.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.id
     *
     * @param id the value for log.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.loginaccount
     *
     * @return the value of log.loginaccount
     *
     * @mbggenerated
     */
    public String getLoginaccount() {
        return loginaccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.loginaccount
     *
     * @param loginaccount the value for log.loginaccount
     *
     * @mbggenerated
     */
    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.loginip
     *
     * @return the value of log.loginip
     *
     * @mbggenerated
     */
    public String getLoginip() {
        return loginip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.loginip
     *
     * @param loginip the value for log.loginip
     *
     * @mbggenerated
     */
    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.actionurl
     *
     * @return the value of log.actionurl
     *
     * @mbggenerated
     */
    public String getActionurl() {
        return actionurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.actionurl
     *
     * @param actionurl the value for log.actionurl
     *
     * @mbggenerated
     */
    public void setActionurl(String actionurl) {
        this.actionurl = actionurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.module
     *
     * @return the value of log.module
     *
     * @mbggenerated
     */
    public String getModule() {
        return module;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.module
     *
     * @param module the value for log.module
     *
     * @mbggenerated
     */
    public void setModule(String module) {
        this.module = module;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.method
     *
     * @return the value of log.method
     *
     * @mbggenerated
     */
    public String getMethod() {
        return method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.method
     *
     * @param method the value for log.method
     *
     * @mbggenerated
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.actiontime
     *
     * @return the value of log.actiontime
     *
     * @mbggenerated
     */
    public Long getActiontime() {
        return actiontime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.actiontime
     *
     * @param actiontime the value for log.actiontime
     *
     * @mbggenerated
     */
    public void setActiontime(Long actiontime) {
        this.actiontime = actiontime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.description
     *
     * @return the value of log.description
     *
     * @mbggenerated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.description
     *
     * @param description the value for log.description
     *
     * @mbggenerated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.gmtcreate
     *
     * @return the value of log.gmtcreate
     *
     * @mbggenerated
     */
    public Date getGmtcreate() {
        return gmtcreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.gmtcreate
     *
     * @param gmtcreate the value for log.gmtcreate
     *
     * @mbggenerated
     */
    public void setGmtcreate(Date gmtcreate) {
        this.gmtcreate = gmtcreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.state
     *
     * @return the value of log.state
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column log.state
     *
     * @param state the value for log.state
     *
     * @mbggenerated
     */
    public void setState(Integer state) {
        this.state = state;
    }
}