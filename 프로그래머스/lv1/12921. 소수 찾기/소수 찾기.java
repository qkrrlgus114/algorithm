class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        for(int i=2; i<Math.sqrt(n); i++){
            if(arr[i]!=0){
                for(int j=i*i; j<arr.length; j+=i){
                    arr[j] = 0;
                }
            }
        }
        int count = 0;
        for(int i=2; i<arr.length; i++){
            if(arr[i]!=0) count++;
        }
        return count;

    }
}