// Given a list of coins of distinct denominations arr and the total amount of money. 
// Find the minimum number of coins required to make up that amount. Output -1 if that money cannot be made up using given coins.
class Solution {
    static int find(int[] arr, int sum, int[] dp) {
        if(sum<0) return Integer.MAX_VALUE;
        if(sum==0) return 0;
        if(dp[sum]!=-1)  return dp[sum];
        int ans=Integer.MAX_VALUE;
        for(int a:arr){
            int k=find(arr,sum-a,dp);
            if(k!=Integer.MAX_VALUE) ans=Math.min(ans,k+1);
        }
        return dp[sum]=ans;
    }
    public int MinCoin(int[] arr, int sum) {
        // Code here
        int[] dp=new int[sum+1];
        Arrays.fill(dp,-1);
        int ans=find(arr,sum,dp);
        return ans==2147483647?-1:ans;
    }
}
