package com.project.service;

import com.project.entity.Log;
import com.project.utils.date.DateUtil;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 导出业务
 * @author: huangh
 * @since 2019-09-05 15:30
 */
@Service
public class ExcelService {

    @Autowired
    private LogService logService;

    /**
     * 获取操作日志列表
     * @param log 搜索信息
     * @return java.util.List<com.project.entity.Log>
     */
    public List<Log> queryLogList(Log log) {
        return logService.queryLogList(log);
    }

    /**
     * 导出操作日志列表
     * @param list 操作日志列表
     * @return org.apache.poi.hssf.usermodel.HSSFWorkbook
     */
    public HSSFWorkbook exportLogList(List<Log> list) {
        // 行数
        int row_num = 0;
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet("操作日志列表");
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        // 创建一个居中格式
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 标题
        HSSFRow row_header = sheet.createRow(row_num++);
        String[] headers = { "管理员", "ip", "请求链接", "执行模块", "执行方法", "执行时长", "描述", "执行时间", "状态" };
        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row_header.createCell((short) i);
            // 设置cell编码解决中文高位字节截断
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
        }
        // 3.单元格应用样式
        HSSFRow row_data;
        for (Log log : list) {
            row_data = sheet.createRow(row_num++);
            //
            HSSFCell cell = row_data.createCell((short) 0);
            cell.setCellValue(log.getLoginaccount());
            //
            cell = row_data.createCell((short) 1);
            cell.setCellValue(log.getLoginip());
            //
            cell = row_data.createCell((short) 2);
            cell.setCellValue(log.getActionurl());
            //
            cell = row_data.createCell((short) 3);
            cell.setCellValue(log.getModule());
            //
            cell = row_data.createCell((short) 4);
            cell.setCellValue(log.getMethod());
            //
            cell = row_data.createCell((short) 5);
            cell.setCellValue(log.getActiontime().toString());
            //
            cell = row_data.createCell((short) 6);
            cell.setCellValue(log.getDescription());
            //
            cell = row_data.createCell((short) 7);
            cell.setCellValue(DateUtil.toDateString(log.getGmtcreate()));
            //
            cell = row_data.createCell((short) 8);
            cell.setCellValue(log.getState() == 1 ? "成功" : "失败");
        }
        return wb;
    }
}
