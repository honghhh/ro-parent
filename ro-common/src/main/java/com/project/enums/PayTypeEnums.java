package com.project.enums;

import com.project.utils.FunctionUtils;

public enum PayTypeEnums {

    wx(1,"微信"),
    alipay(2,"支付宝"),
    balance(3,"余额");

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private PayTypeEnums(Integer id,String name) {
        this.id=id;
        this.name=name;
    }

    public static String getName(Integer id) {
        String name="";
        for(PayTypeEnums p:PayTypeEnums.values()) {
            if(FunctionUtils.isEquals(p.getId(), id)) {
                name=p.getName();
                break;
            }
        }
        return name;
    }
}
