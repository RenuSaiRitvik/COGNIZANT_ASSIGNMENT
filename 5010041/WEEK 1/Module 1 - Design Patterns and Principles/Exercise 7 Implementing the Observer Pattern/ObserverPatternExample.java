import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockPrice);
}

class MobileApp implements Observer {
    @Override
    public void update(String stockPrice) {
        System.out.println("MobileApp received stock price update: " + stockPrice);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockPrice) {
        System.out.println("WebApp received stock price update: " + stockPrice);
    }
}

interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void setStockPrice(String stockPrice) {
        this.stockPrice = stockPrice;
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
            observer.update(stockPrice);
        }
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("100 USD");
        stockMarket.setStockPrice("200 USD");
    }
}
