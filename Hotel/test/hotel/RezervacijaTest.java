package hotel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RezervacijaTest {
	Rezervacija r;
	
	@Before
	public void setUp() throws Exception {
		r=new Rezervacija();
	}

	@After
	public void tearDown() throws Exception {
		r=null;
	}

	@Test
	public void testSetIdRezervacije() {
		r.setIdRezervacije(3);
		assertEquals(3, r.getIdRezervacije());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetIdRezervacijeF() {
		r.setIdRezervacije(-4);
	}
	
	@Test
	public void testSetIdSobe(){
		r.setIdSobe(4);
		assertEquals(4, r.getIdSobe());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetIdSobeF() {
		r.setIdSobe(-4);
	}
	
	@Test
	public void testSetImeGosta() {
		r.setImeGosta("Mika");
		assertEquals("Mika", r.getImeGosta());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeGostaPrazan() {
		r.setImeGosta("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeGostaNull() {
		r.setImeGosta(null);
	}
	
	@Test
	public void testSetPrezimeGosta() {
		r.setPrezimeGosta("Mika");
		assertEquals("Mika", r.getPrezimeGosta());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeGostaPrazan() {
		r.setPrezimeGosta("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeGostaNull() {
		r.setPrezimeGosta(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumOd(){
		r.setDatumOd(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumDo(){
		r.setDatumDo(null);
	}
	
	
	
}
