package design.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverTwo implements Observer
{

    @Override
    public void update(Observable o, Object arg)
    {
       System.out.println("Observer Two got the news:" + arg);
    }

}
