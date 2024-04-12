// 보조 컨테이너 -> 스택
// 보조 컨테이너까지 이용하는데 몇 개를 실을 수 있는지

import java.util.*;

class Solution {
    static int count = 0;
    static Stack<Integer> subContainer = new Stack<>();
    static int index = 0;
    
    public int solution(int[] order) {
        Queue<Integer> mainContainer = new LinkedList<>();
        for(int i=1; i<=order.length; i++){
            mainContainer.add(i);
        }
        
        while(index < order.length){
            int target = order[index];
            // 메인 컨테이너 있는 경우
            if(!mainContainer.isEmpty()){
                if(mainContainer.peek() > target){
                    if(!checkSubContainer(target)) break;
                }else if(mainContainer.peek() == target){
                    mainContainer.poll();
                    count++;
                    index++;
                }else if(mainContainer.peek() < target){
                    subContainer.push(mainContainer.poll());
                }
            }else{
                if(!checkSubContainer(target)) break;
            }
        }
        
        return count;
    }
    
    
    // 서브 컨테이너 값 확인
    public static boolean checkSubContainer(int target){
        if(!subContainer.isEmpty()){
            if(subContainer.peek() != target) return false;
            subContainer.pop();
            index++;
            count++;
            return true;
        }
        return false;
    } 
}