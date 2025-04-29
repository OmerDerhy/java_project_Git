package classesinterfaces;

public class BallDeodorant extends Deodorant {
	private int volume;

	public BallDeodorant(String sku, double price, int volume) {
		super(sku, price);
		this.volume = volume;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getCategory() {
		return "Ball" + super.getCategory();
	}

	@Override
	public void printAttributes() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return String.format("%-15s %-10s %-10s %-5s %-5s %-10s", getCategory(), sku, price, volume, "", "");
	}

}
