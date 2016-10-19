package equalexperts.fizzbuzz;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

public class FizzBuzzReportTest {

	@Test	
	public void canReportIdentifyMultipleLuckyStrings(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		assertThat(fizzBuzzReport.getLuckyCount(), equalTo(0));
		fizzBuzzReport.includeStringInReport(FizzBuzzString.LUCKY);
		assertThat(fizzBuzzReport.getLuckyCount(), equalTo(1));
		fizzBuzzReport.includeStringInReport(FizzBuzzString.LUCKY);
		assertThat(fizzBuzzReport.getLuckyCount(), equalTo(2));
		
		assertThat(fizzBuzzReport.getBuzzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getFizzBuzzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getFizzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(0));
	}
	
	@Test	
	public void canReportIdentifyMultipleFizzStrings(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		assertThat(fizzBuzzReport.getFizzCount(), equalTo(0));
		fizzBuzzReport.includeStringInReport(FizzBuzzString.FIZZ);
		assertThat(fizzBuzzReport.getFizzCount(), equalTo(1));
		fizzBuzzReport.includeStringInReport(FizzBuzzString.FIZZ);
		assertThat(fizzBuzzReport.getFizzCount(), equalTo(2));
		
		assertThat(fizzBuzzReport.getBuzzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getFizzBuzzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getLuckyCount(), equalTo(0));
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(0));		
	}
	
	@Test	
	public void canReportIdentifyMultipleBuzzStrings(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		assertThat(fizzBuzzReport.getBuzzCount(), equalTo(0));
		fizzBuzzReport.includeStringInReport(FizzBuzzString.BUZZ);
		assertThat(fizzBuzzReport.getBuzzCount(), equalTo(1));
		fizzBuzzReport.includeStringInReport(FizzBuzzString.BUZZ);
		assertThat(fizzBuzzReport.getBuzzCount(), equalTo(2));
		
		assertThat(fizzBuzzReport.getLuckyCount(), equalTo(0));
		assertThat(fizzBuzzReport.getFizzBuzzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getFizzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(0));		
	}
	
	@Test	
	public void canReportIdentifyMultipleFizzBuzzStrings(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		assertThat(fizzBuzzReport.getFizzBuzzCount(), equalTo(0));
		fizzBuzzReport.includeStringInReport(FizzBuzzString.FIZZBUZZ);
		assertThat(fizzBuzzReport.getFizzBuzzCount(), equalTo(1));
		fizzBuzzReport.includeStringInReport(FizzBuzzString.FIZZBUZZ);
		assertThat(fizzBuzzReport.getFizzBuzzCount(), equalTo(2));	
		
		assertThat(fizzBuzzReport.getLuckyCount(), equalTo(0));
		assertThat(fizzBuzzReport.getBuzzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getFizzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(0));		
	}
	
	@Test	
	public void canReportIdentifyMultipleNumbers(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(0));
		fizzBuzzReport.includeStringInReport("1");
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(1));
		fizzBuzzReport.includeStringInReport("19999");
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(2));	
		
		assertThat(fizzBuzzReport.getLuckyCount(), equalTo(0));
		assertThat(fizzBuzzReport.getBuzzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getFizzCount(), equalTo(0));
		assertThat(fizzBuzzReport.getFizzBuzzCount(), equalTo(0));		
	}
	
	@Test	
	public void canReportIdentifyAllTypesInSameReport(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		fizzBuzzReport.includeStringInReport("19999");
		fizzBuzzReport.includeStringInReport(FizzBuzzString.BUZZ);
		fizzBuzzReport.includeStringInReport(FizzBuzzString.FIZZ);
		fizzBuzzReport.includeStringInReport(FizzBuzzString.FIZZBUZZ);
		fizzBuzzReport.includeStringInReport(FizzBuzzString.LUCKY);
		
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(1));
		assertThat(fizzBuzzReport.getLuckyCount(), equalTo(1));
		assertThat(fizzBuzzReport.getBuzzCount(), equalTo(1));
		assertThat(fizzBuzzReport.getFizzCount(), equalTo(1));
		assertThat(fizzBuzzReport.getFizzBuzzCount(), equalTo(1));		
	}
	
	@Test	
	public void canReportIdentifyMinInteger(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		fizzBuzzReport.includeStringInReport(Integer.MIN_VALUE+"");
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(1));
	}	

	@Test	
	public void canReportIdentifyMaxInteger(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		fizzBuzzReport.includeStringInReport(Integer.MAX_VALUE+"");
		assertThat(fizzBuzzReport.getIntegerCount(), equalTo(1));
	}
	
	@Test(expected=NumberFormatException.class)	
	public void reportThrowsNumberFormatExceptionWhenIntegerOutOfMinRange(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		final Long longValue = new BigDecimal(Integer.MIN_VALUE).subtract(BigDecimal.ONE).longValue();
		fizzBuzzReport.includeStringInReport(longValue.toString());
	}
	
	@Test(expected=NumberFormatException.class)	
	public void reportThrowsNumberFormatExceptionWhenIntegerOutOfMaxRange(){
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		final Long longValue = new BigDecimal(Integer.MAX_VALUE).add(BigDecimal.ONE).longValue();
		fizzBuzzReport.includeStringInReport(longValue.toString());
	}	
	
}
