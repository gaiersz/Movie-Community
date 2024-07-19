package com.cx.Page;

import com.cx.Dao.Dao;
import com.cx.Impl.Film;
import com.cx.Impl.comment;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.sql.SQLException;
import java.util.ArrayList;


public class MainPage {
    @FXML
    private AnchorPane an;

    public static Film film;
    public void initialize() throws SQLException {

        Dao dao=new Dao();
        ArrayList<Film> films = dao.Select_films();
        int x=50;
        int y=50;
        int c=0;
        for(int i=0;i< films.size();i++){
            ImageView imageView=new ImageView(new Image("file:"+films.get(i).getImage_Url()));
            imageView.setLayoutX(x);
            imageView.setLayoutY(y);
            int finalI = i;
            imageView.setOnMousePressed(event -> {
                ArrayList<comment> comment = dao.getComment();
                for(int i1=0;i1<comment.size();i1++){
                    if(comment.get(i1).getFilm_Name().equals(films.get(finalI).getName())){

                    }else {
                        comment.remove(i1);
                    }
                }
                film=films.get(finalI);
                Main.stage.setScene(new Scene(new Details().Details(films.get(finalI).getName(),films.get(finalI).getTime(),films.get(finalI).getDirector(),films.get(finalI).getLead_actor(),films.get(finalI).getImage_Url(),films.get(finalI).getIntroduction(),comment)));
            });
            an.getChildren().add(imageView);
            c++;
            x=x+400;
            if(c==3){
                x=50;
                y=y+500;
            }
        }


    }
}
