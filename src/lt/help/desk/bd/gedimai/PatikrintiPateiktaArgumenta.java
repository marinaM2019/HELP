package lt.help.desk.bd.gedimai;

public class PatikrintiPateiktaArgumenta {

	PatikrintiPateiktaArgumenta() {
	}

	boolean arNetuscia(String reiksme) {
		if (reiksme.isEmpty()) {
			return false;
		}
		return true;
	}
}
