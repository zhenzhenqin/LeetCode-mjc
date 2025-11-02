package LeeCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * [9,1,4,7,3,-1,0,5,8,-1,6]
 * [-1, -1, 0, 1, 3, 4, 5, 6, 7, 8, 9]
 */
public class main128 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 2};
        Solution solution = new Solution();
        int res = solution.longestConsecutive(nums);
        System.out.println(res);
    }

    /**
     * nums = [100,4,200,1,3,2]
     * 思路：
     * 1.先将数组进行排序 [1， 2， 3， 4， 100， 200]
     * 2. 遍历数组，如果当前数字不等于前一个数字+1，则说明是一个新的连续序列;
     * 3. 如果等于前一个数字+1，则说明是一个连续的序列，记录当前连续数列的长度，并更新最长连续序列的长度
     * 4. 返回最长连续序列的长度
     */

    static class Solution {
        public int longestConsecutive(int[] nums) {
            //数组为空
            if(nums.length == 0) return 0;

            if(nums.length == 1) return 1;

            //数组不为空 进行排序
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            int maxLength = 0;
            int currentLength = 1;

            for(int i = 1; i < nums.length; i++){
                //对于后一个和前一个相同的情况 跳过
                if(nums[i] == nums[i-1]) {
                    continue;
                }else if(nums[i] != nums[i-1] + 1){
                    //当前不连续 重置长度
                    maxLength = Math.max(maxLength, currentLength); //更新最长连续序列的长度
                    currentLength = 1;
                } else {
                    currentLength++; //继续递增当前连续序列的长度
                }
            }
            //最后比较一下当前连续序列的长度和最长连续序列的长度
            maxLength = Math.max(maxLength, currentLength);
            return maxLength;
        }
    }

    /**
     * 因为排序的时间复杂度是O(nlogn)，如果要时间复杂度为O(n)，那么只能使用哈希表
     * 思路：
     * 1. 创建一个哈希表，将数组中的全部元素添加到哈希表中
     * 2. 遍历哈希表集合，对于任何一个元素x，判断是否有x-1在集合中，如果有则跳过。因为以 x−1 为起点计算出的序列长度，一定比以 x 为起点计算出的序列长度要长！这样可以避免大量重复计算
     * 3. 如果无，则x为初始元素，那么再判断有无x+1在集合中，如果有，则连续序列的长度+1
     *
     */
    static class Solution1 {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i); // 遍历数组，将所有元素添加到哈希表
            }

            //遍历哈希数组
            int maxLength = 0;
            for (int i : set) {
                //判断有无x-1在集合中,有的话则跳过
                if (set.contains(i - 1)) {
                    continue;
                }

                int currentLength = 1;
                //此时i为连续数列的初始值
                //判断i+1是否在集合中，有的话连续长度+1
                while (set.contains(i + 1)) {
                    currentLength++;
                    i++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
            return maxLength;
        }
    }
}
