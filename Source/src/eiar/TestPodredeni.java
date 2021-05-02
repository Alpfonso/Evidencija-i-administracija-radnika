package eiar;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestPodredeni {

	@Test
	public void test() {
		Date date = new Date();
		Date rvp = new Date();
		Date rvk = new Date();
		Podredeni p1 = new Podredeni("Ivan","Ivanec",date,"Varazdin","Varazdinska ulica","IvanIvanec@gmail.com",54678321,"0981237894","Riteh","Radnik",rvp,rvk,2);
	
		Zadaci z1 = new Zadaci();
		p1.napisi_izvjesce("izvjesce",);
		assertEquals(,p1.pregledaj_izvjesce());
	}

}
