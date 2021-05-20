package eiar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Worker superclass
 * @author lukas
 *
 */
public class Radnik {

	private int id;
	private String ime;
	private String prezime;
	private Date datum_rodenja;
	private String grad_stanovanja;
	private String ulica_stanovanja;
	private String email_adresa;
	private int OIB;
	private String telefon;
	private String obrazovanje;
	private String razina_ovlasti;
	private Date radno_vrijeme_pocetak;
	private Date radno_vrijeme_kraj;
	private int slobodni_dani;
	
	public Radnik (String ime, String prez, Date dat, String g_s, String u_s, String email, int OIB, String tele, String obrazovanje, String razina_ovlasti, Date r_v_p, Date r_v_k, int s_d) {
		//TO-DO get id_radnika from db
		this.ime = ime;
		this.prezime = prez;
		this.datum_rodenja = dat;
		this.grad_stanovanja = g_s;
		this.ulica_stanovanja = u_s;
		this.email_adresa = email;
		this.OIB = OIB;
		this.telefon = tele;
		this.obrazovanje = obrazovanje;
		this.razina_ovlasti = razina_ovlasti;
		this.radno_vrijeme_pocetak = r_v_p;
		this.radno_vrijeme_kraj = r_v_k;
		this.slobodni_dani = s_d;
		}
	/**
	 * @return returns worker id
	 */
	public int getId() {
		return id;
	}
	
	
	public ResultSet Dohvati_anketu() throws SQLException {
		
		DB_Connect db_object = new DB_Connect();
		ResultSet rs = db_object.Fetch_table_data("ankete");//rs variable saves the whole line that the sql querry returns, and needs to parse in in the method below
		
		return rs;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
}
