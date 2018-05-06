package com.w00429015.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.Nullable;

/**
 * @program: batchDeleteFiles
 * @author: wangkai
 * @date: 2018/4/30
 * @description: Spring容器获取类
 * @create: 2018-04-30 21:50
 */
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) throws BeansException{
        return applicationContext.getBean(name);
    }

    <T> T getBean(String var1, @Nullable Class<T> var2) throws BeansException{
        return applicationContext.getBean(var1, var2);
    }
}
