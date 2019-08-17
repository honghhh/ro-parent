package com.project.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * 语种
 */
public enum LanguageEnums {

    Chinese("", "中文", "CN"),
    Traditional("_trad", "繁體", "TRAD"),
    English("_en", "English", "EN");

    private String ext;
    private String name;
    private String abb;

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbb() {
        return abb;
    }

    public void setAbb(String abb) {
        this.abb = abb;
    }

    private LanguageEnums(String ext, String name, String ab) {
        this.ext = ext;
        this.name = name;
        this.abb = ab;
    }

    public static List<LanguageEnums> queryList() {
        List<LanguageEnums> list = new ArrayList<LanguageEnums>();
        for (LanguageEnums o : LanguageEnums.values()) {
            list.add(o);
        }
        return list;
    }

    public static String getName(String ext) {
        String str = "";
        for (LanguageEnums o : LanguageEnums.values()) {
            if (o.getExt().equals(ext)) {
                str = o.getName();
                break;
            }
        }
        return str;
    }

    /**
     * 获取abb字段等于传入的值的对象的后缀ext字段
     */
    public static String getExt(String ab) {
        String str = "";
        for (LanguageEnums o : LanguageEnums.values()) {
            if (o.getAbb().equals(ab)) {
                str = o.getExt();
                break;
            }
        }
        return str;
    }
}
