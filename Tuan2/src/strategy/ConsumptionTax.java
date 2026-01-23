package strategy;

public class ConsumptionTax implements Tax {

	@Override
	public double calculateTax(double price) {
		return price * 0.05;
	}
	
}
