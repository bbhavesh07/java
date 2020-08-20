public class Deadlock extends Thread{
    //Deadlock is something where two thread waits for each other and so never terminates.
    //Deadlock occurs because of synchronization.
    //So always make sure you write right code of synchronization(and its caller) which will never turn into deadlock.
    //There is also a concept of Starvation. Where thread may not necessarily wait forever.
    //example. 1 lac threads of priority 10 running and there is one thread with priority 1.
    //This priority 1 thread will have to wait until the completion of priority 10 threads and then will get the chance to run.

    A a = new A();
    B b = new B();
    void m1(){
        this.start(); // start child thread(run: at line 16)
        b.d1(a);      // continue in main thread.
    }

    public void run(){
        a.d1(b);
    }
    public static void main(String args[]){
        Deadlock dl = new Deadlock();
        dl.m1();
    }
}

class A{
    //This method holds lock for A's object and now waiting for B's lock to call last().
    public synchronized void d1(B b){
        System.out.println("A's d1()");
        try{
            Thread.sleep(100);
        } catch (InterruptedException e){}
        b.last();
    }
    public synchronized void last(){
        System.out.println("A's last()");
    }
}


class B{
    //This method holds lock for B's object and now waiting for A's lock to call last().
    public synchronized void d1(A a){
        System.out.println("B's d1()");
        try{
            Thread.sleep(100);
        } catch (InterruptedException e){}
        a.last();
    }
    public synchronized void last(){
        System.out.println("B's last()");
    }
}