package classesinterfaces;

import java.util.Comparator;

public class SortBySKU implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return Integer.parseInt(o1.getSku()) - Integer.parseInt(o2.getSku());
//		return o1.getSku().compareTo(o2.getSku());
	}

}
