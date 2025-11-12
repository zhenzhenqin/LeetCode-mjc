package Leet2025_11;

/**
 * 189. 轮转数组
 * mjc
 * 2025.11.18
 */
public class main189 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Solution2 solution = new Solution2();
        solution.rotate(nums, k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }


    /**
     * 思路：
     * 1. 从后往前开始遍历 将每个元素往后移动k个位置
     * 2. 将前面补全最后几个元素
     *
     * 对于k大于数组长度的情况 则取k对数组长度的余数
     */
    static class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            int j = 0;
            k = k % len;

            int[] temp = new int[k]; //用于存放最后几个元素

            for (int i = len - k; i < len; i++) {
                temp[j] = nums[i];
                j++;
            }

            for (int i = len - k - 1; i >= 0; i--) {
                nums[i + k] = nums[i];
            }

            for (int i = 0; i < k; i++) {
                nums[i] = temp[i];
            }
        }
    }


    /**
     * 优化：
     * 如：1, 2, 3, 4, 5, 6, 7
     * 1. 先将整个数组反转 如：7, 6, 5, 4, 3, 2, 1
     * 2. 再将前k个元素反转 如：5, 6, 7, 4, 3, 2, 1
     * 3. 最后将后面的元素反转 如：5, 6, 7, 1, 2, 3, 4
     */
    static class Solution2 {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = k % len;

            //反转整个数组
            reverse(nums, 0, len - 1);
            reverse(nums, 0, k - 1); //反转前k个元素
            reverse(nums, k, len - 1); //反转后面的元素
        }
    }


    private static void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
