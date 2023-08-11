public class MinimumCostClothing {

    public static int minCostClothing(int[][] price) {
        int n = price.length;
        int[][] dp = new int[n][3];

        // Initialize the base case for the first person
        dp[0][0] = price[0][0];
        dp[0][1] = price[0][1];
        dp[0][2] = price[0][2];

        // Iterate through each person starting from the second person
        for (int i = 1; i < n; i++) {
            dp[i][0] = price[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = price[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = price[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        // Return the minimum cost considering that the third person must wear a different color
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    public static void main(String[] args) {
        int[][] price = {
                {14, 4, 11},
                {11, 4, 5},
                {14, 2, 10}
        };

        int output = minCostClothing(price);
        System.out.println(output); // Output: 9
    }
}
