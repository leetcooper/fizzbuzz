package equalexperts.fizzbuzz;

public class FizzBuzzPrinter {
	private static final String FIZZ = "fizz ";
	private static final String BUZZ = "buzz ";
	private static final String FIZZBUZZ = "fizzbuzz ";
	
	public static void printFizzBuzz(final FizzBuzzRange fizzBuzzRange){
		fizzBuzzRange
			.rangeStream()
			.mapToObj(FizzBuzzPrinter::integerToFizzBuzzString)	
			.forEach(System.out::print);
	}
	
	public static String integerToFizzBuzzString(int value){
		if(isDivisableBy(value, 15)){
			return FIZZBUZZ;
		}		
		if(isDivisableBy(value, 3)){
			return FIZZ;
		}
		if(isDivisableBy(value, 5)){
			return BUZZ;
		}		
		else{
			return value + " ";
		}
	}

	private static boolean isDivisableBy(int value, int divider) {
		return value % divider == 0;
	}
	
}
