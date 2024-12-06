import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;

public class main {
	public static void main(String[] args) throws IOException {
		
		// ---- Sea Level -------------------------------------------------------------------
		BufferedReader slIn = new BufferedReader(new FileReader("sea-level-rise.csv"));
		
		String slLine = slIn.readLine();
		slLine = slIn.readLine();
		
		RedBlackTree<CustomDate, getData> slDateRBT = new RedBlackTree<>();
		RedBlackTree<String, CustomDate> slRBT = new RedBlackTree();
		
		while((slLine = slIn.readLine()) != null) {
			String[] item1 = slLine.split(",", -1);
			if(item1[0].equals("World")) {
			    
			    getData day1 = new getData(item1);
			    
			    slDateRBT.put(day1.getDate(), day1);
			    if (day1.getSeaLevel() != null) {
			    	slRBT.put(day1.getSeaLevel(), day1.getDate());
			    }
			}
		}
		
		StringBuilder slStr = new StringBuilder();
		slStr.append("Lowest Sea Level Rise" + ": " + slRBT.getKey(slRBT.findMin()) + " on " + slRBT.getValue(slRBT.findMin()).toString());
		
		getData Mindate = slDateRBT.getValue(slDateRBT.find(slRBT.getValue(slRBT.findMin())));
		if(Mindate.getCO2() != null) {
			slStr.append("\n");
			slStr.append("On that same date, the Average Co2 concentration was " + Mindate.getCO2());
		}
		if(Mindate.getSeaLevel() != null) {
			slStr.append("\n");
			slStr.append("On that same date, the Temperature Anomaly (F) was " + Mindate.getTemp());
		}
		
		slStr.append("\n");
		slStr.append("\n");
		
		slStr.append("Highest Sea Level Rise" + ": " + slRBT.getKey(slRBT.findMax()) + " on " + slRBT.getValue(slRBT.findMax()).toString());
		
		getData Maxdate = slDateRBT.getValue(slDateRBT.find(slRBT.getValue(slRBT.findMax())));
		if(Maxdate.getCO2() != null) {
			slStr.append("\n");
			slStr.append("On that same date, the Average Co2 concentration was " + Maxdate.getCO2());
		}
		if(Maxdate.getSeaLevel() != null) {
			slStr.append("\n");
			slStr.append("On that same date, the Temperature Anomaly (F) was " + Maxdate.getTemp());
		}

		
		// ---------------------------------------------------------------------------------
		
		// -- Temperature Anomaly ----------------------------------------------------------
		
		BufferedReader taIn = new BufferedReader(new FileReader("global-warming-monthly-temperature-anomaly.csv"));
		
		String taLine = taIn.readLine();
		taLine = taIn.readLine();
		
		RedBlackTree<CustomDate, getData> taDateRBT = new RedBlackTree();
		RedBlackTree<String, CustomDate> taRBT = new RedBlackTree();
		
		while((taLine = taIn.readLine()) != null) {
			String[] item2 = taLine.split(",", -1);
			if(item2[0].equals("World")) {
			    
			    getData day2 = new getData(item2);
			    
			    taDateRBT.put(day2.getDate(), day2);
			    if (day2.getTemp() != null) {
			    	taRBT.put(day2.getTemp(), day2.getDate());
			    }
			}
				
			

		}
		
		StringBuilder taStr = new StringBuilder();
		taStr.append("\n");
		taStr.append("Lowest Temperature Anomaly" + ": " + Double.parseDouble(taRBT.getKey(taRBT.findMin())) * 1.8 + " on " + taRBT.getValue(taRBT.findMin()).toString());
		
		getData taMindate = taDateRBT.getValue(taDateRBT.find(taRBT.getValue(taRBT.findMin())));
		if(taMindate.getCO2() != null) {
			taStr.append("\n");
			taStr.append("On that same date, the Average Co2 concentration was " + taMindate.getCO2());
		}
		if(taMindate.getSeaLevel() != null) {
			taStr.append("\n");
			taStr.append("On that same date, the Sea Level Rise was " + taMindate.getSeaLevel());
		}
		taStr.append("\n");
		taStr.append("\n");
		taStr.append("Highest Temperature Anomaly" + ": " + Double.parseDouble(taRBT.getKey(taRBT.findMax())) * 1.8 + " on " + taRBT.getValue(taRBT.findMax()).toString());
		
		getData taMaxdate = taDateRBT.getValue(taDateRBT.find(taRBT.getValue(taRBT.findMax())));
		if(taMaxdate.getCO2() != null) {
			taStr.append("\n");
			taStr.append("On that same date, the Average Co2 concentration was " + taMaxdate.getCO2());
		}
		if(taMaxdate.getSeaLevel() != null) {
			taStr.append("\n");
			taStr.append("On that same date, the Sea Level Rise was " + taMaxdate.getSeaLevel());
		}
		
		// ---------------------------------------------------------------------------------
		
		// -- CO2 Levels -------------------------------------------------------------------
		BufferedReader coIn = new BufferedReader(new FileReader("global-atmospheric-co-concentration.csv"));
		
		String coLine = coIn.readLine(); 
		coLine = coIn.readLine();
		
		RedBlackTree<CustomDate, getData> dateCoRBT = new RedBlackTree();
		RedBlackTree<String, CustomDate> coRBT = new RedBlackTree();
		
		while((coLine = coIn.readLine()) != null) {
			String[] item3 = coLine.split(",", -1);
			if(item3[0].equals("World")) {
			    
			    getData day3 = new getData(item3);
			    
			    dateCoRBT.put(day3.getDate(), day3);
			    if (day3.getTemp() != null) {
			    	coRBT.put(day3.getCO2(), day3.getDate());
			    }
			} 
				
			

		}
		
		StringBuilder coStr = new StringBuilder();
		coStr.append("\n");
		coStr.append("Lowest Sea Level Rise" + ": " + coRBT.getKey(coRBT.findMin()) + " on " + coRBT.getValue(coRBT.findMin()).toString());
		
		getData coMindate = dateCoRBT.getValue(dateCoRBT.find(coRBT.getValue(coRBT.findMin())));
		if(coMindate.getCO2() != null) {
			coStr.append("\n");
			coStr.append("On that same date, the Temperature Anomaly (F) was " + coMindate.getTemp());
		}
		if(coMindate.getSeaLevel() != null) {
			coStr.append("\n");
			coStr.append("On that same date, the Sea Level Rise was " + coMindate.getSeaLevel());
		}
		coStr.append("\n");
		coStr.append("\n");
		coStr.append("Highest Sea Level Rise" + ": " + coRBT.getKey(slRBT.findMax()) + " on " + coRBT.getValue(coRBT.findMax()).toString());
		
		getData coMaxdate = dateCoRBT.getValue(dateCoRBT.find(coRBT.getValue(coRBT.findMax())));
		if(coMaxdate.getCO2() != null) {
			coStr.append("\n");
			coStr.append("On that same date, the Temperature Anomaly (F) was " + coMaxdate.getTemp());
		}
		if(coMaxdate.getSeaLevel() != null) {
			coStr.append("\n");
			coStr.append("On that same date, the Sea Level Rise was " + coMaxdate.getSeaLevel());
		}
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("program2_out.txt"));
			writer.write(slStr.toString());
			writer.write("\n");
			writer.write(taStr.toString());
			writer.write("\n");
			writer.write(coStr.toString());

			
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred");
			e.printStackTrace();
		}
		
		
		// ---------------------------------------------------------------------------------
		
	}
	
}
