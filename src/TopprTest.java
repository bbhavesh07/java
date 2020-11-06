public class TopprTest {

    private static int waterStorage(int[] arr){

        int[] maxRight = new int[arr.length];
        maxRight[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2; i >= 0; --i){
            maxRight[i] = Math.max(maxRight[i+1], arr[i]);
        }
        int maxSoFar = arr[0], res = 0;
        for(int i = 1; i < arr.length; ++i){
            maxSoFar = Math.max(maxSoFar, arr[i]);
            res += Math.min(maxSoFar, maxRight[i]) - arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(waterStorage(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
