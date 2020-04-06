import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
    public static void main(String args[]){
        ArrayList<Integer> ar = new ArrayList<>(5);
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



        List<Integer> list = null;
        for(int x : list){
            System.out.print(x);
        }

    }
}
