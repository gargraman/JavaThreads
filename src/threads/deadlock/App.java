package threads.deadlock;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class App {
    public static void main(String[] args){
        final RunnerWithDeadLock proc = new RunnerWithDeadLock();
        final RunnerDeadLockSolved proc1 = new RunnerDeadLockSolved();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    proc.firstThread();
                    proc1.firstThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    proc.secondThread();
                    proc1.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proc.finished();
    }
}