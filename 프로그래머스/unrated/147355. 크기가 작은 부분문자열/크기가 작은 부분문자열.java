class Solution {
    public int solution(String t, String p) {
        int len = p.length();
        long pNum = Long.parseLong(p);
        int count = 0;
        for(int i=0; i<t.length()-len+1; i++){
            long tNum = Long.parseLong(t.substring(i,i+len));
            if(tNum<=pNum) count++;
        }
        return count;
    }
}