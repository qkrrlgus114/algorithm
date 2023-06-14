class Solution {
    public static int[] sel = new int[3];
    public static int n;
    public static int r = 3;
    public static int count = 0;

    public int solution(int[] nums) {
        // 조합을 이용해서 풀자. n개중에서 r개를 뽑음.
        n = nums.length;
        combination(0, 0, nums);
        return count;
    }
    
    public void combination(int idx, int sidx, int[] nums){
        // 종료 조건
        // 1. 다 뽑았을 경우
        if(sidx==r){
            int sum = 0;
            for(int i=0; i<sel.length; i++){
                sum+=sel[i];
            }
            int temp = 0;
            for(int i=sum; i>=1; i--){
                if(sum%i==0) temp++;
            }
            if(temp<=2) count++;
            
            return;
        }
        
        // 2. 다 고려했을 경우
        if(idx==n) return;
        
        sel[sidx] = nums[idx];
        combination(idx+1, sidx+1, nums); // 뽑아서 다음 자리 고려
        combination(idx+1, sidx, nums) ; // 안 뽑고 다음 자리 고려
    }
}