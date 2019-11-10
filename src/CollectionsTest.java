import java.util.*;

public class CollectionsTest {
    public static void main(String args[]){
        HashMap map = new HashMap<String, Integer>();
        map.put("Bhavesh",2);
        System.out.println(map.get(null));
        map.put(2,"BB");       //THis is possible because the map declaration at line 5 is default(<Object,Object>) if you make it specific to some data type(left side of decl). It will throw error.
        System.out.println(map);
        //int x = map.get("Bhavesh");

        //best for retrieval.
        ArrayList<Double> al = new ArrayList(10);
        al.add(10.2);
        System.out.println(al);

        //best for insertion and removal in between list.
        LinkedList<Integer> ll = new LinkedList();
        ll.add(10);
        ll.get(0);//index
        //ll.remove(10); //index, remove(new Integer(10)) is by content.
        System.out.println(ll);

        //synchronized version of arraylist.
        Vector<String> vector = new Vector(1, 5);
        vector.add("abc");
        //vector.remove("");
        System.out.println(vector);
        Enumeration<String> enumeration = vector.elements();
        while(enumeration.hasMoreElements()){
            //String s = enumeration.nextElement();
            System.out.println(enumeration.nextElement());
        }

        //We can also get synchronized arraylist. see below
        List<Integer> synchList = Collections.synchronizedList(ll);

        Stack<Character> stack = new Stack<>();
        stack.push('C');
        stack.push('H');
        stack.push('A');
        stack.push('R');
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.empty());
        System.out.println(stack.search('H'));
        Iterator<Character> e = stack.iterator();
        while(e.hasNext()){
            char c = e.next();
            System.out.println(c);
            if(c == 'H')
                e.remove();
        }
        System.out.println(stack);

        List<Integer> l = new ArrayList() {
            {
                add(3);
                add(4);
                add(5);
                add(6);
                add(7);
            }
        };

        System.out.println(l);

        //ListIterator is bi directional and also provides features like add, remove, update. In Iterator only remove is allowed.
        ListIterator<Integer> li = l.listIterator();
        while(li.hasNext()){
            int x = li.next();
            if(x == 4)
                li.set(9);
            if(x==4)
                li.remove();
            if(x==5)
                li.add(10);
            //if(x==6)

        }
        System.out.println(l);


        //no insertion order, no duplicates, internally uses hashmap to story element. key is eleme and value is empty object(default)
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(3);
        hs.add(4);
        hs.add(7);
        System.out.println(hs);

        //insertion order maintained, no duplicates, internally uses linkedhashmap.
        //linkedhashmap has entry object which stores previous and next element link. Similar to Doubly LL.
        //Very useful for caching based applications.(caching is implemented by using this collection).
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>(4);
        lhs.add(1);
        lhs.add(3);
        lhs.add(5);
        System.out.println(lhs);

        //it implements SortedSet and navigable interface. provides lot more methods than hashset.
        //insertion order not maintained, no duplicates. Always stores element in sorted order.
        //most imp non empty treeset will throw RTE when inserted null. Because of the comparator.
        //If you are creating treeset of some Object. then that object class must implement comparable. For default sorting.
        TreeSet<Integer> ts = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        ts.add(5);
        ts.add(2);
        ts.add(9);
        ts.add(1);
        System.out.println(ts);
        System.out.println(ts.headSet(3));
        System.out.println(ts.tailSet(2));

        //PriorityQueue, One of the most common implementation of Queue.
        //default priority is FCFS. Priority can be specified using comparator.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(15, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        pq.offer(1);
        pq.offer(3);
        pq.offer(2);
        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq);


        //NavigableSet and NavigableMap, these two interfaces are implemented by TreeSet and TreeMap respectively.
        //These interfaces provide some extra methods for navigation eg. ceiling, floor.
        //UseCase: Get first flight timing after 10PM etc.
        System.out.println(ts);
        System.out.println(ts.floor(2));
        System.out.println(ts.ceiling(2));
        System.out.println(ts.lower(2));
        System.out.println(ts.higher(2));
        System.out.println(ts.pollFirst());
        System.out.println(ts.pollLast());
        System.out.println(ts);
        System.out.println(ts.descendingSet());

        //set and queue can be sorted with comparator but list cannot be sorted directly.
        //to fulfill such gaps, Collections, a utility class is provided.
        al.add(12.9);
        al.add(3.3);
        al.add(33.3);
        Collections.sort(al, new Comparator<Double>() {     //please note: this sort method is only for list
            @Override
            public int compare(Double o1, Double o2) {
                return (o1.intValue() - o2.intValue());
            }
        });
        System.out.println(al);

        //there is also a binarySearch() method for list. Not for other collections.
        //list must be sorted. otherwise results cannot be predicted.
        //For default sorting order(ascending or alphabetical) no comparator needed to be provided in method call.
        //But if customized sorting used in list then same comparator needs to be passed in binarySearch().
        //it returns the index of element searched. if not found returns negative of the index it could be inserted.

        System.out.println(Collections.binarySearch(al,10.2));

        //there are also functions like reverse() and reverseOrder()
        //reverse() returns the reverse order of the passed list. while reverserOrder() returns
        //reversed comparator of originally passed comparator
        Collections.reverse(al);
        System.out.println(al);
        Comparator ct = new Comparator<Double>() {     //please note: this sort method is only for list
            @Override
            public int compare(Double o1, Double o2) {
                return (o1.intValue() - o2.intValue());
            }
        };
        Collections.sort(al, ct);
        System.out.println(al);
        ct = Collections.reverseOrder(ct);
        Collections.sort(al, ct);
        System.out.println(al);

    }


}
