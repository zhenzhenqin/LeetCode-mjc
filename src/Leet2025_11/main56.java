package Leet2025_11;

import java.util.Arrays;

/**
 * 56. 合并区间
 * mjc
 * 2025.11.11
 */
public class main56 {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        Solution solution = new Solution();
        int[][] res = solution.merge(intervals);
        for(int[] interval : res){
            System.out.println(interval[0] + " " + interval[1]);
        }
    }


    /**
     * 思路：
     * 1. 先将区间按照左端点进行排序
     * 2. 遍历排序后的区间，如果当前区间的右端点大于下一个区间的左端点，则两个区间可以合并
     * 3. 如果当前区间的右端点小于下一个区间的左端点，则两个区间不能合并
     */

    static class Solution {
        public int[][] merge(int[][] intervals) {
            //按照区间左端点进行排序
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));   //升序

            //遍历排序之后的数组
            int[][] res = new int[intervals.length][2];

            int index = 0; //记录合并区间的索引

            for (int i = 0; i < intervals.length; i++){
                //区间的右端点小于下一个区间的左端点，则两个区间不能合并
                if (index == 0 || res[index-1][1] < intervals[i][0]){
                    res[index] = intervals[i];
                    index++;
                }else{
                    //区间的右端点大于等于下一个区间的左端点，则两个区间可以合并
                    res[index-1][1] = Math.max(res[index-1][1], intervals[i][1]);
                }
            }
             //返回合并后的区间数组
             return Arrays.copyOf(res, index);
        }
    }
}
