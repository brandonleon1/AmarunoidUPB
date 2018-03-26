package com.fxpelota.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Pelota extends ImageView {
	private boolean estado;
	private double angulo;
	private double radius;
	private double sentido;
	private double centerX;
	private double centerY;
	private Barra futbolista;
	private Bloque[] bloque;
	int random = 1;
	public Pelota(double x, double y, double radio, double angulo, Barra futbolista,Bloque[] bloque) {
		System.out.println("Pelota Constructor");
		Image image = new Image("/com/fxpelota/images/pelota.png");
		this.setImage(image);
		this.setX(x - radio);
		this.setY(y - radio);
		this.setFitWidth(radio * 2);
		this.setFitHeight(radio * 2);
		this.futbolista = futbolista;
		this.bloque = bloque;

		this.centerX = x;
		this.centerY = y;
		this.radius = radio;
		this.estado = false;
		this.angulo = angulo;
		this.sentido = 1;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getCenterX() {
		return centerX;
	}

	public void setCenterX(double centerX) {
		this.setX(centerX - radius);
		this.centerX = centerX;
	}

	public double getCenterY() {
		return centerY;
	}

	public void setCenterY(double centerY) {
		this.setY(centerY - radius);
		this.centerY = centerY;
	}

	public void changeEstado() {
		this.estado = !this.estado;
	}

	
	
	public void verificarChoquebloque(Bloque b ) 
	{
		
		
		
		
			double x = this.getCenterX();
		
			double y = this.getCenterY();

			double radio = this.getRadius();
			
			
			
			if( x  + radio < b.getX()) {
					
			
			
			
			}else if(x -radio > b .getX()+100) {
				
				
				
				
				
			}else if (y + radio < b.getY() ) 
			
			{
				
				
			}else if (y - radio > b .getY()+50) {
				
				
				
				
			}
			
			
			
			
			
			
			
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void mover(double ancho, double alto,Bloque [] barras) {
		
	
		if (random > 5 ) {random = 0;}else {random++;}
		
		
	
		
		for(int i =0 ; i< bloque.length ;i++)
		{
		
		
		if (estado) {

			double x = this.getCenterX();
			double y = this.getCenterY();

			if (futbolista.getBoundsInParent().intersects(this.getBoundsInParent())) {
				System.out.println("choco");

				if (angulo <= 45) {
					
					
					if (x-this.getRadius() <=0 || x+this.getRadius()>= ancho)
					{
						sentido = -sentido;
						angulo = -angulo;
					}
					else if (y-this.getRadius() <= 0 || y+this.getRadius() >= alto-50)
					{
						angulo = -angulo;
						
					}
					x+=sentido;
					y+=sentido*Math.tan(Math.toRadians(angulo));
				}
				else
				{
					if (x-this.getRadius() <=0 || x+this.getRadius() >= ancho)
					{
						angulo = -angulo;
					}
					else if (y-this.getRadius() <= 0 || y+this.getRadius() >= alto-50)
					{
						sentido = -sentido;
						angulo = -angulo;
					}
					x+=sentido/Math.tan(Math.toRadians(angulo));
					y+=sentido;
				}
				
			}
			
			////////
			
			if (bloque[i].getBoundsInParent().intersects(this.getBoundsInParent())) {
				System.out.println("choco bloque");
				
				
				if (angulo <= 45) {
					if (x - this.getRadius() <= bloque[i].getX() + bloque[i].getFitWidth()
							&& x + this.getRadius() >=bloque[i].getX()) {
						sentido = -sentido;
						angulo =  -angulo;
						if(!bloque[i].destruirBloque(random)) {
						
							System.out.println("dcs");
						}else {	this.setX(3000);
						this.setY(6000);}
						System.out.println("1");
						
					} else if (y - this.getRadius() <= bloque[i].getY() + bloque[i].getFitHeight()
							|| y + this.getRadius() >= bloque[i].getY()) {
						angulo = -angulo;
						if(!bloque[i].destruirBloque(random)) {
							this.setX(3000);
							this.setY(6000);
							
						}
						System.out.println("2");
						
					}
					x += sentido;
					y += sentido * Math.tan(Math.toRadians(angulo));
				} else {
					if (x - this.getRadius() <= futbolista.getX() + futbolista.getFitWidth()
							|| x + this.getRadius() >= futbolista.getX()) {
						angulo = -angulo;
						System.out.println("3");
						
					} else if (y - this.getRadius() <= futbolista.getY() + futbolista.getFitHeight()
							|| y + this.getRadius() >= futbolista.getY()) {
						sentido = -sentido;
						angulo = -angulo;
						System.out.println("4");
						
					}
					x += sentido / Math.tan(Math.toRadians(angulo));
					y += sentido;
				}
				
				
				
				if (x - this.getRadius() >= bloque[i].getX() && x + this.getRadius() <=bloque[i].getX()+100  && y + this.getRadius() <= bloque[i].getY()  ) {
					sentido = -sentido;
					angulo = -angulo;
			
					System.out.println("5");
					
					if(!bloque[i].destruirBloque(random)) {
						this.setX(300);
						this.setY(600);
						
					}
				} else if ( x - this.getRadius() >= bloque[i].getX() && x + this.getRadius() <=bloque[i].getX()+100  && y - this.getRadius() >= bloque[i].getY() ) {
					if(!bloque[i].destruirBloque(random)) {
						this.setX(300);
						this.setY(600);
						
					}
					
					//System.exit(0);
					angulo = -angulo;
					sentido = -sentido;
					System.out.println("6");
					
					System.out.println("Abajo");
				
				x += sentido;
				y += sentido * Math.tan(Math.toRadians(angulo));
			} else {
				if (x - this.getRadius() <= bloque[i].getX() || x + this.getRadius() >= bloque[i].getX()+100) {
					angulo = -angulo;
				} else if (y - this.getRadius() <= bloque[i].getY() || y + this.getRadius() >= bloque[i].getX()+50) {
					
					sentido = -sentido;
					angulo = -angulo;

					System.out.println("7");
					
				}
				x += sentido / Math.tan(Math.toRadians(angulo));
				y += sentido;
				
				

			}
			}
			
			
			
			///
			
			if (angulo <= 45) {
				if (x - this.getRadius() <= 0 || x + this.getRadius() >= ancho) {
					sentido = -sentido;
					angulo = -angulo;
				} else if ( y + this.getRadius() >= alto) {
					System.out.println("Abajo");
					System.exit(0);
					angulo = -angulo;
					
				}else if (y - this.getRadius() <= 0 ) {
					angulo = -angulo;
					System.out.println("Arriba");
					
				}
				x += sentido;
				y += sentido * Math.tan(Math.toRadians(angulo));
			} else {
				if (x - this.getRadius() <= 0 || x + this.getRadius() >= ancho) {
					angulo = -angulo;
				} else if (y - this.getRadius() <= 0 || y + this.getRadius() >= alto) {
					
					sentido = -sentido;
					angulo = -angulo;
				
					
				
				
				
				}
				x += sentido / Math.tan(Math.toRadians(angulo));
				y += sentido;
			}

			this.setCenterX(x);
			this.setCenterY(y);

		}

	}

}
}
/*
if (futbolista.getBoundsInParent().intersects(this.getBoundsInParent())) {
				System.out.println("choco");

				if (angulo <= 45) {
					if (x - this.getRadius() <= futbolista.getX() + futbolista.getFitWidth()
							|| x + this.getRadius() >= futbolista.getX()) {
						sentido = -sentido;
						angulo = -angulo;
					} else if (y - this.getRadius() <= futbolista.getY() + futbolista.getFitHeight()
							|| y + this.getRadius() >= futbolista.getY()) {
						angulo = -angulo;
					}
					x += sentido;
					y += sentido * Math.tan(Math.toRadians(angulo));
				} else {
					if (x - this.getRadius() <= futbolista.getX() + futbolista.getFitWidth()
							|| x + this.getRadius() >= futbolista.getX()) {
						angulo = -angulo;
					} else if (y - this.getRadius() <= futbolista.getY() + futbolista.getFitHeight()
							|| y + this.getRadius() >= futbolista.getY()) {
						sentido = -sentido;
						angulo = -angulo;
					}
					x += sentido / Math.tan(Math.toRadians(angulo));
					y += sentido;
				}
			}*/
