package lt.help.desk.bd.beans;

public class Skyrius {
	private String id;
	private String pavadinimas;

	public String getId() {
		return id;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public Skyrius(String id, String pavadinimas) {
		this.id = id;
		this.pavadinimas = pavadinimas;
	}

}
