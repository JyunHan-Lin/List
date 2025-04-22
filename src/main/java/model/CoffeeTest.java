package model;

public class CoffeeTest { // 在實際跑Servlet前, 用來測試程式能不能順利運作
	
	public static void main(String[]args) {
		Coffee coffee = new Coffee(400.0, 100.0);
		System.out.println(coffee.getCoffeeType());
	}
}
