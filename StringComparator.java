import java.util.*;

public class StringComparator implements Comparator<String> {
//	@Override
	public StringComparator() {
		super();
	}
	
	public int compare(String one, String two) {
		return two.length() - one.length();
	}
}