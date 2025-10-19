class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = minutesToSeconds(video_len);
        int currentPos = minutesToSeconds(pos);
        int startOp = minutesToSeconds(op_start);
        int endOp = minutesToSeconds(op_end);
        
        for(int i=0; i<commands.length; i++){
            currentPos = jumpOpening(currentPos, startOp, endOp);
            
            if("prev".equals(commands[i])){
                currentPos = movePrev(currentPos);
            } else if("next".equals(commands[i])){
                currentPos = moveNext(currentPos, videoLen);
            } 
        }
        currentPos = jumpOpening(currentPos, startOp, endOp);
        
        String answer = secondsToMinutes(currentPos);
        
        return answer;
    }
    
    // 전체 영상 길이 치환(mm:ss -> s)
    public static int minutesToSeconds(String video_len){
        int minute = Integer.parseInt(video_len.substring(0, 2));
        int second = Integer.parseInt(video_len.substring(3));
        int result = 0;
        
        // 분 계산
        result += minute * 60;
        
        // 초 계산
        result += second;
        
        return result;
    }
    
    // 전체 영상 길이 치환(s -> mm:ss )
    public static String secondsToMinutes(int seconds){
        String minute = String.valueOf(seconds / 60);
        seconds %= 60;
        String second = String.valueOf(seconds);
        
        if(Integer.parseInt(minute) < 10){
            minute = "0" + minute;
        }
        if(Integer.parseInt(second) < 10){
            second = "0" + second;
        }

        return minute + ":" + second;
    }
    
    // 10초 이전으로 이동
    public static int movePrev(int currentPos){
        if(currentPos <= 10){
            return 0;
        } else {
            return currentPos - 10;
        }
    }
    
    // 10초 이후로 이동
    public static int moveNext(int currentPos, int videoLen){
        if(currentPos + 10 >= videoLen){
            return videoLen;
        } else {
            return currentPos + 10;
        }
    }
    
    // 오프닝 건너뛰기
    public static int jumpOpening(int currentPos, int startOp, int endOp){
        if(startOp <= currentPos && endOp >= currentPos){
            return endOp;
        } else {
            return currentPos;
        }
    }
}