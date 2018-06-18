package com.w00429015.springConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @program: batchDeleteFiles
 * @author: wangkai
 * @date: 2018/5/5
 * @description: Spring配置
 * @create: 2018-05-05 17:58
 */
@Configuration
@ImportResource(locations = "classpath:applicationContext.xml")
@ComponentScan(basePackages = {"com.w00429015"})
@PropertySource(value = "file:${user.dir}/config/batchDeleteFilesConfig.properties", ignoreResourceNotFound = true)
public class SpringApplictionConfig {

    @Autowired
    public Environment env;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
