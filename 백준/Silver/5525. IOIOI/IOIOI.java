import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        String S = bf.readLine();

        int findCount = N * 2 + 1;
        int answer = 0;
        boolean check = false;

        Stack<Character> s = new Stack<>();
        int count = 0;
        for(int i=0; i<M; i++){
            char c = S.charAt(i);
            if(check){
                if(c == 'O'){
                    count = 0;
                }else{
                    count++;
                    check = false;
                }
            }else{
                if(c == 'O'){
                    count++;
                    check = true;
                }else{
                    count = 1;
                }
            }
            s.push(c);

            if(count == findCount){
                answer++;
                s.pop();
                s.pop();
                count -= 2;
            }
        }

        System.out.println(answer);


    }


}
