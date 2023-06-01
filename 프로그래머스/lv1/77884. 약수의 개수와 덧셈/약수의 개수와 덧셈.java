class Solution {
    public int solution(int left, int right) {
        int result = 0; // 전체의 합
        int cnt = 0; // 약수의 개수
        int max = right; // j의 최대 범위
        for(int i=left; i<=right; i++){
            for(int j=1; j<max; j++){
                for(int k=i; k>=1; k--){
                    if(j==k && j*k == i){
                        cnt+=1;
                    }
                    else if(j*k == i){
                        cnt+=2; // 곱했을 때 값이 나오면 약수 개수 2+
                        max = k;
                    } 
                    if(j*k < i) {
                        break; // 곱했는데 값보다 작아지면 끝
                    }
                }
            }
            if(cnt%2 == 0){ // 짝수면
                result += i;
            }else{ // 홀수면
                result -= i;
            }
            cnt = 0;
            max = right;
        }
        return result; 
    }
}