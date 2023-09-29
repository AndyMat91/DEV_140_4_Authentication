package com.example.dev_140_4_authentication.controllers;

import com.example.dev_140_4_authentication.stages.ClientsStage;
import com.example.dev_140_4_authentication.database.Repository;
import com.example.dev_140_4_authentication.models.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.sql.SQLException;


public class AuthenticationController {

    @FXML
    private Label result;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField userNameField;

    @FXML
    protected void passwordFieldOnKeyPressed() {
        passwordField.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                authentication();
            }
        });
    }

    @FXML
    protected void userNameFieldOnKeyPressed() {
        userNameField.setOnKeyPressed(e -> {
            if (e.getCode().toString().equals("ENTER")) {
                authentication();
            }
        });
    }

    @FXML
    private void authentication() {
        Repository repository = new Repository();
        try {
            for (Users i :
                    repository.findAllUsers()) {
                if (i.equalsNamePassword(new Users(userNameField.getText(), passwordField.getText()))) {
                    new ClientsStage().show();
                } else {
                    result.setText("Неверный логин или пароль");
                }
            }
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
