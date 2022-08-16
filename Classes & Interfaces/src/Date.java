import java.io.Serializable;

class Date implements Comparable<Date>, Serializable{

	private static final long serialVersionUID = -2519292849050377102L;
	//instance variables
	private int month;
	private int day;
	private int year;
	
	public Date(int month, int day, int year) {//Sets instance variables
		setMonth(month);
		setDay(day);
		setYear(year);
	}

	public Date(Date other) {//Instance variables constructor
		this.month = other.month;
		this.day = other.day;
		this.year = other.year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {//Checks if month entered is valid
		if(month < 1 || month > 12) {
			System.out.println("Invalid month");
			System.exit(-1);
		}
		this.month = month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {//Checks if day entered is valid
		if(day < 1 || day > 31) {
			System.out.println("Invalid day");
			System.exit(-1);
		}
		this.day = day;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {//Checks if year entered is valid
		if(year < 2014 || month > 2024) {
			System.out.println("Invalid year");
			System.exit(-1);
		}
		this.year = year;
	}
	
	public boolean isAfter(Date compareTo) {//Return true if the compareTo date is after the date.
		int cmp = Integer.compare(compareTo.year, year);
		if(cmp == 0) {
				cmp = Integer.compare(compareTo.month, month);
				if(cmp == 0) {
					cmp = Integer.compare(compareTo.day, day);
					return cmp < 0;
				} else {
					return cmp < 0;
				}
		} else {
			return cmp < 0;
		}
	}
	
	public boolean before(Date lOthr)
	{//Returns true is date is before date
		if(this.year < lOthr.year || (this.year == lOthr.year && this.month < lOthr.month)
		||(this.year == lOthr.year && this.month == lOthr.month && this.day < lOthr.day))
		return true;
		else
		return false;
	}
	
	public String toString()
	{//Formats date in mm/dd/yyyy
		return day + "/" + month + "/" + year;
	}
	
	public boolean equals(Object date) {
		Date other = (Date) date;
		return year == other.year && month == other.month && day == other.day;
	}
	
	@Override
	public int compareTo(Date o) {
		if (getClass() != o.getClass())
		throw new IllegalArgumentException();
		if(this.equals(o))
			return 0;
		else if(this.isAfter(o))
			return 1;
		else
			return -1;
	}
	
	@Override
	public Date clone(){
		Date d;
		try{
			d = (Date) super.clone();
			return d;
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		}
	}