package classesinterfaces;

public abstract class Product implements Storage, Comparable<Product>, Cloneable {
	protected String sku;
	protected double price;

	public Product(String sku, double price) {
		this.sku = sku;
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public int compareTo(Product p) {
		return (int)((this.price - p.price)*100);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
