/**
 * @author Bhavesh Bavdhane
 * @since Sept 2019
 * This class implements searching and sorting offered by java
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchSort {
    /**
     * This method performs binary search and sorting(tim sort) on defined collections
     * @param argsp Array of command line arguments.
     * @return nothing
     *
     */
    public static void main(String argsp[]){
        String arr[] = {"Bhavesh", "Saurabh", "Komal", "Angraj", "Neelam"};
        Arrays.sort(arr);

        //Can use Arrays.toString(arr); instead below for loop
        for(String name: arr){
            System.out.println(name);
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(44);
        list.add(23);
        list.add(1);
        list.add(65);
        Collections.sort(list);
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);

        //binary search: It works only if the collection is sorted

        System.out.println("Found at " + Arrays.binarySearch(arr, "Komal"));
        System.out.println("Could have inserted at " +-1 *Arrays.binarySearch(arr, "Chinmay"));

        Collections.sort(list);
        System.out.println("Found at " + Collections.binarySearch(list, 23));

    }
}
