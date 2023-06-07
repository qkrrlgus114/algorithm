class Solution {
    public int solution(int a, int b, int n) {
        int temp = 0; // 바꾸고 남은 콜라병 수
        int result = 0; // 여태 바꾼 콜라병 수
        while(true){
           if(a<=n){
               temp = temp+(n%a);
               n = (n/a)*b;
               result += n;
           }else if(a<=n+temp){
               n+=temp;
               temp = 0;
           }else{
               break;
           }
        }
        return result;
    }
}