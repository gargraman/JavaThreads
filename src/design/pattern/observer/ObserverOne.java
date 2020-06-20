package design.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverOne implements Observer
{

    @Override
    public void update(Observable o, Object arg)
    {
       System.out.println("Observer One got the news:" + arg);
    }

}
