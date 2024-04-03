class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] result = new int[101];
        
        int pre_work = 0;
        int count = 0;
        for(int i=0; i<progresses.length; i++){
            int cur_progress = progresses[i];
            int cur_speed = speeds[i];
            int day = (100 - cur_progress) / cur_speed;
            if((100 - cur_progress) % cur_speed != 0) day += 1;
            if(pre_work >= day) result[pre_work]++;
            else{
                pre_work = day;
                result[pre_work]++;
            }
            if(result[pre_work] == 1) count++;
        }
        
        int[] answer = new int[count];
        int index = 0;
        for(int i=0; i<result.length; i++){
            if(result[i] != 0) answer[index++] = result[i];
        }
    
        return answer;
    }
}