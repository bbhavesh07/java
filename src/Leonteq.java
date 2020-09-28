

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Leonteq {

    static class FastReader{
        private BufferedReader br;
        private StringTokenizer stringTokenizer = new StringTokenizer("");
        FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }
        private String next(){
            try{
                while(!stringTokenizer.hasMoreElements())
                    stringTokenizer = new StringTokenizer(br.readLine());

            }
            catch (IOException e){
                e.printStackTrace();
            }
            return stringTokenizer.nextToken();

        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        double nextDouble(){
            return Double.parseDouble(next());
        }

        long nextLong(){
            return Long.parseLong(next());
        }

        String nextLine(){
            try{
                return br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return "";
        }

    }
    public static void main(String args[] ) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt(), k = fr.nextInt();
        List<Long> list = new ArrayList();
        for(int i = 0; i < n; ++i){
            list.add(fr.nextLong());
        }
        Collections.sort(list);
        n--;
        while(k-- > 0){
            if(list.get(n) == list.get(0))
                break;
            long orig = list.get(0) + list.get(n);
            list.set(0, list.get(0) * 2);
            if(list.get(n) % 2 == 1){
                list.set(n, list.get(n)/2 + 1);
            }
            else{
                list.set(n, list.get(n)/2);
            }

            if(orig <= list.get(0) + list.get(n))
                break;
            System.out.println(list.get(0) + " " + list.get(n));
            adjustStart(list, n);
            adjustEnd(list, n);

            for(long l: list)
                System.out.println(l);
        }
        System.out.println(list.stream().reduce(0L, (sum, a) -> sum + a));
    }
    private static void adjustStart(List<Long> list, int n){
        int i = 0;

        while(i < n && list.get(i) > list.get(i+1)){
            Long tmp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, tmp);
            i++;
        }
    }
    private static void adjustEnd(List<Long> list, int n){
        int i = n-1;
        while(i >= 0 && list.get(i) > list.get(i+1)){
            Long tmp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, tmp);
            i--;
        }
    }
}
