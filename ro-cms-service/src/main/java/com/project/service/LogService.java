package com.project.service;

import com.github.pagehelper.PageHelper;
import com.project.dao.LogMapper;
import com.project.entity.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description 操作日志业务
 * @author: huangh
 * @since 2019-09-05 11:33
 */
@Service
public class LogService {

    @Autowired
    private LogMapper logMapper;

    /**
     * 获取操作日志列表
     * @param log 搜索信息
     * @return java.util.List<com.project.entity.Log>
     */
    public List<Log> queryLogList(Log log) {
        if (log.isIspage()) {
            PageHelper.startPage(log.getPage(), log.getRows());
        }
        if (!StringUtils.isBlank(log.getQueryTime())) {
            String[] times = log.getQueryTime().split("~");
            log.setStartTime(times[0].trim());
            log.setEndTime(times[1].trim());
        }
        List<Log> list = logMapper.queryList(log);
        return list;
    }
}
