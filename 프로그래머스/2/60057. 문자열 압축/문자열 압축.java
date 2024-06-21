class Solution {
    
    public int solution(String s) {
        
        int result = s.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i <= s.length() / 2; i++){
            int temp = 0;
            String start = s.substring(0, i);
            int count = 0;
            for(int j=i; j < s.length(); j+=i){
                int index = Math.min(j+i, s.length());
                String compare = s.substring(j, index);
                
                if(compare.equals(start)){
                    count++;
                }else{
                    if(count != 0){
                        sb.append(count + 1);
                    }
                    sb.append(start);
                    count = 0;
                    start = compare;
                }
                
            }
            if(count != 0){
                sb.append(count + 1);
            }
            sb.append(start);
            
            result = Math.min(result, sb.length());
            sb.setLength(0);
        }
        
        return result;
    }

}