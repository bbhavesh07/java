import java.io.Serializable;

//Singleton Read : https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/
//This link provides all the examples of early init(static var = new), late init(if null create, multithreaded and
//double check for multi threaded).
//Bill pugh method of lazy loading with static inner class
//Please note the inner static class is not loaded at initialization. It is lazy loading and only loaded
//when it is first time accessed
// if you need serialization for singleton override readResolve() and call getInstance(). Its optional part.
// Reflection can be avoided in any class by adding securityManager. This will prevent setAccessible.
class GFG implements Serializable
{

    private GFG()
    {
        // private constructor
    }

    // Inner class to provide instance of class
    private static class BillPughSingleton
    {
        private static final GFG INSTANCE = new GFG();
    }

    public static GFG getInstance()
    {
        return BillPughSingleton.INSTANCE;
    }

    //to avoid deserialization issues
    protected Object readResolve(){
        return getInstance();
    }
}

//best way of creating singletons, Because above way of singleton can be break using reflection and serialization
//But enums cannot be broke. All enums have default serialization logic which are based on name and not value.
// and deserialization returns the enum.valueOf(name) so the instance is always same.
//Any custom serialization logic written for enum is ignored and default is used.
// The instantiation of enum is internally handled by JVM(we cannot instantiate in our program) so even reflection
// also cannot break it.
// Also note that enum has by default private constructor
//Two disadvantages of enum-singleton: 1. It doesn't allow lazy loading. 2. Problem when we have to convert it to multi-ton.
//here INSTANCE is the object of Singleton
enum Singleton1{
    INSTANCE;
    public void print(){
        System.out.println("printed");
    }
    public int getX(){
        return 10;
    }
}


public class Singleton {



    //Multi-ton pattern
    /*
    Assume you have some surveillance cameras and each camera can have one and only one controller.

    In this case, you should get the camera class multiton. it has a hash map that contains <key, camera> pairs. like:

    public sealed class Camera
    {
        static Dictionary<int, Camera> _cameras = new Dictionary<int, Camera>();
        static object _lock = new object();

        private Camera()
        {
            HardwareId = Guid.NewGuid();
        }

        public static Camera GetCamera(int cameraCode)
        {
            lock (_lock)
            {
                if (!_cameras.ContainsKey(cameraCode)) _cameras.Add(cameraCode, new Camera());
            }
            return _cameras[cameraCode];
        }

        public Guid HardwareId { get; private set; }
    }*/
}
