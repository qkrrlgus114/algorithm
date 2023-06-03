class Solution {
    public String solution(String s, int n) {
        char[] arr = new char[s.length()];
        arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == ' '){
                continue;
            }
            // a:97, z:122 A:65, Z:90
            if((int)arr[i]>=97 && (int)arr[i]<=122){
                if((int)arr[i]+n > 122){ // 소문자인데 z를 넘어가는 경우
                    int temp = arr[i]+n;
                    temp-=123;
                    arr[i] = (char)(97+temp);
                }else{
                    int temp = arr[i]+n;
                    arr[i] = (char)temp;
                }
            }else if((int)arr[i]>=65 && (int)arr[i]<=90){
                if((int)arr[i]+n > 90){ // 대문자인데 Z를 넘어가는 경우
                    int temp = arr[i]+n;
                    temp-=91;
                    arr[i] = (char)(65+temp);
                }else{
                    int temp = arr[i]+n;
                    arr[i] = (char)temp;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}