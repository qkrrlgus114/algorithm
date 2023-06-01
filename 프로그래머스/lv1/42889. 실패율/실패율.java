import java.util.Arrays;
class Solution {
    public int[] solution(int N, int[] stages) {
        // 실패율 = 스테이지 도달했으나 아직 클리어 못한 플레이어 수 / 스테이지 도달한 플레이어 수
        // 원본 스테이지는 유지를 해둬야할듯?
        // 우선 정렬
        // 1스테이지부터 cnt = 1, cnt/N(1/8), N-=cnt, 
        int M = stages.length; // 전체 스테이지 개수
        int[] origin = Arrays.copyOf(stages, stages.length); // 원본 유지
        Arrays.sort(stages);
        int max = N+1;
        double[] newArr = new double[max-1]; // 최댓값으로 새로운 배열 만듦
        int[] result = new int [N]; // 최종 배열
        int cnt = 0; // 해당 스테이지 인원
        int start = 0; // 시작할 지점
        for(int i=1; i<max; i++){ // 1스테이지부터 탐색
            for(int j=start; j<stages.length; j++){ // 0번부터 i번째 스테이지에 몇 명 있는지 탐색
                if(stages[j] == i){ // 같으면 인원 더해주고
                    cnt++;
                }else{ // 다르면
                    if(cnt==0){ // cnt가 0이면 해당 인원이 아예 없으니
                        break;
                    }else{ // 해당 인원이 한 명이라도 있는 거
                        start = j;
                        break;
                    }  
                }
            }
            if(cnt!=0){
                newArr[i-1] = (double)cnt/M;
                M-=cnt;
                cnt=0;
            }else{
                newArr[i-1] = 0;
            }
        }
        double maxLast = -123124213;
        int index = 0;
        for(int i=0; i<newArr.length; i++){
            for(int j=0; j<newArr.length; j++){
                if(maxLast<newArr[j]){
                    maxLast = newArr[j];
                    index = j;
                }
            }
            result[i] = index+1;
            newArr[index] = -1;
            maxLast = -123124213;
            index = 0;
        }
        return result;
    }
}