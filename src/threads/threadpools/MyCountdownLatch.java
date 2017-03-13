package threads.threadpools;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ramgarg on 13-Mar-17.
 */

public class MyCountdownLatch {
    public static void main(String[] args){
        CountDownLatch latch = new CountDownLatch(5);//Threadsafe. No need to think of Thread synchronization
        //lets you count down from number you specify.
        //waits threads till count reaches = 0
        //once reached one of threads waiting for lock carry-on
        System.out.println("countdown from: 5, Total processes: 6, Total threads: 3");
        ExecutorService service = Executors.newFixedThreadPool(3);
        for(int i=0; i<6; i++){
            service.submit(new MyProcessor(latch,i));
        }
        service.shutdown();
        try {
            latch.await();
            service.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Exit.");

    }
}
class MyProcessor implements Runnable {
    private int id = 0;
    private CountDownLatch latch;

    MyProcessor(CountDownLatch latch){
        this.latch = latch;
    }
    MyProcessor(CountDownLatch latch, int id){
        this.latch = latch;
        this.id = id;
    }
    @Override
    public void run() {
        System.out.println("Starting the thread.."+id);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Countdown:"+id);
        latch.countDown();
        System.out.println("Completed id:" + id);
    }
}


