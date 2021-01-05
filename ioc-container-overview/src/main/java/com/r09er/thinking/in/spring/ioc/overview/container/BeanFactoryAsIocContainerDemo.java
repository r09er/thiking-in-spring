package com.r09er.thinking.in.spring.ioc.overview.container;

import com.r09er.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryAsIocContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitionCounts = reader.loadBeanDefinitions(location);
        System.out.println(beanDefinitionCounts);


        lookupByCollectionType(beanFactory);
    }



    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找所有的User 对象集合 " + userMap.toString());
        }
    }
}
