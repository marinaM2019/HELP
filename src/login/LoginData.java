package login;

import java.io.BufferedReader;
import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.List;

import mySql.connection.MySqlConnect;



public class LoginData {
	
    private String line = "";
    private String cvsSplitBy = ";";
    private String[] reiksme;
    private BufferedReader br = null;
	private String csvFile = "/Users/HelpDesc/Users.csv";
    

	MySqlConnect connectToDb = new MySqlConnect();
	
	public boolean getSuperAdminLogin(String loginName, String loginPassword) {
    try {
        br = new BufferedReader(new FileReader (csvFile));
        while ((line = br.readLine()) != null) { 
        	
        	reiksme = line.split(cvsSplitBy);
    		  if (reiksme[0].equals(loginName) && reiksme[1].equals(loginPassword)) {
    			  return true;
    		  }
    		  }
	} catch (Exception e) {
		System.out.println("Klaida: "+e);
	}
	return false;
	}
	
	
	public boolean getLoginFromDB(String loginName, String password) {
	    try {
	    	if (connectToDb.getConnection() != null){
				return true;
			}
		} catch (Exception e) {
			System.out.println("Klaida: "+e);
		}
		return false;
		}
	
//	public List<String> getUserPapildomosInformacijosSarasa(){
//		List <String> userPapildomosInformacijosSarasas = new ArrayList<>();
//		if (reiksme.length==6) {
//		userPapildomosInformacijosSarasas.add(convertToUTF8(reiksme[2]));
//		userPapildomosInformacijosSarasas.add(convertToUTF8(reiksme[3]));
//		userPapildomosInformacijosSarasas.add(convertToUTF8(reiksme[4]));
//		userPapildomosInformacijosSarasas.add(convertToUTF8(reiksme[5]));
//		} else {
//			userPapildomosInformacijosSarasas.add("");
//			userPapildomosInformacijosSarasas.add("");
//			userPapildomosInformacijosSarasas.add("");
//			userPapildomosInformacijosSarasas.add("");
//			System.out.println(reiksme.length);
//		}
//		return userPapildomosInformacijosSarasas;
//	}
	
	
    
    public static String convertToUTF8(String r) {
        String out = null;
        try {
            out = new String(r.getBytes("UTF-8"));
        } catch (java.io.UnsupportedEncodingException e) {
            return null;
        }
        return out;
    }
	

}
