package eiar;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnkete {

	@Test
	public void test() {
		Ankete a1 = new Ankete("naziv","opis","ime autora","sugestija");
		
		assertEquals("naziv",a1.getNaziv());
		a1.promjeni_naziv("naziv2");
		assertEquals("naziv2",a1.getNaziv());
		
		assertEquals("opis",a1.getOpis());
		a1.promjeni_opis("opis2");
		assertEquals("opis2",a1.getOpis());
	}

}
