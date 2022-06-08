package com;

import java.io.Serializable;

/**
 * @Author: liuyong
 * @Date: 2022 - 06 - 08 - 21:04
 * @Description: com
 * @Version: 1.0
 */
public class User implements Serializable {
    private Integer id;
    private String name;

    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
