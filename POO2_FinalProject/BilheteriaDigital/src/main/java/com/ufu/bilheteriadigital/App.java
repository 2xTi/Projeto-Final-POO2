package com.ufu.bilheteriadigital;

import Classes.DadosFacade;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class App extends Application {

    private static Scene scene;
    static DadosFacade dadosCarregar = new DadosFacade();

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("login"), 700, 600);
        stage.setScene(scene);
        stage.show();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
      // fxmlLoader.setController(new LoginController(dadosCarregar));
        //fxmlLoader.setController(new MenuPrincipalController(dadosCarregar));
 
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}