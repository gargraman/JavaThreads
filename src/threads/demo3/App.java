package threads.demo3;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class App {
    public static void main(String[] args){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ;i <10 ;i++){
                    System.out.println("i="+i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        //auto
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
    }
}
