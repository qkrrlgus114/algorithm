class Solution {
    public boolean solution(String s) {
        boolean flag = true;
        if(s.length() == 4 || s.length() == 6){
            char[] arr = s.toCharArray();
            for(int i=0; i<arr.length; i++){
                if(arr[i]<'0' || arr[i]>'9'){
                    return !flag;
                }
            }
            return flag;
        }else{
            return !flag;
        }
    }
}