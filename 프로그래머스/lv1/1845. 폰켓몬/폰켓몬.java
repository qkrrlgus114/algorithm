class Solution {
    public int solution(int[] nums) {
        int[] count = new int[200001];
        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }
        int possible = nums.length/2;
        int cnt = 0;
        for(int i=0; i<count.length; i++){
            if(count[i]!=0) cnt++;
        }
        if(possible<cnt) return possible;
        else return cnt;
    }
}