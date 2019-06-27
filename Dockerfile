FROM ccr.ccs.tencentyun.com/tsf_309810957/jdk-1.8:latest

MAINTAINER zhanwei_huang hzwy23@163.com

WORKDIR /opt

ADD ./target ./basic

WORKDIR basic

EXPOSE 8080

ENV TZ Asia/Shanghai

CMD java -jar microservice.jar --spring.profiles.active=prod
