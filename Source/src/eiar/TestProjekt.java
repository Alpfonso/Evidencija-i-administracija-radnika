package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;


public class TestProjekt {

	@Test
	public void test() {
		Date date = new Date(1,2,2007);//datum rodjena
		Date rvp = new Date(1,2,2008); //radno vrijeme poèetak
		Date rvk = new Date(1,2,2009); //radno vrijeme kraj
		Nadredeni n1 = new Nadredeni("Luka","Lukic",date,"Rijeka","Rijecka ulica","LukaLukic@gmail.com",12345678,"0980981234","Riteh","Nadreden",rvp,rvk,2);
		
		Date datum_pocetak = new Date(1,2,2010);
		Date datum_kraj = new Date(1,2,2011);

		Projekt p1 = new Projekt("Marko",n1,datum_pocetak,datum_kraj);
		
		assertTrue(p1.status());
  		assertTrue(p1.zatvori_projekt());
		assertFalse(p1.status());
		
		assertEquals(n1,p1.provjeri_nadleznog());
		
		p1.setIzvjesce("izvjesce");
		assertEquals("izvjesce",p1.getIzvjesce());
		
	}

}

