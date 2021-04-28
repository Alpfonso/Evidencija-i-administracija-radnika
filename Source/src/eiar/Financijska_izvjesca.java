package eiar;

import java.util.Date;

public class Financijska_izvjesca extends Alati {

	private double prihodi;
	private double rashodi;
	private Date vremenski_period_izvjesca;
	private String format;
	
	public Financijska_izvjesca(String naziv, String opis, String ime_autora, double prihodi, double rashodi, Date vremenski_period_izvjesca, String format) {
		super(naziv, opis, ime_autora);
		this.prihodi = prihodi;
		this.rashodi = rashodi;
		this.vremenski_period_izvjesca = vremenski_period_izvjesca;
		this.format = format;
	}
	

	public void Promjeni_naziv(String novi_naziv_izvjesca) {
		this.setNaziv(novi_naziv_izvjesca);
	}
	
	public void Promjeni_opis(String novi_opis_izvjesca) {
		this.setOpis(novi_opis_izvjesca);
	}
}
