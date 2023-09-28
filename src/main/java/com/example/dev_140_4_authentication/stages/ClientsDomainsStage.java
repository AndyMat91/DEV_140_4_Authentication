package com.example.dev_140_4_authentication.stages;

import com.example.dev_140_4_authentication.database.Repository;
import com.example.dev_140_4_authentication.models.PersonDto;
import javafx.collections.FXCollections;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientsDomainsStage {
    private PersonDto personDto;

    public ClientsDomainsStage(PersonDto personDto) {
        this.personDto = personDto;
    }

    public PersonDto getPersonDto() {
        return personDto;
    }

    public void setPersonDto(PersonDto personDto) {
        this.personDto = personDto;
    }

    public void show() throws SQLException, IOException {
        Stage stage = new Stage();
        stage.setTitle("Домены клиента");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(SceneFactory.getDomainsScene());
        SceneFactory.getTableDomainsController().initTable(FXCollections.observableList(new ArrayList<>(new Repository().findAllClientsDomains(personDto.getId()))));
        stage.showAndWait();
    }
}
