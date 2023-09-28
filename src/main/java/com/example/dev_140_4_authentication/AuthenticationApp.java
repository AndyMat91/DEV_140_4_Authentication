package com.example.dev_140_4_authentication;

import com.example.dev_140_4_authentication.stages.SceneFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;


public class AuthenticationApp extends Application {
    private Stage stage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void init() throws Exception {
        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setResizable(false);
        stage.setTitle("JavaFX Welcome");
        stage.setScene(SceneFactory.getRootScene());
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
    }
}