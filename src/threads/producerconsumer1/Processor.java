package threads.producerconsumer1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class Processor {
    private LinkedList<Integer> list = new LinkedList<>();
    private final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException{
        int value = 0;
        while(true){
            synchronized (lock){
                while(list.size() == LIMIT){
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
        }

    }
    public void consume() throws InterruptedException{
        Random random = new Random();
        while (true){
            synchronized (lock){
                while (list.size() == 0){
                    lock.wait();
                }
                System.out.println("list is :" + list.size());
                if(list.size()>0) {
                    Integer value = list.removeFirst();
                    System.out.println("read value:" + value);
                    lock.notify();
                }
            }
            Thread.sleep(random.nextInt(1000));
        }
    }
}
