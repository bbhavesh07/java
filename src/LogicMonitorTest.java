import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicMonitorTest {

    //given 3 sorted arrays find common elements in all of them.
    //int[] a = {1, 2, 3, 4}
    //int[] b = {3, 4, 5}
    //int[] c = { 3, 4, 6, 8}
    private static List<Integer> findCommon(int[] a, int[] b, int[] c){
        int p1 = 0, p2 = 0, p3 = 0;
        List<Integer> res = new ArrayList();
        while(p1 < a.length && p2 < b.length && p3 < c.length){
            if(a[p1] == b[p2] && a[p1] == c[p3]) {
                res.add(a[p1]);
                p1++;
                p2++;
                p3++;
            }
            else if(a[p1] < b[p2])
                p1++;
            else if(b[p2] < c[p3])
                p2++;
            else
                p3++;
        }
        return res;
    }

    //given a binary tree, invert it

    static class TreeNode{
        TreeNode left, right;
        int val;
        TreeNode(int val){
            this.val = val;
        }
    }

    private static TreeNode invertTree(TreeNode root){
        if(root == null)
            return root;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    //int[] = {1, 2, -2, 0, -3}
    //arrange number in such a way that negative appears first, zeroes second and positive in the end
    //one way is to sort the array with Arrays.sort(arr); but its O(nlogn)
    private static int[] arrange(int arr[]){
        int p1 = 0, p2 = 0, p3 = arr.length -1;
        while(p2 <= p3){
            if(arr[p2] > 0){
                int tmp = arr[p2];
                arr[p2] = arr[p3];
                arr[p3--] = tmp;
            }
            else if(arr[p2] < 0){
                int tmp = arr[p1];
                arr[p1++] = arr[p2];
                arr[p2++] = tmp;
            }
            else{
                p2++;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        System.out.println(findCommon(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5}, new int[]{ 3, 4, 6, 8}));
        System.out.println(Arrays.toString(arrange(new int[]{1, 2, -2, 0, -3})));

    }

    //what are the protocols involved in https call
}
