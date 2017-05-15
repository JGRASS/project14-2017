package hotel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SobaPodaciTest {
	SobaPodaci s;
	@Before
	public void setUp() throws Exception {
		s=new SobaPodaci();
	}

	@After
	public void tearDown() throws Exception {
		s=null;
	}
	@Test
	public void testTestIdSobe() {
		s.setIdSobe(123);
		assertEquals(123, s.getIdSobe());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testTestIdSobeNeg() {
		s.setIdSobe(-123);
	}
	
	
	@Test
	public void testTestsetBrojKreveta() {
		s.setBrojKreveta(123);
		assertEquals(123, s.getBrojKreveta());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testTestsetBrojKrevetaNeg() {
		s.setBrojKreveta(-123);
	}

	@Test
	public void testTestsetCena() {
		s.setCena(123);
		assertEquals(123, s.getCena());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testTestsetCenaNeg() {
		s.setCena(-123);
	}
	
	@Test
	public void testTestsetSprat() {
		s.setSprat(123);
		assertEquals(123, s.getSprat());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testTestsetSpratNeg() {
		s.setSprat(-123);
	}
	
	@Test
	public void setTerasa(){
		s.setTerasa(true);
		assertEquals(true,s.isTerasa());
	}
	
	@Test
	public void testSetIdRezervacije() {
		s.setIdRezervacije(3);
		assertEquals(3, s.getIdRezervacije());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetIdRezervacijeF() {
		s.setIdRezervacije(-4);
	}
	
	@Test
	public void testSetIdSobe(){
		s.setIdSobe(4);
		assertEquals(4, s.getIdSobe());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetIdSobeF() {
		s.setIdSobe(-4);
	}
	
	@Test
	public void testSetImeGosta() {
		s.setImeGosta("Mika");
		assertEquals("Mika", s.getImeGosta());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeGostaPrazan() {
		s.setImeGosta("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetImeGostaNull() {
		s.setImeGosta(null);
	}
	
	@Test
	public void testSetPrezimeGosta() {
		s.setPrezimeGosta("Mika");
		assertEquals("Mika", s.getPrezimeGosta());
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeGostaPrazan() {
		s.setPrezimeGosta("");
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPrezimeGostaNull() {
		s.setPrezimeGosta(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumOd(){
		s.setDatumOd(null);
	}
	
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetDatumDo(){
		s.setDatumDo(null);
	}

}
