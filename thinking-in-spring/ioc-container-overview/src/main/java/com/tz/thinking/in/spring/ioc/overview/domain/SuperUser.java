package com.tz.thinking.in.spring.ioc.overview.domain;

import com.tz.thinking.in.spring.ioc.overview.annotation.Supper;

/**
 * @author https://github.com/TianPuJun @无痕
 * @ClassName SuperUser
 * @Description 超级用户
 * @Date 18:01 2020/3/27
 **/
@Supper
public class SuperUser extends User{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
