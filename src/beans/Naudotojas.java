package beans;

public class Naudotojas {

	private String id;
	private String loginName;
	private String name;
	private String surname;
	private String email;
	private String skyriausPavadinimas;
	private String pareigos;
	private String vaidmuo;
	

	public Naudotojas(String id, String loginName, String name, String surname, String email,
			String skyriausPavadinimas, String pareigos, String vaidmuo) {
		this.id=id;
		this.loginName=loginName;
		this.name=name;
		this.surname=surname;
		this.email=email;
		this.skyriausPavadinimas=skyriausPavadinimas;
		this.pareigos=pareigos;
		this.vaidmuo=vaidmuo;
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSkyriausPavadinimas() {
		return skyriausPavadinimas;
	}


	public void setSkyriausPavadinimas(String skyriausPavadinimas) {
		this.skyriausPavadinimas = skyriausPavadinimas;
	}


	public String getPareigos() {
		return pareigos;
	}


	public void setPareigos(String pareigos) {
		this.pareigos = pareigos;
	}


	public String getVaidmuo() {
		return vaidmuo;
	}


	public void setVaidmuo(String vaidmuo) {
		this.vaidmuo = vaidmuo;
	}
	
	
	

	
	
	
	
}
