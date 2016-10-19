package equalexperts.fizzbuzz;

import static equalexperts.fizzbuzz.FizzBuzzRange.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzPrinterComponentTest {
	
	private ByteArrayOutputStream testableStream;
	private PrintStream testablePrintStream;
	private PrintStream originalStream;
	
	@Before
	public void setUp(){
		testableStream = new ByteArrayOutputStream();
		testablePrintStream = new PrintStream(testableStream);
		originalStream = System.out;
		System.setOut(testablePrintStream);
	}
	
	@After
	public void tearDown(){		
		System.setOut(originalStream);
		try{
			testableStream.close();
			testablePrintStream.close();
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
	}	

	@Test
	public void canRedirectSystemOutToTestableStream(){
		final String testString = "Fizz Buzz Fizz";
	    System.out.print(testString);
	    assertThat(testableStream.toString(), equalTo(testString));
	}
	
	@Test
	public void printFizzBuzzCanHandleNullRange(){
		FizzBuzzPrinter.printFizzBuzz(null);	
		assertThat(testableStream.toString(), equalTo(""));
	}
	
	@Test
	public void canPrintCorrectFizzBuzzStringFor1To20Range(){
		final String expectedOutput = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz \nfizz: 4\r\nbuzz: 3\r\nfizzbuzz:1\r\nlucky: 2\r\ninteger: 10";
		FizzBuzzPrinter.printFizzBuzz(range(1, 20));
	    assertThat(testableStream.toString(), equalTo(expectedOutput));
	}
	
	@Test
	public void canPrintCorrectFizzBuzzStringFor0To1Range(){
		final String expectedOutput = "0 1 \nfizz: 0\r\nbuzz: 0\r\nfizzbuzz:0\r\nlucky: 0\r\ninteger: 2";
		FizzBuzzPrinter.printFizzBuzz(range(0, 1));
	    assertThat(testableStream.toString(), equalTo(expectedOutput));
	}
	
	@Test
	public void canPrintCorrectFizzBuzzStringForNegativeRange20to1(){
		final String expectedOutput = "buzz -19 fizz -17 -16 fizzbuzz -14 lucky fizz -11 buzz fizz -8 -7 fizz buzz -4 lucky -2 -1 \nfizz: 4\r\nbuzz: 3\r\nfizzbuzz:1\r\nlucky: 2\r\ninteger: 10";
		FizzBuzzPrinter.printFizzBuzz(range(-20, -1));
	    assertThat(testableStream.toString(), equalTo(expectedOutput));
	}	
	
}
