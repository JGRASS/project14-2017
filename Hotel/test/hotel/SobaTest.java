package hotel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SobaTest {
	Soba s;

	@Before
	public void setUp() throws Exception {
		s = new Soba();
	}

	@After
	public void tearDown() throws Exception {
		s = null;
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
	
}
