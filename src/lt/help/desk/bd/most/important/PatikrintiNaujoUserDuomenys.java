package lt.help.desk.bd.most.important;

public class PatikrintiNaujoUserDuomenys {

	private static int PASSWORD_MAX_SIMBOLIU = 10;

	private boolean arIrasytaArgumentoReiksme(String reiksme) {
		if (reiksme.isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean arSlaptazodisSutampa(String pasw, String confPasw) {
		if (pasw.isEmpty() || pasw.length() > PASSWORD_MAX_SIMBOLIU || (!(pasw.equals(confPasw)))) {
			return false;
		}
		return true;
	}

	public boolean uzpildytiNeVisi(String userLoginName, String email, String userPareigos, String passw,
			String passwConf, String userSkyrius, String userSurname, String userName, String userVaidmuo) {
		if (arIrasytaArgumentoReiksme(userLoginName) || arIrasytaArgumentoReiksme(email)
				|| arIrasytaArgumentoReiksme(userPareigos) || arSlaptazodisSutampa(passw, passwConf)
				|| arIrasytaArgumentoReiksme(userSkyrius) || arIrasytaArgumentoReiksme(userSurname)) {
			return true;
		}
		return false;
	}

}
