package cn.com.project.common.service;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by lpc on 2018-03-06.
 */
public class CommonMssqlService implements CommonService {
    private JdbcTemplate jt;
    private CommonService commonService;

    public CommonMssqlService() {
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
        this.commonService = new CommonMssqlService();
        this.commonService.setJt(jt);
    }

    @Override
    public Integer excuteUpdate(String sql) {
        return this.jt.update(sql);
    }


}
