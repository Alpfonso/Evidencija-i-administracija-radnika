package eiar;

public class Ankete extends Alati {
	
	private String sugestija;
	
	public Ankete(String naziv, String opis, String ime_autora, String sugestija) {
		super(naziv, opis, ime_autora);
		this.sugestija = sugestija;
	}

	public void Promjeni_naziv(String novi_naziv) {
		this.setNaziv(novi_naziv);
	}
	
	public void Promjeni_opis(String novi_opis) {
		this.setOpis(novi_opis);
	}
}
