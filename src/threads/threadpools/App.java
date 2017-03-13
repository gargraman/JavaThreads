package threads.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ramgarg on 13-Mar-17.
 */

class Processor implements Runnable{

    private int id = 0;

    Processor(int id){
        this.id = id;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("Starting id:"+id);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ending id:"+id);

    }
}

public class App {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService runs managerial threads that handles tasks submitted to it.
        for(int i=0;i<5;i++){
            executorService.submit(new Processor(i));
        }
        executorService.shutdown(); //to stop accepting new tasks
        System.out.println("All tasks submitted");
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
