package lt.help.desk.bd.naudotojai;

public class Patikrinti {
	
	private static int LOGIN_NAME_MAX_SIMBOLIU=6;
	private static int PASSWORD_MAX_SIMBOLIU=10;
	private static int USER_NAME_MAX_SIMBOLIU=110;
	private static int SURNAME_MAX_SIMBOLIU=110;
	private static int MAIL_MAX_SIMBOLIU=240;
	
	
	
	private boolean arIrasytaArgumentoReiksme(String reiksme) {
		if (!reiksme.isEmpty()) {
			return true;
		}
		return false;
	}
	
	
	
	
	public boolean arLoginNameIrasyta (String loginName) {
		if(arIrasytaArgumentoReiksme(loginName)){
			return true;
		} return false;
	}
	
	public boolean arMailIrasytas (String mail) {
		if(arIrasytaArgumentoReiksme(mail)){
			return true;
		} return false;
	}
	
	public boolean arPareigosPasirinktos (String pareigos) {
		if(arIrasytaArgumentoReiksme(pareigos)){
			return true;
		} return false;
	}
	
	public boolean arSlaptazodisSutampa (String pasw, String paswConf) {
		if (pasw.isEmpty() || (pasw.length() > PASSWORD_MAX_SIMBOLIU && (!(pasw.equals(paswConf))))) {
			return false;
		}
		return true;
	}
	
	public boolean arSkyriusPasirinktas (String skyrius) {
		if(arIrasytaArgumentoReiksme(skyrius)){
			return true;
		} return false;
	}
	
	public boolean arSurnameIrasyta (String surname) {
		if(arIrasytaArgumentoReiksme(surname)){
			return true;
		} return false;
	}
	
	public boolean arUserNameIrasyta (String userName) {
		if(arIrasytaArgumentoReiksme(userName)){
			return true;
		} return false;
	}
	
	public boolean arVaidmuoPasirinktas (String vaidmuo) {
		if(arIrasytaArgumentoReiksme(vaidmuo)){
			return true;
		} return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
