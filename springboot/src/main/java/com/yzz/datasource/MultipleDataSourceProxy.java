package com.yzz.datasource;

import com.google.common.collect.Maps;
import com.mysql.jdbc.StringUtils;
import org.springframework.jdbc.datasource.DelegatingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * Description: 多数据源代理类
 *
 * @Author: 17080012
 * @Date: 2018/7/29
 * modified By:
 *
 */

public class MultipleDataSourceProxy extends DelegatingDataSource {
    private Map<String,DataSource> dataSourceMap = Maps.newConcurrentMap();

    /**无参构造器*/
    public MultipleDataSourceProxy() {
    }

    /**有参构造器*/
    public MultipleDataSourceProxy(DataSource defaultDataSource) {
        super(defaultDataSource);
    }
    /**获取数据源列表*/
    public Map<String, DataSource> getDataSourceMap() {
        return dataSourceMap;
    }

    /**存取数据源名字和数据源*/
    public MultipleDataSourceProxy putDataSource(String dataSourceName, DataSource dataSource){
        dataSourceMap.put(dataSourceName,dataSource);
        return this;
    }

    public void setDataSourceMap(Map<String, DataSource> dataSourceMap) {
        this.dataSourceMap = dataSourceMap;
    }

    /**返回目标数据源*/
    @Override
    public DataSource getTargetDataSource(){
        String name = DynamicDataSourceHolder.getDataSouce();
        if(StringUtils.isNullOrEmpty(name) || dataSourceMap.isEmpty()){
            return super.getTargetDataSource();
        }
        DataSource target = dataSourceMap.get(name);
        return null == target ? super.getTargetDataSource() : target ;
    }

}
