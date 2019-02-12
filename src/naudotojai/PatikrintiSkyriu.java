package naudotojai;

import naudotojai.MetodamsSuVienuArgumentu;

public class PatikrintiSkyriu implements MetodamsSuVienuArgumentu {

	@Override
	public boolean patikrintiVienoArgumentoReiksme(String reiksme) {
		if (reiksme.equals("-1")) {
			return false;
		}
		return true;
	}
}
