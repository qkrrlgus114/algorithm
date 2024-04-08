// k진법 변환 숫자 구함
// 

class Solution {
    public int solution(int n, int k) {
        // k진법 변환
        String a = changeNumber(n, k);
        int result = 0;
        long temp = 0;
        int start_index = 0;
        
        for(int i=0; i <= a.length() - 1; i++){
            if(a.charAt(i) == '0'){
                temp = 0;
                continue;
            }else{
                if(temp == 0) start_index = i;
                temp *= (long) 10;
                temp += (long) a.charAt(i) - '0';
                // 소수 체크
                if(temp == 1) continue;
                boolean check = checkNumber(temp);
                if(check){
                    check = false;
                    // 여기서 조건 체크
                    // 1. 양쪽에 0이 있는 경우
                    if(start_index != 0 && a.charAt(start_index - 1) == '0' && 
                      i != a.length() - 1 && a.charAt(i + 1) == '0'){
                        check = true;
                        result++;
                    } 
                    // 2. 오른쪽에 0이고 왼쪽에는 아무것도 없는 경우
                    else if(start_index == 0 && i != a.length() - 1 && a.charAt(i + 1) == '0'){
                        check = true;
                        result++;
                    }
                    // 3. 왼쪽에 0이고 오른쪽에 아무것도 없는 경우
                    else if(i == a.length() - 1 && start_index != 0 && a.charAt(start_index - 1) == '0'){
                        check = true;
                        result++;
                    }
                    // 4. 양쪽에 아무것도 없는 경우
                    else if(start_index == 0 && i == a.length() - 1){
                        check = true;
                        result++;
                    }
                    if(check){
                        temp = 0;
                        start_index = 0;
                    }
                }
                
            }
        }
        
        return result;
    }
    
    // 소수 체크
    public static boolean checkNumber(long n){
        for(int i=2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    // 진법 변환
    public static String changeNumber(int n, int k){
        StringBuilder sb = new StringBuilder();
        while(n >= k){
            if(n % k == 0){
                n /= k;
                sb.append(0);
            }else{
                int nam = n % k;
                n /= k;
                sb.append(nam);
            }
        }
        sb.append(n);
        
        return sb.reverse().toString();
    }
}