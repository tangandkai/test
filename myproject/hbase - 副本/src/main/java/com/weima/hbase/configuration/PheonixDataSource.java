package com.weima.hbase.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class PheonixDataSource {

    @Autowired
    private Environment environment;

    @Bean(name = "phoenixJdbcDataSource")
    @Qualifier("phoenixJdbcDataSource")
    public DataSource dataSource() throws Exception{
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("phoenix.url"));
        druidDataSource.setDriverClassName(environment.getProperty("phoenix.driver-class-name"));
        druidDataSource.setUsername(environment.getProperty("phoenix.username"));
        druidDataSource.setPassword(environment.getProperty("phoenix.password"));
        druidDataSource.setDefaultAutoCommit(Boolean.valueOf(environment.getProperty("phoenix.default-auto-commit")));
        druidDataSource.setMaxActive(Integer.parseInt(environment.getProperty("phoenix.maxActive")));
        druidDataSource.setInitialSize(1);
        // druidDataSource.setConnectionProperties("phoenix.schema.isNamespaceMappingEnabled=true");
        druidDataSource.setValidationQuery(environment.getProperty("phoenix.validationQuery"));
        return druidDataSource;
    }




    @Bean(name = "phoenixJdbcTemplate")
    @Qualifier("phoenixJdbcTemplate")
    public JdbcTemplate phoenixJdbcTemplate(@Qualifier("phoenixJdbcDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
