package threads.waitnotify;

import java.util.Scanner;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class Processor {
    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("Producer thread running...");
            //should be called in sychronize block
            // loses the lock on 'this'
            wait(); // it waits - doesn't consume resources... better than while(true)
            System.out.println("Resumed...");

        }

    }
    public void consume() throws InterruptedException{
        Scanner scan = new Scanner(System.in);
        Thread.sleep(2000);
        synchronized (this){
            System.out.println("waiting for return key...");
            scan.nextLine();
            System.out.println("return key pressed.");
            notify(); //can only be called from synchronized block
            // allows other threads to get the lock on object 'this' once run() is finished
            // NOTIFY doesn't relinquish the lock
        }

    }
}
