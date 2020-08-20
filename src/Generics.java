import java.util.ArrayList;
import java.util.List;

//Why generics
//“In layman,s term, generics force type safety in java language.”
//“Generics add stability to your code by making more of your bugs detectable at compile time.”
// In original collection framework, having homogeneous collections was not possible without adding extra checks before adding an element.
// Generics were introduced to remove this limitation to be very specific.
// They add this type checking of parameters in your code at compile time, automatically

// What is type erasure?
//It is introduced for type safety. When you compile the code, the compiler will erase the type(T) and replace it with Object class.

class MyClass<T extends Print & Sum & Sub> {
    public T printObj;

    MyClass(T printObj) {
        this.printObj = printObj;
    }

    void display() {
        System.out.println("From Myclass");
        this.printObj.print();
        System.out.println(printObj.add(5, 10));
        System.out.println(printObj.sub(15, 5));
    }
}

class GenericsEx2<T extends Object>{

    Print p;
    GenericsEx2(T t){
        p = (Print) t;
        p.print();
    }

}

interface adder<T extends Number>{
    T add(T a, T b);
}

class GenericsEx3<T extends Number>{
    //T[] arr = new Integer[4]; // Generics is not allowed with array
    T add(T a, T b, adder<T> adder){
        return adder.add(a, b);
    }
}

class Print implements Sum, Sub{
    void print(){
        System.out.println("From Print class");
    }

     public int add(int a, int b){
        return a+b;
    }

    public int sub(int a, int b){
        return a-b;
    }
}

interface Sum{
    int add(int a, int b);
}

interface Sub{
    int sub(int a, int b);
}




public class Generics {
    public static void main(String args[]){

        MyClass<Print>  myClass = new MyClass<>(new Print());
        myClass.display();
        //Though below is the object type we need only print type object. otherwise class cast exception will be thrown
        //And I feel this is not a good design.
        GenericsEx2<Object> genericsEx2 = new GenericsEx2<>(new Print());

        GenericsEx3<Integer> genericsEx3 = new GenericsEx3<>();
        System.out.println(genericsEx3.add(10,15, new adder<Integer>(){
            public Integer add(Integer a, Integer b){
                return a + b;
            }

        }));

        GenericsEx3<Double> genericsEx4 = new GenericsEx3<>();
        System.out.println(genericsEx4.add(10.6,15.6, new adder<Double>(){
            public Double add(Double a, Double b){
                return a + b;
            }

        }));

        //here rather passing adder of specific type, you can do something like T.getClass = Integer.class and so on.

        MyGenerics1<String> myGenerics1 = new MyGenerics1();
        myGenerics1.print("bhavesh", "bb");
        new MyGenerics2().<Integer>print(2, 1);

        //Wild cards in generics 1. ?
        List<?> list = new ArrayList<Integer>(); // the list is typed to any type(it is same as <? extends Object).
        List<? extends Object> list1 = new ArrayList<Double>(); // the list is typed to Object or sub classes of Object. Anything which extends Object.
        List<? super String> list2 = new ArrayList<Object>(); //the list is typed to either the String class, or a superclass of String.

        Object[] x = new Integer[4]; // Generics is not allowed with Array. Because Arrays carry type information at run time.

        List<? extends Object> objList = new ArrayList<String>();
    }
}

//Class level generics
class MyGenerics1<T>{   //bydefault T extends Object if we do not specify explicitly.
    public void print(T a, T b){
        System.out.println(a +" "+ b);
    }
}

class MyGenerics2{   //Method level generics, generics is even possible with static methods
    public <T extends Number> void print(T a, T b){
        System.out.println(a +" "+ b);
    }
    public static <T extends Number> void printStatic(T a, T b){
        System.out.println(a +" "+ b);
    }
}


//below are the some points we cannot do with generics

/*a) You can’t have static field of type
        You can not define a static generic parameterized member in your class. Any attempt to do so will generate compile time error: Cannot make a static reference to the non-static type T.

public class GenericsExample<T>
{
    private static T member; //This is not allowed
}
b) You can not create an instance of T
        Any attempt to create an instance of T will fail with error: Cannot instantiate the type T.

public class GenericsExample<T>
{
    public GenericsExample(){
        new T();
    }
}
c) Generics are not compatible with primitives in declarations
        Yes, it’s true. You can’t declare generic expression like List or Map<String, double>.
        Definitely you can use the wrapper classes in place of primitives and then use primitives when passing the actual values.
        These value primitives are accepted by using auto-boxing to convert primitives to respective wrapper classes.

final List<int> ids = new ArrayList<>();    //Not allowed

final List<Integer> ids = new ArrayList<>(); //Allowed
d) You can’t create Generic exception class
Sometimes, programmer might be in need of passing an instance of generic type along with exception being thrown. This is not possible to do in Java.

// causes compiler error
public class GenericException<T> extends Exception {}*/
