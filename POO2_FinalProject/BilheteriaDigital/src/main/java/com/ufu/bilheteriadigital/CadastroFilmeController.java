package com.ufu.bilheteriadigital;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;

import Classes.Filme;
import Classes.DadosFacade;
import static com.ufu.bilheteriadigital.App.dadosCarregar;

public class CadastroFilmeController implements Initializable {

    private String userLogado;

    @FXML
    private TextField inputCodFilme;
    @FXML
    private TextField inputMovieName;
    @FXML
    private TextField inputTicketPrice;
    @FXML
    private TextField inputMovieProducer;
    @FXML
    private TextField inputDiretor;
    @FXML
    private TextField inputMovieParentalRating;
    @FXML
    private TextField inputTicketQtd;
    @FXML
    private TextField inputSinopse;

    public void getUser(String userLogado) {
        this.userLogado = userLogado;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    Alert alert = new Alert(Alert.AlertType.ERROR);
    Alert alertc = new Alert(Alert.AlertType.CONFIRMATION);

    @FXML
    private void btnCadastraFilme(ActionEvent event) {
        if (inputCodFilme.getText().isEmpty()
                || inputMovieName.getText().isEmpty()
                || inputTicketPrice.getText().isEmpty()
                || inputMovieParentalRating.getText().isEmpty()
                || inputTicketQtd.getText().isEmpty()) {

            alert.setTitle("Erro de cadastro");
            alert.setHeaderText("Preencha os campos");
            alert.showAndWait();
        } else if (!dadosCarregar.verificaCodFilme(inputCodFilme.getText())) {
            alert.setTitle("Erro de cadastro");
            alert.setHeaderText("ESSE CODIGO JA FOI UTILIZADO EM UM FILME!!");
            alert.showAndWait();
        } else {

            Filme novoFilme = new Filme.FilmeBuilder()
                    .codigo(inputCodFilme.getText())
                    .nomeFilme(inputMovieName.getText())
                    .valorIngresso(Float.parseFloat(inputTicketPrice.getText()))
                    .qntdIngressos(Integer.parseInt(inputTicketQtd.getText()))
                    .sinopse(inputSinopse.getText())
                    .diretor(inputDiretor.getText())
                    .idade(inputMovieParentalRating.getText())
                    .produtora(inputMovieProducer.getText())
                    .criarFilme();
            dadosCarregar.cadastrarFilme(novoFilme);
            alertc.setTitle("Cadastro Efetuado");
            alertc.setHeaderText("Filme novo cadastrado com sucesso!");
            alertc.showAndWait();

        }

    }

    @FXML
    private void btnBack(ActionEvent event) throws IOException {
        App.setRoot("menuPrincipal");
    }

    private void alert(String campos_em_branco_por_favor_preencha_todos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
