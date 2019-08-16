package com.project.rest;

import java.io.Serializable;

public class RestResponse implements Serializable {
    private static final long serialVersionUID = 7929905752016924917L;
    private boolean status;
    private String desc;
    private Object data;
    private String flag;

    public RestResponse() {
    }

    public RestResponse(boolean status) {
        this.status = status;
    }

    public RestResponse(boolean status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public RestResponse(boolean status, String desc, Object data, String flag) {
        this.status = status;
        this.desc = desc;
        this.data = data;
        this.flag = flag;
    }

    public RestResponse(boolean status, String desc, Object data) {
        this.status = status;
        this.desc = desc;
        this.data = data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getFlag() {
        return this.flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
