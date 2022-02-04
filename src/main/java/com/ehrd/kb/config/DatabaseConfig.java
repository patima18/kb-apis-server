package com.ehrd.kb.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
 
 
@Configuration
@Lazy
@EnableTransactionManagement
@MapperScan(basePackages= "com.ehrd.kb.*.repository")
public class DatabaseConfig {
 
    /**
     * Session Factory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
 
        // 오른쪽에 있는 리소스 경로에 들어감(src/main/resources)
        sessionFactory.setMapperLocations(resolver.getResources(
            // 실제 쿼리가 들어갈 xml 패키지 경로
            "/mapper/*.xml"
        ));
 
        // Value Object를 선언해 놓은 package 경로
        sessionFactory.setTypeAliasesPackage( "com.ehrd.kb.*.model" );
        return sessionFactory.getObject();
    }
 
    /**
     * Mybatis template 설정
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

        sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);

        sqlSessionTemplate.getConfiguration().setUseGeneratedKeys(true);
        return sqlSessionTemplate;
    }
    
    /** 
    * Transaction Manager 설정
    */
    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
}