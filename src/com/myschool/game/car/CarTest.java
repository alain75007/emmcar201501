package com.myschool.game.car;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
		

public class CarTest {
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
	public void test() {
		Car car = new Car();
		assertNotNull(car);
		assertEquals(1, Car.getCarCount());
	}
	
	@Test
	public void testInitialize() {
		Car car = new Car("Alain", "rouge", 12);
		assertEquals("power should be 12", 12, car.getPower());
		assertEquals("Alain", car.getOwner());
		assertEquals("rouge", car.getColor());
		assertFalse("Ne doit pas  être décapotable ", car.isConvertible());
	}
	
	@Test
	public void testInitializeConvertible() {
		Car car = new Car("Alain", "rouge", 12, true);
		assertEquals("power should be 12", 12, car.getPower());
		assertEquals("Alain", car.getOwner());
		assertEquals("rouge", car.getColor());
		assertTrue("Doit être décapotable ", car.isConvertible());
	}
	
	@Test
	public void testVroomVroom() {
		Car car = new Car("Alain", "rouge", 12);
		boolean result = car.vroomvroom();
		assertFalse("should not do vroomvroom if not started", result);
		
		outContent.reset();
		result = car.start();
		assertEquals("La voiture de Alain démarre!\n", outContent.toString()); 
		
		outContent.reset();
		result = car.vroomvroom();
		assertEquals("La voiture de Alain fait: Vroom Vroom!!!\n", outContent.toString());
	}
}
