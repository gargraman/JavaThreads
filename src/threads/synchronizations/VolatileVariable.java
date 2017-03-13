package threads.synchronizations;

import java.util.Scanner;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class VolatileVariable {
    public static void main(String[] args){
        Processor pr = new Processor();
        pr.start();
        System.out.println("Enter to shutdown");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        pr.shutdown();
    }
}

class Processor extends Thread{
    /** missing volatile keyword
    //private boolean running = true; //issue. this value is cached.
    */
    private volatile boolean running = true; // volatile makes java to check running variable everytime.


    public void run(){
        while (running){
            System.out.println("Hello");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void shutdown(){
        this.running = false;
    }
}
