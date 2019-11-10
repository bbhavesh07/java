public class VolatileSync {
    //Visible to all the threads, accessed directly from main memory. No caching is performed.
    static volatile int x;
    int a = 1;
    synchronized void modifyX(int x){
        VolatileSync.x = x;
    }
}
