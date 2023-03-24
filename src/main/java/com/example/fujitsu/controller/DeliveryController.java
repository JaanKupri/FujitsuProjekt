package com.example.fujitsu.controller;

import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.collection.spi.LazyInitializable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ResourceBundle;

@RestController
public class DeliveryController implements Initializable {

    private static final Logger log = LogManager.getLogger(DeliveryController.class);


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to my application! ";
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
