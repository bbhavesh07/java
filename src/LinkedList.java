import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Node<T>{
    T val;
    Node next;
    Node(T val){
        this.val = val;
        this.next = null;
    }
}

public class LinkedList<T> {
    Node<T> head;

    public void add(T val){
        if(head == null){
            head = new Node<T>(val);
        } else{
            Node<T> curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = new Node<T>(val);
        }
    }

    public void delete(T val){
        Node<T> curr = head;
        if(head.val == val){
            head = head.next;
            curr.next = null;
            return;
        }
        while(curr.next != null){
            if(curr.next.val == val){
                Node temp = curr.next;
                curr.next = curr.next.next;
                temp.next = null;
            }
            curr = curr.next;
        }
    }

    public Node<T> search(T val){
        Node<T> curr = head;
        while(curr != null){
            if(curr.val == val)
                return curr;
            curr = curr.next;
        }
        return null;
    }

//1 3 4 5 6 7 9 10 11
//
//14
    public int pairsWithSum(int[] arr, int sum){
        Set<Integer> cache = new HashSet();
        int cnt = 0;
        for(int a: arr){
            int b = sum - a;
            if(cache.contains(b))
                cnt++;
            else{
                cache.add(a);
            }
        }
        return cnt;
    }

    public static void main(String[] ar){
        List<String> list = new ArrayList<String>(){
            {
                add("ab");
                add("bb");
                add("ab");
            }
        };
        List<String> unique = list.stream().distinct().collect(Collectors.toList());
        for(String s: unique)
            System.out.println(s);
    }

    public int move(int n, int m){
        if(n > m) return -1;
        if(n == m) return 0;
        int cnt = 0;
        while(m > n){
            if(m % 2 != 0){
                m -= 1;
            }
            else{
                m = m / 2;
            }
            cnt++;
        }
        return cnt;
    }

}



/*
    int start = 0, end  = length-1;
    while(start <= end){
        int mid = start + (end - start)/2;
        if(arr[mid] == val) return true;
        if(arr[mid] > val) end = mid -1;
        else start = mid +1;
    }
 */