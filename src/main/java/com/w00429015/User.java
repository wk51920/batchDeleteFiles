package com.w00429015;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @program: batchDeleteFiles
 * @author: wangkai
 * @date: 2018/4/30
 * @description: 测试类
 * @create: 2018-04-30 23:17
 */
@Component
public class User {
    private  String name;
    private  int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
