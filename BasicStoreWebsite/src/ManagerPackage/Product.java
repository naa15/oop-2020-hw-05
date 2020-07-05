package ManagerPackage;

public class Product {
	private String name;
	private Double price;
	private String imageL;
	private String ID;
	public Product(String ID, String name, Double price, String imageL){
		this.name = name;
		this.ID = ID;
		this.price = price;
		this.imageL = imageL;
	}
	public String getID() {
		return ID;
	}
	public String getImageL() {
		return imageL;
	}
	public String getName() {
		return name;
	}
	public Double getPrice() {
		return price;
	}
}
