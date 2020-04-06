// Java program to illustrate
// CopyOnWriteArrayList class
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;

class ConcurrentDemo extends Thread {

    static CopyOnWriteArrayList<String> l = new CopyOnWriteArrayList<>();

    public void run()
    {
        // Child thread trying to
        // add new element in the
        // Collection object
        try{
            Thread.sleep(1000);
            l.add("D");
        } catch(Exception e){
        }
    }

    public static void main(String[] args)
            throws InterruptedException
    {
        l.add("A");
        l.add("B");
        l.add("C");

        // We create a child thread
        // that is going to modify
        // ArrayList l.
        ConcurrentDemo t = new ConcurrentDemo();
        t.start();
        System.out.println(l);

        //Thread.sleep(1000);

        // Now we iterate through
        // the ArrayList and get
        // exception.
        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            String s = (String)itr.next();
            System.out.println(s);
            //Thread.sleep(1000);
        }
        System.out.println(l);
    }
}
