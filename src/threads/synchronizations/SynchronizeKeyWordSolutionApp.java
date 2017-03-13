package threads.synchronizations;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class SynchronizeKeyWordSolutionApp {

    private int count = 0;

    public synchronized void increment(){
        //Every object in java has intrinsic lock called Mutex
        //Threads need to acquire intrinsic lock on the object.
        //only one thread can acquire at a given time

        count++;

        //this is not ideal to lock whole object. so we use explicit locks
    }

    public static void main(String[] argvs){
        SynchronizeKeyWordSolutionApp app = new SynchronizeKeyWordSolutionApp();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i< 10000 ; i++){
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i< 10000 ; i++){
                    increment();
                }
            }
        });

        t1.start();
        t2.start();
        //wait thread are finished
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Count value is:" + count);
    }
}
