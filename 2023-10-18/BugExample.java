import java.util.*;

public class BugExample {
    
    private Map<Integer,Integer> counts;

    BugExample() {
        counts = new HashMap<Integer,Integer>();
    }

    /**
     * Find the most common element in an array of ints
     * @param arr the array to parse
     * @return the most common element
     */
    int findMostCommonElement( int[] arr ) {
        // first, populate the `counts` hashmap with a count for each value in the array
        for (int i = 0; i < arr.length; i++ ) {
            if (counts.containsKey(arr[i])) {
                counts.put(arr[i], counts.get(arr[i])+ 1);
            } else {
                counts.put(arr[i], 1);
            }
        }

        // next, find the maximum count
        Integer maxCount = 0;
        Integer maxInt = null;
        for (Integer k : counts.keySet()) {
            Integer v = counts.get(k);
            if ((maxInt == null) || (v >= maxCount)) {
                maxInt = k;
                maxCount = v;
            }
        }

        return maxInt;
    }

    public static void main(String[] args) {
        BugExample bugExample = new BugExample();

        int []arr1 = {5, 6, 2, 3, 2, 9, 2};
        int []arr2 = {1, 1, 1, 2};

        System.out.println( bugExample.findMostCommonElement( arr1 ) );

        System.out.println( bugExample.findMostCommonElement( arr2 ) );

    }
}
