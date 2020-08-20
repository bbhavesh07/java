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
    public static void main(String[] args){
        Overriding ov = new Class2();
        ov.m1(1, 1);
    }
}

class Class2 extends Overriding{
    public void m(int x){   //this is method overloading as m() is inherited from parent class.
        System.out.println("m() returns int");
    }

    public void m1(long y, int x){   //this is method overloading as m() is inherited from parent class.
        System.out.println("long int");
    }
    /*public void m2(int x) throws IOException {   //because parent method doesn't throw exception, it's not allowed
        System.out.println("m() returns int");
    }*/
}

/*
If the superclass method does not declare an exception
    If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.
If the superclass method declares an exception
    If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception.
 */