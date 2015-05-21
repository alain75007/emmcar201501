package com.myschool.game.car;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BatmanCarTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	public void testStart() {
		BatmanCar car = new BatmanCar();
		car.start();
		String[] lines = outContent.toString().split("\n");
		assertEquals("La voiture de " + car.getOwner() + " fait: Vroom Vroom!!!", lines[lines.length -1 ]);

		outContent.reset();
		car.initialize("Alain", 14);
		assertEquals("La voiture de Batman doit toujours être noire", "black", car.getColor());
	}
	
	@Test
	public void testSetFlying() {
		BatmanCar car = new BatmanCar();
		boolean result = car.setFlying(true);
		assertFalse(car.isFlying());
		assertFalse("Pour voler la voiture doit être démarrée", result);
		
		car.start();
		outContent.reset();
		result = car.setFlying(true);
		assertTrue(car.isFlying());
		assertTrue("La voiture doit pouvoir voler quand elle est démarrée", result);

		assertEquals("Les ailes de la voiture de " + car.getOwner() + " se déploient, la voiture vole…\n", outContent.toString());

		outContent.reset();
		car.stop();
		String[] lines = outContent.toString().split("\n");
		assertEquals("La voiture de " + car.getOwner() + " tombe!!!!", lines[1]);

		outContent.reset();
		car.start();
		car.setFlying(false);
		lines = outContent.toString().split("\n");
		assertEquals("Les ailes de la voiture de " + car.getOwner() + " se rétractent, la voiture atterrie…", lines[1]);

	}

}
