/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader*/

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class HackerEarth {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] pts = new int[n], energy = new int[n];
            for(int i = 0; i < n; i++){
                pts[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                energy[i] = sc.nextInt();
            }
            int res = 0;
            for(int i = 0; i < n; i++){

                int j = i+1, pt = pts[i] + energy[i];
                while(j < n && pt >= pts[j]){
                    pt += energy[j++];
                }
                if(pt >= 100000)
                    res++;
            }
            System.out.println(res);
        }


    }
}
/*
1
3
99991 99994 99997
3 3 3

 */