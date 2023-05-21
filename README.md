# 基于Spring MVC框架下的登录项目

## 前言：

​	由于一直使用Spring Boot直接搭建项目环境，最近突然发现好久没有使用原生的Spring来创建项目，于是花了几天时间来创建了这个简易得小登录注册页面。项目由于是从零搭建，所以存在很多不足之处，不正确的地方还请各位多多指正！

## 1.搭建环境：

### 	1.1：创建Maven工程：

​	由于不使用Spring Boot来搭建框架，所以我们需要创建一个Maven模块。

![image-20230517161709750](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171619032.png)

![image-20230517161958764](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171619841.png)

![image-20230517163521103](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171635533.png)

### 1.2：在Main下搭建webapp模块：

​	这是用于存放静态页面，以及一些Spring配置的xml配置文件的。但由于该项目中，Spring相关配置我使用的是Java类的配置模式，所以此处只存放静态页面。

![image-20230517163654801](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171636862.png)

![image-20230517163734347](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171637405.png)

![image-20230517163758912](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171637951.png)

![image-20230517163946657](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171639739.png)

![image-20230517164107707](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171641754.png)

![image-20230517164205286](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171642388.png)

![image-20230517164231396](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171642435.png)

### 1.3：导入依赖：

​	此处我们需要设置打包方式，以及导入相关依赖。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.it</groupId>
    <artifactId>Login</artifactId>
    <version>1.0-SNAPSHOT</version>
	<!--打包方式-->
    <packaging>war</packaging>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <dependencies>
        <!--spring mvc依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.10.RELEASE</version>
        </dependency>
        <!--        servlet依赖-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
<!--        jdbc依赖，整合数据库配置-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.10.RELEASE</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>5.2.10.RELEASE</version>
        </dependency>

        <!--        mybatis依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.5</version>
        </dependency>

        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.3.0</version>
        </dependency>
        <!--        druid数据库连接池-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.12</version>
        </dependency>
        <!--        mysql-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.24</version>
        </dependency>
        <!--        junit测试-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
        
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.10.1</version>
        </dependency>
        
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.76</version>
        </dependency>
    </dependencies>


    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <version>2.2</version>
            </plugin>
        </plugins>
    </build>
</project>
```

​	其他依赖可以自行选择，下面这两个（mvc和servlet依赖必须加）

![image-20230517164854757](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305171648819.png)

### 1.4：准备资源：

#### 	数据库：自行下载并运行sql问件

链接：https://pan.baidu.com/s/1eDFwhfs97i6DqEeEv_hGbw 
提取码：inyk

​	

#### 	jdbc.properties:

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/login_db
jdbc.username=root	#请修改为自己的用户名和密码
jdbc.password=root
```

#### 	页面：

​	自行上百度网盘提取：

链接：https://pan.baidu.com/s/1eDFwhfs97i6DqEeEv_hGbw 
提取码：inyk

【注】：前端页面为本人书写，由于不是专业学前端的，所以有些地方存在不足，但大体上能够运行使用，所以还请多包涵

## 2.创建配置类：

​	【注】：此处的配置类本人没有采用xml语法配置，而是采用了Java类的配置方式。

### 	2.1 SpringMvcConfig：

​	SpringMvcConfig是一个SpringMvc的配置类，加上@Configuration表示它是一个Spring的配置类。

![image-20230519135506636](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191355755.png)

### 2.2 SpringConfig：

![image-20230519140646455](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191406533.png)

### 	2.3  ServletConfig：

​	定义一个servlet容器启动配置类，加载spring配置，用于向服务器声明。

```java
package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 加载Spring配置
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    // 加载SpringMvc配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    // 配置SpringMvc的指定请求路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
```

![image-20230519140319488](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191403573.png)

### 2.4 JdbcConfig:

```java
package config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

public class JdbcConfig{

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.driver}")
    private String driverClassName;

    @Value("${jdbc.type}")
    private String type;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;


    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setDbType(type);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        return druidDataSource;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
```

![image-20230519140842066](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191411662.png)![image-20230519141253589](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191412676.png)

### 2.5 MybatisConfig:

​	mybatis的配置类：

```java
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
        // 开启驼峰命名
        configuration.setMapUnderscoreToCamelCase(true);
        return configuration;
    }

}
```

![image-20230521155626843](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305211556054.png)

### 2.6 SpringMvcSupportConfig:

​	用于映射静态页面资源：

```java
package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupportConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }
}

```

![image-20230519141631759](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191416851.png)

​	最终config包成型：![image-20230519141751401](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191417463.png)

## 3.创建实体类，数据访问层，业务层，控制层：

### 3.1：实体类：

```java
package entity;

import java.util.Date;

public class User {
    private long id;    // id

    private String username;    // 用户名

    private String password;    // 密码

    private String idNumber;    // 身份证

    private int gender;     // 性别：0：女 1：男

    private String address; // 籍贯

    private Date createTime;    // 创建时间

    private int status;     // 状态：0：停用 1：启用

    public User() {
    }

    public User(long id, String username, String password, String idNumber, int gender, String address, Date createTime, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.idNumber = idNumber;
        this.gender = gender;
        this.address = address;
        this.createTime = createTime;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
```

![image-20230517201521654](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305172015839.png)

### 3.2：数据访问层接口：

```java
package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    // 测试用
    List<User> selectAll();

    // 根据用户名和密码查询
    User select(@Param("username") String username, @Param("password") String password);

    // 当根据用户名和密码查询为空时，调用它
    User selectByUsername(String username);

    // 没有账号，注册
    int save(User user);

    // 修改密码
    int update(User user);

    // 注销账号
    int deleteById(long id);

}
```

​	SQL语句：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="mapper.UserMapper">
    <select id="selectAll" resultType="User">
        select * from user
    </select>

    <select id="select" resultType="User">
        select * from user where username = #{username} and password = #{password}
    </select>

    <select id="selectByUsername" resultType="User">
        select * from user where username = #{username}
    </select>

    <insert id="save" parameterType="User" keyProperty="id">
        insert into user (username, password, phone, email, id_number, gender, address)
        values (#{username}, #{password}, #{phone}, #{email}, #{idNumber}, #{gender}, #{address})
    </insert>

    <update id="update">
        update user
        set username = #{username}, password = #{password}, phone = #{phone}, email = #{email},
            id_number = #{idNumber}, gender = #{gender}, address =  #{address}, status = #{status}
        where id = #{id}
    </update>

    <delete id="deleteById">
        delete
        from user
        where id = #{id}
    </delete>
</mapper>
```

![image-20230519142012799](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191420916.png)

### 3.3：业务层：

#### 	接口类：

```java
package service;

import entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserService {
    List<User> selectAll();

    User select(String username, String password);

    User selectByUsername(String username);

    boolean save(User user);

    boolean update(User user);

    boolean deleteById(long id);
}
```

#### 	实现类：

```java
package service.Impl;

import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public User select(String username, String password) {
        User user = userMapper.select(username, password);
        return user;
    }

    @Override
    public User selectByUsername(String username) {
        User user = userMapper.selectByUsername(username);
        return user;
    }

    @Override
    public boolean save(User user) {
        return userMapper.save(user) > 0;
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user) > 0;
    }

    @Override
    public boolean deleteById(long id) {
        return userMapper.deleteById(id) > 0;
    }
}
```

![image-20230519142301666](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191423754.png)

### 3.4：控制层：

```java
package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;
import controller.util.Code;
import controller.util.Result;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @GetMapping
    public Result select(String username, String password) {
        // 先根据用户名和密码进行查询
        User user1 = userService.select(username, password);
        // 如果返回null,再查询username
        if (user1 == null) {
            User user2 = userService.selectByUsername(username);
            // 如果查询仍为空，则说明用户名不存在
            if (user2 == null) {
                return new Result(Code.SELECT_ERR, null, "用户名不存在，请先注册");
            }else {
                // 否则说明密码错误
                return new Result(Code.SELECT_ERR, null, "密码错误，请重新输入密码");
            }
        } else if (user1.getStatus() == 0) {
            return new Result(Code.SELECT_ERR, null, "您的账号已被禁用！");
        }else {
            return new Result(Code.SELECT_OK, user1,  user1.getUsername() + "您好");
        }


    }

    @PostMapping
    public Result save(@RequestBody User user) {
        String username1 = user.getUsername();
        // 先查询数据库中该用户是否注册
        User user1 = userService.selectByUsername(username1);
        if (user1 != null) {
            return new Result(Code.INSERT_ERR, "null", "该用户以存在，请重新注册");
        }

        boolean save = userService.save(user);

        Integer code = save ? Code.INSERT_OK : Code.INSERT_ERR;
        String msg = save ? "恭喜您注册成功！" : "注册失败，请重新注册！";

        return new Result(code, user, msg);
    }
}
```

#### 	工具类：

​			状态码：可以根据自己需求更改

```java
package controller.util;

/**
 * 状态码
 */
public class Code {
    // 成功
    public static final Integer SELECT_OK = 2001;
    public static final Integer INSERT_OK = 3001;
    public static final Integer UPDATE_OK = 4001;
    public static final Integer DELETE_OK = 5001;

    // 失败
    public static final Integer SELECT_ERR = 2004;
    public static final Integer INSERT_ERR = 3004;
    public static final Integer UPDATE_ERR = 4004;
    public static final Integer DELETE_ERR = 5004;

    //异常处理
    public static final Integer SYSTEM_ERROR = 6005;               //系统异常
    public static final Integer SYSTEM_TIMEOUT_ERROR = 7005;       //系统超时
    public static final Integer SYSTEM_UNKNOWN_ERROR = 8005;       //未知异常
    public static final Integer BUSINESS_ERROR = 9005;             //业务繁忙
}
```

​		返回结果类：

```java
package controller.util;


public class Result {
    private Integer code;   // 状态码

    private Object data;    // 返回数据

    private String message; // 返回信息

    public Result() {
    }

    public Result(Integer code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }
}
```

![image-20230519142629968](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305191426088.png)

## 4.运行：

![image-20230521160115387](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305211601491.png)

![image-20230521160215840](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img/202305211602937.png)

## 5.最终页面效果：

![image-20230521164122115](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img1/202305211641413.png)

![image-20230521164322933](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img1/202305211643189.png)

![image-20230521164548588](https://gitee.com/syj_123/idea-remote-connection---hbase/raw/master/img1/202305211645844.png)

## 总结：

​	由于本人技术水平问题，该项目还有许多不足之处，还请各位大佬提供解决方案。例如：前端页面的籍贯可以做成夜歌地址级联选择器等。欢迎大家在评论区讨论，共同学习。

