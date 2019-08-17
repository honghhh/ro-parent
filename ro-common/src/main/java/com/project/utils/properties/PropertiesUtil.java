package com.project.utils.properties;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class PropertiesUtil {

    /**
     * 获取文件名键名对应的值
     * @param filePath 文件名
     * @param keyWord 键名
     * @return
     */
    public static String getProperties(String filePath, String keyWord) {
        ResourceBundle prop = null;
        String value = null;
        try {
            // 通过Spring中的PropertiesLoaderUtils工具类进行获取
            prop = ResourceBundle.getBundle(filePath);
            // 根据关键字查询相应的值
            value = prop.getString(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 获取翻译后的文字
     * @param key 建
     * @param ext 文件后缀
     * @return
     */
    public static String getVal(String key, String ext) {
        /**
         * PropertiesUtil.getVal("login_not_exit", ext)
         * login_not_exit=adsf
         */
        String res = key;
        try {
            String propertiesFiles = "sys-infos";
            // 文件后缀为空 默认为sys-infos_cn文件
            if (StringUtils.isEmpty(ext)) {
                propertiesFiles = "sys-infos_cn";
            } else {
                propertiesFiles = propertiesFiles + ext;
            }
            ResourceBundle rb = ResourceBundle.getBundle(propertiesFiles);
            res = rb.getString(key);
        } catch (Exception e) {
        }
        return res;
    }

    /**
     * 获取翻译后的文字[带参数]
     * @param key 建
     * @param params 参数数组
     * @param ext 文件后缀
     * @return
     */
    public static String getVal(String key, String[] params, String ext) {
        /**
         * PropertiesUtil.getVal("login_not_exit","asdfksfjl", ext);
         * login_not_exit={0}adfdsf
         */
        String msg = key;
        try {
            String propertiesFiles = "sys-infos";
            // 文件后缀为空 默认为sys-infos_cn文件
            if (StringUtils.isBlank(ext)) {
                propertiesFiles = "sys-infos_cn";
            } else {
                propertiesFiles = propertiesFiles + ext;
            }
            ResourceBundle rb = ResourceBundle.getBundle(propertiesFiles);
            String res = rb.getString(key);
            msg = MessageFormat.format(res, params);
        } catch (Exception e) {
        }
        return msg;
    }
}
