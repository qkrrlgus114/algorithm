import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    
        Queue<Integer> bridge = new LinkedList<>();
        int time = 0;
        int index = 0;
        int totalWeight = 0;
        
        while(index != truck_weights.length){
            if(bridge.isEmpty()){
                bridge.add(truck_weights[index]);
                time++;
                totalWeight += truck_weights[index++];
            }else{
                if(bridge.size() == bridge_length){
                    int truck = bridge.poll();
                    totalWeight -= truck;
                }else if(totalWeight + truck_weights[index] > weight){
                    bridge.add(0);
                    time++;
                }else if(totalWeight + truck_weights[index] <= weight){
                    bridge.add(truck_weights[index]);
                    time++;
                    totalWeight += truck_weights[index++];
                }
            }
        }
        return time + bridge_length;
    }
}