package lesson02.get;

public class MinusOperator implements Operator {

	@Override
	public double execute(double a, double b) throws Exception {
		return a - b;
	}

	@Override
	public String getName() {
		return "-";
	}
}
