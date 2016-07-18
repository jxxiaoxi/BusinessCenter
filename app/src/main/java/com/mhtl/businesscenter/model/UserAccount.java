package com.mhtl.businesscenter.model;

import java.io.Serializable;

/**
 * Created by liuwei on 7/5/16.
 */
public class UserAccount implements Serializable {
    String name;
    int age,sex;

    public UserAccount(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
