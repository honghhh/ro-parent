package com.project.utils.export;

import com.project.exception.ThrowJsonException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @description 导出工具类
 * @author: huangh
 * @since 2019-09-05 15:45
 */
public class ExportUtil {

    private static ExportUtil exportUtil = null;

    public static ExportUtil getInstance() {
        if (exportUtil == null) {
            synchronized (ExportUtil.class) {
                if (exportUtil == null) {
                    exportUtil = new ExportUtil();
                }
            }
        }
        return exportUtil;
    }

    /**
     * 导出Excel文件
     * @param response /
     * @param fileName 文件名
     * @param wb HSSFWorkbook对象
     * @author leehao
     * @return void
     */
    public void exportFiles(HttpServletResponse response, String fileName, HSSFWorkbook wb) {
        try {
            response.setContentType("application/multipart");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "iso8859-1"));
            OutputStream out = response.getOutputStream();
            wb.write(out);
            out.flush();
            out.close();
        } catch (Exception e) {
            throw new ThrowJsonException("导出文件失败");
        }
    }
}
