import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FastInputReader {
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


    public static void main(String args[]){
        FastReader fr = new FastReader();
        System.out.println("Enter input in the sequence of int, double, long and String: ");
        System.out.println(fr.nextInt());
        System.out.println(fr.nextDouble());
        System.out.println(fr.nextLong());
        System.out.println(fr.nextLine());

    }

}
