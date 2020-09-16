/*class Singleton{
    private static Singleton instance = null;

    private Singleton(){

    }

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}*/


import java.util.HashMap;
import java.util.Map;

public class NexusTest {
    static boolean isAlmostPalindrome(String s) {
        boolean first = false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                if (!first)
                    first = true;
                else
                    return false;
            }
        }
        return true;
    }

    static int mostPopular(int[] arr){
        Map<Integer, Integer> map = new HashMap();
        int cnt = 0, res = Integer.MAX_VALUE;
        for(int a: arr){
            int acnt = map.getOrDefault(a, 0) + 1;
            map.put(a, acnt);
            if(cnt < acnt){
                cnt = acnt;
                res = a;
            }
            else if(cnt == acnt && a < res){
                res = a;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(mostPopular(new int[]{34}));
    }
}


/*

k = 3,
1 3 5 7
2, 4 6 8
0 9 10 11

list merge(list l1, list l2){
	if(l1 == null) return l2;
	if(l2 == null) return l1;
	list res = null;
	if(l1.val <= l2.val){
		res = l1;
		res.next = merge(l1.next, l2);
	}
	else{
		res = l2;
		res.next = merge(l1, l2.next);
	}
	return res;
}

List flatten(int k, List<List> lists){
	if(k == 0) return null;
	List res = lists.get(0);

	for(int i = 1; i < lists.size(); i++){
		res = merge(res, lists.get(i));
	}
	return res;
}


Collections.sort(list, (a, b)-> a-b);



Student{
age, name
}

class StudentSorting implements Comparator<Student>{

	public int compare(Student s1, Student s2){
		if(s1.getAge() == s2.getAge()){
			return s1.getName().compareTo(s2.getName());
		}
		else
			return s1.getAge()-s2.getAge();
	}
}



int [] arr = {5 6 7 8 9 10 1 2 3}

int binarySearch(int[] arr, int key, int start, int end){
	int mid = start + (end - start)/2;
	if(arr[mid] == value) return mid;
	if(arr[start] < arr[mid]){
		if(arr[start] <= key && arr[mid] > key){
			binarySearch(arr, key, start, mid-1);
		}
		else{
			binarySearch(arr, key, mid + 1, end);
		}
	}
	else{
		if(arr[mid] < key && arr[end] >= key){
			binarySearch(arr, key, mid + 1, end);
		}
		else{
			binarySearch(arr, key, start, mid - 1);
		}
	}
	return -1;
}

10 15 14 25 30

height 1
q {10}
curr 10;
q.offer(15, 14)

heigh2
curr = 15
q.offer(14, 25 30);

curr = 14

height 3

curr = 30;



5 6 7 8 9 10 11

8 6 10 5 7 9 11

 */