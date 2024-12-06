public class CustomDate implements Comparable<CustomDate>{
	private int year;
	private int month;
	private int day;
	
	public CustomDate(String item) {
		String[] day = item.split("-");                                
		if (day[0].length() > 2) {							// Assuming YYYY/MM/DD
			this.year = Integer.parseInt(day[0]);
			this.month = Integer.parseInt(day[1]);
			this.day = Integer.parseInt(day[2]);
		} else {											// Assuming MM/DD/YYYY
			this.year = Integer.parseInt(day[2]);
			this.month = Integer.parseInt(day[0]);
			this.day = Integer.parseInt(day[1]);
		}
	}
	
	public void printDate() {
		System.out.println(year + " " + month + " " + day);
	}
	
    public boolean isAfter(CustomDate that) {
        return compareTo(that) > 0;
    }

    public boolean isBefore(CustomDate that) {
        return compareTo(that) < 0;
    }
    
    public String toString() {
    	StringBuilder str = new StringBuilder();
    	String monthStr;
    	switch(month) {
    	case 1:
    		monthStr = "Jan";
    		break;
    	case 2:
    		monthStr = "Feb";
    		break;
    	case 3:
    		monthStr = "Mar";
    		break;
    	case 4:
    		monthStr = "Apr";
    		break;
    	case 5:
    		monthStr = "May";
    		break;
    	case 6:
    		monthStr = "Jun";
    		break;
    	case 7:
    		monthStr = "Jul";
    		break;
    	case 8:
    		monthStr = "Aug";
    		break;
    	case 9:
    		monthStr = "Sep";
    		break;
    	case 10:
    		monthStr = "Oct";
    		break;
    	case 11:
    		monthStr = "Nov";
    		break;
    	case 12:
    		monthStr = "Dec";
    		break;
    	default:
    		monthStr = "Invalid Month";
    	}
    	str.append(monthStr + "-" + day + "-" + year);
    	return str.toString();
    }
	
    public int compareTo(CustomDate that) {
        if (this.year  < that.year)  return -1;
        if (this.year  > that.year)  return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day   < that.day)   return -1;
        if (this.day   > that.day)   return +1;
        return 0;
    }
}
