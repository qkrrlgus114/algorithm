import java.util.*;

class Solution {
    // 기본 시간, 기본 요금, 단위 시간, 단위 요금
    static int initTime, initFee, overTime, overFee;
    
    public int[] solution(int[] fees, String[] records) {
        initTime = fees[0];
        initFee = fees[1];
        overTime = fees[2];
        overFee = fees[3];
        // 입차 시간 기록
        Map<String, Integer> inTime = new HashMap<>();
        // 누적 요금 기록
        Map<String, Integer> totalFee = new HashMap<>();
        
        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            if(record[2].equals("IN")){
                inTime.put(record[1], changeInTime(record[0]));
            }else{
                int totalTime = calculatorTime(inTime.get(record[1]), record[0]);
                totalFee.put(record[1], totalFee.getOrDefault(record[1], 0) + totalTime);
                inTime.remove(record[1]);
            }
        }
        
        // 아직 출차 기록 없는 요금 계산
        for(String key : inTime.keySet()){
            int totalTime = calculatorTime(inTime.get(key), "23:59");
            totalFee.put(key, totalFee.getOrDefault(key, 0) + totalTime);
        }
        
        // 오름차순 정렬
        List<String> list = new ArrayList<>();
        for(String key : totalFee.keySet()){
            list.add(key);
        }
        Collections.sort(list);
        
        // 정답 배열
        int[] result = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            int fee = calculatorFee(totalFee.get(list.get(i)));
            result[i] = fee;
        }

        return result;
    }
    
    // 입차 시간 변환
    public static int changeInTime(String inTime){
        int hour = Integer.parseInt(inTime.substring(0, 2));
        int min = Integer.parseInt(inTime.substring(3, 5));
        
        return hour * 60 + min;
    }
    
    // 출차 시간 - 입차 시간
    public static int calculatorTime(int inTime, String outTime){
        int hour = Integer.parseInt(outTime.substring(0, 2));
        int min = Integer.parseInt(outTime.substring(3, 5));
        
        int outMin = hour * 60 + min;
        
        return outMin - inTime;
    }
    
    // 요금 계산
    public static int calculatorFee(int time){
        int fee = initFee;
        if(time <= initTime) return fee;
        
        time -= initTime;
        if(time % overTime == 0){
            fee += (time / overTime) * overFee;
        }else{
            fee += (time / overTime) * overFee + overFee;
        }
        
        return fee;
    }

}