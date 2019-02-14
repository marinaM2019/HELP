package lt.help.desk.bd.beans;

public class LoginUserAtribute {

	private String name;
	private String surname;
	private String skyrius;
	private String pareigos;

	public LoginUserAtribute(String name, String surname, String skyrius, String pareigos) {
		super();
		this.name = name;
		this.surname = surname;
		this.skyrius = skyrius;
		this.pareigos = pareigos;
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

	public String getSkyrius() {
		return skyrius;
	}

	public void setSkyrius(String skyrius) {
		this.skyrius = skyrius;
	}

	public String getPareigos() {
		return pareigos;
	}

	public void setPareigos(String pareigos) {
		this.pareigos = pareigos;
	}

}
