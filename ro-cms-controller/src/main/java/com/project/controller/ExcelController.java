package com.project.controller;

import com.project.entity.Log;
import com.project.service.ExcelService;
import com.project.utils.ExcelMapping;
import com.project.utils.StaticUtils;
import com.project.utils.date.DateUtil;
import com.project.utils.excel.ExportUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @description 导出Handle
 * @author: huangh
 * @since 2019-09-05 15:29
 */
@Controller
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    /**
     * 导出操作日志列表
     * @param response 响应对象
     * @param log 搜索信息
     * @return void
     */
    @RequestMapping(value = ExcelMapping.EXPORT_LOG_LIST)
    public void exportLogList(HttpServletResponse response, Log log) {
        log.setRows(StaticUtils.EXCEL_MAX_LINE);
        List<Log> list = excelService.queryLogList(log);
        HSSFWorkbook wb = excelService.exportLogList(list);
        ExportUtil export = ExportUtil.getInstance();
        String fileName = "操作日志列表_" + DateUtil.toDateString(new Date()) + ".xls";
        export.exportFiles(response,fileName,wb);
    }
}
