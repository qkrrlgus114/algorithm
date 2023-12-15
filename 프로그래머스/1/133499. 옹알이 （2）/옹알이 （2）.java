class Solution {
    public int solution(String[] babbling) {
        // 정답의 개수
        int result = 0;
        
        
        for(int i=0; i<babbling.length; i++){
            // 연속해서 같은 발음 불가능
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")){
                continue;
            }
            
            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");
            
            if(babbling[i].length() == 0){
                result++;
            }
        }
        
        return result;
    }
}