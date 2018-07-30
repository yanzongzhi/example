package com.yzz.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 *
 * @Author: 17080012
 * @Date: 2018/7/29
 * modified By:
 */

public class DynamicDataSourceHolder {
    private final static Logger LOGGER = LoggerFactory.getLogger(DynamicDataSourceHolder.class);
    /**存储线程获取的数据源的名字*/
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 设置数据源
     * @param name 数据源名
     */
    public static void putDataSource(String name) {
        LOGGER.debug("put datasource name:" + name);
        holder.set(name);
    }
    /**
     * 获取数据源
     * @return 数据源
     */
    public static String getDataSouce() {
        LOGGER.debug("get datasource from ThreadLocal variable.");
        return holder.get();
    }

    public static void remove() {
        LOGGER.debug("get datasource from ThreadLocal variable.");
        holder.remove();
    }

}
