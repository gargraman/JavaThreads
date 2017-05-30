package threads.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ramgarg on 13-Mar-17.
 */
public class RunnerDeadLockSolved {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public  void firstThread() throws InterruptedException{
        Random random = new Random();

        for(int i=0; i<10000;i++){
            acquireLock(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            }finally {
                releaseLock(lock2, lock1);
            }
        }
    }

    private void releaseLock(Lock lock2, Lock lock1) {
        lock2.unlock();
        lock1.unlock();
    }

    private void acquireLock(Lock lock1, Lock lock2) {
        while(true){
            //acquire lock
            boolean gotFirstLock = false;
            boolean gotSecondLock = false;


            try {
                gotFirstLock = lock1.tryLock();
                gotSecondLock = lock2.tryLock();
                if(gotFirstLock && gotSecondLock){
                    return;
                }
                if(gotFirstLock){
                    lock1.unlock();
                }
                if(gotSecondLock){
                    lock2.unlock();
                }
                //no locks so try after sometime after Sleep
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public  void secondThread() throws InterruptedException{
        Random random = new Random();
        for(int i=0; i<10000;i++){
            //lock2.lock(); //Deadlock condition if order of lock is changed
            acquireLock(lock1, lock2);
            try {
                Account.transfer(acc2, acc1, random.nextInt(100));
            }finally {
                releaseLock(lock2, lock1);
            }
        }
    }
    public  void finished() {
        System.out.println("Account 1 balance: "+ acc1.getBalance());
        System.out.println("Account 2 balance: "+ acc2.getBalance());
        System.out.println("Total balance: "+ (acc1.getBalance()+acc2.getBalance()) );

    }

}
