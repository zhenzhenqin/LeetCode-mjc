package Leet2025_11;

/**
 * 238. 除自身以外数组的乘积
 */
public class main238 {

    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        Solution solution = new Solution();
        int[] ans = solution.productExceptSelf(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }


    /**
     * 思路:
     * 1. 先计算每个元素的前缀积
     * 2. 再计算每个元素的后缀积
     */

    static class Solution {
        public int[] productExceptSelf(int[] nums) {

            int[] ans = new int[nums.length];

            int pre = 1; //前缀积
            int suf = 1; //后缀积

            //先计算前缀积
            for (int i = 0; i < nums.length; i++) {
                ans[i] = pre;           //1 -1 -1 0 0
                pre = pre * nums[i];    //-1 -1  0 0 0
            }

            //然后计算后缀积
            for (int j = nums.length - 1; j >= 0; j--){
                ans[j] = ans[j] * suf;
                suf = suf * nums[j];
            }


            return ans;
        }
    }
}
