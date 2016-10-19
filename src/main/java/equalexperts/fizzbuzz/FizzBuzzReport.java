package equalexperts.fizzbuzz;

import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzReport {
	
	private AtomicInteger luckyCount = new AtomicInteger(0);
	private AtomicInteger buzzCount = new AtomicInteger(0);
	private AtomicInteger fizzCount = new AtomicInteger(0);
	private AtomicInteger fizzbuzzCount = new AtomicInteger(0);
	private AtomicInteger integerCount = new AtomicInteger(0);
	
	public int getLuckyCount(){
		return luckyCount.get();
	}
	
	public int getBuzzCount(){
		return buzzCount.get();
	}
	
	public int getFizzCount(){
		return fizzCount.get();
	}
	
	public int getFizzBuzzCount(){
		return fizzbuzzCount.get();
	}
	
	public int getIntegerCount(){
		return integerCount.get();
	}
	
	public void includeStringInReport(final String str) {	
		if(str == null) return;
		switch(str){
			case FizzBuzzString.BUZZ :
				buzzCount.incrementAndGet();
				return;
			case FizzBuzzString.FIZZ :
				fizzCount.incrementAndGet();
				return;
			case FizzBuzzString.FIZZBUZZ :
				fizzbuzzCount.incrementAndGet();
				return;
			case FizzBuzzString.LUCKY :
				luckyCount.incrementAndGet();
				return;
		}
		try{
			Integer.parseInt(str);
			integerCount.incrementAndGet();
			return;
		}
		catch(NumberFormatException e){
			throw e;
		}
	}

	public FizzBuzzReport merge(final FizzBuzzReport report) {		
		final FizzBuzzReport fizzBuzzReport = new FizzBuzzReport();
		fizzBuzzReport.buzzCount.set(buzzCount.get()+report.buzzCount.get());
		fizzBuzzReport.luckyCount.set(luckyCount.get()+report.luckyCount.get());
		fizzBuzzReport.fizzCount.set(fizzCount.get()+report.fizzCount.get());
		fizzBuzzReport.fizzbuzzCount.set(fizzbuzzCount.get()+report.fizzbuzzCount.get());
		fizzBuzzReport.integerCount.set(integerCount.get()+report.integerCount.get());
		return fizzBuzzReport;
	}
}
