package lesson02.get;

public class MultipleOperator implements Operator {

	@Override
	public String getName() {
		return "*";
	}

	@Override
	public double execute(double a, double b) throws Exception {
		return a * b;
	}

}
