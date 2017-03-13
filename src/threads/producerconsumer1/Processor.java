package threads.producerconsumer1;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class Processor {
    private List<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException{
        int value = 0;
        while(true){
            synchronized (lock){
                list.add(value++);
            }
        }
    
    }
    public void consume() throws InterruptedException{
        while (true){
            synchronized (lock){
                System.out.println("list is :" + list.size());
            }
        }
    }
}
