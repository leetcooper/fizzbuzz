package equalexperts.fizzbuzz;

public class FizzBuzzPrinter {
	private static final String FIZZ = "fizz ";
	private static final int FIZZ_MULIPLE = 3;
	
	private static final String BUZZ = "buzz ";
	private static final int BUZZ_MULIPLE = 5;
	
	private static final String FIZZBUZZ = "fizzbuzz ";
	private static final int FIZZBUZZ_MULIPLE = 15;
	
	public static void printFizzBuzz(final FizzBuzzRange fizzBuzzRange){
		fizzBuzzRange
			.rangeStream()
			.mapToObj(FizzBuzzPrinter::integerToFizzBuzzString)	
			.forEach(System.out::print);
	}
	
	private static String integerToFizzBuzzString(int value){
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
			return value + " ";
		}
	}

	private static boolean isDivisableBy(int value, int multiplier) {
		return value % multiplier == 0;
	}
	
}
