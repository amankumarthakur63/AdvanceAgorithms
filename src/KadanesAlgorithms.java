
public class KadanesAlgorithms {


    // Brute Force Approach : O (n^2)

    public static int bruteForce (int[] nums) {
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int curSum = 0;
            for (int j = i; j < nums.length; j++) {
                curSum = nums[j];
                maxSum = Math.max(maxSum, curSum);
            }
        }
        return maxSum;
    }


    // Kadane's Algorithms : O(n)

    public static int kadane (int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;

        for (int n : nums) {
            curSum = Math.max(curSum, 0);
            curSum = curSum + n;
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }


    // Sliding Window
    // Return the left and right index of the max sub-array sum
    // assuming there's exactly one result (no ties)
    // Sliding window variation of Kadane's : O(n)

    public static int[] slidingWindow (int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        int maxL = 0;
        int maxR = 0;
        int l = 0;

        for (int r = 0; r < nums.length; r++) {
            if (curSum < 0) {
                curSum = 0;
                l = r;
            }
            curSum = curSum + nums[r];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxL = l;
                maxR = r;
            }
        }
        return new int[] {maxL, maxR};
    }

    public static void main(String[] args) {

    }
}