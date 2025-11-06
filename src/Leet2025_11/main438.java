package Leet2025_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * mjc
 * 2025.11.6
 */

public class main438 {
    public static void main(String[] args) {

        Solution2 solution = new Solution2();
        List<Integer> res = solution.findAnagrams("abab", "ab");
        System.out.println(res);
    }

    /**
     * 思路：s, p
     * 1. 定义一个左指针left指向最左边， 定义第二个指针right指向left + p.length()
     * 2. 将p中的字符转化为字符数组， 并进行排序
     * 3. 遍历s， 每次取p.length()个字符，并将其转化为字符数组， 并进行排序
     * 4. 将排序后的字符数组与p排序后的字符数组进行比较，如果相等，则将left放入结果数组
     * 5. 不相等，则left++， right++
     */
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int sLen = s.length();
            int left = 0;
            int right = left + p.length();

            //将p转化为字符数组并进行排序
            char[] pChars = p.toCharArray();
            Arrays.sort(pChars);

            char[] sChars = s.toCharArray(); //将s转化为字符数组

            List<Integer> res = new ArrayList<>(); //用于存储结果

            //遍历s
            for(; left <= s.length() - p.length(); left++){
                //将s从left开始，取p.length()个字符，并转化为字符数组
                char[] temp = Arrays.copyOfRange(sChars, left, right);
                Arrays.sort(temp);

                //将排序后的字符数组与p排序后的字符数组进行比较
                if(Arrays.equals(temp, pChars)){
                    res.add(left);
                }
                right++;
            }
            return res;
        }
    }


    //但是上述的方法时间复杂度太高了 复制数组导致空间复杂度也高

    /**
     * 优化思路： 使用滑动窗口 定长滑窗  s  p
     * 1. 先统计p中每个字符出现的次数 （定义一个p数组）
     * 2. 双指针划定窗口的边界，指针left从最左边开始移动，指针right从left + p.length()开始移动， 右指针所在的字符进入数组
     * 3。 统计窗口中的各个字符出现的次数 （定义一个s数组）
     * 5. 比较这两个数组是否相等， 如果相等， 则将left放入结果数组
     * 6. 无论是否相等，窗口移动，将s数组的left减少一个
     */

    static class Solution2 {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            int[] pCount = new int[26];
            int[] sCount = new int[26];

            //统计p中各个字符出现的数量
            for (char c : p.toCharArray()){
                pCount[c - 'a']++; //每出现一个相同的字符，数组数量加 1
            }

            //窗口开始滑动
            for (int right = 0; right < s.length(); right++){
                //将right指向的字符放入s数组统计
                sCount[s.charAt(right) - 'a']++; //统计right指向的字符出现的次数

                int left = right - p.length() + 1;//划定窗口的左边界

                //当left还未指向s数组的第一个字符时， 数组中的字符数量还不够， 不能进行比较
                if(left < 0){
                    continue;
                }

                //比较s数组和p数组是否相等
                if(Arrays.equals(pCount, sCount)){
                    result.add(left);
                }

                //每次移动窗口时，将最左边的字符从s数组中移除
                sCount[s.charAt(left) - 'a']--;
            }

            return result;
        }
    }
}
