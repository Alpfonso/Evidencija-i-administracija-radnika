package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestFinancijska_izvjesca {

	@Test
	public void test() {
		Date date = new Date(1,2,2012);
		Financijska_izvjesca f1 = new Financijska_izvjesca("project #1 chat room","opis","Ime Autora",1000,800,date,"format");
		
		assertEquals("project #1 chat room",f1.getNaziv());
		f1.Promjeni_naziv("project #2 chat room");
		assertEquals("project #2 chat room",f1.getNaziv());
		
		
		assertEquals("opis",f1.getOpis());
		f1.Promjeni_opis("opis2");
		assertEquals("opis2",f1.getOpis());
		
	}

}
