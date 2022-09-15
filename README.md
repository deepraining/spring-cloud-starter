# spring-cloud-starter

用于快速创建 [Spring Cloud](https://spring.io/projects/spring-cloud) 微服务应用的模板脚手架，使用 [Gradle](https://gradle.org/) 构建项目。

## 特性

- 使用 [spring-cloud-gateway](https://github.com/spring-cloud/spring-cloud-gateway) 处理网关路由
- 使用 [Alibaba Nacos](https://nacos.io/) 注册与发现微服务
- 使用 [spring-cloud-openfeign](https://github.com/spring-cloud/spring-cloud-openfeign) 优雅操作 `rpc` 调用
- 使用 [Alibaba Sentinel](https://github.com/alibaba/Sentinel) 做高可用流控防护组件
- 使用 [Twitter Zipkin](https://github.com/openzipkin/zipkin) 做请求链路的跟踪数据

## 子项目

- `pro-base`: 基础代码
- `pro-gateway`: 网关项目
- `pro-user-api`: `user` 项目对外开放接口
- `pro-user-cloud`: `user` 项目主体代码
- `pro-article-api`: `article` 项目对外开放接口
- `pro-article-cloud`: `article` 项目主体代码

## 创建项目

克隆代码，然后根据需要调整项目与代码

```
git clone https://github.com/deepraining/spring-cloud-starter.git yourProName --depth=1

cd yourProName
```

去掉原有的 Git 信息，并重新初始化

```
rm -rf .git

git init
```

## 运行项目

请先确保已有 Nacos 服务与 Zipkin 服务。

先运行 `pro-user-cloud` 项目

```
./gradlew pro-user-cloud:run
```

再运行 `pro-article-cloud` 项目

```
./gradlew pro-article-cloud:run
```

最后运行 `pro-gateway` 项目

```
./gradlew pro-gateway:run
```

访问 `http://localhost:9100/`，并在 Console 中执行

```
// 访问user项目接口
fetch('/user/articleList').then(res=>res.json()).then(console.log)

// 访问article项目接口
fetch('/article/articleList').then(res=>res.json()).then(console.log)
```

## 注意

- 使用 Nacos 时，服务器与客户端版本需匹配，本项目所需的服务器版本是 `v1.1.4`，参考 [Spring Cloud Alibaba Version 版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)
- 部署时，需要调整 `application*.yml` 配置中的相关服务地址
- 本项目只示例了两个模块 `user, article`，实际使用时，可以自行添加多个模块
