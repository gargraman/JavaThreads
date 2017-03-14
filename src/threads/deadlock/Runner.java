package threads.deadlock;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    public  void firstThread() throws InterruptedException{
        Random random = new Random();
        for(int i=0; i<10000;i++){
            Account.transfer(acc1,acc2,random.nextInt(100));
        }
    }

    public  void secondThread() throws InterruptedException{
        Random random = new Random();
        for(int i=0; i<10000;i++){
            Account.transfer(acc2,acc1,random.nextInt(100));
        }
    }
    public  void finished() {
        System.out.println("Account 1 balance: "+ acc1.getBalance());
        System.out.println("Account 2 balance: "+ acc2.getBalance());
        System.out.println("Total balance: "+ (acc1.getBalance()+acc2.getBalance()) );

    }

}
