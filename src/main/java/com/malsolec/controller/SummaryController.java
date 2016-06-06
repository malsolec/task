package com.malsolec.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.malsolec.model.User;


public class SummaryController {

    @FXML private Label name;
    @FXML private Label surname;
    @FXML private Label address;
    @FXML private Label phoneNumber;
    private User user;


    public SummaryController(User user){
        this.user =  user;
    }

    @FXML
    public void initialize(){
        this.name.setText(user.name);
        this.surname.setText(user.surname);
        this.address.setText(user.address);
        this.phoneNumber.setText(user.phoneNumber);
    }

}
