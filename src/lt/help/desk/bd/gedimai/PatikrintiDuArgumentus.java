package lt.help.desk.bd.gedimai;

import lt.help.desk.bd.gedimai.PatikrintiPateiktaArgumenta;

public class PatikrintiDuArgumentus {
	PatikrintiPateiktaArgumenta patikrintiArg = new PatikrintiPateiktaArgumenta();

	public boolean arPateikti(String gedimoTema, String gedimoAprasymas) {
		if (patikrintiArg.arNetuscia(gedimoTema) && patikrintiArg.arNetuscia(gedimoAprasymas)) {
			return true;
		}
		return false;

	}
}
