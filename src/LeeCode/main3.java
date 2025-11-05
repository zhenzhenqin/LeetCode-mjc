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
     * 1. 定义双指针，左指针指向最左边用于标记滑动窗口的最左边 右指针从最左边开始 进行滑动窗口的右侧边界的范围的划定
     * 2. 右指针开始遍历 只要碰到的字符之前未出现过 就放入hashset中
     * 3. 碰到出现过的字符 就将左指针一直向后移动 直到删除了该字符
     * 4. 每次遍历都要更新max
     * 5. 长度 = right - left + 1
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
