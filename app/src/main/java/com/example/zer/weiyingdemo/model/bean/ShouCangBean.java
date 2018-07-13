package com.example.zer.weiyingdemo.model.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class ShouCangBean {
    @Id
    Long id;
    String url;
    String title;
    String pic;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Generated(hash = 80747353)
    public ShouCangBean(Long id, String url, String title, String pic) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.pic = pic;
    }

    @Generated(hash = 845077157)
    public ShouCangBean() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
