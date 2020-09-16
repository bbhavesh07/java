import java.util.Scanner;

class SynechronTest{


    private static int solve(int[] arr, int n){
        if(arr.length < 2) return arr.length;
        int len = 1, anchor = 0;
        for(int i = 1; i < n; i++){
            if(arr[i] < arr[i-1]){
                anchor = i;
            }
            len = Math.max(len, i - anchor + 1);
        }

        anchor = 0;

        for(int i = 1; i < n; i++){
            if(arr[i] > arr[i-1]){
                anchor = i;
            }
            len = Math.max(len, i - anchor + 1);
        }

        return len;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            System.out.println(solve(arr, n));
        }
    }
}