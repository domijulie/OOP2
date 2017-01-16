package view;

import java.io.File;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.Building;
import model.IO;

public class NavigationView extends HBox{
	
	// Buttons vor zurueck speichern blabla
	
  private Button save;
  private Button delete;
  private Button add;
  private ObservableList<Building> buildings;
  private MainView mainView;
  
  public NavigationView(ObservableList<Building> buildings, MainView mainView){
	  this.buildings = buildings;
	  this.mainView = mainView;
	  initializeControls();
	  layoutControls();
	  addEventHandlers();
	  
  }

private void addEventHandlers() {
	save.setOnAction(e -> {
		try {
			IO.write(buildings);
			Alert alert = new Alert (Alert.AlertType.INFORMATION,"Eingabe wurde gespeichert!");
			alert.show();
		} catch (Exception e1) {
			Alert alert = new Alert (Alert.AlertType.ERROR,"Fehler beim Speichern aufgetreten!");
			alert.show();
			e1.printStackTrace();
		}
		
		mainView.updateList();
	});
	
	delete.setOnAction(e -> {
		buildings.remove(mainView.getSelectedBuilding().get());
		
	});
	
	add.setOnAction(e -> {
		buildings.add(new Building(buildings.size()));
		mainView.setSelectedToLast();
	});
}

private Button initializeButton(String name){
	final File IMAGE = new File("src" + File.separator + "resources" + File.separator + name.toLowerCase() + ".png");
	
	Button button = new Button();
	if (IMAGE.canRead()){
		ImageView iv = new ImageView(IMAGE.toURI().toString());
		
		iv.fitHeightProperty().bind(this.maxHeightProperty());
		
		iv.setPreserveRatio(true);
		
		button.setGraphic(iv);
		
		button.setPadding(new Insets(5));
		
		return button;
	} else {
		System.out.println("can't read image");
		return null;
	}
}

private void layoutControls() {

	setMaxHeight(30);
	setPadding(new Insets(5));
	getChildren().addAll(save, delete, add);
	
}

private void initializeControls() {	
	save = initializeButton("save");
	delete = initializeButton("delete");
	add = initializeButton("add");

	
}

  
  
}
