import java.util.LinkedList;
import java.util.List;

public class InfrrdTest {
    private static int getWinner(int n, char[] arr){
        if(n < 1) throw new RuntimeException("n is not valid");
        if(n == 1) return 1;
        validateInput(arr);
        List<Integer> players = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            players.add(i);
        }

        int i = 0, len = arr.length;
        int pIndex = 0;
        while(players.size() > 1){
            if(pIndex >= players.size())
                pIndex = 0;
            if(arr[i++ % len] == 'b')
                players.remove(pIndex);
            else
                pIndex++;
        }
        return players.get(0);
    }

    private static void validateInput(char[] arr) {
        for(int i = 0; i < arr.length; ++i){
            if(arr[i] == 'b') return;
        }
        throw new RuntimeException("atleast one b is needed in input");
    }

    public static void main(String[] args) {
        System.out.println(getWinner(5, "aaba".toCharArray()));
    }
}
