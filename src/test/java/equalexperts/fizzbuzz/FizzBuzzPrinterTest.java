package equalexperts.fizzbuzz;

import static equalexperts.fizzbuzz.FizzBuzzRange.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FizzBuzzPrinterTest {
	
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
	public void canPrintCorrectFizzBuzzStringFor1To20Range(){
		final String expectedOutput = "1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz ";
		FizzBuzzPrinter.printFizzBuzz(range(1, 20));
	    assertThat(testableStream.toString(), equalTo(expectedOutput));
	}
	
}
