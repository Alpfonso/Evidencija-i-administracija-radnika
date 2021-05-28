package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestFinancijski_sektor {

	@Test
	public void test() {
		Date date = new Date(1,2,2002);//datum rodjena
		Date rvp = new Date(2,3,2004);//pocetak radnog vremena
		Date rvk = new Date(5,7,2003);//kraj radnog vremena
		Financijski_sektor fs = new Financijski_sektor("Mateo","Mateov",date,"Zagreb","Zagrebacka ulica","MateoMateov@gmail.com",87654321,"0911237894","Riteh","Radnik",rvp,rvk,3);
		
		Date datef = new Date(1,2,2012);
		Financijska_izvjesca f1 = new Financijska_izvjesca("project #1 chat room","opis","Ime Autora",1000,800,datef,"format");

		String s = "naziv: " + "project #1 chat room" + "\r\nopis: " + "opis" + "\r\nime autora: " + "Ime Autora" + "\r\nprihodi: " + "1000.0" + "\r\nrashodi: " + "800.0" + "\r\ndatum: " + datef.toString();  

		assertEquals(s,fs.Dohvati_izvjesce(f1));
		
	}
	

	

}
