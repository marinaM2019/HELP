package lt.help.desk.bd.naudotojai;

public class Patikrinti {
	
	private static int LOGIN_NAME_MAX_SIMBOLIU=6;
	private static int PASSWORD_MAX_SIMBOLIU=10;
	private static int USER_NAME_MAX_SIMBOLIU=110;
	private static int SURNAME_MAX_SIMBOLIU=110;
	private static int MAIL_MAX_SIMBOLIU=240;
	
	
	
	private boolean vienoArgumentoReiksme(String reiksme) {
		if (reiksme.isEmpty()) {
			return false;
		}
		return true;
	}
	
	
	

	
	
	
	
	public boolean patikrintiLoginName (String loginName) {
		return vienoArgumentoReiksme(loginName);
	}
	
	public boolean patikrintiMail (String mail) {
		return vienoArgumentoReiksme(mail);
	}
	
	public boolean dvejuArgumentuReiksme(String pasw, String paswConf) {
		if (pasw.isEmpty() || (pasw.length() > PASSWORD_MAX_SIMBOLIU && (!(pasw.equals(paswConf))))) {
			return false;
		}
		return true;
	}
	
	

}
