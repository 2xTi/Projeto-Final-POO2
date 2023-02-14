/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ufu.bilheteriadigital;

import Classes.User;
import static com.ufu.bilheteriadigital.App.dadosCarregar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ExibeUserController implements Initializable {

    public ExibeUserController() {
        
    }


    @FXML
    private TextField inputCPF;
    @FXML
    private TextField inputNome;
    @FXML
    private Button botaoCadastrar;
    
     User logado;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         logado = dadosCarregar.getUser(dadosCarregar.getIndexUserLogado());
        
         inputCPF.setText(logado.getCpf());
         inputNome.setText(logado.getNomeCompleto());
    }    
    
    @FXML
    private void botaoDeletar(ActionEvent event) throws IOException {
        dadosCarregar.deletaUser(logado);
        App.setRoot("login");
    }

    @FXML
    private void botaoVoltar(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

}
