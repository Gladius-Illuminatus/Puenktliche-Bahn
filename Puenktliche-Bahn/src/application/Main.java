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
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
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
		
		//GUI 1 Andre Fuchs
		Stage window = arg0;
		String[] orte = { "test1", "test2", "test3", "test4", "test5" };
		String fontG = "Texas New Roman";

		// image
		/*
		String[] images = { "test1.jpeg", "test2.jpeg", "test3.jpeg", "test4.jpeg", "test5.jpeg",
				"test6.jpeg"};
		int chooseImage = (int) (Math.random() * images.length);
		Image img = new Image(images[chooseImage]);
		ImageView iv1 = new ImageView(img);
		iv1.setFitWidth(200);
		iv1.setPreserveRatio(true);
		iv1.setSmooth(true);
		 */
		
		// Background
		BackgroundFill background_fill = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);

		// _________GUI PANEL1_________________________
		Label titlePanel1 = new Label("Fahrkartenautomat");
		titlePanel1.setFont(Font.font(fontG, FontWeight.BOLD, 28));
		titlePanel1.setTextFill(Color.RED);

		TextArea ankunftsortArea = new TextArea();
		// ScrollPane scrollPane = new ScrollPane(textArea);
		ankunftsortArea.setPromptText("Abfahrtsort");
		ankunftsortArea.setEditable(true);
		ankunftsortArea.setPrefHeight(80.0);
		ankunftsortArea.setPrefWidth(230);
		ankunftsortArea.setFont(Font.font(fontG, FontWeight.BOLD, 28));
		// ankunftsortArea.setTextFill(Color.RED);

		TextArea zielortArea = new TextArea();
		// ScrollPane scrollPane = new ScrollPane(zielortArea);
		zielortArea.setPromptText("Zielort");
		zielortArea.setEditable(true);
		zielortArea.setPrefHeight(80.0);
		zielortArea.setPrefWidth(230);
		zielortArea.setFont(Font.font(fontG, FontWeight.BOLD, 28));
		// zielortArea.setTextFill(Color.RED);

		Button btnConfirmGui1 = new Button("Auswahl bestätigen");
		btnConfirmGui1.setFont(Font.font(fontG, FontWeight.BOLD, 28));

		VBox vPanel1 = new VBox(30, ankunftsortArea, zielortArea);
		vPanel1.setAlignment(Pos.CENTER);

		BorderPane panePanel1 = new BorderPane();
		panePanel1.setPadding(new Insets(30));
		panePanel1.setTop(titlePanel1);
		panePanel1.setAlignment(titlePanel1, Pos.CENTER);
		panePanel1.setCenter(vPanel1);
		panePanel1.setAlignment(vPanel1, Pos.CENTER);
		panePanel1.setBottom(btnConfirmGui1);
		panePanel1.setAlignment(btnConfirmGui1, Pos.CENTER);
		
		/*
		panePanel1.setRight(iv1);
		panePanel1.setMargin(iv1, new Insets(30));
		panePanel1.setAlignment(iv1, Pos.TOP_RIGHT);
		*/
		
		panePanel1.setBackground(background);
		

		// GUI 2 Daniel Ott
		// Variables
		String titleOfWindow = "temp";
		String titleOfGUI = "Fahrkartenautomat";
		String departLoc = "dep";
		String destLoc = "dest";
		String depTime = "00:00";
		String destTime = "11:12";
		String travelTimeInH = "25";
		// String currentTime

		// BorderPane
		BorderPane pane1 = new BorderPane();
		pane1.setPadding(new Insets(5));

		// TOP
		HBox top = new HBox(50);
		Label title = new Label(titleOfGUI);
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		top.getChildren().addAll(title);
		top.setAlignment(Pos.TOP_CENTER);
		pane1.setTop(top);

		// CENTER
		VBox center = new VBox(20);
		Label depart = new Label("Abfahrt von " + departLoc + " um: " + depTime + "h");
		depart.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		Label dest = new Label("Ankunft in " + destLoc + " um: " + destTime + "h");
		dest.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		Label travelTime = new Label("Fahrtzeit " + travelTimeInH + "h");
		travelTime.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		center.getChildren().addAll(depart, dest, travelTime);
		center.setAlignment(Pos.CENTER);
		pane1.setCenter(center);

		// BOTTOM
		HBox bottom = new HBox(20);
		Button btnConfirmGui2 = new Button("Auswahl bestätigen");
		btnConfirmGui2.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		bottom.getChildren().addAll(btnConfirmGui2);
		bottom.setAlignment(Pos.TOP_CENTER);
		pane1.setBottom(bottom);
		

		// window setup
		Scene gui1 = new Scene(panePanel1, 900, 400);
		Scene gui2 = new Scene(pane1, 900, 400);
		
		btnConfirmGui1.setOnAction(e -> {
			System.out.println("from " + ankunftsortArea.getText() + " to " + zielortArea.getText());
			window.setScene(gui2);
		});
		btnConfirmGui2.setOnAction(e -> window.setScene(gui1));
		

		
		window.setScene(gui1);
		window.setTitle("Fahrkartenautomat der PB");
		window.show();
		/*
		 * window.setScene(gui2); window.setTitle(titleOfWindow); window.show();
		 */
	}

}
