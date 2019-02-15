package lt.help.desk.bd.gedimai;

public class PatikrintiDuArgumentus {

	public static boolean arVisiUzpildyti(String... strs) {

		for (String string : strs) {
			if (string != null && !string.isEmpty()) {
				// do nothing
			} else {
				return false;
			}
		}

		return true;

	}
}
