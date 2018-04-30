
public class Array {
	
	private String day_of_the_month;
	private String month;
	private String time;
	private String type;
	private String description;
	
	public Array(String day_of_the_month, String month, String time, String type, String description) {
		super();
		this.day_of_the_month = day_of_the_month;
		this.month = month;
		this.time = time;
		this.type = type;
		this.description = description;
	}
	public String getDay_of_the_month() {
		return day_of_the_month;
	}
	public void setDay_of_the_month(String day_of_the_month) {
		this.day_of_the_month = day_of_the_month;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Object[] getArrayObject() {
		Object[] array = { getDay_of_the_month(), getMonth(), getTime(), getType(), getDescription() };
		return array;
	}
	
}
