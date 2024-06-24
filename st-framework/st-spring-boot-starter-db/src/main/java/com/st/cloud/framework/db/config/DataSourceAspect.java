package com.st.cloud.framework.db.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static com.st.cloud.framework.db.config.DataSourceContextHolder.DataSourceType.SLAVE;

@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(ReadOnly)")
    public void readOnlyOperation() {}

    @Before("readOnlyOperation()")
    public void setSlaveDataSource() {
        DataSourceContextHolder.setDataSourceType(SLAVE);
    }

    @After("readOnlyOperation()")
    public void clearDataSource() {
        DataSourceContextHolder.clearDataSourceType();
    }
}