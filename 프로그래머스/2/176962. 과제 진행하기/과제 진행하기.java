import java.util.*;

class Solution {
    
    static List<String> answer = new ArrayList<>();
    static Study study = null;
    static Stack<Study> s = new Stack<>();
    
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, new Comparator<String[]>(){
            public int compare(String[] o1, String[] o2){
                return o1[1].compareTo(o2[1]);
            }
        });
        
        // 과제 순서
        int index = 0;
        int curTime = 0;
        for(int t=0; t<1440; t++){
            // 현재 진행중인 과제가 있다면
            if(study != null){
                // 시간 감소 후 0이면 완료에 추가
                study.time -= 1;
                if(study.time == 0){
                    answer.add(study.name);
                    study = null;
                }
            }
            // 과제를 시작해야 하는 시간이라면
            if(t == changeTime(plans[index][1])){
                // 이전 과제가 있는지 판단
                if(study != null){
                    s.push(study);
                }
                study = new Study(plans[index][0], changeTime(plans[index][1]),
                                  Integer.parseInt(plans[index][2]));
                index++;
                if(index == plans.length){
                    curTime = t;
                    break;
                }
            }else{
                if(s.size() != 0 && study == null){
                    study = s.pop();
                }
            }
        }
        
        if(study != null){
            answer.add(study.name);
            
            while(s.size() != 0){
                study = s.pop();
                answer.add(study.name);
            }
        }

        System.out.println(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    // 00:00 -> 0 (int로 시간 변환)
    private static int changeTime(String time){
        int result = 0;
        String[] times = time.split(":");
        result += (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
        
        return result;
    }
}

class Study{
    String name;
    int start;
    int time;
    
    public Study(String name, int start, int time){
        this.name = name;
        this.start = start;
        this.time = time;
    }
}