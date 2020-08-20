public class Multithreading {
    public static void main(String args[]) throws Exception{
        //two ways of defining a thread.
        //1. extending Thread class 2. implementing Runnable interface.
        //second approach is best. Commonly used. because it also gives you a chance to extend some other class.
        //approach1 implementation
        class MyThread extends Thread{
            public void run(){
                System.out.println("From Thread");
                for(int i = 0; i < 10; i++){
                    System.out.println(i);
                }
            }
        }

        MyThread mt = new MyThread();
        mt.start(); //This is a Thread class utility method, responsible for registering this thread with scheduler(in JVM).
                    //Currently thread is in ready state. Once scheduler allocates CPU, it will go to running state.

        //approach2 implementation
        class MyRunnable implements Runnable{
            public void run(){
                System.out.println("From runnable");
                for(int i = 0; i < 10; i++){
                    System.out.println(i);
                    //Thread.yield();
                }
            }
        }

        Thread t = new Thread(new MyRunnable());
        t.start();

        //Thread lifecycle. On new Thread() thread goes in new/born state. on t.start() goes in ready.
        //Once thread scheduler allocates cpu it goes to running state. on completion of run method goes to dead state.
        //can also go to wait state if t.sleep() or t.join() is called.

        t.setName("Bhavesh");
        System.out.println(t.getName());
        System.out.println(Thread.currentThread().getName());

        //priority of a thread
        //priority range is 1 to 10. 10 is highest priority.
        //Scheduler will always rely on OS(platform). If os supports priority based execution of process then only its useful.
        //default priority for main thread is 5 and all other children threads will inherit priority from its children.
        t.setPriority(2);

        //Prevention of thread execution.
        //yield(), sleep(), wait(), join()
        //yield() is used in preemptive scheduling. eg. When there is a lot of processing in one thread, that thread must consider that
        //there may be other threads waiting for processor and pass the cpu to other thread(give chance to other threads.
        //The thread can call Thread.yield() to go into wait state and give chance of execution to other threads.
        //if the other threads have lower priority or no waiting threads then same thread will continue.
        //It is a static native method it indicates scheduler that currently running thread wants to preempt.
        Thread.yield();

        //join() is used when the current thread wants to wait for  some other threads completion.
        //eg. if t1 calls t2.join() in t1's run method then t1 will wait till the completion of t2.
        //useful when there is some dependency between threads. //This is a object level method. non static.
        mt.join();  //here the main thread will be suspended and wait till mt is completed.
        //we can also pass some time to join() in ms. to add limit of waiting. if time is completed before completion of thread, current thread will move to ready state.
        mt.join(1000);

        //the sleep() method can also be used to make a currently running thread wait for some time.
        //in calling of join or sleep, we need to take special care that threads doesn't go in deadlock.
        //when main thread is calling join on t1 and t1 is calling join for main, then the deadlock will occur.
        //when main thread calls join on himself, deadlock will occur.
        Thread.sleep(100);

        //Interrupting thread. When a thread is in sleep() you can interrupt it. that means it will go to ready state(from wait/sleep state)
        //The loophole here is if the thread is not sleeping still the interrupt call will be registered and will wait for the thread to sleep.
        mt.interrupt(); //here if mt is interrupted if he is sleeping. Note: the InterruptedException will be thrown when the thread gets interrupted.


        //Synchronization
        //There are two types of synchronization- 1. Object level synchronization(for instance methods). 2. class level synchronization(for static methods).
        //Synchronization uses locking mechanism, every class and every object holds a unique lock.
        //But then problem is if there are two synchronized instance level methods or two static sync methods in a class then though methods are independent,
        //scheduler can't get exclusive lock(as it is with object or class).
        //And will make either of the thread to wait until one completes.
        //The other problem is when you create a synchronized instance level method and call it on different objects from different threads.
        //Because here the lock is with object it will not actually be synchronized. And both objects will run the method in parallel.
        // It will give you irregular output.

        class MeraThread implements Runnable{
            int i;
            Display d;
            MeraThread(int i, Display d){
                this.i = i;
                this.d = d;
            }

            public void run(){
                try{
                    if(this.i == 1){
                        d.displayn();
                    }
                    else if(this.i == 2){
                        d.displayc();
                    }
                    else if(this.i == 3){
                        d.displaynstatic();
                    }
                    else if(this.i == 4){
                        d.displaycstatic();
                    }

                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
        }

        Thread thread1 = new Thread(new MeraThread(1, new Display()));
        Thread thread2 = new Thread(new MeraThread(2, new Display())); //pass same diplay obj in both thread1 and 2. then sync will work.
        Thread thread3 = new Thread(new MeraThread(3, new Display()));
        Thread thread4 = new Thread(new MeraThread(4, new Display()));
        thread1.start();
        thread2.start();
        Thread.sleep(20000);
        thread3.start();
        thread4.start();
        Thread.sleep(20000);
        //Here thread3 and thread4 will print either ABCDEFGHIJ0123456789 or 0123456789ABCDEFGHIJ. because the lock is with class.
        //but in thread1 and thread2 the synchronization won't work. because both objects has different locks. o/p something like 0AB12CD34EF5G6H7I89J

        //working sync for thread1 and thread2
        Display d = new Display();
        thread1 = new Thread(new MeraThread(1, d));
        thread2 = new Thread(new MeraThread(2, d));
        System.out.println("\nSync is working now");
        thread1.start();
        thread2.start();
        Thread.sleep(20000);


        //synchronized block--If very few lines of code in a method needs synchronization then no need to declare whole method synchronized.
        //just make that block of code synchronized.
        //This will improve performance.
        new Thread(){
            public void run(){
                new Display().displaysquares();
            }
        }.start();
        //One thread can also hold a lock of multiple objects. if there are multiple synchronized blocks in a method.

        //Inter thread communication
        //threads can communicate through wait(), notify(), notifyAll() methods. All of these methods are present in Object class.
        //Because those methods can only be called on perticular object.
        //To call any of these method you should have exclusive lock of the object on which you are calling. i.e. within synchronized block.
        //once wait(), notify(), notifyAll() is called immediately the thread will release the lock of current object(only current obj)
        //and wait() goes to waiting state, other methods can continue.
        //other than these methods no other method releases lock before going to waiting state. notify and notifyAll may not immediately release the lock.
        //Here lock is released because, if wait holds the lock notify won't get the lock to perform updation.
        ThreadB wteg = new ThreadB();

        wteg.start();
        try {
            synchronized (wteg) {
                wteg.wait(10000);    //wait till the updation of total is done(till notified). The max waiting time is 10sec.
            }
        } catch(IllegalMonitorStateException e){}
        System.out.println("\nSum of first 100 numbers is " + wteg.total);

        //Daemon is a small and background process. Eg. Garbage collector.
        //The default priority is 1 but when GC comes into picture(memory problem for a prog). JVM will make GC a 10 priority(highest).
        //main thread is non daemon and we cannot make it daemon.
        //If a thread is daemon automatically child threads are daemon unless we change them.
        //If all non-daemon threads terminates automatically daemon threads terminates.
        Thread daemon = new Thread(){
            public void run() {
                while (true) {
                    System.out.println("Daemon is still alive");
                }
            }
        };
        Thread.sleep(13000);
        daemon.setDaemon(true);
        daemon.start();
        System.out.println("Main Terminated");

        //What is green thread --> This is a multithreading model by JVM. where JVM itself handles multi threading. Deprecated model.
        //The other model is native OS model. Here JVM takes help from OS to manage multithreading.
        //How to stop thread? --> th.stop(). This is deprecated method. Not recommended to use Because if the thread opens db conn and then stopped the connection would still be alive. and wasted.
        //suspend() and resume(). Using suspend() thread can be moved to suspended state and won't come to ready/runnable state unless resume() called. Deprecated methods.
    }
}

class ThreadB extends Thread{
    int total = 0;
    public void run() {
        synchronized (this){
            for(int i = 1; i <= 100; i++)
                total += i;
            this.notify();
        }
    }
}

class Display{
    public synchronized void displayn() throws InterruptedException{
        for(int i = 0; i < 10; i++){
            System.out.print(i);
            Thread.sleep(1000);
        }
    }

    public synchronized void displayc() throws InterruptedException{
        for(int i = 65; i < 75; i++){
            System.out.print((char)i);
            Thread.sleep(1000);
        }
    }

    public synchronized static void displaynstatic() throws InterruptedException{
        for(int i = 0; i < 10; i++){
            System.out.print(i);
            Thread.sleep(1000);
        }
    }

    public synchronized static void displaycstatic() throws InterruptedException{
        for(int i = 65; i < 75; i++){
            System.out.print((char)i);
            Thread.sleep(1000);
        }
    }

    public void displaysquares(){
        int arr[] = new int[10];       //This is just an example. I know we could calculate squares in some static block once.
        for(int i = 0; i < 10; i++){
            arr[i] = i*i;
        }
        synchronized (this){        //In this example only printing of squares is synchronized and not calculating squares. Calculation of squares can be performed by multiple threads in parallel.
                                    //Synchornized(someObject) eg. Synchornized(new Display()) or Synchronized(Display.class) is also correct for diff objects and class lock.
            for(int i = 0; i < 10; i++){
                System.out.print(arr[i]);
                try{
                    Thread.sleep(1000);
                } catch(InterruptedException e){}

            }
        }
    }
}


//How do you make an instance method synchronized for two different objects.
//Ans: For instance methods the lock is associated with object. So if there are two objects the lock is different for
//both of them and they can run in parallel. To avoid this and make it synchronized we declare a static object in the
// class and use it for both the methods. Because the object is static and common to all instances the method is synchronized.
//Another way of achieving this is synchronized(ClassName.class) as for each class there is only one metadata object.
//But then make sure that there is no static method otherwise the same lock will be shared with static methods.
//eg.

class SynchInstanceMethod implements Runnable{

    private static final Object object = new Object();

    private void m(){
        synchronized (object) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + ": in m()");
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void run(){
        this.m();
    }

    public static void main(String args[]){
        Thread t1 = new Thread(new SynchInstanceMethod());
        Thread t2 = new Thread(new SynchInstanceMethod());
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
    }
}
