package eiar;

public class Alati {

	private String naziv;
	private String opis;
	private String ime_autora;
	
	public Alati (String naziv, String opis, String ime_autora) {
		this.naziv = naziv;
		this.opis = opis;
		this.ime_autora = ime_autora;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
	
}
