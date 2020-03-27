package com.tz.thinking.in.spring.ioc.overview.dependency.lookup;

import com.tz.thinking.in.spring.ioc.overview.annotation.Supper;
import com.tz.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author https://github.com/TianPuJun @无痕
 * @ClassName DependencyLookupDemo
 * @Description 依赖查找（实时查找，延迟查找） https://time.geekbang.org/course/detail/100042601-184050
 * @Date 16:55 2020/3/27
 **/
public class DependencyLookupDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:WEB-INF/dependency-lookup-context.xml");
        // 实时查找
        lookupInRealTime(beanFactory);
        // 延迟查找
        lookupInLazy(beanFactory);
        // 根据类型查找
        lookupByType(beanFactory);
        // 查找所有该类型的集合
        lookupByCollectionType(beanFactory);
        // 根据注解
        lookupByAnnotation(beanFactory);
    }
    private static void lookupByAnnotation(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> users = (Map)listableBeanFactory.getBeansWithAnnotation(Supper.class);
            System.out.println("lookupByAnnotation 查找到的所有的 @Super 注解 集合对象"+users);
        }
    }
    private static void lookupByCollectionType(BeanFactory beanFactory){
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory)beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupByCollectionType 查找到的所有的 Users 集合对象"+users);
        }
    }
    private static void lookupByType(BeanFactory beanFactory){
        User bean = beanFactory.getBean(User.class);
        System.out.println("lookupByType 类型查找: "+bean);
    }
    private static void lookupInLazy(BeanFactory beanFactory) {

        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("lookupInLazy 延迟查找: "+user);

    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("lookupInRealTime 实时查找:"+user);
    }
}
