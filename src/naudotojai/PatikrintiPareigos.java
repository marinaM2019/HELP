package naudotojai;

import naudotojai.MetodamsSuVienuArgumentu;

public class PatikrintiPareigos implements MetodamsSuVienuArgumentu {

	@Override
	public boolean patikrintiVienoArgumentoReiksme(String reiksme) {
		if (reiksme.equals("-1")) {
			return false;
		}
		return true;
	}
}