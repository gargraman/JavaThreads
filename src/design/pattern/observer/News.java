package design.pattern.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class News extends Observable
{
    List<String> news = new ArrayList<>();

    public News()
    {
        news.add("News 1");
        news.add("News 2");
        news.add("News 3");
    }

    public void publishNews()
    {
        for (String n : news) {
            setChanged();
            notifyObservers(n);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
