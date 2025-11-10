package Leet2025_11;

/**
 * 76. 最小覆盖子串
 * mjc
 * 2025.11.9
 */
public class main76 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = solution.minWindow(s, t);
        System.out.println(res);
    }


    /**
     * 思路：s t
     * 1. 先统计t中每个字符出现的次数
     * 2. 定义双指针，left固定位置， right向右移动
     * 3. 当不涵盖时， right向右移动，直到涵盖
     * 4. 当涵盖时， left向右移动，直到不涵盖，记录当前的子串以及长度
     * 5. 重复3，4，直到right到达s的末尾
     */

    static class Solution {
        public String minWindow(String s, String t) {
            int[] cntS = new int[128]; //记录当前窗口内的字符出现次数
            int[] cntT = new int[128]; //记录t中每个字符出现的次数

            for (char c : t.toCharArray()){
                cntT[c] ++;
            }

            char[] S = s.toCharArray(); //将s转换为字符数组，方便操作

            int left = 0;
            int right = 0;
            int minLen = Integer.MAX_VALUE;
            int minStart = 0;

            if (s.length() < t.length()){
                return "";
            }

            for (; right < s.length(); right++){
                cntS[S[right]] ++; //将当前字符加入窗口

                //判断是否涵盖
                while(isCovered(cntS, cntT)){ //涵盖
                    //更新最小窗口信息
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1;
                        minStart = left;
                    }
                    //缩小left的范围来找到更小的子串
                    cntS[S[left]] --;
                    left ++;
                }
            }

            return s.substring(left - 1, right);
        }
    }



    /**
     * 判断是否涵盖
     */
    private static boolean isCovered(int[] cntS, int[] cntT){
        for (int i = 'A'; i < 'Z'; i++){
            if(cntS[i] < cntT[i]){
                return false;
            }
        }

        for (int i = 'a'; i < 'z'; i++){
            if(cntS[i] < cntT[i]){
                return false;
            }
        }

        return true;
    }
}
