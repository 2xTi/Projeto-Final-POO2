
package com.ufu.bilheteriadigital;

import Classes.Filme;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import static com.ufu.bilheteriadigital.App.dadosCarregar;
import java.util.List;

import javafx.scene.control.ListView;

public class ComprarIngressosController implements Initializable {
    
 @FXML private ListView<Filme> listMovies;
   

    private List<Filme> eventosListaMostrar;
    
    ObservableList<Filme> items;

    public ComprarIngressosController() {
       
        
    }
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOcarregarTableIngressoDisponiveis
         try{
            carregarTableIngressoDisponiveis();
        }catch(Exception e){
            
        }
      
    }
 @FXML
    private void botaoComprarIngresso(ActionEvent event) {
        //Filme filmeSelecionado = listMovies.getSelectionModel().getSelectedItem();
        //System.out.println(filmeSelecionado.getNomeFilme());
    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

    public void carregarTableIngressoDisponiveis() {
        eventosListaMostrar = dadosCarregar.getFilme();
        
        items =  FXCollections.observableArrayList(eventosListaMostrar);
         listMovies.setItems(items);
        
       
        
        //listMovies.setVisible(true);

    }

}
