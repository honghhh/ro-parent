package com.project.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FunctionUtils {

    /**
     * 获取唯一编号
     * @param a
     * @return
     */
    public static final String getOrderCode(String a) {
        String time;
        java.util.Calendar cal = new java.util.GregorianCalendar();
        int random = (int) (Math.random() * 900) + 100;
        time = "" + a + cal.get(Calendar.HOUR) + String.valueOf(random).charAt(0) + cal.get(Calendar.MINUTE) + String.valueOf(random).charAt(1) + cal.get(Calendar.SECOND)
                + String.valueOf(random).charAt(2) + cal.get(Calendar.MILLISECOND);
        return time;
    }

    /**
     * 获取订单号
     * @param a
     * @param b
     * @return
     */
    public static final String getOrderCode(int a, int b) {
        String time;
        java.util.Calendar cal = new java.util.GregorianCalendar();
        int random = (int) (Math.random() * 900) + 100;
        time = "" + a + b + cal.get(Calendar.HOUR) + String.valueOf(random).charAt(0) + cal.get(Calendar.MINUTE) +
                String.valueOf(random).charAt(1) + cal.get(Calendar.SECOND) + String.valueOf(random).charAt(2) + cal.get(Calendar.MILLISECOND);
        return time;
    }

    /**
     * 获取本机IP
     * @param request
     * @return
     */
    public static String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * BigDecimal 加减乘除
     */
    /**
     * 加
     * @param a1    加数
     * @param a2    被加数
     * @param index 保留位数
     * @return 四舍五入 保留两位小数
     */
    public static BigDecimal add(BigDecimal a1, BigDecimal a2, int index) {
        return a1.add(a2).setScale(index, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 减
     * @param a1    减数
     * @param a2    被减数
     * @param index 保留位数
     * @return 四舍五入 保留两位小数
     */
    public static BigDecimal sub(BigDecimal a1, BigDecimal a2, int index) {
        return a1.subtract(a2).setScale(index, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 乘
     * @param a1    乘数
     * @param a2    被乘数
     * @param index 保留位数
     * @return 四舍五入 保留两位小数
     */
    public static BigDecimal mul(BigDecimal a1, BigDecimal a2, int index) {
        return a1.multiply(a2).setScale(index, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 除
     * @param d1    除数
     * @param d2    被除数
     * @param index 保留位数
     * @return 四舍五入 保留两位小数
     */
    public static BigDecimal div(BigDecimal d1, BigDecimal d2, int index) {
        if (d2.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return d1.divide(d2, index, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 判断两个int类型的是否相等
     * @param a
     * @param b
     * @return
     */
    public static boolean isEquals(Integer a, Integer b) {
        if (a == null) {
            if (b.equals(a) || b == a) {
                return true;
            }
        } else {
            if (a.equals(b) || b == a) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串数组转list int对象
     * @param arr
     * @return
     */
    public static List<Integer> getIntegerList(String[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                Integer a = Integer.parseInt(s);
                list.add(a);
            }
        }
        return list;
    }

    /**
     * 字符串数组转list int对象
     * @param arr
     * @return
     */
    public static List<String> getStringList(String[] arr) {
        List<String> list = new ArrayList<String>();
        for (String s : arr) {
            if (!StringUtils.isEmpty(s)) {
                list.add(s);
            }
        }
        return list;
    }

    /***
     * 数组(逗号分隔)转list String对象
     * @param str
     * @param reg
     * @return
     */
    public static List<String> getStringList(String str, String reg) {
        List<String> StringList = new ArrayList<String>();
        if (!StringUtils.isBlank(str)) {
            String[] split = str.split(reg);
            for (String item : split) {
                if (!StringUtils.isBlank(item)) {
                    StringList.add(item);
                }
            }
        }
        return StringList;
    }

    /**
     * 判断所传的集合是否为空
     * @param val
     * @return
     */
    public static <T> List<T> getList(List<T> val) {
        if (val == null || val.size() < 1) {
            val = new ArrayList<T>();
        }
        return val;
    }
}
