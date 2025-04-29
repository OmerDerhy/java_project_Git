package classesinterfaces;

public abstract class Deodorant extends Product{

	public Deodorant(String sku, double price) {
		super(sku, price);
	}
	
	public String getCategory() {
		return "Deodorant";
	}
}
