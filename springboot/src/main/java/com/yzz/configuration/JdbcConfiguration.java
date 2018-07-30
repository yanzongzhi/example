package com.yzz.configuration;

import com.yzz.datasource.MultipleDataSourceProxy;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {
    /**由于多数据源,hikari的连接池属性赋值方法,没有走,所有手动对连接池做处理*/
    @Value("${spring.datasource.hikari.connection-test-query}")
    private String connectionTestQuery;
    @Value("${spring.datasource.hikari.connection-init-sql}")
    private String connectionInitSql;
    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int maximumPoolSize;
    @Value("${spring.datasource.hikari.minimum-idle}")
    private int minmumIdle;

    @Bean
    @ConfigurationProperties(prefix = "slave.spring.datasource")
    public DataSourceProperties slave() {
        return new DataSourceProperties();
    }


//    @Bean
//    public DataSourceAspect dataSourceAspect(){
//        return new DataSourceAspect();
//    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties master() {
        return new DataSourceProperties();
    }


    @Bean
    @Primary
    public DataSource dataSource() {

        HikariDataSource master = (HikariDataSource)master().initializeDataSourceBuilder().type(HikariDataSource.class).build();
        master.setMaximumPoolSize(maximumPoolSize);
        master.setMinimumIdle(minmumIdle);
        master.setConnectionTestQuery(connectionTestQuery);
        master.setConnectionInitSql(connectionInitSql);
        HikariDataSource slave = (HikariDataSource)slave().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
        slave.setMaximumPoolSize(maximumPoolSize);
        slave.setMinimumIdle(minmumIdle);
        slave.setConnectionTestQuery(connectionTestQuery);
        slave.setConnectionInitSql(connectionInitSql);

        return new MultipleDataSourceProxy(master).putDataSource("slave",slave);

    }
}
