module com.example.dev_140_1_authentication {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.dev_140_4_authentication to javafx.fxml;
    exports com.example.dev_140_4_authentication;
    exports com.example.dev_140_4_authentication.controllers;
    opens com.example.dev_140_4_authentication.controllers to javafx.fxml;
    exports com.example.dev_140_4_authentication.models;
    opens com.example.dev_140_4_authentication.models to javafx.fxml;
    exports com.example.dev_140_4_authentication.stages;
    opens com.example.dev_140_4_authentication.stages to javafx.fxml;
    exports com.example.dev_140_4_authentication.database;
    opens com.example.dev_140_4_authentication.database to javafx.fxml;
}