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
        mt.start(); //THis is a Thread class utility method, responsible for registering this thread with scheduler(in JVM).
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

        //the sleep() method can also be used to make a thread wait for some time.
        mt.sleep(100);

    }
}
