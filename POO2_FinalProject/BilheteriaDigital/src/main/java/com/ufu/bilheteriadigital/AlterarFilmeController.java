/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.ufu.bilheteriadigital;

import Classes.DadosFacade;
import Classes.Filme;
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

public class AlterarFilmeController implements Initializable {
    
    @FXML
    private TextField inputCodFilme;

    @FXML
    private TextField inputTicketPriceUpdate;

    @FXML
    private TextField inputSinopse;

    @FXML
    private TextField inputTicketQtdUpdate;

    @FXML
    private TextField inputParentalRatingUpdate;

    @FXML
    private TextField inputProducerUpdate;

    @FXML
    private TextField inputDiretorUpdate;

    @FXML
    private TextField inputMovieName;

   
    private String userLogado;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnConfirmMovieUpdate(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        /// try {
        if (inputMovieName.getText().isEmpty()
                || inputTicketPriceUpdate.getText().isEmpty()
                || inputTicketQtdUpdate.getText().isEmpty()) {

            alert.setTitle("Erro");
            alert.setHeaderText("Erro na atualização do filme");
            alert.setContentText("CAMPOS VAZIOS. PREENCHA OS CAMPOS");
            alert.showAndWait();

        } else if (!inputParentalRatingUpdate.getText().equals("livre")
                && !inputParentalRatingUpdate.getText().equals("10")
                && !inputParentalRatingUpdate.getText().equals("12")
                && !inputParentalRatingUpdate.getText().equals("14")
                && !inputParentalRatingUpdate.getText().equals("16")
                && !inputParentalRatingUpdate.getText().equals("18")) {
            alert.setTitle("Erro");
            alert.setHeaderText("Erro na atualização do filme");
            alert.setContentText("O campo 'Classificação indicativa' é obrigatório e só pode ser preenchido com os valores 'livre', '10','12','14','16','18'.");
            alert.showAndWait();
        } else if (dadosCarregar.verificaCodFilme(inputCodFilme.getText())) {
            alert.setTitle("Erro");
            alert.setHeaderText("Erro na atualização do filme");
            alert.setContentText("Codigo de filme nao foi Encontrado");
            alert.showAndWait();
        } else if (Double.parseDouble(inputTicketPriceUpdate.getText()) < 0) {
            alert.setTitle("Erro");
            alert.setHeaderText("Erro na atualização do filme");
            alert.setContentText("O campo 'Preço do Ingresso' é obrigatório e não pode ser vazio ou menor que 0.");
            alert.showAndWait();
        } else if (Integer.parseInt(inputTicketQtdUpdate.getText()) <= 0) {
            alert.setTitle("Erro");
            alert.setHeaderText("Erro na atualização do filme");
            alert.setContentText("O campo 'Quantidade de ingressos' não pode ser menor ou igual a 0.");
            alert.showAndWait();
        } else {

            Filme filmeAlterado = new Filme.FilmeBuilder()
                    .codigo(inputCodFilme.getText())
                    .nomeFilme(inputMovieName.getText())
                    .valorIngresso(Float.parseFloat(inputTicketPriceUpdate.getText()))
                    .qntdIngressos(Integer.parseInt(inputTicketQtdUpdate.getText()))
                    .sinopse(inputSinopse.getText())
                    .diretor(inputDiretorUpdate.getText())
                    .idade(inputParentalRatingUpdate.getText())
                    .produtora(inputProducerUpdate.getText())
                    .criarFilme();
            dadosCarregar.alterarDadosFilme(filmeAlterado);

            alert.setTitle("Alteracao Efetuado");
            alert.setHeaderText("Filme alterado com sucesso!");
            alert.showAndWait();
        }

        //   } catch (NumberFormatException e) {
        //        alert.setTitle("Erro");
        //        alert.setHeaderText("Erro na atualização do filme");
        //         alert.setContentText("Foi colocado um valor invalido para ingresso");
        //         alert.showAndWait();
        //    }
    }

    @FXML
    private void botaoVoltar(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

}
