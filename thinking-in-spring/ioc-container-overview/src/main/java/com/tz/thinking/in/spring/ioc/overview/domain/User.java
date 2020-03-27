package com.tz.thinking.in.spring.ioc.overview.domain;

/**
 * @author https://github.com/TianPuJun @无痕
 * @ClassName User
 * @Description 用户
 * @Date 17:43 2020/3/27
 **/
public class User {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
