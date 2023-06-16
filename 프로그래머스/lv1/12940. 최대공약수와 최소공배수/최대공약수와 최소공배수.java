class Solution {
    public int[] solution(int n, int m) {
        int max = gcd(n,m);
        int min = (n*m)/max;
        int[] result = new int[] {max, min};
        return result;
    }
    
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}