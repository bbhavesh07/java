import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class EnhancedMultiThreading {
    //synchronized keyword introduced deadlock. But there is a concurrent.locks package which has enhanced feature of
    //multithreading which also avoids deadlock.
    public static void main(String args[]) {
        DisplayJob dj = new DisplayJob();
        new Thread(new Runnable() {
            @Override
            public void run() {
                dj.print("Bhavesh");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                dj.printWithTryLock("Onkar");
            }
        }).start();

        //There is a thread pool which helps us to manage our threads. Keeps threads in pool which then can be allocated to our job. This improves memory and performance.
        //Just like jdbc connection pool, instead opening a new connection whenever needed and closing it. we have a pool of connection which will be used whenever needed.
        //Automatically calls start method.
        ExecutorService service = Executors.newFixedThreadPool(3); //currently we have 3 active threads in pool which can be used to perform an operation.
        service.submit(new Printable());
        service.submit(new Printable());
        service.submit(new Printable());
        service.submit(new Printable());
        service.submit(new Printable());
        service.submit(new Printable());

        service.shutdown();

        //There is also a thing called Callable. Which is same as Runnable the only diff is callable has call() method istead run() and  can return a value.
        //returning results of some operation. which then can be caught into object.
        System.out.println(new Callable(){
            public Object call(){
                return 100;
            }
        }.call());
        //if callable is used in ServiceExecutor then the return value must be caught in Future object. On which you can call get method to get actual value.
        service = Executors.newFixedThreadPool(1);
        Future f= service.submit(new Callable(){
            public Object call(){
                return 100;
            }
        });
        try {
            System.out.println(f.get());
        }catch(Exception e){}
        service.shutdown();
    }

}
class DisplayJob{
    ReentrantLock l = new ReentrantLock();

    public void print(String s) {
        l.lock(); //similar to using synchronized(this). It can still have a deadlock problem. The flexibility here is l.unlock can also be called in a different method of same class.
        for (int i = 0; i < 5; i++) {
            System.out.println("GM " + s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        l.unlock();
    }
    public void printWithTryLock(String s) {
        if(l.tryLock()) {       //here if lock is available use it otherwise perform else part. and since no waiting there is no deadlock.
                                // We can also specify time for tryLock(). Keep trying to get lock for 10secs otherwise ignore, etc.  l.tryLock(1000, TimeUnit.MILLISECONDS)
            for (int i = 0; i < 5; i++) {
                System.out.println("GM " + s);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
            l.unlock();
        }
        else{
            System.out.println("could not get the lock for "+s+" so performing alternative part");
        }
    }

}

class Printable implements Runnable{
    public void run(){
        System.out.println("Running " +Thread.currentThread().getName());
    }
}
