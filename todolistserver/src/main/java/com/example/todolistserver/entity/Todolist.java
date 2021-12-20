package com.example.todolistserver.entity;

import java.io.Serializable;

/**
 * (Todolist)实体类
 *
 * @author makejava
 * @since 2021-11-29 10:23:06
 */
public class Todolist implements Serializable {
    private static final long serialVersionUID = -96130219954967163L;

    private String id;

    private String title;

    private Boolean done;

    private Boolean ifdelete;

    private String info;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Boolean getIfdelete() {
        return ifdelete;
    }

    public void setIfdelete(Boolean ifdelete) {
        this.ifdelete = ifdelete;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Todolist{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", done=" + done +
                ", ifdelete=" + ifdelete +
                ", info='" + info + '\'' +
                '}';
    }
}