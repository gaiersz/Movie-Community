package com.cx.Page;

import com.cx.Dao.Dao;
import com.cx.Impl.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class Login {
  @FXML
 private Button button;
  @FXML
  private TextField username;
  @FXML
  private PasswordField password;

  public static Scene scene;
  public static User user;


  public void initialize(){

    button.setOnAction(event -> {
      try {
        Dao dao=new Dao();
       if( dao.Login(new User(username.getText(),password.getText()))==1){
         user=new User(username.getText(),password.getText());
         scene=new Scene(FXMLLoader.load(getClass().getResource("Main.fxml")));
         Main.stage.setScene(scene);
       }else {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("登陆失败");
         alert.setContentText("请检查密码或者账户名！！！");

         alert.showAndWait();
       }
      } catch (SQLException | IOException e) {
        e.printStackTrace();
      }
    });
    }
}
