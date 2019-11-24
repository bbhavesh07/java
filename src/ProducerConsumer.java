import java.util.PriorityQueue;
import java.util.Queue;

public class ProducerConsumer {

    public static void main(String args[]) throws Exception{
        Queue q = new PriorityQueue(10);
        Thread prod = new Thread(new Producer( q));
        Thread cons = new Thread(new Consumer(q));
        prod.start();
        cons.start();
        //Thread.sleep(1000);

    }
}

class Producer implements Runnable{
    Queue q;
    Producer(Queue q) {
        this.q = q;
    }
    public void run(){
        synchronized (q){
            q.add("Bhavesh");
            q.notify();
        }
    }
}

class Consumer implements Runnable{
    Queue q;
    Consumer(Queue q){
        this.q = q;
    }
    public void run(){
        synchronized (q){
            try{
                if(q.isEmpty())
                    q.wait();
                System.out.println("Found element: "+ q.remove());
            } catch(InterruptedException e){}

        }
    }
}
