package com.w00429015.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @program: batchDeleteFiles
 * @author: wangkai
 * @date: 2018/4/30
 * @description: propFile加载器
 * @create: 2018-04-30 23:02
 */
public class PropLoader {
    private static Logger logger = LoggerFactory.getLogger(PropLoader.class);
    private static Properties prop = new Properties();

    static {
        loadFile();
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }

    private static void loadFile() {
        logger.info("LoadPropFile start...");
        String basePath = System.getProperty("user.dir");
        String configPath = basePath + File.separator + "config" + File.separator + "batchDeleteFilesConfig.properties";
        try {
            prop.load(new FileInputStream(new File(configPath)));
        } catch (IOException e) {
            logger.error("load {} failed...", configPath);
            e.printStackTrace();
        }
        logger.info("LoadPropFile end....");
    }
}
