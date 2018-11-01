import org.junit.Test;

import static org.junit.Assert.*;

public class Question5Test {
    int[] arr1 = {1,2};
    int[] arr2 = {3,4};
    @Test
    public void findMedianSortedArrays() {
        double ans = Question5.findMedianSortedArrays(arr1,arr2);
        assertEquals(2.5,ans,0.0000001);
    }
}