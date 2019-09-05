package com.project.utils;

import com.alibaba.fastjson.JSONObject;
import com.project.rest.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @description 常用工具类
 * @author: huangh
 * @since 2019-09-02 16:08
 */
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

    /**
     * 返回信息给客户端
     * @param response
     * @param restResponse
     * @return
     */
    public static  void responseMessage(HttpServletResponse response, RestResponse restResponse) {
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(restResponse);
        out.print(json);
        out.flush();
        out.close();
    }

    /**
     * 上传单个图片到webapp/images/upload文件夹下
     * @param request 请求对象
     * @param file 图片信息
     * @return java.lang.String
     */
    public static String uploadOneImages(HttpServletRequest request, MultipartFile file) {
        StringBuffer purls = new StringBuffer();
        try {
            // webapp目录
            String java = "src\\main\\webapp";
            // webapp下的保存图片保存目录
            String uploadDir = "\\images\\upload";

            // 获取项目编译的目录
            String realPath = request.getSession().getServletContext().getRealPath("/");

            // 获取项目根目录(替换编译目录为空)
            // D: \ java \ workspace_idea \ ro-parent \ ro-cms-controller \
            realPath = realPath.replace("target\\ro-cms-controller", "");
            System.out.println("打印项目根目录" + realPath);

            // 获取图片保存全目录(根目录+webapp目录+webapp下的图片保存目录)
            // D: \ java \ workspace_idea \ ro-parent \ ro-cms-controller \ src \ main \ webapp \ images \ upload
            realPath = realPath + java + uploadDir;
            System.out.println("打印图片保存全目录" + realPath);

            // 如果当前项目里不存在images文件夹，就创建
            File fileUrl = new File(realPath);
            if (!fileUrl.exists()) {
                fileUrl.mkdir();
            }

            // 上传图片的原名称
            String filename = file.getOriginalFilename();
            // 图片后缀名
            String ext = filename.substring(filename.lastIndexOf(".") + 1);
            // 保存到数据库的图片全名带后缀 唯一
            String purlName = String.valueOf(System.currentTimeMillis()) + "." + ext;
            // 创建File对象，传入目标路径参数，和新的文件别名
            String purl = realPath + "\\" + purlName;
            System.out.println("打印图片保存路径" + purl);

            // 将上传的图片复制到purl路径下
            file.transferTo(new File(purl));
            // 数据库保存路径(webapp下的图片保存目录 + "/" + 图片名称带后缀 + ",")
            uploadDir = uploadDir.replace("\\", "/") + "/" + purlName + ",";
            purls.append(uploadDir);
            System.out.println("打印数据库保存路径" + uploadDir);

            // 去掉最后一个，号
            purls.setLength(purls.length() - 1);
            System.out.println("返回路径" + purls);
            return purls.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 上传多张图片到webapp/images/upload文件夹下
     * @param request 请求对象
     * @param files 图片信息数组
     * @return java.lang.String
     */
    public static String uploadMoreImages(HttpServletRequest request, MultipartFile[] files) {
        StringBuffer purls = new StringBuffer();
        try {
            // webapp目录
            String java = "src\\main\\webapp";
            // webapp下的保存图片保存目录
            String uploadDir = "\\images\\upload";

            // 获取项目编译的目录
            String realPath = request.getSession().getServletContext().getRealPath("/");

            // 获取项目根目录(替换编译目录为空)
            // D: \ java \ workspace_idea \ ro-parent \ ro-cms-controller \
            realPath = realPath.replace("target\\ro-cms-controller", "");
            System.out.println("打印项目根目录" + realPath);

            // 获取图片保存全目录(根目录+webapp目录+webapp下的图片保存目录)
            // D: \ java \ workspace_idea \ ro-parent \ ro-cms-controller \ src \ main \ webapp \ images \ upload
            realPath = realPath + java + uploadDir;
            System.out.println("打印图片保存全目录" + realPath);

            // 如果当前项目里不存在images文件夹，就创建
            File fileUrl = new File(realPath);
            if (!fileUrl.exists()) {
                fileUrl.mkdir();
            }

            // 循环上传文件
            for (MultipartFile file : files) {
                // 上传图片的原名称
                String filename = file.getOriginalFilename();
                // 图片后缀名
                String ext = filename.substring(filename.lastIndexOf(".") + 1);
                // 保存到数据库的图片全名带后缀 唯一
                String purlName = String.valueOf(System.currentTimeMillis()) + "." + ext;
                // 创建File对象，传入目标路径参数，和新的文件别名
                String purl = realPath + "\\" + purlName;
                System.out.println("打印图片保存路径" + purl);

                // 将上传的图片复制到purl路径下
                file.transferTo(new File(purl));
                // 数据库保存路径(webapp下的图片保存目录 + "/" + 图片名称带后缀 + ",")
                uploadDir = uploadDir.replace("\\", "/") + "/" + purlName + ",";
                purls.append(uploadDir);
                System.out.println("打印数据库保存路径" + uploadDir);
            }
            // 去掉最后一个，号
            purls.setLength(purls.length() - 1);
            System.out.println("返回路径" + purls);
            return purls.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
