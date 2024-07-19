package com.cx.Page;

import com.cx.Dao.Dao;
import com.cx.Impl.comment;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
  public static Stage stage;
  public static Scene scene;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage=primaryStage;
        scene=new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
       // stage.setScene(new Scene(new Details().Details("cc","cc","cc",new ArrayList<String>(),"src/com/cx/Image/img_1.png","cc",new ArrayList<comment>())));
        stage.setScene(scene);
       stage.show();
    }
}
