package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestNadredeni {

	@Test
	public void test() {
		Date date = new Date(1,2,2002);//datum rodjena
		Date rvp = new Date(2,3,2004);//pocetak radnog vremena
		Date rvk = new Date(5,7,2003);//kraj radnog vremena
		Nadredeni n1 = new Nadredeni("Mateo","Mateov",date,"Zagreb","Zagrebacka ulica","MateoMateov@gmail.com",87654321,"0911237894","Riteh","nadredeni",rvp,rvk,3);
		
		Date datum_pocetak = new Date(1,2,2010);
		Date datum_kraj = new Date(1,2,2011);

		Projekt pro1 = new Projekt("Marko",n1,datum_pocetak,datum_kraj);
		
		n1.napisi_izvjesce("neko izvjesce",pro1);
		assertEquals("neko izvjesce",n1.izvjesce(pro1));
		
	}

}
