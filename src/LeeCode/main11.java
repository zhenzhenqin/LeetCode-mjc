package LeeCode;

/**
 * 11. 盛最多水的容器
 * 2025.11.2
 */
public class main11 {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxArea = new Solution().maxArea(height);
        System.out.println(maxArea);
    }

    /**
     * 思路：
     * 暴力求解（枚举法）
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     */

    /*static class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    int area = (j - i) * Math.min(height[i], height[j]);
                    maxArea = Math.max(maxArea, area);
                }
            }
            return maxArea;
        }
    }*/

    /**
     * 但是上述做法超时了
     * 因此需要缩短时间复杂度
     * 思路：
     * 1. 使用双指针， 一个指向最左边 另一个指向最右边
     * 2. 每次只移动所在位置高度较小的指针，
     * 3. 每次计算面积，更新最大面积
     * 4. 返回最大面积
     *
     * 因为这样做每次都会选择较大的高度，那么总体最大面积一定会出现在这些大的值之间
     * 时间复杂度：O(n)
     */
    static class Solution {
        public int maxArea(int[] height) {
            int left = 0; //最左边指针
            int right = height.length - 1; //最右边指针
            int maxArea = 0; //最大面积
            while (left < right) {
                int area = (right - left) * Math.min(height[left], height[right]);
                maxArea = Math.max(maxArea, area);
                if(height[left] < height[right]){
                    left ++;
                }else{
                    right --;
                }
            }
            return maxArea;
        }
    }
}
