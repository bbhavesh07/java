import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;

public class ConcurrentModification {
    public static void main(String[] args){
        //all the iterators obtained are fail fast except obtained for CopyOnWriteArrayList and ConcurrentHashMap.
        //for those two collection the separate copy is created and given to iterator so iterator is iterating over its own copy.

        //fail fast iterators fail and throw ConcurrentModification exception when somebody modifies collection while iterating.
        //Please note: exception is not thrown when collection is modified by iterator itself.
        //Iterator allows read and remove() operation. While ListIterator allows all crud operation.


        ArrayList<Integer> list
                = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Iterator
        Iterator itr = list.iterator();

        System.out.println("Iterator:");
        System.out.println("Forward traversal: ");

        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
            //list.add(2); //it will throw ConcurrentModificationException
            //itr.remove(); //but this will not throw exception

        }

        System.out.println();

        // ListIterator
        ListIterator i = list.listIterator();

        System.out.println("ListIterator:");
        System.out.println("Forward Traversal : ");

        while (i.hasNext())
            System.out.print(i.next() + " ");

        System.out.println();

        System.out.println("Backward Traversal : ");

        while (i.hasPrevious())
            System.out.print(i.previous() + " ");

        System.out.println();

        //there is also a SplitIterator which mainly used for parallel processing of collection.
        // It has hasNext and next methods combined in one method.
        //Its a FunctionalInterface with consumer which takes input from the collection and perform operation

    }
}


//diff between iterator and listiterator
/*
1) Iterator is used for traversing List and Set both.

We can use ListIterator to traverse List only, we cannot traverse Set using ListIterator.

2) We can traverse in only forward direction using Iterator.

Using ListIterator, we can traverse a List in both the directions (forward and Backward).

3) We cannot obtain indexes while using Iterator

We can obtain indexes at any point of time while traversing a list using ListIterator. The methods nextIndex() and previousIndex() are used for this purpose.

4) We cannot add element to collection while traversing it using Iterator, it throws ConcurrentModificationException when you try to do it.

We can add element at any point of time while traversing a list using ListIterator.

5) We cannot replace the existing element value when using Iterator.

By using set(E e) method of ListIterator we can replace the last element returned by next() or previous() methods.

6) Methods of Iterator:

hasNext()
next()
remove()
Methods of ListIterator:

add(E e)
hasNext()
hasPrevious()
next()
nextIndex()
previous()
previousIndex()
remove()
set(E e)
 */