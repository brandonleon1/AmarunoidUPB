package com.fxpelota.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Barra extends ImageView {
	private boolean estado;
	private boolean cara;
	private Image image;


	public Barra(double x, double y, double width, double height) {
		System.out.println("Futbolista Constructor");
		image = new Image("/com/fxpelota/images/barra.png");

		this.setImage(image);
		this.setX(x);
		this.setY(y);
		this.setFitWidth(width);
		this.setFitHeight(height);
		this.estado = false;
		this.cara = true;

	}

	public void changeEstado() {
		this.estado = !this.estado;
	}


	

	public boolean isCara() {
		return cara;
	}

	public void setCara(boolean cara) {
		this.cara = cara;
	}
	

	public void mover(double width, double height, KeyEvent ke) {
		double x = this.getX();
		double y = this.getY();
		double incremento;
		
		incremento = 5;
		switch (ke.getCode()) {

		case LEFT:
			
			if (x > 0)
				x -= incremento;
			break;
		case RIGHT:
			if (x + this.getFitWidth() < width)
				x += incremento;
			break;
		case Q:
			if ((y > 0) && (x + this.getFitWidth() < width)) {
				y -= incremento * Math.sin(Math.toRadians(45));
				x += incremento * Math.cos(Math.toRadians(45));
			}
			break;
		default:
			break;
		}

		this.setX(x);
		this.setY(y);
	}

}
