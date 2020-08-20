import java.util.HashSet;
import java.util.Set;

// this class make sure that current as well as all the inherited classes gets instantiated only once.
class S1{
    static Set<String> cnt = new HashSet<>();
    S1(){
        if(cnt.contains(this.getClass().getName())) throw new RuntimeException("Already instantiated");
        else cnt.add(this.getClass().getName());
        System.out.println("successfully created");
        //for(String s: cnt) System.out.println(s);
    }
}

class S2 extends S1{

}

class S3 extends S2{

}
public class SingleInstance {
    public static void main(String[] args){
        S1 s = new S1();
        s = new S2();
        s = new S3();
        s = new S3(); // throws exception
    }
}
