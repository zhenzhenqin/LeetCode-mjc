package Leet2025_11;


import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * 2025.11.3
 */
public class main167 {

    public static void main(String[] args) {

        int[] numbers = {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] twoNum = solution.twoSum(numbers, target);
        System.out.println(Arrays.toString(twoNum));
    }


    /**
     *  思路：
     *  关注两个点：因为是非递减数组
     *  1。 当最小的数值和最大的数值之和大于目标值时， 说明最大值和任何值都会大于目标值，因此可以排除
     *  2。 当最小的数值和最大的数值之和小于目标值时， 说明最小值和任何值都会小于目标值，因此可以排除
     */

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right){
                int sum = numbers[left] + numbers[right];
                if(sum > target){
                    right--;
                }else if(sum < target){
                    left++;
                }else{
                    return new int[]{left +1, right +1};
                }
            }
            return new int[]{-1, -1};
        }
    }
}
