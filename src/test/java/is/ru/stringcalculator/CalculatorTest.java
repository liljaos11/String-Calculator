package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testTenNumbers() {
		assertEquals(47, Calculator.add("6,1,2,5,8,7,9,3,1,5"));
	}

	@Test
	public void testNewLineDelimiter() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testMultipleNewLineDelimiter() {
		assertEquals(32, Calculator.add("1\n2\n3\n9\n3\n1,5\n8"));
	}

	@Test
	public void testStringWithSemicolonAsDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void testStringWithHashtagAsDelimiter() {
		assertEquals(3, Calculator.add("//#\n1#2"));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

 	@Test
	public void getNameWithNullValue() {
	thrown.expect(IllegalArgumentException.class);
	thrown.expectMessage("Negatives not allowed: -1");
	Calculator obj = new Calculator();
	obj.add("-1,2");
	}

	@Test
	public void testNumbersHigherThan1000() {
		assertEquals(2, Calculator.add("1001,2"));
	}
}