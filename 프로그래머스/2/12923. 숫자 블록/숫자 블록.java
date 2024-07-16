class Solution {
    public int[] solution(long begin, long end) {
        int s = (int) begin;
        int e = (int) end;
        
        int[] answer = new int[(int) (e - s + 1l)];
        
        int index = 0;
        for(int i = s; i <= e; i++){
            if(i == 1){
                index++;
                continue;
            }
            answer[index++] = check(i);
        }
        
        return answer;
    }
    
    private static int check(int num){
        int result = 1;
        
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                if(i <= 10000000 && i != num){
                    result = Math.max(result, i);
                }
                if(num / i <= 10000000 && num / i != num){
                    result = Math.max(result, num / i);
                }
            }
        }
        
        return result;
    }
}