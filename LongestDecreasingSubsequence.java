public class LongestDecreasingSubsequence {
    public int lds(int[] nums , int k ) {
        if(nums==null || nums.length==0){ //array ko size 0 cha vane 0 return
            return 0;
        }
        int[] dp = new int[nums.length];
        int length = 1;
        for(int i=0; i<nums.length-1;i++){ //i = 2
            dp[i]=1;
            for(int j=0; j<i; j++){ // dpindex vaneko dp ko lagi track garnu banako
                if(nums[j]>nums[i] && nums[i]-nums[i+1] <=k){  // nums >nums4
                    dp[i]=Math.max(dp[i],dp[j]+1);//dp ko 4th index ma dp[4], dp[3]+1 // its like increasing the count
                    length=Math.max(dp[i],length);
                }
            }
        }
        return length;
    }
    public static void main(String[] args) {
        LongestDecreasingSubsequence l = new LongestDecreasingSubsequence();
        int arr[] = {8,5,4, 2, 1, 4, 3, 4, 3, 1, 15};
        System.out.print("The subsequence has a length of "+l.lds(arr,3));
    }
}
