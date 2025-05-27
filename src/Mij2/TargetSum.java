package Mij2;

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, 0, 0, target);
    }

    private int dfs(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            return currentSum == target ? 1 : 0;
        }

        return dfs(nums, index + 1, currentSum + nums[index], target) +
                dfs(nums, index + 1, currentSum - nums[index], target);
    }
}
