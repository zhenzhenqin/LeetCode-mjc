package Leet2025_11;

import java.util.HashMap;

/**
 * 53. 最大子数组和
 * mjc
 * 2025.11.10
 */
public class main53 {

    public static void main(String[] args) {

        int[] nums = {-1};
        Solution solution = new Solution();
        int maxSubArray = solution.maxSubArray(nums);
        System.out.println(maxSubArray);

    }



    /**
     * 思路：
     * 1. 使用前缀和
     * 2. 遍历数组 计算出前缀和 将前缀和存入哈希表中
     * 3. 遍历哈希表 计算出当前位置的前缀和 减去之前的前缀和 得到当前位置的子数组和
     * 4. 用当前位置的子数组和 与 max 比较 取较大值
     */
    static class errorSolution {
        public int maxSubArray(int[] nums) {
            int max = 0; //用来记录当前的最大值
            int preSum = 0; //用来记录当前的前缀和
            HashMap<Integer, Integer> map = new HashMap<>(); //下标以及前缀和

            for (int i = 0; i < nums.length; i++) {
                preSum = preSum + nums[i];
                map.put(i, preSum);
            }

            //遍历哈希表 每次获取当前的前缀和减去之前的前缀和 得到当前位置的子数组和
            for (int j = nums.length - 1; j > 0; j--) { //不能从递减到0 否则j会越界
                int curSum = map.get(j) - map.get(j - 1);
                max = Math.max(max, curSum);
            }

            //将max与nums[0]比较 取较大值
            max = Math.max(max, nums[0]);

            return max;
        }
    }


    /**
     * 错误原因：
     * 前缀和还是避免不了双重循坏
     */


    /**
     * 新思路：
     * 着眼于眼前，如果当前位置的加上之前的还是小于当前的， 说明之前的都是错误的， 那就从当前位置开始计算
     *
     * 动态规划
     */
    static class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            long max = Long.MIN_VALUE; //用来记录当前的最大值
            for (int i = 0; i < nums.length; i++){
                sum = sum + nums[i];
                if (sum < nums[i]){
                    sum = nums[i];

                }
                max = Math.max(max, sum);
            }
            return (int) max;
        }
    }
}
