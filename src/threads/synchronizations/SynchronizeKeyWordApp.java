package threads.synchronizations;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class SynchronizeKeyWordApp {

    private int count = 0;

    public static void main(String[] argvs){
        SynchronizeKeyWordApp app = new SynchronizeKeyWordApp();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i< 10000 ; i++){
                    //some increments are skipped.
                    count++;// this is not one step. count = count + 1
                    //both the threads reads the same value
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0; i< 10000 ; i++){
                    count++;// this is not one step
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
