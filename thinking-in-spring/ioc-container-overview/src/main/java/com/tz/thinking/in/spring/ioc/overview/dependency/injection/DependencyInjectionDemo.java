package com.tz.thinking.in.spring.ioc.overview.dependency.injection;

import com.tz.thinking.in.spring.ioc.overview.annotation.Supper;
import com.tz.thinking.in.spring.ioc.overview.domain.User;
import com.tz.thinking.in.spring.ioc.overview.repository.UserRepository;
import javafx.application.Application;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * @author https://github.com/TianPuJun @无痕
 * @ClassName DependencyLookupDemo
 * @Description 依赖注入（实时查找，延迟查找）
 * @Date 16:55 2020/3/27
 **/
public class DependencyInjectionDemo {
    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:WEB-INF/dependency-injection-context.xml");
        UserRepository userRepository = (UserRepository)beanFactory.getBean("userRepository");
        System.out.println(userRepository.getBeanFactory());
        ObjectFactory<ApplicationContext> objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject() == beanFactory);
        Environment bean = beanFactory.getBean(Environment.class);
        System.out.println("获取 Environment 的bean  "+bean);

    }

}
