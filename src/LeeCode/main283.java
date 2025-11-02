package LeeCode;

/**
 * 283. 移动零
 */
public class main283 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0,1,0,3,12};
        solution.moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 思路：
     * 1. 创建两个指针，一个指向起始位置，以一个指向结束位置，遍历数组
     * 2. 如果当前位置的元素为0 ， 则和结束位置的元素交换位置，结束指针往前移一个,当前指针往后移动一个
     * 3. 如果当前位置的元素不为0， 则当前指针（left）往后移动一个
     */

    /*static class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0; //初始指针
            int right = nums.length - 1; //结束指针指向数组最后一个元素
            while(left <= right){
                if(nums[left] == 0){
                    //交换两个指针所在的元素
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    right--;
                    left++;
                }else{
                    left++;
                }
            }
        }
    }*/

    /**
     * 思路： 之前的方法因为交换之后会改变之前的顺序，所以不能使用
     * 1. 创建两个指针，一个用于固定位置，另一个用于遍历数组
     * 2. 如果当前位置为0， 则直接跳过
     * 3. 如果当前位置不为0，则将当前位置的元素赋值给固定位置的指针所在的元素，固定位置的指针往后移动
     * 4. 遍历结束后，固定位置的指针之后的元素全部为0
     */
    static class Solution {
        public void moveZeroes(int[] nums) {
            int left = 0; //用于固定当前位置
            int right = 0; //用于遍历数组去寻找不为0的元素
            while(right <= nums.length - 1){
                if(nums[right] == 0){
                    //如果当前位置为0 则直接跳过 往后移动
                    right++;
                }else{
                    //如果当前位置不为0 则将当前位置的元素赋值给固定位置的指针所在的元素，固定位置的指针以及当前位置指针都往后移动
                    nums[left] = nums[right];
                    left++;
                    right++;
                }
            }

            //将其余位置全部设置为0
            while(left <= nums.length - 1){
                nums[left] = 0;
                left++;
            }
        }
    }
}
