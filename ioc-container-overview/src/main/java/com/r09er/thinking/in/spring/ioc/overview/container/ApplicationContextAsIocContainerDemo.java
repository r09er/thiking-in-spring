package com.r09er.thinking.in.spring.ioc.overview.container;

import com.r09er.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ApplicationContextAsIocContainerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        //将当前类作为ApplicationContext的配置类
        annotationConfigApplicationContext.register(ApplicationContextAsIocContainerDemo.class);
        //启动应用上下文
        annotationConfigApplicationContext.refresh();
        lookupByCollectionType(annotationConfigApplicationContext);

    }

    @Bean
    public User user(){
        User user = new User();
        user.setId(1L);
        user.setName("r09er");
        return user;
    }


    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有的User 对象集合 " + userMap.toString());
        }
    }
}
