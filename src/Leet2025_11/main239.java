package Leet2025_11;

/**
 * 239. 滑动窗口最大值
 * mjc
 * 2025.11.8
 */
public class main239 {

    public static void main(String[] args) {
        int[] nums = {-7,-8,7,5,7,1,6,0};
        int k = 4;
        Solution2 solution = new Solution2();
        int[] res = solution.maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.println(i);
        }
    }


    /**
     * 思路:
     * 首先采用暴力解法
     * 1. 定义双指针 一个用来划定滑动窗口的边界范围 另一个用来遍历元素获得最大值
     * 2. 定义一个变量用来记录当前滑动窗口的最大值
     */

    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int left = 0;
            int right = k - 1;
            short max = Short.MIN_VALUE; //计算每次最大值
            int[] res = new int[nums.length - k + 1]; //存放结果数组

            while (right < nums.length) {
                for (int i = left; i <= right; i++){
                    max = (short) Math.max(max, nums[i]);
                }
                res[left] = max;

                //移动窗口
                left++;
                right++;
                max = Short.MIN_VALUE; //重置最大值
            }
            return res;
        }
    }

    /**
     * 但是暴力解法的时间复杂度过高 于是使用其他方式来解决
     *
     * 思路2：
     * 1. 记录下标
     * 2. 如果当前进入的元素大于之前的最大值，则更新最大值
     * 3. 如果当前进入的元素小于之前的最大值，判断之前的最大值是否还在窗口中，如果在窗口内 则最大值不变，如果不在，则重新找到最大值
     */
    static class Solution2 {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int left = 0;
            int right = k - 1;
            short max = Short.MIN_VALUE; //计算每次最大值
            int[] res = new int[nums.length - k + 1]; //存放结果数组
            int temp = 0; //记录之前的最大值的下标

            // 先遍历一次 找到第一个窗口的最大值
            for (int i = 0; i < k; i++){
                max = (short) Math.max(max, nums[i]);
                if (nums[i] == max){
                    temp = i; //记录最大值的下标
                }
            }
            res[left] = max; // 第一个窗口的最大值

            //更新窗口
            left++;
            right++;

            //遍历剩余元素
            for (;right < nums.length && left <= right; left++, right++){
                //如果当前进入的元素大于或者等于之前的最大值，则直接更新最大值
                if (nums[right] >= max){
                    res[left] = nums[right];
                    max = (short) nums[right];
                }

                //如果当前进入的元素小于之前的最大值，
                if (nums[right] < max){
                    //则判断之前的最大值是否还在滑动窗口内
                    if (temp < left){
                        //之前的最大值不在窗口内 则需要重新获取最大值
                        max = Short.MIN_VALUE;
                        for (int i = left; i <= right; i++){
                            max = (short) Math.max(max, nums[i]);
                            if (nums[i] == max){
                                temp = i; //记录最大值的下标
                            }
                            res[left] = max;
                        }
                    }else {
                        //之前的最大值还在窗口中 则最大值不变
                        res[left] = max;
                    }
                }
            }

            return res;
        }
    }
}
