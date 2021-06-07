package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestAdministracija {

	@Test
	public void test() {
		Date dateA = new Date(1,2,2002);//datum rodjena
		Date rvpA = new Date(2,3,2003);//pocetak radnog vremena
		Date rvkA = new Date(5,7,2004);//kraj radnog vremena
		Administracija a1 = new Administracija("Mateo","Mateov",dateA,"Zagreb","Zagrebacka ulica","MateoMateov@gmail.com",87654321,"0911237894","Riteh","Administrator",rvpA,rvkA,3);
		
		Date date = new Date(1,2,2001);//datum rodjena
		Date rvp = new Date(2,3,2003);//pocetak radnog vremena
		Date rvk = new Date(5,7,2004);//kraj radnog vremena
		Radnik r1 = new Radnik("Luka","Lukas",date,"Rijeka","Rijecka ulica","LukaLukas@gmail.com",12378945,"0951237894","Riteh","Radnik",rvp,rvk,2);
	
		a1.Postavi_nadredenog (r1, "Administrator");
		a1.Dohvati_anketu(123);
		
		Date dateF = new Date(1,2,2012);
		Financijska_izvjesca f1 = new Financijska_izvjesca("project #1 chat room","opis","Ime Autora",1000,800,dateF,"format");
		
		assertEquals(null,a1.Dohvati_izvjesce(f1,"format"));
		
	}

}
