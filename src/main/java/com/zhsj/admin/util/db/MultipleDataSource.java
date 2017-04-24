package com.zhsj.admin.util.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by lcg on 16/12/13.
 */
public class MultipleDataSource extends AbstractRoutingDataSource {


    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal();

    public MultipleDataSource() {
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String dsName = (String)dataSourceKey.get();
//        dataSourceKey.remove();
        return dsName;
    }

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
}
