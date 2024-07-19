package com.cx.Impl;

import java.util.ArrayList;

public class Film {
    private String name;//电影名
    private String time;//上映时间
    private String director;//导演
    private ArrayList<String> Lead_actor;//主演名单
    private String image_Url;//图片
    private String introduction;//简介

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<String> getLead_actor() {
        return Lead_actor;
    }

    public void setLead_actor(ArrayList<String> lead_actor) {
        Lead_actor = lead_actor;
    }

    public String getImage_Url() {
        return image_Url;
    }

    public void setImage_Url(String image_Url) {
        this.image_Url = image_Url;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
