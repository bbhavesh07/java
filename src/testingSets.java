import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.*;

public class testingSets {

    static void removeAll(List<String> list, String element) {
        while (list.contains(element)) {
            list.remove(element);
        }

    }
    public static void main(String argsp[]) {

            ArrayList<Integer> ar = new ArrayList<>(5);
            //Arrays.asList(new Array(){1,2,3,-5});
            ar.add(5);
            ar.add(7);
            ar.add(-3);
            ar.add(-5);
            int i = 0;
            while (i < ar.size()) {
                if (ar.get(i) < 0) {
                    ar.remove(i);

                } else
                    i++;
            }
        }

}





