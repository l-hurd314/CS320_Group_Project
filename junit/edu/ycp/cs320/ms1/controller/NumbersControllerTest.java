package edu.ycp.cs320.ms1.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.ms1.controller.NumbersController;
import edu.ycp.cs320.ms1.model.Numbers;

public class NumbersControllerTest {
	private Numbers model;
	private NumbersController controller;
	
	@Before
	public void setUp() {
		model = new Numbers();
		controller = new NumbersController();
	}
	
	@Test
	public void getResultAdd123() {
		model.setValue1(1.0);
		model.setValue2(2.0);
		model.setValue3(3.0);
		model.setResult(controller.add(model.getValue1(), model.getValue2(), model.getValue3()));
		assertTrue(model.getResult() == 6.0);
	}
	
	@Test
	public void getResultAdd731() {
		model.setValue1(7.0);
		model.setValue2(3.0);
		model.setValue3(1.0);
		model.setResult(controller.add(model.getValue1(), model.getValue2(), model.getValue3()));
		assertTrue(model.getResult() == 11.0);
	}
	
	@Test
	public void getResultAdd472() {
		model.setValue1(4.0);
		model.setValue2(7.0);
		model.setValue3(2.0);
		model.setResult(controller.add(model.getValue1(), model.getValue2(), model.getValue3()));
		assertTrue(model.getResult() == 13.0);
	}
	
	@Test
	public void getResultMult23() {
		model.setValue1(2.0);
		model.setValue2(3.0);
		model.setResult(controller.mult(model.getValue1(), model.getValue2()));
		assertTrue(model.getResult() == 6.0);
	}
	
	@Test
	public void getResultMult510() {
		model.setValue1(5.0);
		model.setValue2(10.0);
		model.setResult(controller.mult(model.getValue1(), model.getValue2()));
		assertTrue(model.getResult() == 50.0);
	}
	
	@Test
	public void getResultMult92() {
		model.setValue1(9.0);
		model.setValue2(2.0);
		model.setResult(controller.mult(model.getValue1(), model.getValue2()));
		assertTrue(model.getResult() == 18.0);
	}
}
