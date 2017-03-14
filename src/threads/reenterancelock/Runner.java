package threads.reenterancelock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class Runner {

    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();
    private void increment(){
        for(int i=0; i<10000; i++){
            count++;
        }
    }
    public  void firstThread() throws InterruptedException{
        lock.lock();
        //conditions should be called After getting the lock
        System.out.println("first thread waiting...");
        cond.await(); //equivalent of wait()
        System.out.println("first thread woken up..");
        try {
            increment(); //not a good way to call alone. as increment() can throw exception
        }finally {
            lock.unlock();
        }
    }

    public  void secondThread() throws InterruptedException{
        Thread.sleep(1000);
        lock.lock();
        System.out.println("Second Thread: Press the return key.");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        System.out.println("Second Thread: Got return key.");
        cond.signal(); //equivalent of notify()
        try {
            increment();
        }finally {
            lock.unlock();
        }

    }
    public  void finished() {
        System.out.println("Count is:" + count);
    }

}
