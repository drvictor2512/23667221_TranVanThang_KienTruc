package strategy;

public class Product {
	private String name;
    private double price;
    private Tax taxStrategy;

    public Product(String name, double price, Tax taxStrategy) {
        this.name = name;
        this.price = price;
        this.taxStrategy = taxStrategy;
    }

    public double calculateTotalPrice() {
        double tax = taxStrategy.calculateTax(price);
        return price + tax;
    }
}
