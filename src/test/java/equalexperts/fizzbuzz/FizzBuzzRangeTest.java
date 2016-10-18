package equalexperts.fizzbuzz;

import static equalexperts.fizzbuzz.FizzBuzzRange.range;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class FizzBuzzRangeTest {

	@Test	
	public void fizzBuzzRangeThrowsIllegalArgumentExceptionWhenGivenABadRange(){
		String actualExceptionMessage = null;
		final String expectedExceptionMessage = "Range start:[2] cannot be greater then range end[1]";
		
		try{			
			range(2, 1);
		}
		catch(IllegalArgumentException e){
			actualExceptionMessage = e.getMessage();
		}
		
		assertThat(actualExceptionMessage, equalTo(expectedExceptionMessage));
	}
	
	@Test	
	public void canRetrieveFizzBuzzRangeIntStreamWithInclusiveEndOfRange(){
		final int[] expectedRangeArray = {1,2,3,4,5};		
		final int[] actualRangeArray = range(1, 5).rangeStream().toArray();
		assertArrayEquals(expectedRangeArray, actualRangeArray);
	}	

}
