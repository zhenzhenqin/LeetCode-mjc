package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 加油mjc
 * 2025.11.3
 */
public class main15 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    /**
     * 思路：
     * 遍历数组， 固定一个数， 转化为求两数之和的问题
     *
     * 对于两数之和问题 先将数组进行排序 使用双指针 一个指向最左边 另一个指向最右边
     * 1.如果这三个数字和大于0，则说明最小的和最大值的和都大于0， 则说明这三数之和一定大于0， 因此right--
     * 2.如果这三个数字和小于0，则说明最小的和最大值的和都小于0， 则说明这三数之和一定小于0， 因此left++
     * 3.如果这三个数字和等于0，则说明这三数之和等于0， 则说明这三数之和等于0， 因此记录这三个数字
     * 4.为了避免重复记录，如果一个数字等于前面一个数字（对于right， 则是等于后面一个数字）， 则跳过这个数字
     *
     *
     * 两个优化：
     * 1. 如果当前的数字与接下来最小的两个和大于0，则一定会大于0，直接跳出循环
     * 2. 如果当前i数字与最后两个最大的数字之和小于0， 则这个内层循环一定小于0， 说明可以直接跳出这个内层循环
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            Arrays.sort(nums);
            //i < j < k
            for (int i = 0; i < nums.length - 2; i++){
                //如果当前的数字与接下来最小的两个和大于0，则一定会大于0，直接跳出循环
                if(nums[i] + nums[i + 1] + nums[i + 2] > 0){
                    break;
                }

                //如果当前i数字与最后两个最大的数字之和小于0， 则这个内层循环一定小于0， 说明可以直接跳出这个内层循环
                if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0){
                    continue;
                }

                //如果等于前面一个数字
                if(i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }
                int left = i + 1; //最左边
                int right = nums.length - 1; //最右边

                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    //如果这三个数的和==0
                    if (sum < 0){
                        //这三个数字一定小于0， 左边增加
                        left++;
                    }else if (sum > 0){
                        //这三个数字一定大于0， 右边减小
                        right--;
                    }else {
                        lists.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        //如果等于后面一个数字
                        while(left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        //如果等于前面一个数字
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }
                }

            }
            return lists;
        }
    }
}