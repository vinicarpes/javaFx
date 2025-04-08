package br.edu.ifsc.fln.prjjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nome;
    @FXML
    private TextField sobreNome;


    @FXML
    protected void onDeleteButtonClick(){
        welcomeText.setText("");
    }

    @FXML
    protected void onButtonClick() {
        welcomeText.setText("Welcome " + nome.getText() + " " + sobreNome.getText() + "!");
    }
}