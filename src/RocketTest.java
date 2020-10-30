import java.util.*;

public class RocketTest {
/*

program should accept length of the rod and output should be the lengths in which the rod should be cut into
to get the maximum price
cut the rod into multiple pieces to get the max profit.
 piece length in cm                price(Rs)
 1                                1
 2                                2
 4                                6
 5                                8
 8                                11

 eg. if the given length is 10, output should be length 5,5  and max price = 16
 */


    private static int[] lengths = new int[]{1,2,4,5,8};
    private static int[] prices = new int[]{1,3,6,9,11};
    private static List<Integer> pieces(int n){
        int[][] dp = new int[lengths.length+1][n+1];
        for(int i = 1; i <= lengths.length; ++i){
            for(int j = 1; j < dp[0].length; ++j){
                if(j >= lengths[i-1])
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-lengths[i-1]] + prices[i-1]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        //System.out.println(Arrays.deepToString(dp));

        List<Integer> res = new ArrayList();
        int sum = 0;
        int i = lengths.length, j = n;
        while(i > 0 && j > 0){
            if(dp[i-1][j] == dp[i][j])
                i = i-1;
            else{
                res.add(lengths[i-1]);
                sum += prices[i-1];
                j = j - lengths[i-1];

            }

        }
        System.out.println(sum);
        return res;

        //Another way to solve this problem is with Object Oriented way, class Rod with price and length as properties
        // and priority queue to sort all Rod objects by price and then reduce the given length.

    }


    public static void main(String[] args) {
        for(int n: pieces(8)){
            System.out.println(n);
        }
    }

}
