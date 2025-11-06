package Leet2025_11;

/**
 * 42.接雨水
 * 2025.11.4
 * mjc
 */
public class main42 {

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] height = {1};
        int res = solution.trap(height);
        System.out.println(res);
        System.out.println("--------------------------");
    }

    /**
     * 接雨水
     * 思路：将蓝色部分也看做实心方块， 所以接水的面积（蓝色） = 所有方块（蓝色 + 黑色） - 黑色（数组之和）
     * 1. 一层一层计算 先把总面积算出来
     * 2. 定义双指针， 分别指向头和尾，定义层数h， h从1开始， 每次计算一层的面积
     * 3. 左右指针向中间移动， 当>h时停止， 每次h加一
     *
     */

    static class Solution {
        public int trap(int[] height) {
            int maxHeight = 0; //最大高度 总共有几层
            int sumArea = 0; //总面积 黑色+蓝色
            int sumBlack = 0; //黑色方块面积

            //先计算出最大高度
            for(int i = 0; i < height.length; i++){
                if(height[i] > maxHeight){
                    maxHeight = height[i];
                }
            }

            for (int h = 1; h <= maxHeight; h++){
                int left = 0;
                int right = height.length - 1;
                while(left < right){
                    if (height[left] < h){
                        left ++;
                    }
                    if (height[right] < h){
                        right --;
                    }
                    if (height[left] >= h && height[right] >= h){
                        sumArea = sumArea +  (right - left) + 1; //一层的总面积
                        break;
                    }
                }
            }

            for(int i = 0; i < height.length; i++){
                sumBlack = sumBlack + height[i]; //计算出黑色总面积
            }


            return Math.max(sumArea - sumBlack, 0); //返回接水面积
        }
    }
}
