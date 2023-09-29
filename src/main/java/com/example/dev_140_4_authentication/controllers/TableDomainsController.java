package com.example.dev_140_4_authentication.controllers;

import com.example.dev_140_4_authentication.AuthenticationApp;
import com.example.dev_140_4_authentication.models.Domain;
import com.example.dev_140_4_authentication.stages.ClientsDomainsStage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class TableDomainsController {
    @FXML
    private TableView<Domain> table;
    @FXML
    private TableColumn<Domain, Integer> idCol;
    @FXML
    private TableColumn<Domain, String> webCol;
    @FXML
    private TableColumn<Domain, String> domCol;
    @FXML
    private TableColumn<Domain, String> ipCol;
    @FXML
    private TableColumn<Domain, Date> dateCol;
    @FXML
    private TableColumn<Domain, String> countryCol;
    @FXML
    private TableColumn<Domain, Integer> personIdCol;

    private String css;

    @FXML
    public void changeStyle() {
        String css1 = AuthenticationApp.class.getResource("Style1.css").toExternalForm();
        String css2 = AuthenticationApp.class.getResource("Style2.css").toExternalForm();
        if(css!=null && css.equals(css1)){
            css = css2;
        }else {
            css = css1;
        }
        Scene scene = table.getScene();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(css);
    }

    public void initTable(ObservableList<Domain> domains) {
        if (table.getItems().size() < 1) {
            idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            webCol.setCellValueFactory(new PropertyValueFactory<>("webname"));
            domCol.setCellValueFactory(new PropertyValueFactory<>("domainname"));
            ipCol.setCellValueFactory(new PropertyValueFactory<>("ip"));
            dateCol.setCellValueFactory(new PropertyValueFactory<>("datereg"));
            countryCol.setCellValueFactory(new PropertyValueFactory<>("countryreg"));
            personIdCol.setCellValueFactory(new PropertyValueFactory<>("personid"));
            table.setItems(domains);
        }
    }
}
