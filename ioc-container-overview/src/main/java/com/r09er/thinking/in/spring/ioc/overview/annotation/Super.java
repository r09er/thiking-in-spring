package com.r09er.thinking.in.spring.ioc.overview.annotation;


import java.lang.annotation.*;

/**
 * 超级用户注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
