package naudotojai;

import naudotojai.MetodamsSuVienuArgumentu;

public class PatikrintiSurname implements MetodamsSuVienuArgumentu {

	@Override
	public boolean patikrintiVienoArgumentoReiksme(String reiksme) {
		if (reiksme.isEmpty() || reiksme.length() > 110) {
			return false;
		}
		return true;
	}
}