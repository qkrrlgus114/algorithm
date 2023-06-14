import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            map.add(nums[i]);
        }
        int possible = nums.length/2;
        if(map.size() < possible) return map.size();
        else return possible;
    }
}