import java.util.function.Function;

public class Currying {
    public static void main(String argsp[]){
        Function<Integer, Function<Integer, Integer>> adder = a -> b -> a+b;
        System.out.println(adder.apply(10).apply(15));
    }
}
