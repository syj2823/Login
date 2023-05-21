package config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource, Configuration mybatisConfiguration) {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        // 配置数据库资源
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("entity");
        // 设置驼峰命名转换
        factoryBean.setConfiguration(mybatisConfiguration);
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        msc.setBasePackage("mapper");
        return msc;
    }

    @Bean
    public Configuration mybatisConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        return configuration;
    }

}
