package equalexperts.fizzbuzz;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class FizzBuzzCollector implements Collector<String, FizzBuzzReport, FizzBuzzReport>{

	@Override
	public Supplier<FizzBuzzReport> supplier() {
		return FizzBuzzReport::new;
	}

	@Override
	public BiConsumer<FizzBuzzReport, String> accumulator() {
		return (report, str) -> report.includeStringInReport(str.trim());
	}

	@Override
	public BinaryOperator<FizzBuzzReport> combiner() {
		return (report1, report2) -> report1.merge(report2);
	}

	@Override
	public Function<FizzBuzzReport, FizzBuzzReport> finisher() {
		return Function.identity();
	}

	@Override
	public Set<java.util.stream.Collector.Characteristics> characteristics() {
		return new HashSet<>();
	}
	
	public static FizzBuzzCollector toFizzBuzzReport(){
		return new FizzBuzzCollector();
	}

}
