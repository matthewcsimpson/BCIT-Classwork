public class LongestIncreasingSubsequence {
    
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0; // if there are no nums, return 0. 

        int[] dp = new int[nums.length]; // a new array of the same length as nums
        
        for (int i = 0; i < dp.length; i++) { // loop DP
            dp[i] = 1; // Each element is an increasing subsequence of at least length 1.
        }

        for (int i = 1; i < nums.length; i++) { // loop over nums from the second index 
            for (int j = 0; j < i; j++) { // loop over the remaining elements 
                if (nums[i] > nums[j]) { // if the value of the element in the first loop is higher than the element in the scond loop, updated dp with either the current dp[i] or the current dip[j+1]
                    dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }
        }

        // Find the maximum value in dp array
        int maxLength = 0; 
        for (int length : dp) {
            maxLength = Math.max(maxLength, length); // loop over dp.  if the current value is longer than the stored value, update the stored value
        }

        return maxLength; // The length of the longest increasing subsequence.
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums)); // Output: 4
    }
}
