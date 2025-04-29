package classesinterfaces;

public class Perfume extends Product {
	private int size;
	private String madeIn;

	public Perfume(String sku, double price, int size, String madeIn) {
		super(sku, price);
		this.size = size;
		this.madeIn = madeIn;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}

	@Override
	public String getCategory() {
		return "Perfume";
	}

	@Override
	public void printAttributes() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format("%-15s %-10s %-10s %-5s %-5s", getCategory(), sku, price, size, madeIn);
	}

	
	
}
