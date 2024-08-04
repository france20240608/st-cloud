# st-cloud
some things new

项目管理
jira

代码管理
git
gitLab

集成发布
jenkins

开发工具
VSCode 1.89
Idea 2024
navicat 17

中间件
tidb 8.1.0
rocketMQ 5.2.0
Redis 7.4.2  已集成
tomcat 10.1
Prometheus
skywalking

开发技术栈
java 21  已集成
spring boot 3.3.0
feign 13.2.1
sentinel
nacos
Seata

st-cloud
    st-dependencies                     ## 依赖定义
    st-framework                        ## 依赖组件管理
        >st-spring-boot-starter-env     ## 核心环境
        >st-spring-boot-starter-mq      ## 消息队列
        >st-spring-boot-starter-redis   ## 二级缓存
        >st-spring-boot-starter-rpc     ## 网络调用
    st-common                           ## 工具类
    st-gateway-agent                    ## 技术网关
    st-gateway-member                   ## 技术网关
    st-module-endpoint                  ## 对外API暴露模块
        >st-module-agent                ## 代理系统
        >st-module-central              ## 总控系统
        >st-module-member               ## 会员系统
    st-module-service-activity          ## 活动服务
    st-module-service-payment           ## 支付服务
    st-module-service-report            ## 报表服务
    st-module-service-user              ## 客户服务
