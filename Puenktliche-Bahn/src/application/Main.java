package application;


import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
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
	static double departTime=1;
	@Override
	public void start(Stage arg0) throws Exception {
		//
		// Global Variables
		// global settings to be uses throughout the program
		String titleOfWindow = "Fahrkartenautomat der PB";
		// is it pretty NO!, does it work ? YES, do I have a better solution ? wish I
		// had...
		// NEEDS FIXING
		String titleOfGUI = "                            Fahrkartenautomat der PB";
		String departLoc = "dep";
		String destLoc = "dest";
		String depTime = "00:00";
		String destTime = "11:12";
		String travelTimeInH = "25";
		String fontGlobal = "Calibri";
		int velocity = 300; // velocity in km/h
		Color fontCollorGlobal = Color.RED;
		int fontSizeGlobal = 80;
		int sizeH = 1920;
		int sizeV = 1000;
		int imageSize = 250;
		String saveFile = "Staedte.txt";

		// CITIES AND DISTANCES - ARRAYS
		FileReader fileReader = new FileReader(saveFile);
		char[] carrierChar = new char[10000000];
		fileReader.read(carrierChar);
		String carrierStringLong = new String(carrierChar);

		String[] carrierStringSplit = carrierStringLong.split("\r|;");

		// define length of arrays
		String[] cities = new String[carrierStringSplit.length / 2];
		long[] distances = new long[carrierStringSplit.length / 2];

		for (int i = 0; i < carrierStringSplit.length / 2; i++) {
			// every second entry is a city
			cities[i] = carrierStringSplit[i * 2];
		}

		for (int i = 0; i < carrierStringSplit.length / 2; i++) {
			// after a city comes a distance-value
			distances[i] = Long.parseUnsignedLong(carrierStringSplit[i * 2 + 1]);
		}

		// call arg0 window for easy use
		Stage window = arg0;

		// _________GUI PANEL1_________________________

		// image
		String[] images = { "test1.jpeg", "test2.jpeg", "test3.jpeg", "test4.jpeg", "test5.jpeg", "test6.jpeg" };
		int chooseImage = (int) (Math.random() * images.length);
		Image img = new Image(images[chooseImage]);

		// Image GUI1
		ImageView logoGUI1 = new ImageView(img);
		logoGUI1.setFitWidth(imageSize);
		logoGUI1.setPreserveRatio(true);
		logoGUI1.setSmooth(true);

		// Image GUI2
		ImageView logoGUI2 = new ImageView(img);
		logoGUI2.setFitWidth(imageSize);
		logoGUI2.setPreserveRatio(true);
		logoGUI2.setSmooth(true);

		// Image GUI2
		ImageView logoGUI3 = new ImageView(img);
		logoGUI3.setFitWidth(imageSize);
		logoGUI3.setPreserveRatio(true);
		logoGUI3.setSmooth(true);

		// Image GUI4
		ImageView logoGUI4 = new ImageView(img);
		logoGUI4.setFitWidth(imageSize);
		logoGUI4.setPreserveRatio(true);
		logoGUI4.setSmooth(true);

		// Background
		BackgroundFill background_fill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);

		// GUI 1 BorderPane
		BorderPane borderPaneGUI1 = new BorderPane();
		borderPaneGUI1.setBackground(background);
		borderPaneGUI1.setPadding(new Insets(30));

		// TOP
		HBox topGUI1 = new HBox();
		HBox.setHgrow(topGUI1, Priority.ALWAYS);
		HBox topRightGUI1 = new HBox(30);
		HBox.setHgrow(topRightGUI1, Priority.ALWAYS);
		Label titleGUI1 = new Label(titleOfGUI);
		titleGUI1.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		titleGUI1.setTextFill(fontCollorGlobal);
		topRightGUI1.getChildren().addAll(logoGUI1);
		topRightGUI1.setAlignment(Pos.TOP_RIGHT);
		topGUI1.getChildren().addAll(titleGUI1, topRightGUI1);
		topGUI1.setAlignment(Pos.TOP_CENTER);
		borderPaneGUI1.setTop(topGUI1);

		// CENTER
		TextArea ankunftsortArea = new TextArea();
		ComboBox ankunftCombo = new ComboBox(FXCollections.observableArrayList(cities));
		ankunftCombo.setPromptText("Abfahrtsort");
		ankunftCombo.setStyle(
				"-fx-font: " + 100 + "px \"" + fontGlobal + "\";-fx-font-weight: bold;-fx-text-box-border: red;");

		ankunftsortArea.setPromptText("Abfahrtsort");
		ankunftsortArea.setEditable(true);
		ankunftsortArea.setPrefHeight(80.0);
		ankunftsortArea.setPrefWidth(230);
		ankunftsortArea.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));

		ComboBox destCombo = new ComboBox(FXCollections.observableArrayList(cities));
		destCombo.setPromptText("Zielort");
		destCombo.setStyle("-fx-font: " + 100 + "px \"" + fontGlobal + "\";-fx-font-weight: bold;");

		TextArea zielortArea = new TextArea();
		zielortArea.setPromptText("Zielort");
		zielortArea.setEditable(true);
		zielortArea.setPrefHeight(80.0);
		zielortArea.setPrefWidth(230);
		zielortArea.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));

		VBox vPanel1 = new VBox(30, ankunftCombo, destCombo);
		vPanel1.setAlignment(Pos.CENTER);
		borderPaneGUI1.setCenter(vPanel1);
		borderPaneGUI1.setAlignment(vPanel1, Pos.CENTER);

		// BOTTOM
		Button btnConfirmGui1 = new Button("Auswahl bestätigen");
		btnConfirmGui1.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		btnConfirmGui1.setTextFill(fontCollorGlobal);
		borderPaneGUI1.setBottom(btnConfirmGui1);
		borderPaneGUI1.setAlignment(btnConfirmGui1, Pos.CENTER);

		// GUI 2 BorderPane
		BorderPane borderPaneGUI2 = new BorderPane();
		borderPaneGUI2.setPadding(new Insets(5));
		borderPaneGUI2.setBackground(background);
		borderPaneGUI2.setPadding(new Insets(30));

		// TOP
		HBox topGUI2 = new HBox();
		HBox.setHgrow(topGUI2, Priority.ALWAYS);
		HBox topRightGUI2 = new HBox(30);
		HBox.setHgrow(topRightGUI2, Priority.ALWAYS);
		Label titleGUI2 = new Label(titleOfGUI);
		titleGUI2.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		titleGUI2.setTextFill(fontCollorGlobal);
		topRightGUI2.getChildren().addAll(logoGUI2);
		topRightGUI2.setAlignment(Pos.TOP_RIGHT);
		topGUI2.getChildren().addAll(titleGUI2, topRightGUI2);
		topGUI2.setAlignment(Pos.TOP_CENTER);
		borderPaneGUI2.setTop(topGUI2);

		// CENTER
		VBox center = new VBox(20);
		Label depart = new Label("Abfahrt von " + destLoc + " um: " + depTime + "h");
		depart.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		depart.setTextFill(fontCollorGlobal);
		Label dest = new Label("Ankunft in " + departLoc + " um: " + destTime + "h");
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

		// GUI3
		BorderPane borderPaneGUI3 = new BorderPane();
		borderPaneGUI3.setBackground(background);
		borderPaneGUI3.setPadding(new Insets(30));

		// TOP
		HBox topGUI3 = new HBox();
		HBox.setHgrow(topGUI3, Priority.ALWAYS);
		HBox topRightGUI3 = new HBox(30);
		HBox.setHgrow(topRightGUI3, Priority.ALWAYS);

		Label titleGUI3 = new Label(titleOfGUI);

		titleGUI3.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		titleGUI3.setTextFill(fontCollorGlobal);

		topRightGUI3.getChildren().addAll(logoGUI3);
		topRightGUI3.setAlignment(Pos.TOP_RIGHT);

		topGUI3.getChildren().addAll(titleGUI3, topRightGUI3);
		topGUI3.setAlignment(Pos.TOP_CENTER);
		borderPaneGUI3.setTop(topGUI3);

		// CENTER
		VBox centerGUI3 = new VBox(20);

		String[] klassen = { "Erstklassig", "Zweitklassig" };
		ComboBox klassenCombo = new ComboBox(FXCollections.observableArrayList(klassen));
		klassenCombo.setPromptText("Klasse");
		klassenCombo.setStyle(
				"-fx-font: " + 100 + "px \"" + fontGlobal + "\";-fx-font-weight: bold;-fx-text-box-border: red;");

		String[] altersStufe = { "Kleingeist", "Halbstark", "Grossmaul " };
		ComboBox altersStufeCombo = new ComboBox(FXCollections.observableArrayList(altersStufe));
		altersStufeCombo.setPromptText("Alterstufe");
		altersStufeCombo.setStyle(
				"-fx-font: " + 100 + "px \"" + fontGlobal + "\";-fx-font-weight: bold;-fx-text-box-border: red;");

		centerGUI3.getChildren().addAll(klassenCombo, altersStufeCombo);
		centerGUI3.setAlignment(Pos.CENTER);
		borderPaneGUI3.setCenter(centerGUI3);

		// BOTTOM
		HBox bottomGUI3 = new HBox(20);
		Button btnConfirmGui3 = new Button("Auswahl bestätigen");
		btnConfirmGui3.setTextFill(fontCollorGlobal);
		btnConfirmGui3.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		bottomGUI3.getChildren().addAll(btnConfirmGui3);
		bottomGUI3.setAlignment(Pos.TOP_CENTER);
		borderPaneGUI3.setBottom(bottomGUI3);

		// GUI 4 Philippe

		// GUI 4 BorderPane
		BorderPane borderPaneGUI4 = new BorderPane();
		borderPaneGUI4.setPadding(new Insets(5));
		borderPaneGUI4.setBackground(background);
		borderPaneGUI4.setPadding(new Insets(30));

		// TOP
		HBox topGUI4 = new HBox();
		HBox.setHgrow(topGUI4, Priority.ALWAYS);
		HBox topRightGUI4 = new HBox(30);
		HBox.setHgrow(topRightGUI4, Priority.ALWAYS);
		Label titleGUI4 = new Label(titleOfGUI);
		titleGUI4.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		titleGUI4.setTextFill(fontCollorGlobal);
		topRightGUI4.getChildren().addAll(logoGUI4);
		topRightGUI4.setAlignment(Pos.TOP_RIGHT);
		topGUI4.getChildren().addAll(titleGUI4, topRightGUI4);
		topGUI4.setAlignment(Pos.TOP_CENTER);
		borderPaneGUI4.setTop(topGUI4);

		// CENTER
		VBox center4 = new VBox(20);
		Label depart4 = new Label("Abfahrt von " + destLoc + " um: " + depTime + "h");
		depart4.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		depart4.setTextFill(fontCollorGlobal);
		Label dest4 = new Label("Ankunft in " + departLoc + " um: " + destTime + "h");
		dest4.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		dest4.setTextFill(fontCollorGlobal);
		Label klasse4 = new Label();
		klasse4.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		klasse4.setTextFill(fontCollorGlobal);
		Label age4 = new Label("");
		age4.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		age4.setTextFill(fontCollorGlobal);
		center4.getChildren().addAll(depart4, dest4, klasse4, age4);
		center4.setAlignment(Pos.CENTER);
		borderPaneGUI4.setCenter(center4);

		// BOTTOM
		HBox bottom4 = new HBox(20);
		Button btnConfirmGui4 = new Button("Fahrkarte drucken");
		btnConfirmGui4.setTextFill(fontCollorGlobal);
		btnConfirmGui4.setFont(Font.font(fontGlobal, FontWeight.BOLD, fontSizeGlobal));
		bottom4.getChildren().addAll(btnConfirmGui4);
		bottom4.setAlignment(Pos.TOP_CENTER);
		borderPaneGUI4.setBottom(bottom4);

		// BSOD

		BorderPane bsodScene = new BorderPane();
		Image bsodImage = new Image("BSOD.png");
		ImageView bsodView = new ImageView(bsodImage);
		bsodView.setFitWidth(1920);
		bsodView.setPreserveRatio(true);
		bsodView.setSmooth(true);
		bsodScene.setCenter(bsodView);

		// window setup
		Scene gui1 = new Scene(borderPaneGUI1, sizeH, sizeV);
		Scene gui2 = new Scene(borderPaneGUI2, sizeH, sizeV);
		Scene gui3 = new Scene(borderPaneGUI3, sizeH, sizeV);
		Scene gui4 = new Scene(borderPaneGUI4, sizeH, sizeV);
		Scene death = new Scene(bsodScene, sizeH, sizeV);

		window.setScene(gui1);
		window.setTitle(titleOfWindow);
		window.show();
		
		// button setup
		btnConfirmGui1.setOnAction(new EventHandler<ActionEvent>() {
		
			@Override
			public void handle(ActionEvent arg0) {

				window.setScene(gui2);
				int indexPositionAnkunft = positionOfStringInArray(cities, (String) ankunftCombo.getValue());
				int indexPositionZiel = positionOfStringInArray(cities, (String) destCombo.getValue());
				double duration = Math
						.sqrt(Math.pow(((distances[indexPositionZiel] - distances[indexPositionAnkunft]) / 300.0), 2));
				 departTime = ((int) (Math.random() * 24)) + (Math.random() * 60 / 100);
				//String durationS = displayLikeClock(departTime);

				depart.setText("Abfahrt von " + ankunftCombo.getValue() + " um: " + displayDoubleLikeClock(departTime));
				dest.setText("Ankunft in " + destCombo.getValue() + " um: "+ displayDoubleLikeClock(duration + departTime));

				travelTime.setText("Fahrtzeit " + convertToTimeString(duration));
			//	travelTime.setText("Fahrtzeit " + formatDoubleToString( duration) + "h");
				
				
				System.out.print(cities[indexPositionAnkunft] + " to " + cities[indexPositionZiel] + "\t");
				System.out.print("duration" + duration);
				System.out.println(
						"\tdepart" + distances[indexPositionAnkunft] + "\tdest" + distances[indexPositionZiel]);

				// change image
				logoGUI2.setImage(new Image(images[(int) (Math.random() * images.length)]));
			}
		});// end button setup

		btnConfirmGui2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				window.setScene(gui3);

				// change image
				logoGUI3.setImage(new Image(images[(int) (Math.random() * images.length)]));

			}
		});

		btnConfirmGui3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {

				int indexPositionAnkunft = positionOfStringInArray(cities, (String) ankunftCombo.getValue());
				int indexPositionZiel = positionOfStringInArray(cities, (String) destCombo.getValue());
				double duration = Math
						.sqrt(Math.pow(((distances[indexPositionZiel] - distances[indexPositionAnkunft]) / 300.0), 2));
				
				//String durationS = displayLikeClock(departTime);

				depart4.setText("Von " + ankunftCombo.getValue() + " um: " + displayDoubleLikeClock(departTime));
				dest4.setText("Ankunft in " + destCombo.getValue() + " um: "
						+ displayDoubleLikeClock( duration + departTime));
				klasse4.setText("Sie fahren: "+(String) klassenCombo.getValue());
				age4.setText((String) "Sie sind ein: "+ altersStufeCombo.getValue());

				window.setScene(gui4);

				// change image
				logoGUI4.setImage(new Image(images[(int) (Math.random() * images.length)]));

			}
		});

		btnConfirmGui4.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				window.setScene(death);
				window.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
				window.setFullScreenExitHint("");
				death.setCursor(Cursor.NONE);
				
				
				String musicFile = "bsod.mp3";     // For example

				Media sound = new Media(new File(musicFile).toURI().toString());
				MediaPlayer mediaPlayer = new MediaPlayer(sound);
				mediaPlayer.play();
				
				window.setFullScreen(true);
				

			}
		});

	}// end start

	// takes double and gives it back as formatted String XX.xx
	public static String formatDoubleToString(double input) {
		String formatedString;
		formatedString = String.format("%.2f", (double) input);
		return formatedString;
	}

	// OUT OF ORDER: looks if String-input is present in array
	public static boolean weHave(String input, String[] array) {
		boolean check = false;
		List<String> list = Arrays.asList(array);
		check = list.contains(input);
		return check;
	}// end weHave - Method

	// finds position of given string in array
	public static int positionOfStringInArray(String[] array, String input) {
		int position = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(input)) {
				position = i;
			}
		}
		return position;
	}// end positionOf - Method

	// PLEASE COMMENT!!
	public static String displayDoubleLikeClock(double time) {
		String timeAsClock = "did not work";
		long hour = ((long)time)%24;
		int carryHour = (int)((time-(long)time)*100/60);
		double min = (time-(int)time)%0.6;
		hour = hour + carryHour;
		
		
		if ((int)(min*100)<10) {
			timeAsClock = hour + ":0" + (int)(min*100) +"h";
		}else {
			timeAsClock = hour + ":" + (int)(min*100) +"h";
		}
		
		return timeAsClock;
	}

	// converts
	public static String convertToTimeString(double time) {
		String timeAsClock = "did not work";
		long hour = ((long)time);
		int carryHour = (int)((time-(long)time)*100/60);
		double min = (time-(long)time)%0.6;
		hour = hour + carryHour;
		
		String[]dayToYear= new String[4];
		long year = hour/8760;
		hour -= year*8760;
		long month = hour/730;
		hour -= month*730;
		long week = hour/168;
		hour -= week*168;
		long day = hour/24;
		hour -= day*24;
		
		
		dayToYear[0]= year+" Years, ";//year 
		dayToYear[1]= month+" Months, ";//month
		dayToYear[2]= week+" Weeks, ";//week
		dayToYear[3]= day+" Days, ";//week
		timeAsClock="";
		
		for (int i = 0; i < dayToYear.length; i++) {
			if (dayToYear[i].charAt(0)!='0') {
				timeAsClock += dayToYear[i];
			}
		}
		
		
		
		
		if ((int)(min*100)<10) {
			timeAsClock += hour%24 + ":0" + (int)(min*100) +"h";
		}else {
			timeAsClock += hour%24 + ":" + (int)(min*100) +"h";
		}
		return timeAsClock;
	}

}// end class