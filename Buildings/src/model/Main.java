package model;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.MainView;

/** created by Domi 16.12.16 **/

public class Main extends Application {
	
	private IO io = new IO();
	

	public static void main(String... args){
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		ObservableList<Building> buildings = FXCollections.observableArrayList(io.readFile());
		
		//buildings.stream().forEach(s -> System.out.println(s.getRank()));
				//methode aufrufen fuer dateneinlesen (readcsv)
		// daten werden eingelesen hier 
		Parent root = new MainView(buildings);
		Scene scene = new Scene(root);
		
		//String stylesheet = getClass().getResource("style.css").toExternalForm();
		//scene.getStylesheets().add(stylesheet);
		// im web suchen wie css einfuegen in eclipse 
		
		
		window.setTitle("Building");
		window.setScene(scene);
		window.setWidth(800);
		window.setHeight(600);
		
		// hauptfenster darstellung wird hier definiert Titel, center, get icons, height etc...
		
		
		
		
		window.show();
		
	}
	
}
