import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class Test1 {
    public static void main(String args[]){
        ArrayList ar = new ArrayList<Integer>(5);
        String first = "first", a = "first";
        String sec = new String("first");
        System.out.println(first == sec);
        new Integer('a');

        /*ArrayList<Integer> ar = new ArrayList<>(5);
        //Arrays.asList(new Array(){1,2,3,-5});
        ar.add(5);
        ar.add(7);
        ar.add(-3);
        ar.add(-5);
        int i = 0;
        while(i< ar.size()){
            if(ar.get(i) <0){
                ar.remove(i);

            }
            else
                i++;
        }
        TreeMap<Person, Integer> tmap = new TreeMap<Person, Integer>();
        tmap.put(new Person(), 20);
        tmap.put(new Person(), 10);*/

    }



}
class Person{
    int age;
}