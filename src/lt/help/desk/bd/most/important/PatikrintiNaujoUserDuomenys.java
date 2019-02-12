package lt.help.desk.bd.most.important;



public class PatikrintiNaujoUserDuomenys {
	
//	private static int LOGIN_NAME_MAX_SIMBOLIU=6;
	private static int PASSWORD_MAX_SIMBOLIU=10;
//	private static int USER_NAME_MAX_SIMBOLIU=110;
//	private static int SURNAME_MAX_SIMBOLIU=110;
//	private static int MAIL_MAX_SIMBOLIU=240;
//	
	
	
	private boolean arIrasytaArgumentoReiksme(String reiksme) {
		if (reiksme.isEmpty()) {
			return false;
		}
		return true;
	}
	
	private boolean arSlaptazodisSutampa(String pasw, String confPasw) {
		if (pasw.isEmpty() || pasw.length()>PASSWORD_MAX_SIMBOLIU || (!(pasw.equals(confPasw)))) {
			return false;
		}
		return true;
	}

	


	public boolean uzpildytiNeVisi(String userLoginName, String email, String userPareigos, String passw, String passwConf, String userSkyrius, String userSurname,
			String userName, String userVaidmuo) {
		if (arIrasytaArgumentoReiksme(userLoginName) || 
				arIrasytaArgumentoReiksme(email) ||
				arIrasytaArgumentoReiksme(userPareigos) ||
				arSlaptazodisSutampa(passw, passwConf) ||
				arIrasytaArgumentoReiksme(userSkyrius) ||
				arIrasytaArgumentoReiksme(userSurname)
				) {
			return false;
		}
		return true;
	}

}
