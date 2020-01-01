package com.Tubes.controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
public class LoginController extends Application  {




    
    public Button btnLogin;
  public TextField txtUsername;
  public PasswordField txtPassword;
  private String username, password;
    Scene scene1;


    public static void main(String[] args) {
      launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("View Login System.fxml"));
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
    }


    public void loginAction(ActionEvent actionEvent) throws IOException, SQLException {
      username = txtUsername.getText();
      password = txtPassword.getText();

      PreparedStatement preparedStatement = null;
      ResultSet resultSet = null;
      String sql;

      sql = "SELECT * FROM users WHERE Inlognaam = 1 AND Wachtwoord = 2";
      preparedStatement.setString(1, username);
      preparedStatement.setString(2, password);
      resultSet = preparedStatement.executeQuery(sql);

      if (!resultSet.next()) {
        System.out.println("Login Failed");
      } else {
        Parent root1 = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Stage secondarystage = new Stage();
        secondarystage.setScene(new Scene(root1));
        secondarystage.show();
        Stage stage = (Stage) btnLogin.getScene().getWindow();
        stage.close();
      }
      txtUsername.setText("");
      txtPassword.setText("");
    }

  }
}
