package threads.demo1;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class App
{
    public static void main(String[] arg)
    {
        Runner runn = new Runner();
        Thread r = new Thread(new Runner2());
        r.start();
        runn.start();
        try {
            r.join();
            runn.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}

class Runner2 implements Runnable
{

    @Override
    public void run()
    {
        for(int j=0; j< 10; j++) {
            try {
                System.out.println("j" + j);
                Thread.sleep(50);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

}

class Runner extends Thread
{
    public void run()
    {
        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // auto
                e.printStackTrace();
            }
        }
    }
}
