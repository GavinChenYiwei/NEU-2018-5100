import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Assignment4 {

    /**
     * The deadline of assignment4 is 10/12/2018 23:59 PST.
     * Please feel free to contact Zane and Amanda for any questions.
     */

    /*
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     * s = "leetcode" return 0.
     * s = "loveleetcode" return 2.
     */
    public int firstUniqChar(String s) {
        int[] letterCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letterCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letterCount[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    /*
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * Input: 38 Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */

    public int addDigits(int n) {
        if (n < 10)
            return n;
        int sum = 0;
        while (n / 10 != 0) {
            sum = sum + n % 10;
            n /= 10;
        }
        sum = sum + n;
        return addDigits(sum);
    }

    /*
     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
     */
    public int[] moveZeroes(int[] nums) {
        int zeroCount = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] == 0 && zeroCount + i < nums.length) {
                for (int j = i; j < nums.length - zeroCount - 1; j++) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                zeroCount++;
            }
        }
        return nums;
    }

    /*
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
     */
    public static String longestPalindrome(String s) {
        if (s.length() < 1)
            return "";
        int end = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = findFromCenter(s, i, i);
            int len2 = findFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int findFromCenter(String s, int i, int j) {
        int L = i;
        int R = j;
        while (L >= 0 && R <= s.length() - 1 && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /*
     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * Given input matrix = [ [1,2,3],
  			                  [4,5,6],
  			                  [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
  								                                 [8,5,2],
  								                                 [9,6,3]],
     */
    public int[][] rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                swap(matrix, j, i, matrix.length - j - 1, i);
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        return matrix;
    }

    public void swap(int[][] m1, int a, int b, int i, int j) {
        int temp = m1[a][b];
        m1[a][b] = m1[i][j];
        m1[i][j] = temp;
    }

}

