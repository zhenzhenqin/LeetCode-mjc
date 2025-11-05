package LeeCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * mjc
 * 2025.11.5
 */
public class main3 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "dvdf";
        int res = solution.lengthOfLongestSubstring(s);
        System.out.println(res);
    }

    /**
     * 无重复字符的最长子串
     * 思路：
     *
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            int left = 0; //左指针
            Set<Character> set = new HashSet<>();
            for (int right = 0; right < s.length(); right++){

                while(set.contains(s.charAt(right))){
                    //set.removeAll(set);  //太过激进 会将之前的有效数据也删除 如defd会将de一起删除 但实际上是只删除d

                    //修改为只要碰到之前有的字符，就将左指针一直往右边移动直到删除该字符
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
                max = Math.max(max, right - left + 1);
            }
            return max;
        }
    }
}
