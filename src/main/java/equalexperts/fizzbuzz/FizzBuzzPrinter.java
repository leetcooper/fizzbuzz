package equalexperts.fizzbuzz;

import static equalexperts.fizzbuzz.FizzBuzzCollector.toFizzBuzzReport;
import static equalexperts.fizzbuzz.FizzBuzzString.BUZZ;
import static equalexperts.fizzbuzz.FizzBuzzString.FIZZ;
import static equalexperts.fizzbuzz.FizzBuzzString.FIZZBUZZ;
import static equalexperts.fizzbuzz.FizzBuzzString.LUCKY;

public class FizzBuzzPrinter {
	private static final int FIZZ_MULIPLE = 3;
	private static final int BUZZ_MULIPLE = 5;
	private static final int FIZZBUZZ_MULIPLE = 15;
	private static final String LUCKY_MATCH = "3";
	private static final String DELIMINATOR = " ";
	
	public static void printFizzBuzz(final FizzBuzzRange fizzBuzzRange){
		if(fizzBuzzRange == null) return;
		final FizzBuzzReport report = fizzBuzzRange
			.rangeStream()
			.mapToObj(FizzBuzzPrinter::integerToFizzBuzzString)
			.map(FizzBuzzPrinter::printFizzBuzz)
			.collect(toFizzBuzzReport());
			printReport(report);
	}
	
	private static void printReport(final FizzBuzzReport report) {
		if(report == null) return;
		System.out.println("\nfizz: " + report.getFizzCount());
		System.out.println("buzz: " + report.getBuzzCount());
		System.out.println("fizzbuzz:" + report.getFizzBuzzCount());
		System.out.println("lucky: " + report.getLuckyCount());
		System.out.print("integer: " + report.getIntegerCount());				
	}

	private static String integerToFizzBuzzString(int value){		
		if(new Integer(value).toString().contains(LUCKY_MATCH)){
			return LUCKY;
		}
		if(isDivisableBy(value, FIZZBUZZ_MULIPLE)){
			return FIZZBUZZ;
		}		
		if(isDivisableBy(value, FIZZ_MULIPLE)){
			return FIZZ;
		}
		if(isDivisableBy(value, BUZZ_MULIPLE)){
			return BUZZ;
		}		
		else{
			return value + "";
		}
	}
	
	private static boolean isDivisableBy(int value, int multiplier) {		
		return value != 0 ? value % multiplier == 0 : false;
	}
	
	private static String printFizzBuzz(final String printFizzBuzz){
		System.out.print(printFizzBuzz+DELIMINATOR);
		return printFizzBuzz;
	}
}
