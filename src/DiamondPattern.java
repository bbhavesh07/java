public class DiamondPattern {
    /***
     *
     * @param n: total number of rows in a diamond pattern
     */
    static void print(int n){
        if(n % 2 == 0) throw new RuntimeException("Diamond pattern cannot be created with even number of rows");
        n = n / 2;
        int spaces = n;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < spaces; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*i -1; j++){
                System.out.print("*");
            }
            System.out.println();
            spaces--;
        }
        spaces = 1;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*(n-i)-1; j++){
                System.out.print("*");
            }
            System.out.println();
            spaces++;
        }
    }

    public static void main(String[] args){
        DiamondPattern.print(5);
    }
}
