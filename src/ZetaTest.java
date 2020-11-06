import java.util.Queue;

enum Singleton123{
    INSTANCE("Bhavesh");
    String name;
    Singleton123(String name){
        this.name = name;
    }
}
class Singleton12{
    private static Singleton12 obj;
    private Singleton12(){}
    public synchronized static Singleton12 getInstance(){
        if(obj == null)
            obj = new Singleton12();
        return obj;
    }
}

class Producer1 implements Runnable{
    Queue<Integer> queue;
    int size;
    Producer1(Queue<Integer> q, int size){
        this.queue = q;
        this.size = size;
    }
    public void run(){
        synchronized (queue) {
            while (true) {
                if (queue.size() == size){
                    try{
                        queue.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else{
                    queue.offer(1);
                    queue.notify();
                }

            }
        }
    }
}

class Consumer1 implements Runnable{
    Queue<Integer> queue;
    int size;
    Consumer1(Queue<Integer> q, int size){
        this.queue = q;
        this.size = size;
    }
    public void run(){
        synchronized (queue) {
            while (true) {
                if (queue.isEmpty()){
                    try{
                        queue.wait();
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                else{
                    queue.poll();
                    queue.notify();
                }

            }
        }
    }
}
public class ZetaTest {
    public static void main(String[] args) {

    }
}
