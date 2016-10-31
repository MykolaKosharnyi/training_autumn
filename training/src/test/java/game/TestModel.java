package game;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TestModel.java
 *
 * @author Mykola Kosharny 30 Oct 2016
 * @version 1.0
 */
public class TestModel{
	/**
     * Object that we need to test
     */
	private Model model;
	
	/**
     * Creating model object
     */
	@Before
	public void createModel(){
		model = new Model();
	}
	
	/**
	 * Test creating numbers in range by default
	 * */
	@Test
	public void testCreateRangeDefault(){
		int result = model.rand();
		Assert.assertTrue(model.getMin()< result && result<=model.getMax());
	}
	
	/**
	 * Test creating numbers in range
	 * */
	@Test
	public void testCreateRange(){
		int min = 5;
		int max = 75;
		int result = model.rand(min, max);
		Assert.assertTrue(min< result && result<=max);
	}
	
	/**
	 * Test throw OutOfRangeException
	 * */
	@Test
	public void testCheckNumberThowOutOfRangeException() {
		model.setMin(45);
		model.setMax(70);
		
		try {
			model.checkNumber(30, 50);
			Assert.fail("OutOfRangeException not thrown.");
		} catch (OutOfRangeException e) {
			Assert.assertTrue(true);
		} catch (WinnerException e) {}

	}
	
	/**
	 * Test throw WinnerException
	 * @throws WinnerException 
	 * @throws OutOfRangeException 
	 * */
	@Test(expected=WinnerException.class)
	public void testCheckNumberWinnerException() throws OutOfRangeException, WinnerException {
		model.setMin(45);
		model.setMax(70);

		model.checkNumber(50, 50);
	}
	
	/**
	 * Test if user entered smaller number that we need to guess
	 * */
	@Test
	public void testCheckNumberIfWeInputSmolerNumber(){
		model.setMin(30);
		model.setMax(90);
		
		try {
			Assert.assertFalse(model.checkNumber(45, 50));
		} catch (OutOfRangeException | WinnerException e) {}
	}
	
	/**
	 * Test if user entered bigger number that we need to guess
	 * */
	@Test
	public void testCheckNumberIfWeInputBiggerNumber(){
		model.setMin(30);
		model.setMax(90);
		
		try {
			Assert.assertTrue(model.checkNumber(60, 50));
		} catch (OutOfRangeException | WinnerException e) {}
	}
}
