package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 訪客留言版
public class IceDessert {
	
	private String mainDish;
	private List<String> toppings;
	private Date date;
	
	public IceDessert(String mainDish, String[] toppings) {
		this.mainDish = mainDish;
		this.toppings = List.of(toppings); 
		this.date = new Date();
	}
	
	public String getMainDish() {
		return mainDish;
	}
	
	public List<String> getToppings() {
		return toppings;
	}
	
	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "IceDessert [mainDish=" + mainDish + "toppings=" + toppings + ", date=" + date + "]";
	}

	private static List<IceDessert> icedesserts = new ArrayList<>();
	
	public static void add(IceDessert dessert) {
		icedesserts.add(dessert);
	}

	public static List<IceDessert> getAll() {
		return icedesserts;
	}
}
