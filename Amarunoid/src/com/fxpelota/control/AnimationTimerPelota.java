package com.fxpelota.control;

import com.fxpelota.entity.Barra;
import com.fxpelota.entity.Bloque;
import com.fxpelota.entity.Pelota;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

public class AnimationTimerPelota extends AnimationTimer
{
	private Pane paneCancha;
	private Pelota pelota;
	private Bloque[] barras;
	
	public AnimationTimerPelota (Pane paneCancha, Pelota pelota, Bloque [] barras)
	{
		this.paneCancha = paneCancha;
		this.pelota = pelota;
		this.barras = barras;
	}

	@Override
	public void handle(long arg0)
	{
		pelota.mover(paneCancha.getWidth(), paneCancha.getHeight(),barras);
	}

}
