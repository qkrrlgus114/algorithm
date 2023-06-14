import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[score.length];
        for(int i=0; i<score.length; i++){
            if(pq.size() < k){
                pq.add(score[i]);
                result[i] = pq.peek();
            }else if(pq.size() >= k){
                if(pq.peek() < score[i]){
                    pq.poll();
                    pq.add(score[i]);
                    result[i] = pq.peek();
                }else{
                    result[i] = pq.peek();
                }
            }
        }
        return result;
    }
}