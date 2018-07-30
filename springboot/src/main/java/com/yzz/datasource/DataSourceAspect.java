package com.yzz.datasource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @Author: 17080012
 * @Date: 2018/7/30
 * modified By:
 */
@Aspect//定义切面类的注解
@Order(1)
@Component//将该类加载到springIoc容器中,或者使用@Bean,在相应配置类中进行配置
public class DataSourceAspect {
    //注释前
    @Before("@annotation(dataSource)")
    public void before(JoinPoint point, DataSource dataSource) {
        DynamicDataSourceHolder.putDataSource(dataSource.value());

    }
    @After("@annotation(com.yzz.datasource.DataSource)")
    public void after(JoinPoint point) {
        DynamicDataSourceHolder.remove();
    }

}
