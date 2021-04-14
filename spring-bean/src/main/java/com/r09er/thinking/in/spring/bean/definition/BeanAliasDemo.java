package com.r09er.thinking.in.spring.bean.definition;

import com.r09er.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAliasDemo {

    public static void main(String[] args) {
        //配置XML配置文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        User factoryBean1 = beanFactory.getBean("r09er-user", User.class);
        User factoryBean2 = beanFactory.getBean("r09er-user", User.class);

        System.out.println(factoryBean1);
        System.out.println(factoryBean2);
    }
}
