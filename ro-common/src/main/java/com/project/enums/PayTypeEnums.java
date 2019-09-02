package com.project.enums;

import com.project.utils.FunctionUtils;

/**
 * @description 支付类型
 * @author: huangh
 * @since 2019-09-02 15:40
 */
public enum PayTypeEnums {

    /**
     * 微信
     */
    wx(1, "微信"),
    /**
     * 支付宝
     */
    alipay(2, "支付宝"),
    /**
     * 余额
     */
    balance(3, "余额");

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

    private PayTypeEnums(Integer id, String name) {
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
