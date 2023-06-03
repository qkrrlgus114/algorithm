class Solution {
    public String solution(String s) {
        // -32하면 대문자가 된다.
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ' '){
                cnt = 0;
            }else if(cnt==0 || cnt%2==0){ // 짝수이면
                cnt++;
                arr[i] = Character.toUpperCase(arr[i]);
            }else if(cnt%2==1){ // 홀수이면
                cnt++;
                arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}