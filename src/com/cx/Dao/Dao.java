package com.cx.Dao;

import com.cx.Impl.Film;
import com.cx.Impl.User;
import com.cx.Impl.comment;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.*;
import java.util.ArrayList;

public class Dao {
    //        2.用户信息和url
    String url = "jdbc:mysql://localhost:3306/film?useUnicode=true&characterEncoding=utf8&useSSL=true";
    String username="root";
    String password="8888";
    //        3.连接成功，数据库对象 Connection
    Connection connection = DriverManager.getConnection(url,username,password);
    Statement statement = connection.createStatement();

    public Dao() throws SQLException {
    }

  public int Login(User user){
        String sql="SELECT * FROM user WHERE name='"+user.getName()+"' AND password='"+user.getPassword()+"'";
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            if(resultSet.next()){
                return 1;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

   public ArrayList<Film> Select_films(){
        ArrayList<Film> films=new ArrayList<>();
        String sql="SELECT * FROM film";
        try {
            ResultSet resultSet = statement.executeQuery(sql);

           while (resultSet.next()){
                Film film=new Film();
                film.setName(resultSet.getString("name"));
                film.setDirector(resultSet.getString("director"));
                film.setImage_Url(resultSet.getString("image_url"));
                film.setIntroduction(resultSet.getString("introduction"));
                film.setTime(resultSet.getString("time"));
                ArrayList<String> strings=new ArrayList<>();
               String[] lead_actors = resultSet.getString("lead_actor").split(",");
               for (int i=0;i<lead_actors.length;i++){
                   strings.add(lead_actors[i]);
               }
               film.setLead_actor(strings);

                films.add(film);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }
    public ArrayList<comment>  getComment(){

        ArrayList<comment> comments=new ArrayList<>();

        String sql="SELECT * FROM comment";
        try {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
               comment comment=new comment(resultSet.getString("Film_Name"),resultSet.getString("name"),resultSet.getString("comment"));

               comments.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
    public void Add_comment(comment comment){
        String sql="INSERT INTO comment VALUES ('"+comment.getFilm_Name()+"','"+comment.getName()+"','"+comment.getComment()+"')";
        try {
            int resultSet = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
