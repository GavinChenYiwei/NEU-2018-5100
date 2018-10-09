import org.junit.Test;

import static org.junit.Assert.*;

public class Assignment4Test {

    @Test
    public void firstUniqChar() {
        assertEquals(0,new Assignment4().firstUniqChar("leetcode"));
        assertEquals(2,new Assignment4().firstUniqChar("loveleetcode"));
    }

    @Test
    public void addDigits() {
        assertEquals(2,new Assignment4().addDigits(38));
    }

    @Test
    public void moveZeroes() {
        int[] test1 = {0,0,1,2,3};
        int[] test1answer = {1,2,3,0,0};
        int[] test2 = {0,1,0,3,12};
        int[] test2answer = {1,3,12,0,0};
        assertArrayEquals(test1answer,new Assignment4().moveZeroes(test1));
        assertArrayEquals(test2answer,new Assignment4().moveZeroes(test2));
    }

    @Test
    public void longestPalindrome() {
        String test1 = "babad";
        String test1answer = "aba";
        String test2 = "aswdeffedwaaa";
        String test2answer = "wdeffedw";

        assertEquals(test1answer,new Assignment4().longestPalindrome(test1));
        assertEquals(test2answer,new Assignment4().longestPalindrome(test2));
    }

    @Test
    public void rotate() {
        int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] test1answer = {{7,4,1},{8,5,2},{9,6,3}};

        assertEquals(test1answer,new Assignment4().rotate(test1));
    }
}