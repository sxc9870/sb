package sb.sb;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
 
/**
 * mybatis配置类
 */
@Configuration
public class MybatisConfig implements TransactionManagementConfigurer {
    @Bean
    public DataSource dataSource(Environment environment) {
        return DruidDataSourceBuilder.create().build(environment, "spring.datasource.druid.");
    }
    
    @Resource(name = "dataSource")
    DataSource dataSource;
    public MybatisConfig() {
        System.out.println("1");
    }
    /**
     * 可以通过这个类,详细配置mybatis
     * 
     * @return
     */
    @Bean
    public org.apache.ibatis.session.Configuration mybatisSetting() {
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setDefaultStatementTimeout(2000);
        //
      //  mybatis.configuration.cache-enabled=true
        configuration.setCacheEnabled(false);
        return configuration;
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setTypeAliasesPackage("com.sxc.dao.mapper");

        // 分页插件,插件无非是设置mybatis的拦截器

        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            // 设置xml扫描路径
          
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException("sqlSessionFactory init fail", e);
        }
    }

    /**
     * 用于实际查询的sql工具,传统dao开发形式可以使用这个,基于mapper代理则不需要注入
     * 
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 事务管理,具体使用在service层加入@Transactional注解
     */
    @Override
    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
    
    
    
    
    
    
    
    
    
}