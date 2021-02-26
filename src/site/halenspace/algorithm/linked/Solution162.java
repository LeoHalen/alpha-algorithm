package site.halenspace.algorithm.linked;

/**
 * LeetCode 162. 寻找峰值
 * @Author Zg.Li · 2021/2/26
 */
public class Solution162 {

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    /**
     * 解法一：递归二分查找
     * 最坏时间复杂度：O(logN)
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int search(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) >>> 1;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, left, mid);
        }

        return search(nums, mid + 1, right);
    }

    /**
     * 解法二：数组一次遍历
     * 最坏时间复杂度：O(N)
     * @param nums
     * @return
     */
    public int search(int[] nums) {
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }

        return nums.length - 1;
    }
}
