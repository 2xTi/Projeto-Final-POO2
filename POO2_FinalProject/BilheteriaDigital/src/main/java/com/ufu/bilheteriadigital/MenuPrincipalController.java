
package com.ufu.bilheteriadigital;

import Classes.DadosFacade;
import Classes.User;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class MenuPrincipalController implements Initializable {

    
     //private User user = new User("sdad", "sdfaf", "sfad");
     
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    @FXML
    private void btnPerfil(ActionEvent event) throws IOException {
        App.setRoot("exibeUser");
        
    }

    @FXML
    private void btnCadastrarFilme(ActionEvent event) throws IOException {
        App.setRoot("cadastroFilme");
    }

    @FXML
    private void btnMostrarMeusIngressos(ActionEvent event) {
        //PRECISA FAZER ESSA TELA
    }

    @FXML
    private void btnAlterarFilme(ActionEvent event) throws IOException {
        App.setRoot("alterarFilme");
    }

    @FXML
    private void btnAlterarSenha(ActionEvent event) throws IOException {
        App.setRoot("alterarSenha");
    }

    @FXML
    private void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void btnComprarIngressos(ActionEvent event) throws IOException {
        App.setRoot("comprarIngressos");
    }

    @FXML
    private void btnCatalogoFilmes(ActionEvent event) {
       // App.setRoot("catalogoFilmes");
    }

}
