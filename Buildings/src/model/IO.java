package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/* created by Domi 20.12.16 */

public class IO {
	
	private static String FILE_URL = "/resources/buildings.csv";
	
	private final ObservableList<Building> building = FXCollections.observableArrayList();
	
	public Collection<Building> readFile() {
		
		try (Stream<String> stream = getStreamOfLines(FILE_URL, false)) {
			return stream.skip(1)
					.map(s -> new Building(s.split(";")))
					.collect(Collectors.toList());
		}
		
	
	}
	
	
		private Path getPath (String fileName, boolean locatedInSameFolder) {
			try {
				if (!locatedInSameFolder) {
					fileName = "../" + fileName;
				}
				return (Path) Paths.get(getClass().getResource(fileName).toURI());
			} catch (URISyntaxException e) { 
				throw new IllegalArgumentException(e);
			}
		}

			
		private Stream<String> getStreamOfLines( String fileName, boolean locatedInSameFolder) {
			
			try { 
				return Files.lines(getPath(fileName, locatedInSameFolder), StandardCharsets.UTF_8);
				
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
		
		public ObservableList<Building> getBuilding() {
			return building;
		}


		public static void write(ObservableList<Building> buildings) throws IOException{
			
			BufferedWriter writer = Files.newBufferedWriter(Paths.get("src" + FILE_URL));
			
			writer.write("ID;RANK;BUILDING;CITY;COUNTRY;HEIGHT_M;HEIGHT_FT;FLOORS;BUILD;ARCHITECT;ARCHITECTUTAL_STYLE;COST;MATERIAL;LONGITUDE;LATITUDE;IMAGE_URL");
			writer.newLine();
			buildings.stream().forEach(e -> {
				try{
					writer.write(e.toString());
					writer.newLine();
				}catch(IOException exc){
					exc.printStackTrace();
				}
			});
			writer.close();
		}
		
		
	}

/*	while(){
		List<Building> bs;
		for ( building b: bs){
			Line = b.getID();
			Line += ";";
			Line = b.getRank();
			Line += ";";
			Line = b.getName();
			Line += ";";
			Line = b.getCity();
			Line += ";";
			Line = b.getCountry();
			Line += ";";
			Line = b.getHeight();
			Line += ";";
			Line = b.getFloors();
			Line += ";";
			Line = b.getBuildYear();
			Line += ";";
			Line = b.getArchitect();
			Line += ";";
			Line = b.getStyle();
			Line += ";";
			Line = b.getCost();
			Line += ";";
			Line = b.getMaterial();
			Line += ";";
			Line = b.getLongtitude();
			Line += ";";
			Line = b.getLaltitude();
			Line += ";";
			Line = b.getImage();}*/
