package eiar;

/** Superclass for all future tools
 */
public class Alati {

	private String naziv;
	private String opis;
	private String ime_autora;
	/**
	 * Tool constructor
	 * @param naziv name for a tool instance (ex. "project #1 chat room")
	 * @param opis description
	 * @param ime_autora object creator
	 */
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

	public String getIme_autora() {
		return ime_autora;
	}

	public void setIme_autora(String ime_autora) {
		this.ime_autora = ime_autora;
	}
	
	
	
	
}
