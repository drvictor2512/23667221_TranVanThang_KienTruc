package strategy;

public class VatTax implements Tax {

	@Override
	public double calculateTax(double price) {
		return price * 0.10;
	}
	
}
