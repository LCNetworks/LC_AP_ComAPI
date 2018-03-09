package cn.com.project.common.controller;

import cn.com.project.common.service.CommonMssqlService;
import cn.com.project.common.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lpc on 2018-03-06.
 */

public class CommonController {
    private JdbcTemplate jdbcTemplate;
    private CommonService csvc;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        csvc = new CommonMssqlService();
        csvc.setJt(this.jdbcTemplate);
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> getInfomation() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("version", "0.0.1");
        map.put("description", "Function Or Bug:公共管理模块\n" +
                "    Symptom: 公共管理模块" +
                "    Root Cause: N/A\n" +
                "    Solution:  1.0.0\n" +
                "    Note:  N/A");
        return map;
    }

}
