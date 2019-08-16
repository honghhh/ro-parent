package com.project.rest;

import java.io.Serializable;

public abstract class GetRest implements Serializable {
    private static final long serialVersionUID = 4156472221941702383L;

    public GetRest() {
    }

    public static RestResponse getFail(String desc) {
        RestResponse rest = new RestResponse();
        rest.setStatus(false);
        rest.setData("");
        rest.setDesc(desc);
        return rest;
    }

    public static RestResponse getFail(String desc, Object data) {
        RestResponse rest = new RestResponse();
        rest.setStatus(false);
        rest.setData(data);
        rest.setDesc(desc);
        return rest;
    }

    public static RestResponse getFail(String desc, Object data, String flag) {
        RestResponse rest = new RestResponse();
        rest.setStatus(false);
        rest.setData(data);
        rest.setDesc(desc);
        rest.setFlag(flag);
        return rest;
    }

    public static RestResponse getSuccess(String desc, Object data) {
        RestResponse rest = new RestResponse();
        rest.setStatus(true);
        rest.setData(data);
        rest.setDesc(desc);
        return rest;
    }

    public static RestResponse getSuccess(String desc, Object data, String flag) {
        RestResponse rest = new RestResponse();
        rest.setStatus(true);
        rest.setData(data);
        rest.setDesc(desc);
        rest.setFlag(flag);
        return rest;
    }

    public static RestResponse getSuccess(String desc) {
        RestResponse rest = new RestResponse();
        rest.setStatus(true);
        rest.setData("");
        rest.setDesc(desc);
        return rest;
    }

    public static RestResponse getRestResponse(boolean status, String desc, Object data) {
        RestResponse rest = new RestResponse();
        rest.setStatus(status);
        rest.setData(data);
        rest.setDesc(desc);
        return rest;
    }

    public static RestResponse getRestResponse(boolean status, String desc, Object data, String flag) {
        RestResponse rest = new RestResponse();
        rest.setStatus(status);
        rest.setData(data);
        rest.setDesc(desc);
        rest.setFlag(flag);
        return rest;
    }
}
