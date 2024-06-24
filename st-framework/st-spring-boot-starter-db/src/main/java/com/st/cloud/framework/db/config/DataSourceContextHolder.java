package com.st.cloud.framework.db.config;

public class DataSourceContextHolder {
    public enum DataSourceType {
        MASTER, SLAVE
    }

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(DataSourceType dataSourceType) {
        contextHolder.set(dataSourceType);
    }

    public static DataSourceType getDataSourceType() {
        return contextHolder.get() != null ? contextHolder.get() : DataSourceType.MASTER;
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }
}
