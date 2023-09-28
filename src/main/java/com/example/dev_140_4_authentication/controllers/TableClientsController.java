package com.example.dev_140_4_authentication.controllers;

import com.example.dev_140_4_authentication.stages.ClientsDomainsStage;
import com.example.dev_140_4_authentication.models.PersonDto;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;

import java.io.IOException;
import java.sql.SQLException;

public class TableClientsController {
    @FXML
    private TableView<PersonDto> table;
    @FXML
    private TableColumn<PersonDto, Integer> idCol;
    @FXML
    private TableColumn<PersonDto, String> jobCol;
    @FXML
    private TableColumn<PersonDto, String> fioCol;
    @FXML
    private TableColumn<PersonDto, String> phoneCol;
    @FXML
    private TableColumn<PersonDto, String> emailCol;
    @FXML
    private TableColumn<PersonDto, String> countCol;


    public void initTable(ObservableList<PersonDto> persons) {
        if (table.getItems().size() < 1) {
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            jobCol.setCellValueFactory(new PropertyValueFactory<>("jobtitle"));
            fioCol.setCellValueFactory(new PropertyValueFactory<>("firstnamelastname"));
            phoneCol.setCellValueFactory(new PropertyValueFactory<>("phone"));
            emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
            countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
            table.setItems(persons);
        }
    }

    public void onMouseClicked() {
        table.setOnMouseClicked((mouseEvent) -> {
            int count = mouseEvent.getClickCount();
            if (count == 2 && mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                PersonDto personDto = (PersonDto) table.getSelectionModel().getSelectedItem();
                try {
                    new ClientsDomainsStage(personDto).show();
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void onKeyPressed() {
        table.setOnKeyPressed((keyEvent) -> {
            if (keyEvent.getCode() == KeyCode.ENTER) {
                PersonDto personDto = (PersonDto) table.getSelectionModel().getSelectedItem();
                try {
                    new ClientsDomainsStage(personDto).show();
                } catch (SQLException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
