package eiar;
/**
 * Survey tool<br>
 * Used by HR to conduct employee surveys
 */
public class Ankete extends Alati {
	
	private String sugestija;
	/**
	 * 
	 * @param naziv survey name
	 * @param opis description
	 * @param ime_autora creator name
	 * @param sugestija suggestions written by surveyed employees
	 */
	public Ankete(String naziv, String opis, String ime_autora, String sugestija) {
		super(naziv, opis, ime_autora);
		this.sugestija = sugestija;
	}

	public void Promjeni_naziv(String novi_naziv) {
		//Method used to change poll name
		this.setNaziv(novi_naziv);
	}
	
	public void Promjeni_opis(String novi_opis) {
		//Method used to change poll description
		this.setOpis(novi_opis);
	}
	
	public void getAnketa () {
		
		
		
	}
}
