package Leet2025_11;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 * mjc
 * 2025.11.7
 */
public class main560 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,0,0,0,0,0,0,0,0,0};
        int k = 0;
        int result = solution.subarraySum(nums, k);
        System.out.println(result);
    }


    /**
     * 思路：前缀和 + 哈希表
     * 1. 先遍历一次数组 将前缀和做为主键， 出现的次数做为值存入哈希表中
     * 2. 遍历数组，每次将前缀值减去k，如果哈希表中存在这个值， 则计数器加上这个值的个数
     * 3. 然后判断这个前缀值是否在哈希表中，没有插入， 有的话次数加1
     *
     */

    static class Solution {
        public int subarraySum(int[] nums, int k) {
            int count = 0; //计数器计算子数组的个数
            Map<Integer, Integer> map = new HashMap<>();
            int preSum = 0; //计算前缀和

            for (int num : nums) {
                preSum = preSum + num;

                if (preSum == k) {
                    count++;
                }

                if (map.containsKey(preSum - k)) {
                    count = count + map.get(preSum - k); //如果哈希表中存在这个值， 则将计数器加上这个值的个数
                }

                //将前缀值存入哈希表中
                //getOrDefault : 如果哈希表中不存在这个值， 则返回0， 否则返回这个值的value
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);
            }

            return count;
        }
    }
}
