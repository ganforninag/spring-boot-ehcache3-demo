package com.itclj.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by clj on 2017/6/17.
 */
public class UserBean implements Serializable {

    private Long id;

    private String name;

    private Date birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
