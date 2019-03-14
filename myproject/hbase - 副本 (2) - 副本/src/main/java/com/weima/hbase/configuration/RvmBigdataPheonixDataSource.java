package com.weima.hbase.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class RvmBigdataPheonixDataSource {

    private static final Logger logger = Logger.getLogger(RvmBigdataPheonixDataSource.class);
    @Autowired
    private Environment environment;


    @Bean(name = "phoenixJdbcDataSource")
    @Qualifier("phoenixJdbcDataSource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("phoenix.url"));
        druidDataSource.setDriverClassName(environment.getProperty("phoenix.driver-class-name"));
        druidDataSource.setMinIdle(Integer.parseInt(environment.getProperty("phoenix.minIdle")));
        druidDataSource.setMaxWait(Long.valueOf(environment.getProperty("phoenix.maxWait")));
        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(environment.getProperty("phoenix.timeBetweenEvictionRunsMillis")));
        druidDataSource.setMinEvictableIdleTimeMillis(Long.valueOf(environment.getProperty("phoenix.minEvictableIdleTimeMillis")));
        druidDataSource.setTestWhileIdle(Boolean.valueOf(environment.getProperty("phoenix.testWhileIdle")));
        druidDataSource.setTestOnBorrow(Boolean.valueOf(environment.getProperty("phoenix.testOnBorrow")));
        druidDataSource.setTestOnReturn(Boolean.valueOf(environment.getProperty("phoenix.testOnReturn")));
        druidDataSource.setPoolPreparedStatements(Boolean.valueOf(environment.getProperty("phoenix.poolPreparedStatements")));
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(environment.getProperty("phoenix.maxPoolPreparedStatementPerConnectionSize")));
        druidDataSource.setUsername(environment.getProperty("phoenix.username"));
        druidDataSource.setPassword(environment.getProperty("phoenix.password"));
        druidDataSource.setDefaultAutoCommit(Boolean.valueOf(environment.getProperty("phoenix.default-auto-commit")));
        druidDataSource.setPoolPreparedStatements(Boolean.valueOf(environment.getProperty("phoenix.poolPreparedStatements")));
//        druidDataSource.setConnectionProperties("phoenix.schema.isNamespaceMappingEnabled=true");

        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(environment.getProperty("phoenix.maxPoolPreparedStatementPerConnectionSize")));
//        druidDataSource.setValidationQuery(environment.getProperty("phoenix.validationQuery"));
        druidDataSource.setMaxActive(Integer.parseInt(environment.getProperty("phoenix.maxActive")));
        druidDataSource.setInitialSize(1);
        logger.debug("druidDataSource="+druidDataSource.toString());
        return druidDataSource;
    }




    @Bean(name = "phoenixJdbcTemplate")
    @Qualifier("phoenixJdbcTemplate")
    public JdbcTemplate phoenixJdbcTemplate(@Qualifier("phoenixJdbcDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
