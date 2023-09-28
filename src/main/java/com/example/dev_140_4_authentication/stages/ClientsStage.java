package com.example.dev_140_4_authentication.stages;

import com.example.dev_140_4_authentication.database.Repository;
import javafx.collections.FXCollections;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientsStage {
    public ClientsStage() {
    }

    public void show() throws SQLException, IOException {
        Stage stage = new Stage();
        stage.setTitle("Клиенты");
        stage.setScene(SceneFactory.getClientsScene());
        SceneFactory.getTableClientsController().initTable(FXCollections.observableList(new ArrayList<>(new Repository().findAllPersonsDto())));
        stage.show();
    }
}
