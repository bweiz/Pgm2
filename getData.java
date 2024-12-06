import java.util.ArrayList;

public class getData implements Comparable<String>{
	private CustomDate date;
	private String tempAnomaly;
	private String seaLevel;
	private String co2con;
	
	public getData(String[] day) {

		this.date = new CustomDate(day[1]);
		
		if(!day[11].isEmpty()) {
			this.tempAnomaly = day[11];
		}
		if(!day[14].isEmpty()) {
			this.seaLevel = day[14];
		}
		if(!day[18].isEmpty()) {
			this.co2con = day[18];
		}
	}
	
	public ArrayList<String> retData() {
		ArrayList<String> data = new ArrayList<String>();
		data.add(this.date.toString());
		data.add(this.tempAnomaly);
		data.add(this.seaLevel);
		data.add(this.co2con);
		
		return data;
	}
	
	public CustomDate getDate() {
		return date;
	}
	
	public String getTemp() {
		return tempAnomaly;
	}
	
	public String getSeaLevel() {
		return seaLevel;
	}
	
	public String getCO2() {
		return co2con;
	}
	


	@Override
	public int compareTo(String that) {
		if (this.compareTo(that) == 0) return 0;
		else if (this.compareTo(that) > 0) return -1;
		else return 1;
	}
	
}
