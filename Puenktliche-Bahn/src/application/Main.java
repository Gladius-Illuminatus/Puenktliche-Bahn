package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		//
		//Variables
		String titleOfWindow="temp";
		String titleOfGUI="Fahrkartenautomat";
		String departLoc="dep";
		String destLoc="dest";
		String depTime="00:00";
		String destTime="11:12";
		String travelTimeInH="25";
		//String currentTime
		
		//create stage window to call window instead of arg0
		Stage window;
		window=arg0;
		
		//BorderPane
		BorderPane pane1 = new BorderPane();
		pane1.setPadding(new Insets(5));
		
		//TOP
		HBox top = new HBox(50);
		Label title = new Label(titleOfGUI);
		title.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		top.getChildren().addAll(title);
		top.setAlignment(Pos.TOP_CENTER);
		pane1.setTop(top);
		
		//CENTER
		VBox center = new VBox(20);
		Label depart = new Label("Abfahrt von "+departLoc+" um: "+ depTime+"h");
		depart.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		Label dest = new Label("Ankunft in "+destLoc+" um: "+destTime+"h");
		dest.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		Label travelTime = new Label("Fahrtzeit "+travelTimeInH+"h");
		travelTime.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		center.getChildren().addAll(depart,dest,travelTime);
		center.setAlignment(Pos.CENTER);
		pane1.setCenter(center);
		
		//BOTTOM
		HBox bottom = new HBox(20);
		Button btnConfirm = new Button("Auswahl bestätigen");
		btnConfirm.setFont(Font.font("Times New Roman", FontWeight.BOLD, 28));
		bottom.getChildren().addAll(btnConfirm);
		bottom.setAlignment(Pos.TOP_CENTER);
		pane1.setBottom(bottom);
		
		//window setup
		Scene scene1 = new Scene(pane1,600,600);
		window.setScene(scene1);
		window.setTitle(titleOfWindow);
		window.show();
	}

}
