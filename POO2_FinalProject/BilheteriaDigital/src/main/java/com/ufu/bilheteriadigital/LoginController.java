/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ufu.bilheteriadigital;

import Classes.DadosFacade;
import static com.ufu.bilheteriadigital.App.dadosCarregar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javafx.scene.control.TextField;


public class LoginController implements Initializable {
 
   
    
    @FXML
    private TextField inputCpfLogin;

    @FXML
    private TextField inputUserPassword;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void btnLogin(ActionEvent event) throws IOException {
        //fazer a verificação, se estiver certo, executar o codigo abaixo para ir para a tela de login
          Alert alert = new Alert(Alert.AlertType.ERROR);
           Alert alertc = new Alert(Alert.AlertType.CONFIRMATION);
        if(inputCpfLogin.getText().isEmpty() || inputUserPassword.getText().isEmpty()){
           
            alert.setTitle("Erro de login");
            alert.setHeaderText("Campos Vazios");
            alert.setContentText("Por favor, preencha Todos Os campos");
            alert.showAndWait();
        }else if(!dadosCarregar.validarLogin(inputCpfLogin.getText(), inputUserPassword.getText())){
            alert.setTitle("Erro de login");
            alert.setHeaderText("CPF ou SENHA invalido");
            alert.setContentText("Por favor, tente novamente");
            alert.showAndWait();
        }else{
            /* amigo fez isso
             JOptionPane.showMessageDialog(rootPane, "LOGIN FEITO COM SUCESSO!\nBEM VINDO AO SISTEMA DE BILHETERIA DIGITAL!!");
            formMenuPrincipal telaMenuPrincipal = new formMenuPrincipal();
            telaMenuPrincipal.carregarDados(dadosList);
            telaMenuPrincipal.getUser(campoUserLogin.getText());
            this.setVisible(false);
            telaMenuPrincipal.setVisible(true);         
*/
            alertc.setTitle("Login Efetuado");
            
            alertc.setContentText("Login foi um sucesso");
            alertc.showAndWait();
            App.setRoot("menuPrincipal");
        }
        
      //  FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource( "MenuPrincipal.fxml"));
        
     
     //  fxmlLoader.setController(new MenuPrincipalController(dadosCarregar));
       
    }

    @FXML
    private void btnRegisterLogin(ActionEvent event) throws IOException {
        App.setRoot("cadastro");
    }

}
