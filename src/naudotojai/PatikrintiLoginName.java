package naudotojai;

import naudotojai.MetodamsSuVienuArgumentu;

public class PatikrintiLoginName implements MetodamsSuVienuArgumentu {

	@Override
	public boolean patikrintiVienoArgumentoReiksme(String reiksme) {
		if (reiksme.isEmpty() || reiksme.length() > 6) {
			return false;
		}
		return true;
	}

}