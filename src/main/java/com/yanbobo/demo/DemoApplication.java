package com.yanbobo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * @SpringBootApplication 是spring-boot的核心注解，是一个组合注解，包含了：@Configuration、@EnableAutoConfiguration、@ComponentScan
 * @EnableTransactionManagement 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
 */
@SpringBootApplication
/*@Configuration
@EnableAutoConfiguration
@ComponentScan*/
@EnableTransactionManagement
public class DemoApplication implements TransactionManagementConfigurer {

    @Resource(name="txManager2")
    private PlatformTransactionManager txManager2;

    // 其中 dataSource 框架会自动为我们注入
    @Bean(name = "txManager")
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    // 创建事务管理器2
    @Bean(name = "txManager2")
    public PlatformTransactionManager txManager2(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

    // 实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
    //使用默认事务
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return txManager2;
    }

/*
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager) {
        System.out.println(">>>>>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }
*/



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
