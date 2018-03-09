package cn.com.project.common.service;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by lpc on 2018-03-06.
 */
public interface CommonService {

    public void setJt(JdbcTemplate jt);
    public Integer excuteUpdate(String sql);

}
