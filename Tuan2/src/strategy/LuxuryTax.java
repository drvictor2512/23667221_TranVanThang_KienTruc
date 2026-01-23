package strategy;

public class LuxuryTax implements Tax {

	@Override
	public double calculateTax(double price) {
		return price * 0.20;
	}

}
