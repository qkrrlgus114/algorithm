import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            s = bf.readLine();
            boolean check = false;
            boolean finish = false;
            int l = 0;
            int r = s.length() - 1;
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    if(check){
                        finish = true;
                        break;
                    }else{
                        check = true;
                        // 2가지 경우를 확인
                        // 1. l++하고 다시 확인
                        // 2. r--하고 다시 확인
                        // 둘 다 돌렸을 때 true면 회문이 맞음.
                        if(circleCheck(l+1, r, s) || circleCheck(l, r-1, s)) break;
                        else{
                            finish = true;
                            break;
                        }
                    }
                }
                l++;
                r--;
            }
            if(finish) sb.append(2).append("\n");
            else if(check) sb.append(1).append("\n");
            else sb.append(0).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean circleCheck(int l, int r, String s){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}