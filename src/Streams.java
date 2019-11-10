import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * original collection is immutable -> not modified in streams
 * intermediate operations : map, filter, sorted
 * end operations: collect, foreach, reduce
 */
public class Streams {

    public static void main(String arg[]){
        List<Integer> list = Arrays.asList(1, 3, 55, 4, 6,3);
        System.out.println(list.stream().map(x->x-2).collect(Collectors.toList()));
        list.stream().filter(x -> x % 2 == 0).forEach(x ->System.out.println(x));
        System.out.println(list.stream().reduce(0, (sum, x) ->sum +x ));
        System.out.println(list.stream().sorted().collect(Collectors.toList()));



    }

}
