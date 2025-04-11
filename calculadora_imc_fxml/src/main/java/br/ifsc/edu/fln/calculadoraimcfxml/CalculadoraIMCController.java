package br.ifsc.edu.fln.calculadoraimcfxml;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CalculadoraIMCController {
    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldPeso;

    @FXML
    private TextField textFieldAltura;

    @FXML
    private TextField textFieldIdade;

    ObservableList<String> options = FXCollections.observableArrayList("Masculino", "Feminino");

    @FXML
    private ChoiceBox choiceBoxSexo;

    @FXML
    private void initialize() {
        choiceBoxSexo.setItems(options);
    }

    @FXML
    protected void onActionButtonCalcular() {
        float altura = Float.parseFloat(textFieldAltura.getText());
        float peso = Float.parseFloat(textFieldPeso.getText());
        float idade = Float.parseFloat(textFieldIdade.getText());
        String nome = textFieldNome.getText();
        String sexo = (String) choiceBoxSexo.getValue();

        float imc = calcularIMC(peso, altura);

        mostrarIMC(nome, sexo, peso, altura, imc, idade);
    }

    private String classificarIMC(float imc) {
        String classificacao;

        if (imc < 18.5) {
            classificacao = "Baixo peso";
        }
        else if (imc < 24.9) {
            classificacao = "Peso adequado";
        }
        else if (imc < 29.9) {
            classificacao = "Sobrepeso";
        }  else if (imc < 34.9) {
            classificacao = "Obesidade I";
        }  else if (imc < 39.9) {
            classificacao = "Obesidade II";
        } else {
            classificacao = "Obesidade extrema";
        }

        return classificacao;
    }

    public float calcularIMC(float peso, float altura) {
        return Math.round(peso/(altura*altura));
    }

    public void mostrarIMC(String nome, String Sexo, float peso, float altura, float imc, float idade) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cálculo de IMC");
        alert.setHeaderText("Demonstrativo do IMC");

        StringBuilder texto = new StringBuilder();
        texto.append("Nome: ").append(nome).append("\n")
                .append("Sexo: ").append(Sexo).append("\n")
                .append("Peso: ").append(peso).append("\n")
                .append("Altura: ").append(altura).append("\n")
                .append("Idade: ").append(idade).append("\n\n")
                .append("IMC: ").append(imc).append("\n")
                .append("Classificação: ").append(classificarIMC(imc));

        alert.setContentText(texto.toString());

        alert.showAndWait();
    }

    @FXML
    protected void limparForm(){
        textFieldNome.clear();
        textFieldAltura.clear();
        textFieldPeso.clear();
        textFieldIdade.clear();
        choiceBoxSexo.setValue(null);
    }

}
