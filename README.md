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
参数配置文件有6个，分别是：
```properties
application-dev.yml   本地开发配置文件
application-sit.yml   集成测试环境配置文件
application-uat.yml   用户体验测试环境配置文件
application-prod.yml  生产环境配置文件
application.yml       全局配置文件
bootstrap.yml         全局配置文件
```

application.yml和bootstrap.yml 一定会生效的配置。
其余4个配置文件，根据spring.profiles.active的值来决定启动哪个配置。如spring.profiles.active=dev则application-dev.yml配置文件生效，其余的-sit,-uat,-prod的几个配置不生效，以此类推。


## 配置文件生效顺序：
**注意：bootstrap.yml和application.yml有一些差异，系统启动时，先读取的是bootstrap.yml文件**
```properties
bootstrap.yml -> application.yml -> application-(dev|sit|uat|prod).yml
```
如果后边的配置文件出现了前边配置文件中相同的变量名，则使用后边出现的变量值替换前边变量的值。

# 设置Consul服务地址
在 IDE 中启动，通过 VM options 配置启动参数
```properties
-Dtsf_consul_ip=127.0.0.1 -Dtsf_consul_port=8500
```
其中 IP 和 port 取值为轻量级服务注册中心的地址。服务打包发布到TSP平台，无需设置此参数。

## 本地开发设置consul地址
本地开发时，我们需要连接到一个有效的consul-server，否则服务在本地无法启动。
腾讯官方推荐在本地启动一个consul-server，TSF-SDK在启动的时候会默认连接127.0.0.1:8500，也就是本地启动的consul-server。
我建议，直接在服务端上装一个consul-server，本地开发时默认连接我们安装的consul-server，本地开发环境指定consul-server的IP地址，
这样本地开发时就无需在本地启动consul-server。本地开发连接服务端consul-server配置方式是在bootstrap.yml中设置如下变量：
```properties
tsf_consul_ip: 121.42.143.130
```
服务开发完成后，这个值不能发布到TSP平台，否则会导致微服务无法使用TSF集群内默认的服务注册与发现中心。

使用了分布式配置功能的模块，需要设置
```properties
-Dtsf_application_id=a -Dtsf_group_id=b
```
# 使用maven运行项目
```shell
mvn clean package
```

# Swagger-ui页面
系统启动后，打开浏览器输入如下地址：
```properties
http://IP:PORT/swagger
```
> 如采用默认配置启动，访问地址是：http://localhost:8080/swagger