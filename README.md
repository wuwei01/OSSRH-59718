# OSSRH-59718
# 这是一个开源工具类整合项目，后续有待完善
------------
#### 主要应用与统一异常处理，统一返回值处理，更好的应用于项目中的实践功能。

###### 使用方式
###### 在application 配置文件中配置一个参数来定义扫描的包
###### 以YML格式配置文件为例：
# 1.使用wwei-common
## 1.1 引入maven
  ```xml
   <dependency>
        <groupId>io.github.wuwei01</groupId>
        <artifactId>wwei-common</artifactId>
        <version>1.1</version>
   </dependency>
  ```
#### 版本目前是目前最新版本是1.1
## 1.2 通过注解开启统一处理
```java
@SpringBootApplication()
@EnableGlobalResult //开启统一处理注解
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```
## 1.3 修改属性配置文件
* 在工程中添加springmvc的静态路径
  如果不添加,grh将会拦截html
```yaml
spring:
  mvc:
    throw-exception-if-no-handler-found: true
    static-path-pattern: "*.html"
  resources:
    add-mappings: false
  ```
