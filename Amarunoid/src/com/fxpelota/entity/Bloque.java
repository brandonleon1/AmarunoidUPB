package com.fxpelota.entity;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.sun.javafx.geom.Rectangle;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Bloque extends ImageView {
	private boolean estado;
	private boolean cara;
	private Image image;
private String[][] preguntas = new String[10][2];

	public Bloque(double x, double y, double width, double height) {
		System.out.println("Futbolista Constructor");
		image = new Image("/com/fxpelota/images/1.png");

		this.setImage(image);
		this.setX(x);
		this.setY(y);
		this.setFitWidth(width);
		this.setFitHeight(height);
		this.estado = false;
		this.cara = true;
		
		
		
		preguntas [0][0]="El agua tiene 3 estados?";
		preguntas [0][1]= "Y";
		preguntas [4][1]= "Y";
		preguntas [3][1]= "Y";
		preguntas [1][1]= "Y";
		preguntas [2][1]= "N";
		preguntas [1][0]="La marca apple es americana";
		preguntas [2][0]="El vodka se puede congelar";
		preguntas [3][0]="El tomate es una fruta";
		preguntas [4][0]="Existe mas de 1 universo";
		

	}

	public void changeEstado() {
		this.estado = !this.estado;
	}

	public boolean verificarChoque(Pelota pelota) {
		boolean result = false;
		Rectangle rectangle = new Rectangle();
		rectangle.x =(int) this.getX();
		rectangle.y= (int) this.getY();
		rectangle.height = 100;
		rectangle.width = 50;
		
		Rectangle rectangle1 = new Rectangle();
		rectangle1.x =(int) pelota.getX();
		rectangle1.y= (int) pelota.getY();
		rectangle1.height = (int) pelota.getRadius();
		rectangle1.width = (int) pelota.getRadius();
		
		
		
		if(		rectangle.contains(rectangle)){
			result =true;
			
		}		
			return result;
		
	}
	

	public boolean isCara() {
		return cara;
	}

	public void setCara(boolean cara) {
		this.cara = cara;
	}
	

	public boolean destruirBloque(int random) {
	
		boolean valor = true;
		
		System.out.println();
		Scanner  scanner = new Scanner(System.in);
		
		
		
		System.out.println(preguntas[random][0]);
		String value = scanner.nextLine();
		if(preguntas[random][1].contains( value)) {	

			this.setX(10000);
			this.setY(10000);
			
			
	}else {

		
		System.out.println("Fallo");
		System.out.println(valor);
		
		try {Stage primaryStage = new Stage();
		Parent root;
			root = FXMLLoader.load(getClass().getResource("/com/fxpelota/view/creditos.fxml"));
			Scene scene = new Scene(root,450,750);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
	
		primaryStage.show();	
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	valor = false;
	
	//System.exit(0);
	}
	
		
		
		
		
		

		
	return valor;
	
	
	
	
	
	}

}
