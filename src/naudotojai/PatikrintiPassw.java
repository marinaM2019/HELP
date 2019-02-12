package naudotojai;

public class PatikrintiPassw implements MetodamsSuDviemArgumentais {

	@Override
	public boolean patikrintiDvejuArgumentuReiksmes(String pirmaReiksme, String antraReiksme) {
		if (pirmaReiksme.isEmpty() || (pirmaReiksme.length() > 10 && (!(pirmaReiksme.equals(antraReiksme))))) {
			return false;
		}
		return true;
	}
}