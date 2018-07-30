package com.yzz.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Description:
 *
 * @Author: 17080012
 * @Date: 2018/7/29
 * modified By:
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    private final static Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);

    @Override
    protected Object determineCurrentLookupKey() {
        String name = DynamicDataSourceHolder.getDataSouce();
        return name;
    }
}
