package task07;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Product implements Serializable{
	private static final long serialVersionUID = -7210691782371237290L;
	private String name = "N/A";
	private String unitOfMeasurement = "N/A";
	private int amount = 0;
	private int price = 0;
	private LocalDate arrivalDate = LocalDate.of(1970, Month.JANUARY, 1);
	private ArrayList<Stat> stats = new ArrayList<Stat>();
	public Product(){
		
	}
	public Product(String name, String unitOfMeasurement, int amount, int price, int yearOfArrival, int monthOfArrival, int dayOfArrival, String... args){
		this.name = name;
		this.unitOfMeasurement = unitOfMeasurement;
		this.amount = amount;
		this.price = price;
		this.arrivalDate = LocalDate.of(yearOfArrival, monthOfArrival, dayOfArrival);
		for (int i = 0;i < args.length;i+=2) {
			stats.add(new Stat(args[i],args[i+1]));
		}
	}
	public String toString() {
		String result = "Name: " + name + "\nUnit of measurement: " + unitOfMeasurement + "\nAmount: " + Integer.toString(amount) + "\nPrice: " + Integer.toString(price) + "\nDate of arrival: " + arrivalDate.format(DateTimeFormatter.ofPattern("d MMMM uuuu"));
		for (Stat i : stats) {
			result += "\n" + i.getName() + ": " + i.getValue(); 
		}
		return result;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitOfMeasurment() {
		return unitOfMeasurement;
	}
	public void setUnitOfMeasurment(String unitOfMeasurment) {
		this.unitOfMeasurement = unitOfMeasurment;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public void setArrivalDate(int year, int month, int day) {
		this.arrivalDate = LocalDate.of(year, Month.values()[month-1], day);
	}
	public ArrayList<Stat> getStats() {
		return stats;
	}
	public void setStats(ArrayList<Stat> stats) {
		this.stats = stats;
	}
	
}
