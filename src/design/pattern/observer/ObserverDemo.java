package design.pattern.observer;

public class ObserverDemo
{
    public static void main(String[] args) {
        News news = new News();
        news.addObserver(new ObserverOne());
        news.addObserver(new ObserverTwo());
        news.publishNews();
    }
}
