package observer;

import java.util.ArrayList;
import java.util.List;

public class Task implements Subject {
    private List<Observer> observers;
    private String taskName;
    private String status;

    public Task(String taskName) {
        observers = new ArrayList<>();
        this.taskName = taskName;
    }

    public void setStatus(String status) {
        this.status = status;
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
            observer.update("Trạng thái công việc " + taskName + " đã thay đổi thành: " + status);
        }
    }
}
