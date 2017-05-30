package threads.semaphore;

/**
 * Created by ramgarg on 09-Apr-17.
 */
public class Connection {
    private static Connection instance = new Connection();
    private int connections = 0;

    public static Connection getInstance(){
        return instance;
    }

    public void connect(){
        synchronized (this){
            connections++;
        }
    }
}
