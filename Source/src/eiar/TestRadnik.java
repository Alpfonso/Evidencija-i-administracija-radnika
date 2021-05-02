package eiar;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class TestRadnik {

	@Test
	public void test() {
		Date date = new Date();
		Date rvp = new Date();
		Date rvk = new Date();
		Radnik r1 = new Radnik("Mateo","Mateov",date,"Zagreb","Zagrebacka ulica","MateoMateov@gmail.com",87654321,"0911237894","Riteh","Radnik",rvp,rvk,3);
		assertEquals(87654321,r1.getId);
	}

}
