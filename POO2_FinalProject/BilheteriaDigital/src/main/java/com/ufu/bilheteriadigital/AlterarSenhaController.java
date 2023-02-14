package com.ufu.bilheteriadigital;

import Classes.DadosFacade;
import static com.ufu.bilheteriadigital.App.dadosCarregar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import javafx.scene.layout.Pane;

public class AlterarSenhaController implements Initializable {

   
    private String userLogado;

   

    Alert alertc = new Alert(Alert.AlertType.CONFIRMATION);
    Alert alert = new Alert(Alert.AlertType.ERROR);

    @FXML
    private Pane wrapperContetAlterarSenha;

    @FXML
    private TextField inputNewPassword;

    @FXML
    private TextField inputConfirmNewPassword;
    
    @FXML
    private TextField inputCpf;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAlteraSenha(ActionEvent event) {

        if (inputNewPassword.getText().isEmpty() || inputConfirmNewPassword.getText().isEmpty() || inputCpf.getText().isEmpty()) {
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao alterar senha");
            alert.setContentText("A senha não atende aos critérios de segurança");
            alert.showAndWait();
        } else if (!inputNewPassword.getText().equals(inputConfirmNewPassword.getText())) {
            alert.setTitle("Erro");
            alert.setHeaderText("Erro ao alterar senha");
            alert.setContentText("As senhas não são iguais");
            alert.showAndWait();
        } else {
            //altera aqui
            dadosCarregar.alterarSenha(inputCpf.getText(), inputNewPassword.getText());

            alertc.setTitle("Sucesso");
            alertc.setHeaderText("Senha alterada com sucesso");
            alertc.showAndWait();
        }
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

}
