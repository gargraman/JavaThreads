package threads.demo1;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class App{
  public static void main(String[] arg){
      Runner runn = new Runner();
      runn.start();
  }
}

class Runner extends Thread{
    public void run(){
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
}
