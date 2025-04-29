package classesinterfaces;

public class SprayDeodorant extends Deodorant {
	private int size;
	private String type;

	public SprayDeodorant(String sku, double price, int size, String type) {
		super(sku, price);
		this.size = size;
		this.type = type;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	public String getCategory() {
		return "Spray" + super.getCategory();
	}

	@Override
	public void printAttributes() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format("%-15s %-10s %-10s %-5s %-5s %-10s", getCategory(), sku, price, size, "", type);
	}
	
	
	
}
