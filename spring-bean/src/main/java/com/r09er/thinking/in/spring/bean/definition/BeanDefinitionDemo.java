package com.r09er.thinking.in.spring.bean.definition;

import com.r09er.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * BeanDefinition构建示例
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        //1.通过BeanDefinitionBuilder构造
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //2.设置对象属性
        beanDefinitionBuilder.addPropertyValue("id",26);
        beanDefinitionBuilder.addPropertyValue("name","罗杰");
        //3.获取实例
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //4.BeanDefinition并非最终状态，可以自定义修改属性


        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置具体类
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue("id",26);
        propertyValues.addPropertyValue("name","罗杰2");
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
