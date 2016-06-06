package com.malsolec.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import com.malsolec.formpage.FormPage;
import com.malsolec.formpage.FormPagePosition;
import com.malsolec.formpage.NameFormPage;
import com.malsolec.model.User;
import com.malsolec.config.Config;

import java.io.IOException;


public class Controller{

    @FXML private TextField textFieldInput;
    @FXML private Label barLabel;
    @FXML private Pane root;
    @FXML private Button buttonBack;

    private FormPage currentFormPage = new NameFormPage();
    private User user = new User();


    @FXML
    protected void next() throws IOException {

        currentFormPage.save(textFieldInput.getText(), user);
        if(currentFormPage.getViewPosition().equals(FormPagePosition.LAST))
            changeView();
        else {
            currentFormPage = currentFormPage.next();
            buttonBack.setVisible(true);
            barLabel.setText(currentFormPage.getLabel());
            textFieldInput.setText(currentFormPage.getValue(user));
        }
    }

    private void changeView() throws IOException {
        SummaryController summaryController = new SummaryController(user);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Config.SUMMARY_VIEW_PATH));
        loader.setController(summaryController);

        Stage stage = (Stage) root.getScene().getWindow();
        root = (BorderPane)loader.load();
        stage.setScene(new Scene(root, Config.SCENE_WIDTH, Config.SCENE_HEIGHT));
    }

    @FXML
    public void back() {
        currentFormPage.save(textFieldInput.getText(), user);
        currentFormPage = currentFormPage.back();
        barLabel.setText(currentFormPage.getLabel());
        textFieldInput.setText(currentFormPage.getValue(user));

        if(currentFormPage.getViewPosition().equals(FormPagePosition.FIRST))
            buttonBack.setVisible(false);
    }
}
