package eiar;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Date;

public class TestProjekt {

	@Test
	public void test() {
		Date date = new Date();
		Date rvp = new Date(); //radno vrijeme po�etak
		Date rvk = new Date(); //radno vrijeme kraj
		Nadredeni n1 = new Nadredeni("Luka","Lukic",date,"Rijeka","Rijecka ulica","LukaLukic@gmail.com",12345678,"0980981234","Riteh","Nadreden",rvp,rvk,2);
		
		Date datum_pocetak = new Date();
		Date datum_kraj = new Date();

		Projekt p1 = new Projekt("Marko",n1,datum_pocetak,datum_kraj);
		
		
	}

}
