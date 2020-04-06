import bhavesh.BB;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class MapTest {
    public static void main(String args[])throws Exception{
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Bhavesh", 222);
        map.put("Onkar", 444);
        map.put("Swapnil", 555);
        map.put("X", 111);

        System.out.println(map);
        System.out.println(map.remove("X")); //returns value
        System.out.println(map.put("Bhavesh", 111)); //old value is returned when the existing key is updated
        System.out.println(map.size());
        System.out.println(map.get("Onkar"));
        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());

        Iterator<Map.Entry<String, Integer>> itr = map.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry<String, Integer> entry = itr.next();
            System.out.println(entry.getKey() +" : " + entry.getValue());
            if(entry.getKey().equals("Swapnil"))
                entry.setValue(666);
        }
        System.out.println(map);


        //HashMap is not synchronized not thread safe but Hashtable is synchronized.
        //Hashtable does not allow null key null value. Throws null pointer.
        Hashtable ht = new Hashtable();
        ht.put("a", "b");
        System.out.println(ht);

        //But We can get synchronized HashMap using Collection utility class.
        //every method in synchronizedMap is implemented with synchronization.
        //return object of innerclass.
        Map syncMap = Collections.synchronizedMap(map);

        //hash is generated based on the memory address(reference) and not content like other hashmaps.
        IdentityHashMap<Integer,Integer> idmap = new IdentityHashMap<>();
        idmap.put(new Integer(10), 10);
        idmap.put(10, 13);
        System.out.println(idmap);

        //no duplicate keys but insertion order preserved.
        //implements doubly LL for each entry and that holds prev and next pointer.
        //best map when we have to iterate over it multiple times. Used mostly for caching applications.
        LinkedHashMap<Integer, Integer> lhs = new LinkedHashMap<>();
        lhs.put(1,1);
        lhs.put(2,2);
        lhs.put(3,3);
        System.out.println(lhs);

        //weakhashmap is exactly same as hashmap. The only difference is if the key pointing to object has no other references
        //than weakhashmap then gc can clean that object. In case of Hashmap this won't happen. GC cannot clean the object.
        //garbage collector wins over weak hashmap but not over hashmap.
        WeakHashMap wkmap = new WeakHashMap();
        BB bb = new BB("AB");
        wkmap.put(bb, 2);
        System.out.println(wkmap);
        bb = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println(wkmap);
        HashMap mymap = new HashMap();
        bb = new BB("AB");
        mymap.put(bb, 2);
        System.out.println(mymap);
        bb = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println(mymap);


        //TreeMap, It stores keys on the basis of some sorting mechanism provided by comparator or comparable.
        //underlying DS is red black tree.
        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        tmap.put(5,"a");
        tmap.put(2, "b");
        tmap.put(7, "c");
        System.out.println(tmap);

        //Hashtable, every method is synchronized. thread safe. no null key or value is allowed. not even once.
        Hashtable<Integer, Integer> htable = new Hashtable<>();
        htable.put(1,3);

        //Properties object internally uses hashtable.
        //used to store externally configurable properties.
        Properties properties = new Properties();
        properties.load(new FileInputStream("env.properties"));
        System.out.println(properties);
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.setProperty("test", "test"));
        Enumeration e = properties.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
        properties.store(new FileOutputStream("env.properties"), "Updated by Bhavesh");
    }
}
