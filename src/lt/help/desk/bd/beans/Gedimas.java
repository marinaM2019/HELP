package lt.help.desk.bd.beans;

public class Gedimas {
	private String data;
	private String tema;
	private String aprasymas;
	private String statusas;
	private String vykdytojas;
	private String vykdytojoIrasoKeitimoData;

	public Gedimas(String data, String tema, String aprasymas, String statusas, String vykdytojas,
			String vykdytojoIrasoKeitimoData) {

		this.data = data;
		this.tema = tema;
		this.aprasymas = aprasymas;
		this.statusas = statusas;
		this.vykdytojas = vykdytojas;
		this.vykdytojoIrasoKeitimoData = vykdytojoIrasoKeitimoData;

	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getAprasymas() {
		return aprasymas;
	}

	public void setAprasymas(String aprasymas) {
		this.aprasymas = aprasymas;
	}

	public String getStatusas() {
		return statusas;
	}

	public void setStatusas(String statusas) {
		this.statusas = statusas;
	}

	public String getVykdytojas() {
		return vykdytojas;
	}

	public void setVykdytojas(String vykdytojas) {
		this.vykdytojas = vykdytojas;
	}

	public String getVykdytojoIrasoKeitimoData() {
		return vykdytojoIrasoKeitimoData;
	}

	public void setVykdytojoIrasoKeitimoData(String vykdytojoIrasoKeitimoData) {
		this.vykdytojoIrasoKeitimoData = vykdytojoIrasoKeitimoData;
	}

}
