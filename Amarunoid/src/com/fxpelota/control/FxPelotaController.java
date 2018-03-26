package com.fxpelota.control;

import com.fxpelota.entity.Barra;
import com.fxpelota.entity.Bloque;
import com.fxpelota.entity.Pelota;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class FxPelotaController {
	@FXML
	private Pane paneCancha;
	@FXML
	private Button botonSalir;
	@FXML
	private Button botonComenzar;

	private Pelota pelota;

	private Barra barra;
	
	private Bloque[] bloque;

	private AnimationTimerPelota timerPelota;

	public FxPelotaController() {
		System.out.println("FxPelotaController constructor");
	}

	@FXML
	public void initialize() {
		System.out.println("FxPelotaController initializer");
		bloque = new Bloque[10];
		/*
		 * Limitar el espacio de la Cancha, para que la figura no se dibuje fuera
		 */
		Rectangle clip = new Rectangle(0, 0, 0, 0);
		clip.widthProperty().bind(paneCancha.widthProperty());
		clip.heightProperty().bind(paneCancha.heightProperty());
		paneCancha.setClip(clip);
		
		
		barra = new Barra(300.0, 610.0, 350.0,50.0);
		bloque[0] = new Bloque(100.0,100.0,100.0,50.0);
		bloque[1] = new Bloque(210.0,100.0,100.0,50.0);
		bloque[2] = new Bloque(320.0,100.0,100.0,50.0);
		bloque[3] = new Bloque(430.0,100.0,100.0,50.0);
		bloque[4] = new Bloque(540.0,100.0,100.0,50.0);
		bloque[5] = new Bloque(650.0,100.0,100.0,50.0);
		bloque[6] = new Bloque(760.0,100.0,100.0,50.0);
		bloque[7] = new Bloque(870.0,100.0,100.0,50.0);
		bloque[8] = new Bloque(980.0,100.0,100.0,50.0);
		bloque[9] = new Bloque(10900.0,100.0,100.0,50.0);

		
		paneCancha.getChildren().add(barra);
		paneCancha.getChildren().add(bloque[0]);
		paneCancha.getChildren().add(bloque[1]);
		paneCancha.getChildren().add(bloque[2]);
		paneCancha.getChildren().add(bloque[3]);
		paneCancha.getChildren().add(bloque[4]);
		paneCancha.getChildren().add(bloque[5]);
		paneCancha.getChildren().add(bloque[6]);
		paneCancha.getChildren().add(bloque[7]);
		paneCancha.getChildren().add(bloque[8]);
		paneCancha.getChildren().add(bloque[9]);
		
		pelota = new Pelota(300.0, 550.0, 20.0, 30.0, barra,bloque);
		paneCancha.getChildren().add(pelota);

		
		// Assuming dialogbox is at last in the children list

		timerPelota = new AnimationTimerPelota(paneCancha, pelota,bloque);
		timerPelota.start();
	}

	@FXML
	public void botonSalir() {
		System.out.println("botonSalir pressed.");
		System.exit(0);
	}

	@FXML
	public void botonComenzar() {
		System.out.println("botonComenzar pressed.");
		pelota.changeEstado();
	}

	@FXML
	public void spinnerAngulo() {
		System.out.println("spinnerAngulo changed.");
	}


	@FXML
	public void keyMoveHandler(KeyEvent ke) {
		barra.mover(paneCancha.getWidth(), paneCancha.getHeight(), ke);
	}
}
