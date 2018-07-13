package com.example.zer.weiyingdemo.model.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class LishiBean {
    @Id
    Long id;
    String name;

    @Generated(hash = 1305831982)
    public LishiBean(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 782686426)
    public LishiBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
