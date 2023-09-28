package com.example.dev_140_4_authentication.stages;

import com.example.dev_140_4_authentication.AuthenticationApp;
import com.example.dev_140_4_authentication.controllers.TableClientsController;
import com.example.dev_140_4_authentication.controllers.TableDomainsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneFactory {
    private static Scene rootScene;
    private static Scene clientsScene;
    private static Scene domainsScene;
    private static TableDomainsController tableDomainsController;
    private static TableClientsController tableClientsController;

    public static Scene getRootScene() throws IOException {
        if (rootScene == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(AuthenticationApp.class.getResource("authentication-view.fxml"));
            rootScene = new Scene(fxmlLoader.load(), 320, 240);
        }
        return rootScene;
    }

    public static Scene getClientsScene() throws IOException {
        if (clientsScene == null) {
            FXMLLoader fxmlLoader = new FXMLLoader(AuthenticationApp.class.getResource("clients-view.fxml"));
            clientsScene = new Scene(fxmlLoader.load(), 960, 720);
            tableClientsController = (TableClientsController) fxmlLoader.getController();
        }
        return clientsScene;
    }

    public static Scene getDomainsScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AuthenticationApp.class.getResource("domains-view.fxml"));
        domainsScene = new Scene(fxmlLoader.load(), 960, 720);
        tableDomainsController = (TableDomainsController) fxmlLoader.getController();
        return domainsScene;
    }

    public static TableClientsController getTableClientsController() {
        return tableClientsController;
    }

    public static TableDomainsController getTableDomainsController() {
        return tableDomainsController;
    }

}
