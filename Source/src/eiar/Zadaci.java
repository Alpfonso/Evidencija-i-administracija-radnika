package eiar;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Tasks class
 */
public class Zadaci{
	private int id;
	private String ime = new String();
	private int zadano_radniku;
	private int projekt;
	private boolean status;
	private String izvjesce;
	/**
	 * Main constructor sets worker, parent project and name
	 * @param radnik assigned worker name
	 * @param projekt project name who's child is the constructed task
	 * @param ime task name
	 */
	public Zadaci(int radnik, int projekt, String ime) throws SQLException{
		this.zadano_radniku = radnik;
		this.projekt = projekt;
		this.ime = ime;
		this.status = false;
		this.addToDB();

		//TODO add data to database and get auto increment id
	}
	public Zadaci(int projekt) throws SQLException{//constructor that only assigns this task to the given project
		this.projekt = projekt;
		this.addToDB();
}
	public Zadaci(int projekt, String opis) throws SQLException{//constructor that assigns this task to the project and gives it a description
		this.projekt = projekt;
		this.ime = opis;
		this.addToDB();
	}
	
	public Zadaci(int id, boolean a) throws SQLException{
		DB_Connect db_object = new DB_Connect();
		ResultSet rs = db_object.Fetch_table_data("zadaci", id, "id");
		this.ime = rs.getString("ime");
		this.zadano_radniku = rs.getInt("zadano_zaposleniku");
		this.projekt = rs.getInt("projekt");
		this.status = rs.getBoolean("status");
	}
	
	private void addToDB() throws SQLException{
		DB_Connect db_object = new DB_Connect();
		String[] attributes = {"ime", "zadano_zaposleniku", "projekt", "opis", "status"};
		Object[] data = {this.ime, this.zadano_radniku, this.projekt, this.izvjesce, this.status};
		db_object.Insert_table_data(attributes, data, "zadaci");
	}
	
	public void Dodaj_radnika(int radnik) {
		this.zadano_radniku = radnik;
		this.updateDB(0);
	}
	
	public void Dodaj_opis(String opis) {
		this.ime = opis;
		this.updateDB(1);
	}
	public boolean Pregled_statusa() {
		
		return status;
		
	}
	public void Zavrsi() {
		this.status = false;
		this.updateDB(2);
	}
	
	private void updateDB(int mode) {
		DB_Connect db_object = new DB_Connect();
		String[] attributes = new String[5];
		Object[] data = new String[5];
		switch(mode) {
			case 0:
				attributes[0] = "ime";
				data[0] = this.ime;
				db_object.Update_table_data(attributes, data, "zadaci", this.id);
			case 1:
				attributes[0] = "opis";
				data[0] = this.izvjesce;
				db_object.Update_table_data(attributes, data, "zadaci", this.id);
			case 2:
				attributes[0] = "Status";
				data[0] = this.status;
				db_object.Update_table_data(attributes, data, "zadaci", this.id);
		}
	}

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getZadano_radniku() {
		return zadano_radniku;
	}
	public void setZadano_radniku(int zadano_radniku) {
		this.zadano_radniku = zadano_radniku;
	}
	public int getProjekt() {
		return projekt;
	}
	public void setProjekt(int projekt) {
		this.projekt = projekt;
	}
	public String getIzvjesce() {
		return izvjesce;
	}
	public void setIzvjesce(String izvjesce) {
		this.izvjesce = izvjesce;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
