package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {

		// Global Variables
		// global settings to be uses throughout the programm
		String titleOfWindow = "Fahrkartenautomat der PB";
		String titleOfGUI = "Fahrkartenautomat der PB";
		String departLoc = "dep";
		String destLoc = "dest";
		String depTime = "00:00";
		String destTime = "11:12";
		String travelTimeInH = "25";
		String fontGlobal = "Calibri";
		Color fontCollorGlobal = Color.RED;
		int fontSizeGlobal = 80;
		int sizeH = 1920;
		int sizeV = 1000;
		int imageSize = 200;
		
		
		// GUI 1 Andre Fuchs

		// call arg0 window for easy use
		Stage window = arg0;
		
		// _________GUI PANEL1_________________________

		// image

		// String[] orte = { "test1", "test2", "test3", "test4", "test5" };
		String[] images = { "test1.jpeg", "test2.jpeg", "test3.jpeg", "test4.jpeg", "test5.jpeg", "test6.jpeg" };
		int chooseImage = (int) (Math.random() * images.length);
		Image img = new Image(images[chooseImage]);
		
		//Image GUI1
		ImageView iv1 = new ImageView(img);
		iv1.setFitWidth(imageSize);
		iv1.setPreserveRatio(true);
		iv1.setSmooth(true);
		
		//Image GUI2
		ImageView iv2 = new ImageView(img);
		iv2.setFitWidth(imageSize);
		iv2.setPreserveRatio(true);
		iv2.setSmooth(true);

		// Background
		BackgroundFill background_fill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);

		// GUI 1 BorderPane
		BorderPane borderPaneGUI1 = new BorderPane();
		borderPaneGUI1.setBackground(background);
		borderPaneGUI1.setPadding(new Insets(30));
		

		// TOP
		HBox topGUI2 = new HBox(30);
		Label titlePanel1 = new Label(titleOfGUI);
		titlePanel1.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		titlePanel1.setTextFill(fontCollorGlobal);
		borderPaneGUI1.setTop(titlePanel1);
		borderPaneGUI1.setAlignment(titlePanel1, Pos.CENTER);
		
		// RIGHT
		
		borderPaneGUI1.setRight(iv1);
		borderPaneGUI1.setMargin(iv1, new Insets(30));
		borderPaneGUI1.setAlignment(iv1, Pos.TOP_RIGHT);
		borderPaneGUI1.setRight(iv1);

		// CENTER
		TextArea ankunftsortArea = new TextArea();
		// ScrollPane scrollPane = new ScrollPane(textArea);
		ankunftsortArea.setPromptText("Abfahrtsort");
		ankunftsortArea.setEditable(true);
		ankunftsortArea.setPrefHeight(80.0);
		ankunftsortArea.setPrefWidth(230);
		ankunftsortArea.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		// ankunftsortArea.setTextFill(Color.RED);

		TextArea zielortArea = new TextArea();
		// ScrollPane scrollPane = new ScrollPane(zielortArea);
		zielortArea.setPromptText("Zielort");
		zielortArea.setEditable(true);
		zielortArea.setPrefHeight(80.0);
		zielortArea.setPrefWidth(230);
		zielortArea.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		// zielortArea.setTextFill(Color.RED);

		VBox vPanel1 = new VBox(30, ankunftsortArea, zielortArea);
		vPanel1.setAlignment(Pos.CENTER);
		borderPaneGUI1.setCenter(vPanel1);
		borderPaneGUI1.setAlignment(vPanel1, Pos.CENTER);

		// BOTTOM
		Button btnConfirmGui1 = new Button("Auswahl bestätigen");
		btnConfirmGui1.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		btnConfirmGui1.setTextFill(fontCollorGlobal);
		borderPaneGUI1.setBottom(btnConfirmGui1);
		borderPaneGUI1.setAlignment(btnConfirmGui1, Pos.CENTER);

		// GUI 2 Daniel Ott

		// GUI 2 BorderPane
		BorderPane borderPaneGUI2 = new BorderPane();
		borderPaneGUI2.setPadding(new Insets(5));
		borderPaneGUI2.setBackground(background);
		borderPaneGUI2.setPadding(new Insets(30));

		// TOP
		HBox top = new HBox();
		HBox.setHgrow(top, Priority.ALWAYS);
		HBox topRight = new HBox(30);
		HBox.setHgrow(topRight, Priority.ALWAYS);
		Label title = new Label(titleOfGUI);
		title.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		title.setTextFill(fontCollorGlobal);
		topRight.getChildren().addAll(iv2);
		topRight.setAlignment(Pos.TOP_RIGHT);
		top.getChildren().addAll(title,topRight);
		top.setAlignment(Pos.TOP_CENTER);
		borderPaneGUI2.setTop(top);
		

		// CENTER
		VBox center = new VBox(20);
		Label depart = new Label("Abfahrt von " + zielortArea.getText() + " um: " + depTime + "h");
		depart.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		depart.setTextFill(fontCollorGlobal);
		Label dest = new Label("Ankunft in " + ankunftsortArea.getText() + " um: " + destTime + "h");
		dest.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		dest.setTextFill(fontCollorGlobal);
		Label travelTime = new Label("Fahrtzeit " + travelTimeInH + "h");
		travelTime.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		travelTime.setTextFill(fontCollorGlobal);
		center.getChildren().addAll(depart, dest, travelTime);
		center.setAlignment(Pos.CENTER);
		borderPaneGUI2.setCenter(center);

		// BOTTOM
		HBox bottom = new HBox(20);
		Button btnConfirmGui2 = new Button("Auswahl bestätigen");
		btnConfirmGui2.setTextFill(fontCollorGlobal);
		btnConfirmGui2.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		bottom.getChildren().addAll(btnConfirmGui2);
		bottom.setAlignment(Pos.TOP_CENTER);
		borderPaneGUI2.setBottom(bottom);

		// window setup
		Scene gui1 = new Scene(borderPaneGUI1, sizeH, sizeV);
		Scene gui2 = new Scene(borderPaneGUI2, sizeH, sizeV);
		window.setScene(gui1);
		window.setTitle(titleOfWindow);
		window.show();


		// button setup
		btnConfirmGui1.setOnAction(e -> {
			System.out.println("from " + departLoc + " to " + zielortArea.getText());
			window.setScene(gui2);
		});
		btnConfirmGui2.setOnAction(e -> {
			window.setScene(gui1);
		});


		
	}

}