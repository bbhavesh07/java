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
    }
}

//Class level generics
class MyGenerics1<T>{   //bydefault T extends Object if we do not specify explicitly.
    public void print(T a, T b){
        System.out.println(a +" "+ b);
    }
}

class MyGenerics2{   //Method level generics
    public <T extends Number> void print(T a, T b){
        System.out.println(a +" "+ b);
    }
}