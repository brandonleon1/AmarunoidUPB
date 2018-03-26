package com.fxpelota.control;

import java.io.IOException;

import com.fxpelota.entity.Barra;
import com.fxpelota.entity.Bloque;
import com.fxpelota.entity.Pelota;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FxMain {
	@FXML
	private Pane paneCancha;
	@FXML
	private Button boton;


	public FxMain() {
		System.out.println("FxPelotaController constructor");
	}

	@FXML
	public void initialize() {
		
		
		
	}

	@FXML
	public void botonIniciar() {
		System.out.println("botonSalir pressed.");
		try {Stage primaryStage = new Stage();
		Parent root;
			root = FXMLLoader.load(getClass().getResource("/com/fxpelota/view/FxPelota.fxml"));
			Scene scene = new Scene(root,1421,928);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
	primaryStage.setResizable(false);
		primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
