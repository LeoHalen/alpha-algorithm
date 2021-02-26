package site.halenspace.algorithm.linked;

/**
 * LeetCode 162. 寻找峰值
 * @Author Zg.Li · 2021/2/26
 */
public class Solution162 {

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) >>> 1;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, left, mid);
        }

        return search(nums, mid, right);
    }
}
