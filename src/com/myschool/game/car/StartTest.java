package com.myschool.game.car;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StartTest {
	
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
	public void testStartMain() {
		//Start start = new Start();
		String[] args = new String[0];
		Start.main(args);
		assertEquals("Car Game lancé\nLa voiture de Maëlis démarre!\nLa voiture de Maëlis fait: Vroom Vroom!!!\n", outContent.toString());

	}

}
