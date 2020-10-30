interface I1{
    default void print(){
        System.out.println("I1 print()");
    }
}
interface I2{
    default void print(){
        System.out.println("I2 print()");
    }
    default void print1(){
        System.out.println("I2 print1()");
    }
}
public class DefaultMethods implements I1,I2{
    //throws compile time exception if not overridden
    @Override
    public void print() {
        System.out.println("DefaultMethods print()");
    }

    public void print1(){
        System.out.println("DefaultMethods print1()");
    }

    public static void main(String[] args) {
        I2 i2 = new DefaultMethods();
        i2.print1(); // class method not interface
    }
}


/*
Java 8 allows the interfaces to have default and static methods.
The reason we have default methods in interfaces is to allow the developers to add new
methods to the interfaces without affecting the classes that implements these interfaces.
 */

/*
It doesn't solve the diamond problem. It is still there.
To avoid this we override default method in current class.
 */