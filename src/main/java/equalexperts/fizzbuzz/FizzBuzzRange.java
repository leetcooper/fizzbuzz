package equalexperts.fizzbuzz;

import java.util.stream.IntStream;

/**
 * Validates and encapsulates range. 
 * Unlike IntStream the range end is considered inclusive.  
 * An inclusive end provides a more intuitive range for the printing FizzBuzz strings 
 */
public class FizzBuzzRange {
	private int start;
	private int end;
	
	private FizzBuzzRange(int start, int end){
		if(start >= end) 
			throw new IllegalArgumentException("Range start:[" + start + "] cannot be greater then range end[" + end + "]");
		this.start = start;
		this.end = ++end;
	}
	
	public IntStream rangeStream(){
		return IntStream.range(start, end);
	}
	
	public static FizzBuzzRange range(int start, int end){
		return new FizzBuzzRange(start, end);
	}
	
}
