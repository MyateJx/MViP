package com.myatejx.vipmvp.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author KunMinX
 * @date 2018/8/22
 * <p>
 * 实体类
 */
@Entity
public class TestBean {

    @PrimaryKey(autoGenerate = true)
    private Long id;
    private String title;
    private String date;

    public TestBean(Long id, String title, String date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
