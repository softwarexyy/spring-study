# 一、Spring IOC
## 简单的SpringIOC概念（spring-ioc01项目）
    (1) service层实现dao层，不再在service层中指定特定的dao层实现类，推迟到调用service层的外部程序，再指定具体的dao层实现类；
    (2) 以上过程简单原理是在service对象实现时，使用setter方法动态注入；
    (3) 控制权交予外部程序，即为控制反转 Inverse of Control(IOC)。
    
## 依赖注入  
    (1) 构造器注入；
    (2) Set方式注入（重点）：
    (3) 拓展方式注入： c标签-构造器注入、p标签-set方法注入。

### bean的作用域  
    (1) 单例模式（默认）：spring对同一个bean每次创建的对象是同一个对象
        <bean id="helloService2" class="com.yancy.service.HelloServiceImpl" scope="singleton">
            <property name="helloDao" ref="helloalice"/>
        </bean>
    (2) 原型模式： spring对同一个bean每次创建的对象是单独的一个对象
        <bean id="helloService3" class="com.yancy.service.HelloServiceImpl" scope="prototype">
            <property name="helloDao" ref="helloalice"/>
        </bean>、
    (3) 剩余 request、session、application在 web开发中用到。
    
### 注解运用：(spring-xml-03)
- 使用注解必须在xml配置 ：
```xml
<!-- 头部信息 -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    <!-- 开启注解 -->
    <context:annotation-config/>
    ...
</beans>
```
### 自动装配：（spring-xml-03）
- 有两个注解可以实现自动装配 @Autowired和 @Resource  
（1）@Autowired通过类型匹配，如果相同类型有两个bean，则用名字匹配，如果名字没有相同的，则使用@Qualifier注解强制限定bean的id；  
（2）@Resource默认通过名字匹配，如果名字找不到则通过类型匹配。

### Spring 各注解
- @Component 通用的标识spring bean的注解；
- @Controller 通常用于SpringMVC；
- @Service 通常用于标识一个service层业务逻辑的bean；
- @Repository 通常用于标识一个数据访问层（dao）的bean。
**以上几种注解作用相似，都是声明当前类作为一个spring bean，只是用在不同层的class上**
**以上几种注解，一般都标于接口的实现类上，而不是接口上，但是当dao层使用一些非class类实现数据操作的接口时，可标于接口类上**

## 静态代理
- （1）首先静态代理需要一个接口，这个接口有需要的业务方法。例如打印机有一个打印方法，则我们抽象出一个接口，这个接口中包含打印方法；
- （2）然后我们定义一个真正的打印机类，实现这个接口；
- （3）再定义一个代理类，同样实现（1）定义的接口，并且这个代理类中包含上面的打印机类对象，作为这个代理类的成员变量；
- （4）这个代理类如何实现接口中定义的方法？--> 使用包含的打印机对象、调用这个打印机对象的打印方法。也可在代理类中加入更多的方法，丰富业务功能。  
**优点主要就是解耦，打印机只需关注打印方法，如果需要前后加入打印日志等乱七八糟的操作，直接在代理类中扩展。**
**缺点是 每针对一个实际操作类 则需要一个代理类， 如果实际操作类太多(即同一个接口实现类过多)，则代理类过多**

## 动态代理
 * 动态代理，掌握两个类：
 * 一是实现InvocationHandler接口的类，二是Proxy类。
 * 前者用来在主程序中、调用目的类的方法；
 * 后者是用newProxyInstance静态方法生成代理类。
 **具体可见 static-proxy项目，包含了静态代理方法**
 **动态代理包含了静态代理所有的优点，并且针对一个接口，只需要一个InvocationHandler类，即使接口有多种实现。因此动态代理是针对一簇Service(一簇是指实现了相同接口的一组类)**
 
# 二、Spring AOP
**概念:**  
* 切入点: 程序中需要从中插入执行别的操作的位置；
* 切片: 执行的操作所在的类；
* 通知: 执行的操作方法。  
例如： 现在需要在A类的B方法执行前执行C类的D方法，则切入点是B方法执行前、切片是C类、通知是D方法。

**有三种方式实现AOP**
- (1)使用Spring的API接口，例如某个类实现了MethodBeforeAdvice接口、代表这个类中有前置通知，某个类实现了AfterReturningAdvice、代表这个类中有后置通知；
- (2)自定义实现AOP【主要是自定义切面类，此类中包含各通知方法，再在xml中配置切入点、以及前置/后置】；
- (3)使用注解

# 三、Spring整合Mybatis
### 方式一，手动实现Mapper接口，由SqlSessionTemplate注入实现SqlSession对象
- （1）spring bean中配置数据源 dataSource;
- （2）sqlSessionFactory: 未整合之前，代码里直接new一个SqlSessionFactory对象，并在new的时候指明mybatis-config.xml配置文件；
整合后，应使用Spring配置一个sqlSessionFactory的bean，在bean中指明各配置项参数。
- （3）sqlSession: 未整合之前，代码里使用sqlSessionFactory对象，通过该对象的openSession()方法，获取SqlSession对象；
整合后，应使用SqlSessionTemplate，配置一个SqlSession对应的spring bean，通过构造器注入，获取sqlSession。
- （4）需要给Mybatis接口加实现类，以便于Spring的bean的注册使用。
- （5）将实现类注册到Spring中。

### 方式二，在applicationContext.xml中配置Mapper扫描地址，spring会自动生成Mapper对象。
applicationContext.xml配置如下bean：
```xml
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <property name="basePackage" value="com.yancy.dao2"/>
    </bean>
```
- 此时无需手动注册mapper的bean了，直接在程序中使用即可
- **使用第二种方法时，sqlSessionTemplate无需在applicationContext.xml中配置相关bean了**


# 四、Spring事务
此处将事务作为一个切面，切入到各数据库操作方法上。因此以下展示事务和AOP的整合。
```xml
<!-- =========== 以下: 用AOP实现事务 ========= -->
    <!--    配置事务管理器-->
    <bean id="myTxManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>

<!-- ============ 结合AOP织入事务 ============ -->
    <!-- 配置事务通知-->
    <tx:advice id="myTxAdvice" transaction-manager="myTxManager">
        <!-- 给哪些方法配置事务 -->
        <tx:attributes>
            <!-- <tx:method name="add"/>-->
            <!-- <tx:method name="delete"/>-->
            <tx:method name="*" propagation="REQUIRED"/>
        </tx:attributes>
    </tx:advice>

<!-- ============ 配置事务切入 =============== -->
    <aop:config>
        <aop:pointcut id="txPointCut" expression="execution(* com.yancy.dao.*.*(..))"/>
        <aop:advisor advice-ref="myTxAdvice" pointcut-ref="txPointCut"/>
    </aop:config>
```
分析：
- (1) 首先配置事务管理器myTxManager；
- (2) 配置事务通知；
- (3) 配置事务的AOP切入规则。