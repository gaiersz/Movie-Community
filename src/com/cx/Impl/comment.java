package com.cx.Impl;

public class comment {
    private String Film_Name;//电影名
    private String name;//评价者名
    private String comment;//评论

    public comment(String film_Name, String name, String comment) {
        Film_Name = film_Name;
        this.name = name;
        this.comment = comment;
    }

    public String getFilm_Name() {
        return Film_Name;
    }

    public void setFilm_Name(String film_Name) {
        Film_Name = film_Name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
