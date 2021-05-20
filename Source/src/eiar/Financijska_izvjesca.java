package eiar;

import java.util.Date;
/**
 * Tool used to generate financial reports
 * 
 * <br><b>Note:</b> WIP
 */
public class Financijska_izvjesca extends Alati {

	private double prihodi;
	private double rashodi;
	private Date vremenski_period_izvjesca;
	private String format;
	/**
	 * 
	 * @param naziv document name
	 * @param opis document description
	 * @param ime_autora creators username
	 * @param prihodi income
	 * @param rashodi expenses
	 * @param vremenski_period_izvjesca period from which we wish to generate a report
	 * @param format WIP - most likely options between .xlsx and .pdf
	 */
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


	public String getIzvjesce() {
		// TODO Auto-generated method stub
		return null;
	}


	public String toString () {
		
		return "naziv: " + this.getNaziv() + "\r\nopis: " + this.getOpis() + "\r\nime autora: " + this.getIme_autora() + "\r\nprihodi: " + this.prihodi + "\r\nrashodi: " + this.rashodi + "\r\ndatum: " + this.vremenski_period_izvjesca.toString();  
	}
	
}
