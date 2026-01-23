package strategy;

public class Main {
	 public static void main(String[] args) {

	        Product book = new Product("Sách", 100000, new VatTax());
	        Product alcohol = new Product("Rượu", 200000, new ConsumptionTax());
	        Product watch = new Product("Đồng hồ xa xỉ", 500000, new LuxuryTax());

	        System.out.println("Giá sách sau thuế: " + book.calculateTotalPrice());
	        System.out.println("Giá rượu sau thuế: " + alcohol.calculateTotalPrice());
	        System.out.println("Giá đồng hồ sau thuế: " + watch.calculateTotalPrice());
	    }
}
