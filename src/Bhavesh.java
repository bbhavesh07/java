import bhavesh.BB;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


//best way of creating singletons
//here INSTANCE is the object of Singleton
enum Singleton{
    INSTANCE;
    public void print(){
        System.out.println("printed");
    }
    public int getX(){
        return 10;
    }
}

// Here Cloneable is just like an annotation.
//It indicates that Object of Bhavesh can be cloned(bitwise: memory copy)
public class Bhavesh extends AB implements Cloneable{
    public class a{

    }
    int a;
    final int x;
    boolean b ;
    //final Bhavesh bhavesh;
    Bhavesh(int a){
        this.a = a;
        this.x  = a;
        //this.bhavesh=new Bhavesh(6);
        System.out.println(b);
    }



    public Object clone() throws CloneNotSupportedException{
        System.out.println("From clone " +this.a);
        return super.clone();
    }

    public static Boolean myBool(){
        return null;
    }

    public static String testBool(boolean b){
        if(b == false){
            return "false";
        }
        if(b == true)
            return "TRUE";
        return "";
    }

    @Override
    public String toString() {
        return "Bhavesh{" +
                "a=" + a +
                ", x=" + x +
                ", b=" + b +
                '}';
    }

    //Overridden method from Object class which is called after garbage collection is called. System.gc();
   /* public void finalize(){

    }*/

    public static void main(String args[]) throws CloneNotSupportedException{
        System.out.println(Bhavesh.testBool(Boolean.valueOf(null)));
        Bhavesh b = new Bhavesh(5);
        System.out.println(b);
        Bhavesh b1 = (Bhavesh)b.clone();
        System.out.println(b1);

        AB bb = new AB();
        System.out.println(bb.a);
        AB bb1 = new Bhavesh(6);
        System.out.println(bb1.a);
        //underscore is ignored while compilation but its good practice to add as it will make number more readable
        int i = 1_00_00_000;
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE + "\n" + Integer.MIN_VALUE);
        System.out.println(5 + Integer.MAX_VALUE);
        System.out.println(-5 + Integer.MIN_VALUE); //it is rotational once overflowed, no exception thrown
        System.out.println("aab".substring(0, 1).indexOf('a'));
        System.out.println(Integer.parseInt("FF", 16)); //This converts any string into base 10 format.
        System.out.println(Integer.toBinaryString(16)); //This converts any integer into binary format.
        DecimalFormat df = new DecimalFormat("$#,###");
        System.out.println(df.format(23445));
        System.out.println(Integer.numberOfLeadingZeros(Integer.MIN_VALUE)); //This method return all leading zeroes(considering every integer of 32 bits)
        System.out.println(new StringBuilder().append(123).reverse().toString().equals("321"));

        String s = "abc";
        String s1 = "abc";

        String s2 = new AB().getS();
        System.out.println(s==s1);
        System.out.println(s==s2);
        System.out.println(new BB("abc").getS() == new AB().getS());
        System.out.println(s == new String("abc"));

        System.out.println(false || true && false);

        //It is not necessary to implement Comparable in TreeMapKey object, but then comparator is needed otherwise will throw RTE
        TreeMap<TreeMapKey, String> map = new TreeMap<TreeMapKey, String>((k1,k2)->k1.val - k2.val);
        map.put(new TreeMapKey(), "bhavesh");

        Inh1 inh = null;
        inh.m();

    }
}

class Inh{
    int x;
    public static void m(){
        System.out.println("Inh m");
    }
}

class Inh1 extends Inh{
    {
        System.out.println(x);
    }
    /*public void m(){ //error cannot override static method
        System.out.println("Inh1 m");
    }*/
}

class TreeMapKey{
    public int val;
}

class AB implements Comparable<AB>{
    int a ;
    String s = "abc";
    public String getS(){
        System.out.println("AB"+a);
        return s;
    }

    public int compareTo(AB ab){
        return a;
    }

}