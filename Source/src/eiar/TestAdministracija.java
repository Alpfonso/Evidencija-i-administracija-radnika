package eiar;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

public class TestAdministracija {

	@Test
	public void test() {
		Date date = new Date(1,2,2002);//datum rodjena
		Date rvp = new Date(2,3,2004);//pocetak radnog vremena
		Date rvk = new Date(5,7,2003);//kraj radnog vremena
		//Administracija a1 = new Radnik("Mateo","Mateov",date,"Zagreb","Zagrebacka ulica","MateoMateov@gmail.com",87654321,"0911237894","Riteh","Radnik",rvp,rvk,3);
	}

}
