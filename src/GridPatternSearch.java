import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridPatternSearch {
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

    private static boolean explore(char[][] grid, char[][] pattern, int gi, int gj, int pr, int pc) {
        for(int i = 0; i < pr; i++){
            for(int j = 0; j < pc; j++){
                if(grid[gi+i][gj+j] != pattern[i][j]) return false;
            }
        }
        return true;
    }

    private static String isPatternPresent(char[][] grid, char[][] pattern, int r, int c, int pr, int pc){
        if(pr == 0 || pc == 0) return "YES";
        for(int i = 0; i <= r - pr; i++){
            for(int j = 0; j <= c - pc; j++){
                if(grid[i][j] == pattern[0][0] && explore(grid, pattern, i, j, pr, pc))
                    return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args){
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        while(t-- > 0){
            int r = fr.nextInt(), c = fr.nextInt();
            char[][] grid = new char[r][c];
            for(int i = 0; i < r; i++){
                grid[i] = fr.nextLine().toCharArray();
            }
            int pr = fr.nextInt(), pc = fr.nextInt();
            char[][] pattern = new char[pr][pc];
            for(int i = 0; i < pr; i++){
                pattern[i] = fr.nextLine().toCharArray();
            }
            System.out.println(isPatternPresent(grid, pattern, r, c, pr, pc));
        }
    }
}
