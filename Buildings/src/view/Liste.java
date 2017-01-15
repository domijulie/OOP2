package view;

import java.io.File;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Building;

public class Liste extends VBox{
	
	
	private TableView<Building> tabelle;
	
	//create tableColumns
	/*private final TableColumn<Building, Integer> rankCol;
	private final TableColumn<Building, String> nameCol;
	private final TableColumn<Building, String> cityCol; */

	private ObservableList<Building> buildings;
	private ObjectProperty<Building> selectedBuilding = new SimpleObjectProperty<>();
	private FilteredList<Building> filteredData;
	
	//public Liste(ObservableList<Building> buildings){
		
	
		
	
    public Liste(ObservableList buildings){
		this.buildings = buildings;
		initializeControls();
		layoutControls();
		addEventHandlers();
		addValueChangedListeners();
		addBindings();
		
	}
	
	
	
	public void initializeControls() {
    //Initialize Tableview
	tabelle = new TableView<Building>();
	filteredData = new FilteredList<Building>(buildings, s-> true);
	
	tabelle.setItems(filteredData);
	
	TextField searchField = new TextField();
	searchField.textProperty().addListener(e -> {
		String filter = searchField.getText();
		if(filter == null || filter.length()==0){
			filteredData.setPredicate(s -> true);
		}else {
			filteredData.setPredicate(s -> s.levenshteinDistance(filter, s.getName()) <= s.getName().length() - filter.length());
		}
	});
	
	TableColumn<Building, Integer> rankCol = new TableColumn<Building, Integer>("Rank");
	rankCol.setCellValueFactory(new PropertyValueFactory("rank"));
	TableColumn<Building, String> nameCol = new TableColumn<Building, String>("Name");
	nameCol.setCellValueFactory(new PropertyValueFactory("name"));
	TableColumn<Building, String> cityCol = new TableColumn<Building, String>("City");
	cityCol.setCellValueFactory(new PropertyValueFactory("city"));
	
	tabelle.getColumns().addAll(rankCol, nameCol, cityCol);
	
	
	HBox searchBox = new HBox();
	ImageView image = new ImageView(new File("src" + File.separator + "resources" + File.separator + "search.png").toURI().toString());
	image.setFitHeight(20);
	image.setFitWidth(20);
	searchBox.getChildren().addAll(image, searchField);
	tabelle.getSelectionModel().selectFirst();
	this.getChildren().addAll(searchBox, tabelle);
	
	
     //bind tablecolumns to presentationmodel with lambda expression
		

		
	}
	
	public TableView <Building> getTable(){
		return tabelle;
	}
	
	private void layoutControls() {
		//setVgrow(tabelle, Priority.ALWAYS);
		
		//getChildren().addAll(tabelle);
		
	}


	
	private void addBindings() {
		// TODO Auto-generated method stub
		
	}

	private void addValueChangedListeners() {
		// TODO Auto-generated method stub
		
	}

	private void addEventHandlers() {
		
	}
	}



