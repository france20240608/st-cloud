package com.st.cloud.framework.db.datasource;

import cn.hutool.core.util.ObjectUtil;
import com.zaxxer.hikari.HikariConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Slf4j
@AutoConfiguration
public class TiDBDataSourceConfig implements InitializingBean {

    private final HikariConfig hikariConfig;

    // 用构造方法注入
    public TiDBDataSourceConfig(HikariConfig hikariConfig) {
        this.hikariConfig = hikariConfig;
    }

    @Override
    public void afterPropertiesSet(){
        log.debug("TiDBDataSourceConfig afterPropertiesSet start {} ", hikariConfig.getConnectionInitSql());
        if (ObjectUtil.isNotNull(hikariConfig)) {
            log.debug("TiDBDataSourceConfig afterPropertiesSet setting");
            try {
                // TODO nacos存储加密值的时候，在这里解密
                hikariConfig.setUsername(hikariConfig.getUsername());
                hikariConfig.setPassword(hikariConfig.getPassword());
            } catch (Exception e) {
                log.error("解密数据库信息错误，解密前账号：{}, 密码：{}", hikariConfig.getUsername(), hikariConfig.getPassword(), e);
            }
        }
        log.debug("TiDBDataSourceConfig afterPropertiesSet end");
    }
}
