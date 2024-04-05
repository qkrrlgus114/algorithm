import java.util.*;

class Solution {
    
    static int cross = 0;
    static int all = 0;
    static boolean[] check1;
    static boolean[] check2;
    
    public int solution(String str1, String str2) {
        char[] c1 = str1.toLowerCase().toCharArray();
        char[] c2 = str2.toLowerCase().toCharArray();
        
        List<String> A = new ArrayList<>();
        List<String> B = new ArrayList<>();
        
        for(int i=0; i<c1.length - 1; i++){
            char a = c1[i];   
            char b = c1[i+1];   
            if(check(a) && check(b)){
                A.add(String.valueOf(a) + String.valueOf(b));
            }
        }
        
        for(int i=0; i<c2.length - 1; i++){
            char a = c2[i];   
            char b = c2[i+1];   
            if(check(a) && check(b)){
                B.add(String.valueOf(a) + String.valueOf(b));
            }
        }
        
        check1 = new boolean[A.size()];
        check2 = new boolean[B.size()];
        
        if(A.size() == 0 && B.size() == 0){
            return 65536;
        }
        
        calculator(A, B);
        
        System.out.println(cross);
        System.out.println(all);
        double value = (double) cross / all;
        value = Math.floor(value * 65536);
        
        return (int) value;
    }
    
    public static boolean check(char c){
        if(c >= 97 && c <= 122) return true;
        return false;
    }
    
    public static void calculator(List<String> A, List<String> B){
        cross = 0;
        all = A.size() + B.size();
        
        for(int i=0; i<A.size(); i++){
            for(int j=0; j<B.size(); j++){
                if(A.get(i).equals(B.get(j)) && !check1[i] && !check2[j]){
                    cross++;
                    check1[i] = true;
                    check2[j] = true;
                    break;
                }
            }
        }
        
        all -= cross;
    }
}