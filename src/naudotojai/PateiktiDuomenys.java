package naudotojai;

import naudotojai.PatikrintiLoginName;
import naudotojai.PatikrintiMail;
import naudotojai.PatikrintiPareigos;
import naudotojai.PatikrintiPassw;
import naudotojai.PatikrintiSkyriu;
import naudotojai.PatikrintiSurname;
import naudotojai.PatikrintiUserName;
import naudotojai.PatikrintiVaidmeni;

public class PateiktiDuomenys {
	PatikrintiLoginName logN = new PatikrintiLoginName();
	PatikrintiMail ma = new PatikrintiMail();
	PatikrintiPareigos pareig = new PatikrintiPareigos();
	PatikrintiPassw passw = new PatikrintiPassw();
	PatikrintiSkyriu skyr = new PatikrintiSkyriu();
	PatikrintiSurname surn = new PatikrintiSurname();
	PatikrintiUserName userNam = new PatikrintiUserName();
	PatikrintiVaidmeni vaidm = new PatikrintiVaidmeni();

	public boolean arTeisingi(String loginName, String email, String pareigos, String pasw1,
			String pasw2, String skyrius, String surname, String userName, String vaidmuo) {
		if (logN.patikrintiVienoArgumentoReiksme(loginName) && ma.patikrintiVienoArgumentoReiksme(email)
				&& pareig.patikrintiVienoArgumentoReiksme(pareigos)
				&& passw.patikrintiDvejuArgumentuReiksmes(pasw1, pasw2) && skyr.patikrintiVienoArgumentoReiksme(skyrius)
				&& surn.patikrintiVienoArgumentoReiksme(surname) && userNam.patikrintiVienoArgumentoReiksme(userName)
				&& vaidm.patikrintiVienoArgumentoReiksme(vaidmuo)) {
			return false;
		}

		return true;

	}

}
