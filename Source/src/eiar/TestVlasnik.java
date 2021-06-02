package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestVlasnik {

	@Test
	public void test() {
		Date date = new Date(1,2,2002);//datum rodjena
		Date rvp = new Date(2,3,2004);//pocetak radnog vremena
		Date rvk = new Date(5,7,2003);//kraj radnog vremena
		Vlasnik v1 = new Vlasnik("Mateo","Mateov",date,"Zagreb","Zagrebacka ulica","MateoMateov@gmail.com",87654321,"0911237894","Riteh","Radnik",rvp,rvk,3);
	
		Date daten = new Date(1,2,2007);//datum rodjena
		Date rvpn = new Date(1,2,2008); //radno vrijeme poèetak
		Date rvkn = new Date(1,2,2009); //radno vrijeme kraj
		Nadredeni n1 = new Nadredeni("Luka","Lukic",daten,"Rijeka","Rijecka ulica","LukaLukic@gmail.com",12345678,"0980981234","Riteh","Nadreden",rvpn,rvkn,2);
		
		Date datum_pocetak = new Date(1,2,2010);
		Date datum_kraj = new Date(1,2,2011);

		Projekt p1 = new Projekt("Marko",n1,datum_pocetak,datum_kraj);
		
		assertEquals("Empty",v1.Dohvati_izvjesce(p1));
		
		
		Date datef = new Date(1,2,2012);
		Financijska_izvjesca f1 = new Financijska_izvjesca("project #1 chat room","opis","Ime Autora",1000,800,datef,"format");
		
		String s = "naziv: " + "project #1 chat room" + "\r\nopis: " + "opis" + "\r\nime autora: " + "Ime Autora" + "\r\nprihodi: " + "1000.0" + "\r\nrashodi: " + "800.0" + "\r\ndatum: " + datef.toString();  

		
		assertEquals(s,v1.Dohvati_financijsko_izvjesce(f1));

		Ankete a1 = new Ankete("naziv","opis","ime autora","sugestija");
		
		assertEquals("naziv",v1.Dohvati_anketu(a1));
		
		

		
	}

}
