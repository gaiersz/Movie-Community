package com.cx.Page;

import com.cx.Dao.Dao;
import com.cx.Impl.comment;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Details {
    BorderPane Details(String name, String time, String director, ArrayList<String> Lead_actor, String image_Url, String introduction,ArrayList<comment> comments) {
        BorderPane borderPane=new BorderPane();
        ScrollPane scrollPane = new ScrollPane();
        GridPane gridPane = new GridPane();
        Label label = new Label("电影名:  " + name);
        Label label1 = new Label("上映时间： " + time);
        Label label2 = new Label("导演： " + director);
        String s = "主演：";
        for (int i = 0; i < Lead_actor.size(); i++) {
            s = s + Lead_actor.get(i) + ",";
        }
        Label label3 = new Label(s);
        ImageView imageView = new ImageView(new Image("file:" + image_Url));
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setText("简介：" + "\r\n" + introduction);
        ListView<Label> labelListView = new ListView<>();

        Label label4 = new Label("评论：");

        ArrayList<Label> labels = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            labels.add(new Label(comments.get(i).getComment()));
        }
        labelListView.setItems(FXCollections.observableList(labels));
        labelListView.setEditable(false);
        gridPane.add(imageView, 0, 1);
        gridPane.add(label, 0, 2);
        gridPane.add(label1, 0, 3);
        gridPane.add(label2, 0, 4);
        gridPane.add(label3, 0, 5);
        gridPane.add(textArea, 0, 6);
        gridPane.add(label4, 0, 7);
        gridPane.add(labelListView, 0, 8);
        scrollPane.setContent(gridPane);
        TextField textField=new TextField();
        GridPane gridPane1=new GridPane();
        textField.setPromptText("我也说两句：.....");
        Button button=new Button("发送");
        button.setOnAction(event -> {
            String text = textField.getText();
            try {
                Dao dao=new Dao();
                dao.Add_comment(new comment(MainPage.film.getName(),Login.user.getName(),text));
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("评论");
                alert.setContentText("评论成功！！");
                alert.showAndWait();
                ArrayList<comment> comment = dao.getComment();
                for(int i1=0;i1<comment.size();i1++){
                    if(comment.get(i1).getFilm_Name().equals(MainPage.film.getName())){

                    }else {
                        comment.remove(i1);
                    }
                }
                Main.stage.setScene(new Scene(new Details().Details(MainPage.film.getName(),MainPage.film.getTime(),MainPage.film.getDirector(),MainPage.film.getLead_actor(),MainPage.film.getImage_Url(),MainPage.film.getIntroduction(),comment)));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        gridPane1.add(textField,0,0);
        gridPane1.setPadding(new Insets(50,50,40,40));

        gridPane1.add(button,2,0);

        Button button1=new Button("返回");
        button1.setOnAction(event -> {
            Main.stage.setScene(Login.scene);
        });
        borderPane.setTop(button1);

        borderPane.setCenter(scrollPane);
        borderPane.setBottom(gridPane1);
        return borderPane;
    }
}
