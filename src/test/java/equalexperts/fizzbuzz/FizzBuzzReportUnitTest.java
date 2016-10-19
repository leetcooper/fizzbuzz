package equalexperts.fizzbuzz;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.math.BigDecimal;

public class FizzBuzzReportUnitTest {

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
	
	@Test
	public void canMergeReports(){
		final FizzBuzzReport report1 = new FizzBuzzReport();
		report1.includeStringInReport("1");
		report1.includeStringInReport(FizzBuzzString.BUZZ);
		report1.includeStringInReport(FizzBuzzString.FIZZ);
		report1.includeStringInReport(FizzBuzzString.FIZZBUZZ);
		report1.includeStringInReport(FizzBuzzString.LUCKY);
		final FizzBuzzReport report2 = new FizzBuzzReport();
		report2.includeStringInReport("1");
		report2.includeStringInReport(FizzBuzzString.BUZZ);
		report2.includeStringInReport(FizzBuzzString.FIZZ);
		report2.includeStringInReport(FizzBuzzString.FIZZBUZZ);
		report2.includeStringInReport(FizzBuzzString.LUCKY);
		final FizzBuzzReport merge = report1.merge(report2);
		assertThat(merge.getIntegerCount(), equalTo(2));
		assertThat(merge.getLuckyCount(), equalTo(2));
		assertThat(merge.getBuzzCount(), equalTo(2));
		assertThat(merge.getFizzCount(), equalTo(2));
		assertThat(merge.getFizzBuzzCount(), equalTo(2));	

	}	
	
}
