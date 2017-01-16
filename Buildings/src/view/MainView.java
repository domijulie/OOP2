package view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import model.Building;

public class MainView extends BorderPane{
	
	
	private NavigationView navigationView;  //header 
	private DetailView content;   
	private Liste liste;
	private ObservableList<Building> buildings;
	private ObjectProperty<Building> selectedBuilding = new SimpleObjectProperty<>();
	


	//public MainView(ObservableList<Building> buildings) {
	//setVgrow(content, Priority.ALWAYS);
	//getChildren().addAll(navigationView, content);
	
	public MainView(ObservableList<Building> buildings){
		this.buildings = buildings;
		initializeControls();
		layoutControls();
		addBindings();
	}
	
	public void layoutControls(){
		setTop(navigationView);
		setCenter(addSplitPane());
	}
	
	public void initializeControls(){
		selectedBuilding.setValue((Building) buildings.get(0));
		navigationView = new NavigationView(buildings, this);
		content = new DetailView(selectedBuilding);
		liste = new Liste(buildings);
	}
	
	private void addBindings(){
		selectedBuilding.bind(liste.getTable().selectionModelProperty().get().selectedItemProperty());
	}
	
	public SplitPane addSplitPane(){
		SplitPane splitPane = new SplitPane();
		splitPane.setPrefSize(400, 800);
		splitPane.getItems().setAll(liste, content);
		splitPane.setDividerPosition(5, 0.25);
		
		return splitPane;
	}

	public ObjectProperty<Building> getSelectedBuilding(){
		return selectedBuilding;
		
	}
	
	public void setSelectedToLast(){
		liste.getTable().getSelectionModel().selectLast();
	}

}
