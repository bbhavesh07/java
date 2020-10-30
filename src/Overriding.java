import java.io.IOException;

public class Overriding {
    public void m(){
        System.out.println("m()");
    }
    public void m1(int x, long y){
        System.out.println("int long");
    }
    public void m2(int x) {
        System.out.println("m() returns int");
    }
    public Number add(int a, int b, int c){
        return a+b+c;
    }
    public static void main(String[] args){
        Overriding ov = new Class2();
        ov.m1(1, 1);

        Class2 c = new Class2();
        c.my("bhavesh");
        c.my(new Object());
        c.my(null); //in hierarchy string comes before object so calls string method
        // if two overloaded methods has an argument which doesn't show relation ex. Emp and Bank, it will throw compile
        // time exception otherwise the lowest class in hierarchy will have preference over the other overloaded method
        System.out.println(c.add(1,2));
    }
}

class Class2 extends Overriding{
    public void m(){
        System.out.println("m()");
    }
    public void m(int x){   //this is method overloading as m() is inherited from parent class.
        System.out.println("m() returns int");
    }

    public void m1(long y, int x){   //this is method overloading as m() is inherited from parent class.
        System.out.println("long int");
    }
    /*public void m2(int x) throws IOException {   //because parent method doesn't throw exception, it's not allowed
        System.out.println("m() returns int");
    }*/


    public void my(String s){
        System.out.println("String" + s);
    }
    public void my(Object s){
        System.out.println("Object" + s);
    }

    public String add(float a, int b){
        return  "double" + a+b;
    }
    public String add(int a, int b){
        return "int" + a+b;
    }

    public Integer add(int a, int b, int c){ //covariant return types are allowed(child types of Number(return type of original method) )
        return a+b+c;
    }
}

/*
If the superclass method does not declare an exception
    If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.
If the superclass method declares an exception
    If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.
 */



//in inheritance, n objects are not created if we have hierarchy of n.
//instead first the Object class is initialized and wrapped to its child and then to next child and so on.
//so the memory footprint for last class's object is more because it has more information.
//super is used to avoid confusion while accessing method or member vars if we have same names.
//as you might have noticed with super() in child class constructor there is no involvement of new so memory is not allocated
//and no new object is created, it just initialize the same object with additional properties.
//to verify you can check parent class hashcode and child class hashcode which will be same for a object.
//i.e.super.hashcode and this.hashcode