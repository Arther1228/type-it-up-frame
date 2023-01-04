
#### 1.自定义springboot starter，你学废了吗
#### https://juejin.cn/post/7127468724046528525

#### 2.徒手撸一个Spring Boot中的starter
#### https://segmentfault.com/a/1190000039170021
#### 总结
1. Spring Boot在启动时扫描项目所依赖的JAR包，寻找包含spring.factories文件的JAR包，
2. 然后读取spring.factories文件获取配置的自动配置类AutoConfiguration`，
3. 然后将自动配置类下满足条件(@ConditionalOnXxx)的@Bean放入到Spring容器中(Spring Context)
4. 这样使用者就可以直接用来注入，因为该类已经在容器中了。


#### 3.Spring Boot Starters是什么？
#### https://www.cnblogs.com/tjudzj/p/8758391.html
