package Demo;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by yuan on 16-7-31.
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        // creating maps
        TreeMap<Integer, String> treemap = new TreeMap<Integer, String>();
        SortedMap<Integer, String> treemapincl = new TreeMap<Integer, String>();

        // populating tree map
        treemap.put(2, "two");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");

        System.out.println("Getting tail map");
        treemapincl=treemap.tailMap(3);
        System.out.println("Tail map values: "+treemapincl);
    }
}
