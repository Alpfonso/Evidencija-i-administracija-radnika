package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestHR {

	@Test
	public void test() {
		
		Date date = new Date(1,2,2002);//datum rodjena
		Date rvp = new Date(2,3,2003);//pocetak radnog vremena
		Date rvk = new Date(5,7,2004);//kraj radnog vremena
		HR hr = new HR("Mateo","Mateov",date,"Zagreb","Zagrebacka ulica","MateoMateov@gmail.com",87654321,"0911237894","Riteh","Administrator",rvp,rvk,3);
		
		Ankete anketa = hr.Napravi_anketu("naziv", "opis", "Ime Autora", "sugestija");
		assertEquals("naziv",hr.Dohvati_anketu(anketa));

		
	}

}
