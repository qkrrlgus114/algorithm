import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        int num = arrayA[0];
        // num의 약수를 구한다.
        List<Integer> aNum = a(num);
        
        int result = 0;
        
        for(int i=0; i<aNum.size(); i++){
            int A = aNum.get(i); // 약수 하나 선택
            boolean check = true;
            for(int j=0; j<arrayA.length; j++){
                if(arrayA[j] % A != 0){
                    check = false;
                    break;
                }
            }
            if(!check) continue;
            for(int j=0; j<arrayB.length; j++){
                if(arrayB[j] % A == 0){
                    check = false;
                    break;
                }
            }
            if(!check) continue;
            
            result = A;
            break;
        }
        
        Arrays.sort(arrayB);
        num = arrayB[0];
        // num의 약수를 구한다.
        List<Integer> bNum = a(num);
        
        for(int i=0; i<bNum.size(); i++){
            int B = bNum.get(i); // 약수 하나 선택
            boolean check = true;
            for(int j=0; j<arrayB.length; j++){
                if(arrayB[j] % B != 0){
                    check = false;
                    break;
                }
            }
            if(!check) continue;
            for(int j=0; j<arrayA.length; j++){
                if(arrayA[j] % B == 0){
                    check = false;
                    break;
                }
            }
            if(!check) continue;
            
            result = Math.max(result, B);
            break;
        }
        
        
        return result;
    }
    
    public static List<Integer> a(int num){
        List<Integer> list = new ArrayList<>();
        for(int i=num; i>=2; i--){
            if(num % i == 0) list.add(i);
        }
        
        return list;
    }
}