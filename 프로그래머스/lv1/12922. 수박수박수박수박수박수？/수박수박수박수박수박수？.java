class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        if(n%2==0){ // 짝수면
            for(int i=0; i<n; i+=2){
                sb.append("수박");
            }
        }else{ // 홀수면
            if(n==1){
                return "수";
            }
            for(int i=0; i<n-1; i+=2){
                sb.append("수박");
            }
            sb.append("수");
        }
        return sb.toString();
    }
}