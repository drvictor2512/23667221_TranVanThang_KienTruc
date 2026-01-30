package observer;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Subject {
    private List<Observer> observers;
    private String stockName;
    private double price;

    public Stock(String stockName) {
        observers = new ArrayList<>();
        this.stockName = stockName;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("Giá cổ phiếu " + stockName + " đã thay đổi thành: " + price);
        }
    }
}
