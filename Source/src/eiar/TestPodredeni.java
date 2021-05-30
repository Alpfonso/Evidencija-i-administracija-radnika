package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestPodredeni {

	@Test
	public void test() {
		
		Date date = new Date(1,2,2002);//datum rodjena
		Date rvp = new Date(2,3,2004);//pocetak radnog vremena
		Date rvk = new Date(5,7,2003);//kraj radnog vremena
		Podredeni p1 = new Podredeni("Ivan","Ivanec",date,"Varazdin","Varazdinska ulica","IvanIvanec@gmail.com",54678321,"0981237894","Riteh","Radnik",rvp,rvk,3);
	
		
		
		Date date1 = new Date(1,2,2007);//datum rodjena
		Date rvp1 = new Date(1,2,2008); //radno vrijeme poèetak
		Date rvk1 = new Date(1,2,2009); //radno vrijeme kraj
		Nadredeni n1 = new Nadredeni("Luka","Lukic",date1,"Rijeka","Rijecka ulica","LukaLukic@gmail.com",12345678,"0980981234","Riteh","Nadreden",rvp1,rvk1,2);
		
		Date datum_pocetak = new Date(1,2,2010);
		Date datum_kraj = new Date(1,2,2011);

		Projekt pro1 = new Projekt("Marko",n1,datum_pocetak,datum_kraj);
		
		
		Zadaci z1 = new Zadaci(p1,pro1,"zadatak");
		p1.napisi_izvjesce("izvjesceee",z1);
		assertEquals("izvjesceee",p1.pregledaj_izvjesce("izvjesceee",z1));

		p1.zavrsi_zadatak(z1);
		
		assertEquals(null,p1.provjera_zadataka());
		
	}

}
