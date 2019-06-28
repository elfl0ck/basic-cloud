# TSF云平台基础开发包
基于腾讯TSF云平台SDK整理而成，主要包含如下组件：
- TSF云平台SDK
- 集成Swagger-ui，辅助本地开发调试
- 集成spring-boot-starter-data-jpa
- 集成druid数据库连接池，以及mysql数据库驱动
- 集成mybatis数据持久层框架
- PageHelper查询分页组件

# 使用方法
- 在git上下载本项目全部代码
```
git clone https://github.com/hzwy23/basic-cloud.git
```
- 修改pom.xml文件中的下边两个值
```xml
<artifactId>basic-cloud</artifactId>
<name>basic</name>
```
- 修改配置文件，给微服务取名.(配置文件：application.yml)
```yml

# 设置服务端口号，默认情况下为8080
server:
  port: 8080

# 设置微服务名称
spring:
  application:
    name: basic-project
```
参数配置文件有5个，分别是：
```properties
application-dev.yml   本地开发配置文件
application-sit.yml   集成测试环境配置文件
application-uat.yml   用户体验测试环境配置文件
application-prod.yml  生产环境配置文件
application.yml       全局配置文件
bootstrap.yml         全局配置文件
```
**注意：bootstrap.yml和application.yml有一些差异，系统启动时，先读取的是bootstrap.yml文件**
- 使用maven运行项目
```shell
mvn clean package
```

# 设置Consul服务地址
在 IDE 中启动，通过 VM options 配置启动参数
```properties
-Dtsf_consul_ip=127.0.0.1 -Dtsf_consul_port=8500
```
其中 IP 和 port 取值为轻量级服务注册中心的地址。服务打包发布到TSP平台，无需设置此参数。

使用了分布式配置功能的模块，需要设置
```properties
-Dtsf_application_id=a -Dtsf_group_id=b
```

# API查看页面
系统启动后，打开浏览器输入如下地址：
```properties
http://IP:PORT/swagger
```
> 如采用默认配置启动，访问地址是：http://localhost:8080/swagger