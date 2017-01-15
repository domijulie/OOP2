package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Building {

	private IntegerProperty id = new SimpleIntegerProperty();
	private IntegerProperty rank = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty city = new SimpleStringProperty();
	private StringProperty country = new SimpleStringProperty();
	private FloatProperty height = new SimpleFloatProperty();
	private IntegerProperty floors = new SimpleIntegerProperty();
	private IntegerProperty buildYear = new SimpleIntegerProperty();
	private StringProperty architect = new SimpleStringProperty();
	private StringProperty style = new SimpleStringProperty();
	private DoubleProperty cost = new SimpleDoubleProperty();
	private StringProperty material = new SimpleStringProperty();
	private FloatProperty longtitude = new SimpleFloatProperty();
	private FloatProperty latitude = new SimpleFloatProperty();
	private StringProperty image = new SimpleStringProperty();

	public Building(String[] line) {

		setId(line[0]);
		setRank(line[1]);
		setName(line[2]);
		setCity(line[3]);
		setCountry(line[4]);
		setHeightM(line[5]);
		setHeightF(line[6]);
		setFloors(line[7]);
		setBuildYear(line[8]);
		setArchitect(line[9]);
		setStyle(line[10]);
		setCost(line[11]);
		setMaterial(line[12]);
		setLongtitude(line[13]);
		setLatitude(line[14]);
		try {
			setImage(line[15]);
		} catch (IndexOutOfBoundsException ioobe) {
			setImage("");
		}

	}

	public Building(int id) {
		setId(id);
	}

	public int getId() {
		return id.get();
	}

	public void setId(String id) {
		this.id.setValue(Integer.parseInt(id));
	}

	public void setId(int id) {
		this.id.setValue(id);
	}

	public int getRank() {
		return rank.get();
	}

	public void setRank(String rank) {
		this.rank.setValue(Integer.parseInt(rank));
	}

	public void setRank(int rank) {
		this.rank.setValue(rank);
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.setValue(name);
	}

	public String getCity() {
		return city.get();
	}

	public void setCity(String city) {
		this.city.setValue(city);
	}

	public String getCountry() {
		return country.get();
	}

	public void setCountry(String country) {
		this.country.setValue(country);
	}

	public float getHeightM() {
		return height.get();
	}

	public void setHeightM(String height) {
		this.height.setValue(Float.parseFloat(height));
		;
	}

	public void setHeightM(float height) {
		this.height.setValue(height);
		;
	}

	public float getHeightF() {
		return (float) (height.get() * 3.2808);
	}

	public void setHeightF(String height) {
		this.height.setValue(Float.parseFloat(height));
		;
	}

	public void setHeighF(float height) {
		this.height.setValue(height);
		;
	}

	public int getFloors() {
		return floors.get();
	}

	public void setFloors(String floors) {
		this.floors.setValue(Integer.parseInt(floors));
	}

	public void setFloors(int floors) {
		this.floors.setValue(floors);
	}

	public int getBuildYear() {
		return buildYear.get();
	}

	public void setBuildYear(String buildYear) {
		this.buildYear.setValue(Integer.parseInt(buildYear));
		;
	}

	public String getArchitect() {
		return architect.get();
	}

	public void setArchitect(String architect) {
		this.architect.setValue(architect);
		;
	}

	public String getStyle() {
		return style.get();
	}

	public void setStyle(String style) {
		this.style.setValue(style);
		;
	}

	public double getCost() {
		return cost.get();
	}

	public void setCost(String cost) {
		this.cost.setValue(Double.parseDouble(cost));
		;
	}

	public void setCost(double cost) {
		this.cost.setValue(cost);
		;
	}

	public String getMaterial() {
		return material.get();
	}

	public void setMaterial(String material) {
		this.material.setValue(material);
		;
	}

	public float getLongtitude() {
		return longtitude.get();
	}

	public void setLongtitude(String longtitude) {
		this.longtitude.setValue(Float.parseFloat(longtitude));
	}

	public void setLongtitude(float longtitude) {
		this.longtitude.setValue(longtitude);
	}

	public float getLatitude() {
		return latitude.get();
	}

	public void setLatitude(String latitude) {
		this.latitude.setValue(Float.parseFloat(latitude));
	}

	public void setLatitude(float latitude) {
		this.latitude.setValue(latitude);
	}

	public String getImage() {
		return image.get();
	}

	public void setImage(String image) {
		this.image.setValue(image);
	}

	public IntegerProperty getIdProperty() {
		return id;
	}

	public IntegerProperty getRankProperty() {
		return rank;
	}

	public StringProperty getNameProperty() {
		return name;
	}

	public StringProperty getCountryProperty() {

		return country;
	}

	public FloatProperty getHeightmProperty() {
		// height in meters!
		return height;
	}

	public FloatProperty getHeightfProperty() {
		// height in feet!
		return height;

	}

	public IntegerProperty getFloorsProperty() {
		return floors;
	}

	public IntegerProperty getYearProperty() {

		return buildYear;
	}

	public StringProperty getArchitectProperty() {

		return architect;
	}

	public StringProperty getStyleProperty() {

		return style;
	}

	public DoubleProperty getCostProperty() {

		return cost;
	}

	public StringProperty getMaterialProperty() {

		return material;
	}

	public FloatProperty getLongtitudeProperty() {

		return longtitude;
	}

	public FloatProperty getLaltitudeProperty() {

		return latitude;
	}

	public StringProperty getCityProperty() {

		return city;
	}

	public String toString() {
		String output = "";
		output += getId() + ";";
		output += getRank() + ";";
		output += getName() + ";";
		output += getCity() + ";";
		output += getCountry() + ";";
		output += getHeightM() + ";";
		output += getHeightF() + ";";
		output += getFloors() + ";";
		output += getBuildYear() + ";";
		output += getArchitect() + ";";
		output += getStyle() + ";";
		output += getCost() + ";";
		output += getMaterial() + ";";
		output += getLongtitude() + ";";
		output += getLatitude();

		return output;
	}

	public int levenshteinDistance(String a, String[] b) {
		return Math.min(levenshteinDistance(a, b[0]), levenshteinDistance(a, b[1]));
	}

	public int levenshteinDistance(String a, String b) {

		// ignore case
		a = a.toLowerCase();
		b = b.toLowerCase();

		// initalize matrix with length of number of caracters in a + 1 and
		// width of number of characters in b + 1
		int costs[][] = new int[a.length() + 1][b.length() + 1];

		// set the values in the first column as 0...length of a
		for (int i = 0; i < a.length() + 1; i++) {
			costs[i][0] = i;
		}

		// set the values in the first row as 0...length of b
		for (int i = 0; i < b.length() + 1; i++) {
			costs[0][i] = i;
		}

		for (int i = 1; i < a.length() + 1; i++) {
			for (int j = 1; j < b.length() + 1; j++) {
				// If a[i] equals b[j], the cost is 0, If a[i] doesn't equal
				// b[j], the cost is 1.
				int cost = (a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1;

				// Set cell costs[i,j] of the matrix equal to the minimum of:
				// a. The cell immediately above plus 1: costs[i-1,j] + 1.
				// b. The cell immediately to the left plus 1: costs[i,j-1] + 1.
				// c. The cell diagonally above and to the left plus the cost:
				// costs[i-1,j-1] + cost.
				costs[i][j] = Math.min(Math.min(costs[i - 1][j] + 1, costs[i][j - 1] + 1), costs[i - 1][j - 1] + cost);

				if (i > 2 && j > 2 && a.charAt(i - 1) == b.charAt(j - 2) && a.charAt(i - 2) == b.charAt(j - 1)) {
					costs[i][j] = Math.min(costs[i][j], costs[i - 2][j - 2] + cost);
				}
			}
		}
		return costs[a.length()][b.length()];
	}
}
