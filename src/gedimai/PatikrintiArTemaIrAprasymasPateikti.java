package gedimai;

import gedimai.PatikrintiPateiktaArgumenta;

public class PatikrintiArTemaIrAprasymasPateikti {
PatikrintiPateiktaArgumenta patikrintiArg = new PatikrintiPateiktaArgumenta();
	
	public boolean patikrintiArgumentus (String gedimoTema, String gedimoAprasymas) {
		if (patikrintiArg.arNetuscia(gedimoTema) && patikrintiArg.arNetuscia(gedimoAprasymas)) {
			return true;
		}
		return false;
		
	}
}
