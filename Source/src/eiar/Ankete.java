package eiar;

public class Ankete extends Alati {
	private String nazivAnkete;
	private String opisAnkete;
	private String sugestija;
	
	public Ankete(String naziv, String opis ) {
		this.nazivAnkete = naziv;
		this.opisAnkete = opis;
		// TODO Auto-generated constructor stub
	}
	
	public void Promjeni_naziv(String novi_naziv) {
		this.nazivAnkete = novi_naziv;
	}
	
	public void Promjeni_opis(String novi_opis) {
		this.opisAnkete = novi_opis;
	}
}
