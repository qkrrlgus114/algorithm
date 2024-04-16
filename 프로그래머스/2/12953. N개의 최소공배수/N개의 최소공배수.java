// 유클리드 호제법 써야함. -> 최대 공약수 구하기
// 최소 공배수 = A * B / AB의 최대 공약수

class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1) return arr[0];
        int g = gcd(arr[0], arr[1]);
        int result = (arr[0] * arr[1]) / g;
        
        if(arr.length > 2){
            for(int i=2; i<arr.length; i++){
                g = gcd(result, arr[i]);
                result = (result * arr[i]) / g;
            }
        }
        return result;
    }
    
    public static int gcd(int a, int b){
        int r = a % b;
        if(r == 0) return b;
        else return gcd(b, r);
    }
}