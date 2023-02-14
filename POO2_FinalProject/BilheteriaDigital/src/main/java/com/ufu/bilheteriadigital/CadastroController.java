package com.ufu.bilheteriadigital;

import Classes.DadosFacade;

import Classes.User;
import static com.ufu.bilheteriadigital.App.dadosCarregar;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

public class CadastroController implements Initializable {

    @FXML
    private Button botaoCadastrar;

    @FXML
    private TextField inputCPF;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputSenha;

    @FXML
    private TextField inputConfirmaSenha;

    @FXML
    void botaoCadastrar(ActionEvent event) {
        // Verifica se o campo de CPF está preenchido
        if (inputCPF.getText().isEmpty()) {
            // Exibe mensagem de erro para o usuário
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro de cadastro");
            alert.setHeaderText("CPF não informado");
            alert.setContentText("Por favor, informe um CPF válido para cadastro.");
            alert.showAndWait();
        } else {
            // Verifica se as senhas digitadas são iguais
            if (inputSenha.getText().equals(inputConfirmaSenha.getText())) {
                // Verifica se o nome está preenchido
                if (inputNome.getText().isEmpty()) {
                    // Exibe mensagem de erro para o usuário
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erro de cadastro");
                    alert.setHeaderText("Nome não informado");
                    alert.setContentText("Por favor, informe um nome válido para cadastro.");
                    alert.showAndWait();
                } else {
                    // Realiza a validação do CPF
                    if (validaCPF(inputCPF.getText())) {

                        User newUser = new User(inputCPF.getText(), inputNome.getText(), inputSenha.getText());
                        dadosCarregar.cadastrarUsuario(newUser);
                        //aqui caique

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Cadastro realizado");
                        alert.setHeaderText("Cadastro realizado com sucesso!");
                        alert.setContentText("Seja bem-vindo(a) " + inputNome.getText() + "!");
                        alert.showAndWait();
                    } else {
                        // Exibe mensagem de erro para o usuário
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro de cadastro");
                        alert.setHeaderText("CPF inválido");
                        alert.setContentText("Por favor, informe um CPF válido para cadastro.");
                        alert.showAndWait();
                    }
                }
            } else {
                // Exibe mensagem de erro para o usuário
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro de cadastro");
                alert.setHeaderText("Senhas não conferem");
                alert.setContentText("Por favor, digite a mesma senha nos dois campos para confirmação.");
                alert.showAndWait();
            }
        }
    }

    private boolean validaCPF(String cpf) {
        return cpf.length() == 11;
    }

    @FXML
    void botaoMudaParaLogin(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
