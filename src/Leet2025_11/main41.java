package Leet2025_11;


import java.util.Arrays;

/**
 * 41. 缺失的第一个正数
 * mjc
 * 2025.11.14
 */
public class main41 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        int[] nums = {0, 2, 2, 1, 1};

        int result = solution.firstMissingPositive(nums);
        System.out.println(result);
    }


    static class Solution {
        public int firstMissingPositive(int[] nums) {

            if (nums.length == 0) {
                return 1;
            }


            Arrays.sort(nums);

            int ans = 1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {

                    // 跳过重复元素
                    if (i > 0 && nums[i] == nums[i - 1]) {
                        continue;
                    }


                    if (nums[i] != ans) {
                        return ans;
                    }
                    ans++;
                }
            }

            return ans;
        }
    }


    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */


    /**
     * 如上方式虽然能够解决问题 但是时间复杂度过高 因此需要寻找更优的解决方案
     * <p>
     * 对于找到缺失的第一个元素 ， 可以通过交换位置的方式：从1开始的下表对应的应该是数字1 ， 2开始的下表对应的应该是数字2 ， 以此类推
     * 数组不在对应的位置上 就进行交换 直到数组在对应的位置上
     * 最后遍历数组 当找到第一个不在对应位置上的数字 则这个数字就是第一个缺失的证书
     */

    static class Solution2 {
        public int firstMissingPositive(int[] nums) {

            int length = nums.length; //数组的长度

            //遍历数组进行交换
            for (int i = 0; i < length; i++){

                //只要出现对应的下标和数字不相等的情况 就将这个数字换到对应的下标下面
                while (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]){

                    //交换 这个数字与对应的下标
                    int temp = nums[nums[i] - 1];
                    nums[nums[i] - 1] = nums[i];
                    nums[i] = temp;

                }
            }

            for (int i = 0; i < length; i++){
                if (nums[i] != i + 1){
                    return i + 1;
                }
            }

            return length + 1;

        }
    }


}
