import bhavesh.BB;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Here Cloneable is just like an annotation.
//It indicates that Object of Bhavesh can be cloned(bitwise: memory copy)
public class Bhavesh extends AB implements Cloneable{
    int a;
    final int x;
    boolean b ;
    Bhavesh(int a){
        this.a = a;
        this.x  = a;
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

    }
}


class AB implements Comparable<AB>{
    int a = 10;
    String s = "abc";
    public String getS(){
        return s;
    }

    public int compareTo(AB ab){
        return 0;
    }

}