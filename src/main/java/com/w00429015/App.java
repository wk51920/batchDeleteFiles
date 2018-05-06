package com.w00429015;

import com.w00429015.common.PropLoader;
import com.w00429015.common.SpringContextUtil;
import com.w00429015.springConfig.SpringApplictionConfig;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * Hello world!
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);
    private static ApplicationContext context;

    private static void initLog() {
        String basePath = System.getProperty("user.dir");
        String log4jConfigPath = basePath + File.separator + "config" + File.separator + "log4j.properties";
        PropertyConfigurator.configure(log4jConfigPath);

        logger.info("log4jPath: {}", log4jConfigPath);
    }

    private static void initSpringContext() {
        context = new AnnotationConfigApplicationContext(SpringApplictionConfig.class);
    }

    public static void main(String[] args) {
        initLog();
        initSpringContext();

        User user = (User)SpringContextUtil.getBean("userBean");
        logger.info("user name: {}", user.getName());
        logger.info("user age: {}", user.getAge());
    }
}
