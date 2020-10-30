import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NiyujTest {
    private static int reduce(double h){
        if(h <= 1) return 0;
        return 1 + reduce(h*0.8);
    }

    private List<Integer> unique(List<Integer> list){
        Set<Integer> set = new HashSet<Integer>(list);
        return new ArrayList<>(set);
    }

    private static StringBuilder reverse(StringBuilder s, int start, int end){
        if(start >= end){
            return s;
        }
        char c = s.charAt(start);
        s.setCharAt(start, s.charAt(end));
        s.setCharAt(end, c);
        return reverse(s, start+1, end-1);
    }
    private static String reverse(String s){
        if(s == null || s.isEmpty())
            return "";
        return reverse(s.substring(1)) + s.charAt(0);
    }

    public static void main(String[] args){
        System.out.println(reverse(new StringBuilder("abcd"), 0, 3));
        System.out.println(reverse("abcd"));
        MyMath m = (a,b)->a+b;

        m.calculate(5,10);
    }
}

@FunctionalInterface
interface MyMath{
    int calculate(int a, int b);
}

class Parent{

    void display() throws FileNotFoundException {
        System.out.println("Parent");
    }
}

class Child extends Parent{

    void display(){
        System.out.println("Child");
    }
}


// select * from employee group by age having age < 20 and age > 30 order by salary;
// select rank() over (order by salary desc) rank salary from employee where rank = 3;