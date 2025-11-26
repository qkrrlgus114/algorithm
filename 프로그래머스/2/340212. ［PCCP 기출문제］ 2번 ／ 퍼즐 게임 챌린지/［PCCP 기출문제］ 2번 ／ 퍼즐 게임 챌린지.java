class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100000;
        
        // 이분탐색을 통해 정답을 추출해야함.
        int s = 1;
        int e = 100000;
        while(s < e){
            int m = (s + e) / 2;
            
            long solvedTime = puzzle(diffs, times, m);
            
            if(limit >= solvedTime){
                answer = Math.min(answer, m);
                e = m;
            } else {
                s = m + 1;
            }
        }
        
        return answer;
    }
    
    private static long puzzle(int[] diffs, int[] times, int level){
        // 걸린 시간
        long time = times[0];
        
        for(int i=1; i<diffs.length; i++){
            if(diffs[i] <= level){
                time += times[i];
            } else {
                time += times[i] + ((times[i-1] + times[i]) * (diffs[i] - level));
            }
        }
        
        return time;
        
    }
}