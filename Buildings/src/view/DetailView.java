package view;

import javafx.beans.property.ObjectProperty;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.util.converter.NumberStringConverter;
import model.Building;

public class DetailView extends GridPane{
	
	private ObjectProperty<Building>building;
	
	public DetailView (ObjectProperty<Building> selectedBuilding) {
		this.building = selectedBuilding;
		initializeControls();
		makeColumnRow();
		addBindings();
		
		labelrank.setText(Integer.toString(building.get().getRank()));
		
		System.out.println(building.get().getName());
	}

	private void addBindings() {
		building.addListener((observable, oldValue, newValue) -> {
//			textFieldid.textProperty().unbindBidirectional(oldValue.getIdProperty());
//			textFieldid.clear();
//			textFieldid.textProperty().bindBidirectional(newValue.getIdProperty(), new NumberStringConverter());
//			textFieldrank.textProperty().unbindBidirectional(oldValue.getRankProperty());
//			textFieldrank.clear();
//			textFieldrank.textProperty().bindBidirectional(newValue.getRankProperty(), new NumberStringConverter());
			textFieldname.textProperty().unbindBidirectional(oldValue.getNameProperty());
			textFieldname.clear();
			textFieldname.textProperty().bindBidirectional(newValue.getNameProperty());
			textFieldcity.textProperty().unbindBidirectional(oldValue.getCityProperty());
			textFieldcity.clear();
			textFieldcity.textProperty().bindBidirectional(newValue.getCityProperty());
			textFieldcountry.textProperty().unbindBidirectional(oldValue.getCountryProperty());
			textFieldcountry.clear();
			textFieldcountry.textProperty().bindBidirectional(newValue.getCountryProperty());
			textFieldheightm.textProperty().unbindBidirectional(oldValue.getHeightmProperty());
			textFieldheightm.clear();
			textFieldheightm.textProperty().bindBidirectional(newValue.getHeightmProperty(), new NumberStringConverter());
			textFieldheightf.textProperty().unbindBidirectional(oldValue.getHeightfProperty());
			textFieldheightf.clear();
			textFieldheightf.textProperty().bindBidirectional(newValue.getHeightfProperty(), new NumberStringConverter());
			textFieldfloors.textProperty().unbindBidirectional(oldValue.getFloorsProperty());
			textFieldfloors.clear();
			textFieldfloors.textProperty().bindBidirectional(newValue.getFloorsProperty(), new NumberStringConverter());
			textFieldyear.textProperty().unbindBidirectional(oldValue.getYearProperty());
			textFieldyear.clear();
			textFieldyear.textProperty().bindBidirectional(newValue.getYearProperty(), new NumberStringConverter());
			textFieldarchitect.textProperty().unbindBidirectional(oldValue.getArchitectProperty());
			textFieldarchitect.clear();
			textFieldarchitect.textProperty().bindBidirectional(newValue.getArchitectProperty());
			textFieldstyle.textProperty().unbindBidirectional(oldValue.getStyleProperty());
			textFieldstyle.clear();
			textFieldstyle.textProperty().bindBidirectional(newValue.getStyleProperty());
			textFieldcost.textProperty().unbindBidirectional(oldValue.getCostProperty());
			textFieldcost.clear();
			textFieldcost.textProperty().bindBidirectional(newValue.getCostProperty(), new NumberStringConverter());
			textFieldmaterial.textProperty().unbindBidirectional(oldValue.getMaterialProperty());
			textFieldmaterial.clear();
			textFieldmaterial.textProperty().bindBidirectional(newValue.getMaterialProperty());
			textFieldlong.textProperty().unbindBidirectional(oldValue.getLongtitudeProperty());
			textFieldlong.clear();
			textFieldlong.textProperty().bindBidirectional(newValue.getLongtitudeProperty(), new NumberStringConverter());
			textFieldlal.textProperty().unbindBidirectional(oldValue.getLaltitudeProperty());
			textFieldlal.clear();
			textFieldlal.textProperty().bindBidirectional(newValue.getLaltitudeProperty(), new NumberStringConverter());
			
			
			
		} );
		textFieldid.textProperty().bindBidirectional(building.get().getIdProperty(),new NumberStringConverter());
	}

	private TextField textFieldid;
	private TextField textFieldrank;
	private TextField textFieldname;
	private TextField textFieldcity;
	private TextField textFieldcountry;
	private TextField textFieldheightm;
	private TextField textFieldheightf;
	private TextField textFieldfloors;
	private TextField textFieldyear;
	private TextField textFieldarchitect;
	private TextField textFieldstyle;
	private TextField textFieldcost;
	private TextField textFieldmaterial;
	private TextField textFieldlong;
	private TextField textFieldlal;
	



	
	private Label labelid;
	private Label labelrank;
	private Label labelname;
	private Label labelcity;
	private Label labelcountry;
	private Label labelheightm;
	private Label labelheightf;
	private Label labelfloors;
	private Label labelyear;
	private Label labelarchitect;
	private Label labelstyle;
	private Label labelcost;
	private Label labelmaterial;
	private Label labellong;
	private Label labellal;
	


	

	private void initializeControls(){
		textFieldid = new TextField(Integer.toString(building.get().getId()));
		textFieldrank = new TextField(Integer.toString(building.get().getRank()));
		textFieldname = new TextField(building.get().getName());
		textFieldcity = new TextField(building.get().getCity());
		textFieldcountry = new TextField(building.get().getCountry());
		textFieldheightm = new TextField(Float.toString(building.get().getHeightM()));
		textFieldheightf = new TextField(Float.toString(building.get().getHeightF()));
		textFieldfloors = new TextField(Double.toString(building.get().getFloors()));
		textFieldyear = new TextField(Integer.toString(building.get().getBuildYear()));
		textFieldarchitect = new TextField(building.get().getArchitect());
		textFieldstyle = new TextField(building.get().getStyle());
		textFieldcost = new TextField(Double.toString(building.get().getCost()));
		textFieldmaterial = new TextField(building.get().getMaterial());
		textFieldlong = new TextField(Float.toString(building.get().getLongtitude()));
		textFieldlal = new TextField(Float.toString(building.get().getLatitude()));
		

		labelid = new Label("ID");
		labelrank = new Label("Rank");
		labelname = new Label("Name");
		labelcity = new Label("City");
		labelcountry = new Label("Country");
		labelheightm = new Label("Height(m)");
		labelheightf = new Label("Height(ft)");
		labelfloors = new Label("Floor(s)");
		labelyear = new Label("Year");
		labelarchitect = new Label("Architect");
		labelstyle = new Label("Style");
		labelcost = new Label("Costs");
		labelmaterial = new Label("Material");
		labellong = new Label("Longtitude");
		labellal = new Label("Latitude");
	}
	
	public void makeColumnRow(){
		
		//Spalte
		ColumnConstraints cc = new ColumnConstraints();
		cc.setHgrow(Priority.ALWAYS);
		getColumnConstraints().addAll(cc, cc, cc, cc); // Anzahl spalten
		
		//Zeilen
		
		RowConstraints rc = new RowConstraints();
		rc.setVgrow(Priority.ALWAYS);
		getRowConstraints().addAll(rc, rc, rc, rc, rc, rc, rc, rc, rc, rc, rc);
		
		add(labelrank, 0, 0);
		
		add(labelname, 0, 1);
		add(labelcity, 0, 2);
		add(labelcountry, 2, 2);
		add(labelheightm, 0, 3);
		add(labelheightf, 2, 3);
		add(labelfloors, 0, 4);
		add(labelyear, 2, 4);
		add(labelarchitect, 0, 5);
		add(labelstyle, 2, 5);
		add(labelcost, 0, 6);
		add(labelmaterial, 2, 6);
		add(labellong, 0, 7);
		add(labellal, 2, 7);
	
		add(textFieldname, 1, 0);
		add(textFieldcity, 1, 1);
		add(textFieldcountry, 3, 1);
		add(textFieldheightm, 1, 2);
		add(textFieldheightf, 3, 2);
		add(textFieldfloors, 1, 3);
		add(textFieldyear, 3, 3);
		add(textFieldarchitect, 1, 4);
		add(textFieldstyle, 3, 4);
		add(textFieldcost, 1, 5);
		add(textFieldmaterial, 3, 5);
		add(textFieldlong, 1, 6);
		add(textFieldlal, 3, 6);
	}

	
	
	}
	
	

	


