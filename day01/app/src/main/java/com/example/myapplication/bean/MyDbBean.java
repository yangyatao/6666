package com.example.myapplication.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class MyDbBean {
    @Id(autoincrement = true)
    private Long id;
    private String img;
    private String name;
    private String title;
    private String time;
    private String link;
    @Generated(hash = 946064162)
    public MyDbBean(Long id, String img, String name, String title, String time,
            String link) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.title = title;
        this.time = time;
        this.link = link;
    }
    @Generated(hash = 720896287)
    public MyDbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getLink() {
        return this.link;
    }
    public void setLink(String link) {
        this.link = link;
    }
}
