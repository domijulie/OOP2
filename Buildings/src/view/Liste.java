package view;

import java.io.File;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Building;

public class Liste extends VBox {

	private TableView<Building> tabelle;

	// create tableColumns
	/*
	 * private final TableColumn<Building, Integer> rankCol; private final
	 * TableColumn<Building, String> nameCol; private final
	 * TableColumn<Building, String> cityCol;
	 */

	private ObservableList<Building> buildings;
	private TextField searchField;
	private FilteredList<Building> filteredData;
	private SortedList<Building> sortedData;


	public Liste(ObservableList<Building> buildings) {
		this.buildings = buildings;
		initializeControls();
		addBindings();
	}
	
	public void update(){
		//ugly workaround
		tabelle.getColumns().get(0).setVisible(false);
		tabelle.getColumns().get(0).setVisible(true);
	}

	private void addBindings() {
		buildings.addListener(new ListChangeListener<Building>(){

            @Override
            public void onChanged(javafx.collections.ListChangeListener.Change<? extends Building> pChange) {
                while(pChange.next()) {
                	filteredData = new FilteredList<Building>(buildings, s -> true);
            		sortedData = new SortedList<Building>(filteredData, (s1, s2) -> Integer.compare(s1.getRank(), s2.getRank()));
            		
            		searchField.textProperty().addListener(e -> {
            			String filter = searchField.getText();
            			if (filter == null || filter.length() == 0) {
            				filteredData.setPredicate(s -> true);
            				sortedData.setComparator((s1, s2) -> Integer.compare(s1.getRank(), s2.getRank()));
            			} else {
            				filteredData.setPredicate(
            						s -> s.levenshteinDistance(filter, s.getName()) <= s.getName().length() - filter.length());
            				sortedData.setComparator((s1, s2) -> (s1.levenshteinDistance(filter, s1.getName()))
            						- (s2.levenshteinDistance(filter, s2.getName())));
            			}
            		});
            		
            		tabelle.setItems(sortedData);
                }
            }
        });
		
	}

	private void initializeControls() {
		// Initialize Tableview
		tabelle = new TableView<Building>();
		filteredData = new FilteredList<Building>(buildings, s -> true);
		sortedData = new SortedList<Building>(filteredData, (s1, s2) -> Integer.compare(s1.getRank(), s2.getRank()));

		tabelle.setItems(sortedData);

		searchField = new TextField();
		searchField.textProperty().addListener(e -> {
			String filter = searchField.getText();
			if (filter == null || filter.length() == 0) {
				filteredData.setPredicate(s -> true);
				sortedData.setComparator((s1, s2) -> Integer.compare(s1.getRank(), s2.getRank()));
			} else {
				filteredData.setPredicate(
						s -> s.levenshteinDistance(filter, s.getName()) <= s.getName().length() - filter.length());
				sortedData.setComparator((s1, s2) -> (s1.levenshteinDistance(filter, s1.getName()))
						- (s2.levenshteinDistance(filter, s2.getName())));
			}
		});

		TableColumn<Building, Integer> rankCol = new TableColumn<Building, Integer>("Rank");
		rankCol.setCellValueFactory(new PropertyValueFactory<Building, Integer>("rank"));
		TableColumn<Building, String> nameCol = new TableColumn<Building, String>("Name");
		nameCol.setCellValueFactory(new PropertyValueFactory<Building, String>("name"));
		TableColumn<Building, String> cityCol = new TableColumn<Building, String>("City");
		cityCol.setCellValueFactory(new PropertyValueFactory<Building, String>("city"));

		tabelle.getColumns().addAll(rankCol, nameCol, cityCol);

		HBox searchBox = new HBox();
		ImageView image = new ImageView(
				new File("src" + File.separator + "resources" + File.separator + "search.png").toURI().toString());
		image.setFitHeight(20);
		image.setFitWidth(20);
		searchBox.getChildren().addAll(image, searchField);
		tabelle.getSelectionModel().selectFirst();
		this.getChildren().addAll(searchBox, tabelle);

	}

	public TableView<Building> getTable() {
		return tabelle;
	}
}
