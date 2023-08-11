import java.util.Arrays;

public class MinimumCoins {
    public static int minimumCoins(int[] ratings) {
        int n = ratings.length;

        // Initialize dp array to store the minimum number of coins required for each rider
        int[] dp = new int[n];
        // Initially, assign 1 coin to each rider
        Arrays.fill(dp,1);
        // Traverse the ratings from left to right
        for (int i = 1; i < n; i++) { // i = 1 so that the index doesn't go out of bound
            // If the current rider has a higher rating than the previous rider, assign more coins
            if (ratings[i] > ratings[i-1]) {
                dp[i] = dp[i-1] + 1;
            }
        }
        // Traverse the ratings from right to left
        for (int i = n - 2; i >= 0; i--) {
            // If the current rider has a higher rating than the next rider and has fewer coins, update the number of coins
            if (ratings[i] > ratings[i+1] && dp[i] <= dp[i+1]) {
                dp[i] = dp[i+1] + 1;
            }
        }

        // Calculate the total number of coins required
        int totalCoins = 0;
        for (int coins : dp) {
            totalCoins += coins;
        }

        return totalCoins;
    }

    public static void main(String[] args) {
        int[] ratings = {6,9,2};
        int minCoins = minimumCoins(ratings);
        System.out.println("Minimum number of coins required: " + minCoins);
    }
}

